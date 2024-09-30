package NASA;

import java.sql.*;

public class EspaiCRUD {
    private Connection conexion;

    public EspaiCRUD() {
        conexion = Conexio.getConnection();
    }

    public boolean insertarEspia(Espia espia) {
        String sqlUsuari = "INSERT INTO usuari (nom, contrasenya, rol) VALUES (?, ?, ?)";
        String sqlEspia = "INSERT INTO espia (idusuari, telefon) VALUES (?, ?)";
        try {
            // Desactivar auto-commit
            conexion.setAutoCommit(false);

            // Crear usuari a la tabla `usuari`
            PreparedStatement statementUsuari = conexion.prepareStatement(sqlUsuari, PreparedStatement.RETURN_GENERATED_KEYS);
            statementUsuari.setString(1, espia.getNom());
            statementUsuari.setString(2, espia.getContrasenya());
            statementUsuari.setString(3, espia.getRoll());
            int filasInsertadasUsuari = statementUsuari.executeUpdate();

            // Obtenir id de l'usuari
            ResultSet generatedKeys = statementUsuari.getGeneratedKeys();
            int idUsuari = 0;
            if (generatedKeys.next()) {
                idUsuari = generatedKeys.getInt(1);
            }

            // Insertar espia amb l'id de l'usuari
            PreparedStatement statementEspia = conexion.prepareStatement(sqlEspia);
            statementEspia.setInt(1, idUsuari);
            statementEspia.setString(2, espia.getTelefon());
            int filasInsertadasEspia = statementEspia.executeUpdate();

            // Confirmar transacció
            if (filasInsertadasUsuari > 0 && filasInsertadasEspia > 0) {
                conexion.commit();
                return true;
            } else {
                // Si algo falla, revertir la transacción
                conexion.rollback();
                return false;
            }
        } catch (SQLException e) {
            try {
                // Si hi ha error fer rollback
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexion.setAutoCommit(true); // Restaurar auto-commit
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Espia obtenerEspia(int idUsuari) {
        String sql = "SELECT * FROM espia WHERE idusuari = ?";
        Espia espia = null;

        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, idUsuari);
            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {
                String telefon = resultado.getString("telefon");
                String nom = obtenerNomUsuari(idUsuari);
                String contrasenya = obtenerContrasenyaUsuari(idUsuari);
                String roll = obtenerRollUsuari(idUsuari);

                espia = new Espia(nom, contrasenya, roll, telefon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return espia;
    }

    public boolean actualizarEspia(Espia espia, int idUsuari) {
        String sqlUsuari = "UPDATE usuari SET nom = ?, contrasenya = ?, rol = ? WHERE idusuari = ?";
        String sqlEspia = "UPDATE espia SET telefon = ? WHERE idusuari = ?";
        try {
            // Desactivar auto-commit
            conexion.setAutoCommit(false);

            // Actualizar el usuario en la tabla `usuari`
            PreparedStatement statementUsuari = conexion.prepareStatement(sqlUsuari);
            statementUsuari.setString(1, espia.getNom());
            statementUsuari.setString(2, espia.getContrasenya());
            statementUsuari.setString(3, espia.getRoll());
            statementUsuari.setInt(4, idUsuari);
            int filasActualizadasUsuari = statementUsuari.executeUpdate();

            PreparedStatement statementEspia = conexion.prepareStatement(sqlEspia);
            statementEspia.setString(1, espia.getTelefon());
            statementEspia.setInt(2, idUsuari);
            int filasActualizadasEspia = statementEspia.executeUpdate();

            if (filasActualizadasUsuari > 0 && filasActualizadasEspia > 0) {
                conexion.commit();
                return true;
            } else {
                conexion.rollback();
                return false;
            }
        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexion.setAutoCommit(true);  // Restaurar auto-commit
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean eliminarEspia(int idUsuari) {
        String sqlEspia = "DELETE FROM espia WHERE idusuari = ?";
        String sqlUsuari = "DELETE FROM usuari WHERE idusuari = ?";
        try {
            // Desactivar auto-commit
            conexion.setAutoCommit(false);

            // Eliminar espia a la taula `espia`
            PreparedStatement statementEspia = conexion.prepareStatement(sqlEspia);
            statementEspia.setInt(1, idUsuari);
            int filasEliminadasEspia = statementEspia.executeUpdate();

            // Eliminar usuari a la taula `usuari`
            PreparedStatement statementUsuari = conexion.prepareStatement(sqlUsuari);
            statementUsuari.setInt(1, idUsuari);
            int filasEliminadasUsuari = statementUsuari.executeUpdate();

            // Confirmar transacció
            if (filasEliminadasEspia > 0 && filasEliminadasUsuari > 0) {
                conexion.commit();
                return true;
            } else {
                // Error fer rollback
                conexion.rollback();
                return false;
            }
        } catch (SQLException e) {
            try {
                // Error fer rollback
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexion.setAutoCommit(true); // Restaurar auto-commit
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private int obtenerIdUsuari(String nom, String contrasenya) {
        String sql = "SELECT idusuari FROM usuari WHERE nom = ? AND contrasenya = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, nom);
            statement.setString(2, contrasenya);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("idusuari");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 si no troba l'usuari
    }

    private String obtenerNomUsuari(int idUsuari) {
        String sql = "SELECT nom FROM usuari WHERE idusuari = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, idUsuari);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("nom");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no troba l'usuari
    }

    private String obtenerContrasenyaUsuari(int idUsuari) {
        String sql = "SELECT contrasenya FROM usuari WHERE idusuari = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, idUsuari);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("contrasenya");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no troba l'usuari
    }

    private String obtenerRollUsuari(int idUsuari) {
        String sql = "SELECT rol FROM usuari WHERE idusuari = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, idUsuari);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("rol");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no troba l'usuari

    }
}

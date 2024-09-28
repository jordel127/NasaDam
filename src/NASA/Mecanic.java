package NASA;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;

public class Mecanic extends Usuari{
    public int idUsuari;
    public double numeroDelTaller;
    public double salari;
    public int edat;
    public String sexe;
    public String adreça;
    public int anyExperiència;
    public String ciutatOnTrballa;

    public Mecanic(int idUsuari, String nom, String contrasenya, String roll, double numeroDelTaller, double salari, int edat, String sexe,String adreça, int anyExperiència, String ciutatOnTrballa) {
        super(nom, contrasenya,roll);
        this.idUsuari = idUsuari;
        this.numeroDelTaller = numeroDelTaller;
        this.salari = salari;
        this.edat = edat;
        this.sexe = sexe;
        this.adreça = adreça;
        this.anyExperiència = anyExperiència;
        this.ciutatOnTrballa = ciutatOnTrballa;
    }

    public void ImorimirVehiclesTaller (String nomArxiu, int taller){
        PreparedStatement pstmt = null;
        FileWriter escritor = null;

        try {
            Connection con = Conexio.getConnection();

            String consultaSQL = "SELECT * FROM vehicles WHERE num_taller = ?";

            pstmt = con.prepareStatement(consultaSQL);
            pstmt.setInt(1, taller);

            ResultSet rs = pstmt.executeQuery();

            escritor = new FileWriter(nomArxiu);

            while (rs.next()) {
                String model = rs.getString("model");
                String matricula = rs.getString("matricula");
                escritor.write(model + "\t" + matricula + "\n");
            }

            System.out.println("Dades guardades al fitxer: " + nomArxiu);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (escritor != null) {
                    escritor.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public StringBuilder llistarVeicles(int taller) {
        StringBuilder llistaDeVeicles = new StringBuilder();

        try (Connection con = Conexio.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT model, matricula FROM vehicles WHERE num_taller = ?")) {

            pstmt.setInt(1, taller);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String model = rs.getString("model");
                    String matricula = rs.getString("matricula");
                    llistaDeVeicles.append("Model: ").append(model).append("\t").append("Matricula: ").append(matricula).append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return llistaDeVeicles;

    }

    public void fitxar(int idUsuari) {
        Connection con = null;
        PreparedStatement pstmt = null;

        System.out.println(idUsuari);

        try {
            con = Conexio.getConnection();

            String sql = "UPDATE mecanic SET hora = ? WHERE idusuari = ?";
            pstmt = con.prepareStatement(sql);

            LocalDateTime horaFitxar = LocalDateTime.now();

            pstmt.setTimestamp(1, Timestamp.valueOf(horaFitxar));
            pstmt.setInt(2, idUsuari);

            int filesActualitzades = pstmt.executeUpdate();

            System.out.println("S''ha actualitzat correctament " + filesActualitzades + " fila.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

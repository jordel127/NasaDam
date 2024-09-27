package NASA;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Mecanic extends Usuari{
    public double numeroDelTaller;
    public double salari;
    public int edat;
    public String sexe;
    public String adreça;
    public int anyExperiència;
    public String ciutatOnTrballa;

    public Mecanic(String nom, String contrasenya, String roll, double numeroDelTaller, double salari, int edat, String sexe,String adreça, int anyExperiència, String ciutatOnTrballa) {
        super(nom, contrasenya,roll);
        this.numeroDelTaller = numeroDelTaller;
        this.salari = salari;
        this.edat = edat;
        this.sexe = sexe;
        this.adreça = adreça;
        this.anyExperiència = anyExperiència;
        this.ciutatOnTrballa = ciutatOnTrballa;
    }

    public void llistarVehiclesTaller (String nomArxiu, int taller){
        PreparedStatement pstmt = null;
        FileWriter escritor = null;

        try {
            Connection con = Conexio.getConnection();

            String consultaSQL = "SELECT * FROM taller WHERE numTaller = ?";

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

    public String fitxar() {
        return "Acabar en una estona.";
    }
}

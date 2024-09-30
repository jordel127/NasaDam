package NASA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Fisic extends Usuari{
    public int idUsuari;
    public int anysExperiència;
    public int edat;
    public String sexe;
    public String adreça;
    public double salari;
    public String titulacioAcademica;
    public String ciutatOnTreballa;


    public Fisic(int idUsuari, String nom, String contrasenya, String roll, int anysExperiència, int edat, String sexe, String adreça, double salari, String titulacioAcademica, String ciutatOnTreballa) {
        super(nom, contrasenya, roll);
        this.idUsuari = idUsuari;
        this.anysExperiència = anysExperiència;
        this.edat = edat;
        this.sexe = sexe;
        this.adreça = adreça;
        this.salari = salari;
        this.titulacioAcademica = titulacioAcademica;
        this.ciutatOnTreballa = ciutatOnTreballa;
    }

    public double tempsDeViatge(String astrosSistemaSolar) {

        astrosSistemaSolar = astrosSistemaSolar.toLowerCase();
        double distanciaPlaneta = 0;
        double distanciaSol = 147000000.0;
        int tiempoAlSol = 2;

        if (astrosSistemaSolar.equals("sol")) {
            return 2.0;
        }
        if (astrosSistemaSolar.equals("mercurio")) {
            distanciaPlaneta = 91500000.0;
        }
        else if (astrosSistemaSolar.equals("venus")) {
            distanciaPlaneta = 40000000.0;
        }
        else if (astrosSistemaSolar.equals("marte")) {
            distanciaPlaneta = 58000000.0;
        }
        else if (astrosSistemaSolar.equals("jupiter")) {
            distanciaPlaneta = 444000000.0;
        }
        else if (astrosSistemaSolar.equals("saturno")) {
            distanciaPlaneta = 750500000.0;
        }
        else if (astrosSistemaSolar.equals("urano")) {
            distanciaPlaneta = 1447500000.0;
        }
        else if (astrosSistemaSolar.equals("neptuno")) {
            distanciaPlaneta = 2300000000.0;
        }

        if (distanciaPlaneta == 0) {
            return 0;
        }else {
            return (distanciaPlaneta*tiempoAlSol) / distanciaSol;
        }
    }

    public double costEconomicRecorregut(String astrosSistemaSolar) {
        astrosSistemaSolar = astrosSistemaSolar.toLowerCase();
        double radioPlaneta = 0;
        final double preuNitrogen = 200;
        final double consumRobotKM3 = 0.00000009;

        radioPlaneta = switch (astrosSistemaSolar) {
            case "mercurio", "1" -> 2440.0;
            case "venus", "2" -> 6052.0;
            case "marte", "3" -> 3390.0;
            case "jupiter", "4" -> 69911.0;
            case "saturno", "5" -> 58232.0;
            case "urano", "6" -> 25362.0;
            case "neptuno", "7" -> 24622.0;
            default -> radioPlaneta;
        };

        double areaPlaneta = 4 * Math.PI * (radioPlaneta * radioPlaneta);
        double consumNitrogen = areaPlaneta / consumRobotKM3;

        return consumNitrogen * preuNitrogen;
    }

    public String PlanetaMesEconomic() {
        // Inicialitzar el preu més baix amb el cost de Mercuri
        double preuMesBaix = costEconomicRecorregut("mercurio");
        String planetaMasBarato = "mercurio";
        System.out.println(preuMesBaix+ " es el cost econòmic del planeta mercurio");

        // Iterar sobre els altres planetes numerats de 1 a 7
        for (int i = 2; i <= 7; i++) {  // Comença amb 2 perquè ja tens Mercurio inicialitzat
            String numString = String.valueOf(i);
            double newPrecio = costEconomicRecorregut(numString);
            System.out.println(i);
            System.out.println(newPrecio);

            // Si trobem un preu més baix, actualitzem el preu i el nom del planeta
            if (newPrecio < preuMesBaix) {
                System.out.println("Ola!");
                preuMesBaix = newPrecio;

                // Assignar el nom del planeta basat en l'índex
                if (i == 2) planetaMasBarato = "venus";
                else if (i == 3) planetaMasBarato = "marte";
                else if (i == 4) planetaMasBarato = "jupiter";
                else if (i == 5) planetaMasBarato = "saturno";
                else if (i == 6) planetaMasBarato = "urano";
                else planetaMasBarato = "neptuno";
            }
        }

        // Retornar el nom del planeta més econòmic amb el seu cost
        return planetaMasBarato + " és el més econòmic amb un cost de " + preuMesBaix + "€";
    }
    public void fitxar(int idUsuari) {
        Connection con = null;
        PreparedStatement pstmt = null;

        System.out.println(idUsuari);

        try {
            con = Conexio.getConnection();

            String sql = "UPDATE fisic SET hora = ? WHERE idusuari = ?";
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
package NASA;

public class Fisic extends Usuari{
    public int anysExperiència;
    public int edat;
    public String sexe;
    public String adreça;
    public double salari;
    public String titulacioAcademica;
    public String ciutatOnTreballa;


    public Fisic(String nom, String contrasenya, int anysExperiència, int edat, String sexe, String adreça, double salari, String titulacioAcademica, String ciutatOnTreballa) {
        super(nom, contrasenya);
        this.anysExperiència = anysExperiència;
        this.edat = edat;
        this.sexe = sexe;
        this.adreça = adreça;
        this.salari = salari;
        this.titulacioAcademica = titulacioAcademica;
        this.ciutatOnTreballa = ciutatOnTreballa;
    }

    public double tempDeViatge(String astrosSistemaSolar) {
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
            return (distanciaPlaneta/distanciaSol) * tiempoAlSol;
        }
    }

    public double costEconomicRecorregut(String astrosSistemaSolar) {
        astrosSistemaSolar = astrosSistemaSolar.toLowerCase();
        double radioPlaneta = 0;
        double areaPlaneta = 0;

        if (astrosSistemaSolar.equals("mercurio") || astrosSistemaSolar.equals("1")) {
            radioPlaneta = 2440.0;
        }
        else if (astrosSistemaSolar.equals("venus") || astrosSistemaSolar.equals("2")) {
            radioPlaneta = 6052.0;
        }
        else if (astrosSistemaSolar.equals("marte") || astrosSistemaSolar.equals("3")) {
            radioPlaneta = 3390.0;
        }
        else if (astrosSistemaSolar.equals("jupiter") || astrosSistemaSolar.equals("4")) {
            radioPlaneta = 69911.0;
        }
        else if (astrosSistemaSolar.equals("saturno") || astrosSistemaSolar.equals("5")) {
            radioPlaneta = 58232.0;
        }
        else if (astrosSistemaSolar.equals("urano") || astrosSistemaSolar.equals("6")) {
            radioPlaneta = 25362.0;
        }
        else if (astrosSistemaSolar.equals("neptuno") || astrosSistemaSolar.equals("7")) {
            radioPlaneta = 24622.0;
        }

        areaPlaneta = 4 * Math.PI * (radioPlaneta * radioPlaneta);

        double consumNitrogen = areaPlaneta * (90.0 / 2);
        double costTotalNitrogen = consumNitrogen * 1000;
        costTotalNitrogen = costTotalNitrogen * 200;

        return costTotalNitrogen;
    }

    public String PlanetaMesEconomic() {
        // Inicialitzar el preu més baix amb el cost de Mercuri
        double precioMasVajo = costEconomicRecorregut("mercurio");
        String planetaMasBarato = "mercurio";
        System.out.println(precioMasVajo+ " es el cost econòmic del planeta mercurio");

        // Iterar sobre els altres planetes numerats de 1 a 7
        for (int i = 2; i <= 7; i++) {  // Comença amb 2 perquè ja tens Mercurio inicialitzat
            String numString = String.valueOf(i);
            double newPrecio = costEconomicRecorregut(numString);
            System.out.println(newPrecio);

            // Si trobem un preu més baix, actualitzem el preu i el nom del planeta
            if (newPrecio < precioMasVajo) {
                System.out.println("Ola!");
                precioMasVajo = newPrecio;

                // Assignar el nom del planeta basat en l'índex
                if (i == 2) planetaMasBarato = "venus";
                else if (i == 3) planetaMasBarato = "marte";
                else if (i == 4) planetaMasBarato = "jupiter";
                else if (i == 5) planetaMasBarato = "saturno";
                else if (i == 6) planetaMasBarato = "urano";
                else if (i == 7) planetaMasBarato = "neptuno";
            }
        }

        // Retornar el nom del planeta més econòmic amb el seu cost
        return planetaMasBarato + " és el més econòmic amb un cost de " + precioMasVajo + "€";
    }

}

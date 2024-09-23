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

        return (distanciaPlaneta/distanciaSol) * tiempoAlSol;
    }

    public double costEconomicRecorregut(String astrosSistemaSolar) {
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

        return (distanciaPlaneta/distanciaSol) * tiempoAlSol;
    }

}

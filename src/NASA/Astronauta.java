package NASA;

public class Astronauta extends Usuari{

    public String dataPrimerVol;
    public int edat;
    public String sexe;
    public String adreça;
    public int rangMilitar;

    public Astronauta(String nom, String contrasenya, String dataPrimerVol, int edat, String sexe, String adreça, int rangMilitar) {
        super(nom, contrasenya);
        this.dataPrimerVol = dataPrimerVol;
        this.edat = edat;
        this.sexe = sexe;
        this.adreça = adreça;
        this.rangMilitar = rangMilitar;
    }
}

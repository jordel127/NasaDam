package NASA;

public class Mecanic extends Usuari{
    public double numeroDelTaller;
    public double salari;
    public int edat;
    public String adreça;
    public int anyExperiència;
    public String ciutatOnTrballa;

    public Mecanic(String nom, String contrasenya, double numeroDelTaller, double salari, int edat, String adreça, int anyExperiència, String ciutatOnTrballa) {
        super(nom, contrasenya);
        this.numeroDelTaller = numeroDelTaller;
        this.salari = salari;
        this.edat = edat;
        this.adreça = adreça;
        this.anyExperiència = anyExperiència;
        this.ciutatOnTrballa = ciutatOnTrballa;
    }
}

package NASA;

public class Espia extends Usuari{
    public String telefon;
    public Espia(String nom, String contrasenya, String telefon) {
        super(nom, contrasenya);
        this.telefon = telefon;
    }
}

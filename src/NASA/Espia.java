package NASA;

public class Espia extends Usuari{
    public String telefon;
    public Espia(String nom, String contrasenya, String telefon) {
        super(nom, contrasenya);
        this.telefon = telefon;
    }

    public String missatgeEncriptat (String missatge) {

        String encriptat = "";

        for (int i = 0; i < missatge.length(); i++) {
            char caracter = missatge.charAt(i);

            if (caracter == 'a' || caracter == 'e'|| caracter == 'i'|| caracter == 'o' || caracter == 'u') {
                encriptat += caracter;
            }

        }

        return encriptat;
    }
}

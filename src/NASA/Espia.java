package NASA;

public class Espia extends Usuari{
    public String telefon;
    public Espia(String nom, String contrasenya, String roll, String telefon) {
        super(nom, contrasenya, roll);
        this.telefon = telefon;
    }

    // Getters y Setters
    public String getNom() {
        return super.getNom();
    }
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
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

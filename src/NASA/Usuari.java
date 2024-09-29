package NASA;

public class Usuari {
    private String nom;
    private String contrasenya;

    private String roll;

    public Usuari(String nom, String contrasenya, String roll){
        this.nom = nom;
        this.contrasenya = contrasenya;
        this.roll = roll;
    }

    // Getters y Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public Boolean iniciaSession(String nom, String contrasenya){
        return true;
    }

    public Boolean terminaSession(){
        return true;
    }
}

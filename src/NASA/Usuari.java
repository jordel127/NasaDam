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

    public Boolean iniciaSession(String nom, String contrasenya){
        return true;
    }

    public Boolean terminaSession(){
        return true;
    }
}

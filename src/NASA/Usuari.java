package NASA;

public class Usuari {
    private String nom;
    private String contrasenya;

    public Usuari(String nom, String contrasenya){
        this.nom = nom;
        this.contrasenya = contrasenya;
    }

    public Boolean iniciaSession(String nom, String contrasenya){
        return true;
    }

    public Boolean terminaSession(){
        return true;
    }
}

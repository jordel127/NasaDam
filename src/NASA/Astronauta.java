package NASA;

import java.util.Random;

public class Astronauta extends Usuari{

    public String dataPrimerVol;
    public int edat;
    public String sexe;
    public String adreça;

    public int missionsOk;

    public int missionsKo;
    public String rangMilitar;

    public Astronauta(String nom, String contrasenya, String roll,String dataPrimerVol, int edat, String sexe, String adreça, int missionsOk, int missionsKo , String rangMilitar) {
        super(nom, contrasenya, roll);
        this.dataPrimerVol = dataPrimerVol;
        this.edat = edat;
        this.sexe = sexe;
        this.adreça = adreça;
        this.missionsOk = missionsOk;
        this.missionsKo = missionsKo;
        this.rangMilitar = rangMilitar;
    }

    public String localitzacioAstronautaLatitud() {
        Random math = new Random();

        //Latitud
        int grausLatitud = math.nextInt(181);
        int minutsLatitud = math.nextInt(60);
        int segonsLatitud = math.nextInt(60);
        char hemisferiLatitud;
        if (grausLatitud < 91) {
            hemisferiLatitud = 'S';
        } else {
            hemisferiLatitud = 'N';
        }

        String latitud = grausLatitud + "° " + minutsLatitud + "' " + segonsLatitud + "'' " + hemisferiLatitud;
        return latitud;
    }

    public String localitzacioAstronautaLongitud() {

        Random math = new Random();

        //Longitud
        int grausLongitud = math.nextInt(181);
        int minutsLongitud = math.nextInt(60);
        int segonsLongitud = math.nextInt(60);
        char hemisferiLongitud;
        if (grausLongitud < 91) {
            hemisferiLongitud = 'W';
        } else {
            hemisferiLongitud = 'E';
        }

        String longitud = grausLongitud + "° " + minutsLongitud + "' " + segonsLongitud + "'' " + hemisferiLongitud;
        return longitud;
    }

    public String missatgeEncriptat (String missatge) {

        String encriptat = "";

        for (int i = 0; i < missatge.length(); i++) {
            char caracter = missatge.charAt(i);

            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                continue;
            }

            encriptat += caracter;
        }

        return encriptat;
    }
}

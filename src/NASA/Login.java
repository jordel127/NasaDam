package NASA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class Login extends JFrame {
    private JTextField user;
    private JPasswordField pass;
    private JButton login;
    private JPanel panell;

    public Login() {
        setVisible(true);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());



        user = new JTextField(10);
        pass = new JPasswordField(10);
        login = new JButton("Login");
        panell = new JPanel();

        panell.add(new JLabel("Usuari: "));
        panell.add(user);
        panell.add(new JLabel("Contrasenya: "));
        panell.add(pass);
        panell.add(login);

        add(panell, BorderLayout.CENTER);

        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        class  LoginListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (user.getText().equals("") || pass.getPassword().length == 0){
                    JOptionPane.showMessageDialog(null, "Introdueix un usuari i una contrasenya");
                }else {
                    String[] userInfo = getUserInfo(user.getText(), new String(pass.getPassword()));

                    if (userInfo == null) {
                        JOptionPane.showMessageDialog(null, "Usuari o contrasenya incorrectes");
                    }else if (userInfo[3].equals("3")){

                        JOptionPane.showMessageDialog(null, "Hola Fisic");
                        new FrameFisic(getInfoCompletaFisic("fisic", userInfo));
                        dispose();
                    }else if (userInfo[3].equals("2")){
                        JOptionPane.showMessageDialog(null, "Hola Espia");
                        new FrameEspia(getInfoCompletaEspia("espia", userInfo));
                        dispose();
                    }else if (userInfo[3].equals("1")){
                        JOptionPane.showMessageDialog(null, "Hola Astronauta");
                        new FrameAstronauta(getInfoCompletaAstronauta("astronauta", userInfo));
                        dispose();
                    }else if (userInfo[3].equals("4")){
                        JOptionPane.showMessageDialog(null, "Hola Mecanic");
                        new FrameMecanic(getInfoCompletaMecanic("mecanic", userInfo));
                        dispose();
                    }
                }
            }
        }

        login.addActionListener(new LoginListener());
    }
    public static String [] getUserInfo(String nom, String contrasenya){
            String [] userInfo = new String[4];
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                Conexio conn = new Conexio();

                Connection con = conn.getConnection();
                String consultaSQL = "SELECT * FROM usuari WHERE nom = ? AND contrasenya = ?";
                pstmt = con.prepareStatement(consultaSQL);
                pstmt.setString(1, nom);
                pstmt.setString(2, contrasenya);

                rs = pstmt.executeQuery();

                while (rs.next()) {
                    userInfo[0] = rs.getString("idusuari");
                    userInfo[1] = rs.getString("nom");
                    userInfo[2] = rs.getString("contrasenya");
                    userInfo[3] = rs.getString("rol");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Arrays.toString(userInfo));
            return userInfo;
    }

    public Fisic getInfoCompletaFisic(String rollUsuari, String [] userInfo){
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Fisic fisic = null;

        String nom = userInfo[1];
        String contrasenya = userInfo[2];
        String rol = userInfo[3];

        try {
            Conexio conn = new Conexio();
            Connection con = conn.getConnection();
            String consultaSQL = "SELECT * FROM " + rollUsuari + " WHERE idusuari = ?";
            pstmt = con.prepareStatement(consultaSQL);
            pstmt.setString(1, userInfo[0]);
            rs = pstmt.executeQuery();


            int anysExperiència = 0;
            int edat = 0;
            String sexe = null;
            String adreça = null;
            double salari = 0;
            String titulacioAcademica = null;
            String ciutatOnTreballa = null;

            while (rs.next()) {
                anysExperiència = rs.getInt("anys_experiencia");
                edat = rs.getInt("edat");
                sexe = rs.getString("sexe");
                adreça = rs.getString("adreca");
                salari = rs.getDouble("salari");
                titulacioAcademica = rs.getString("titolacio");
                ciutatOnTreballa = rs.getString("ciutat_treball");

            }
            fisic = new Fisic(nom, contrasenya, rol, anysExperiència, edat, sexe, adreça, salari, titulacioAcademica, ciutatOnTreballa);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return fisic;
    }

    public Espia getInfoCompletaEspia(String rollUsuari, String [] userInfo){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Espia espia = null;
        String nom = userInfo[1];
        String contrasenya = userInfo[2];
        String rol = userInfo[3];

        try {
            Conexio conn = new Conexio();
            Connection con = conn.getConnection();
            String consultaSQL = "SELECT * FROM " + rollUsuari + " WHERE idusuari = ?";
            pstmt = con.prepareStatement(consultaSQL);
            pstmt.setString(1, userInfo[0]);
            rs = pstmt.executeQuery();

            String telefon = null;

            while (rs.next()) {
                telefon = rs.getString("telefon");
            }
            espia = new Espia(nom, contrasenya, rol, telefon);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return espia;
    }

    public Astronauta getInfoCompletaAstronauta(String rollUsuari, String [] userInfo){
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Astronauta astronauta = null;

        String nom = userInfo[1];
        String contrasenya = userInfo[2];
        String rol = userInfo[3];

        try {
            Conexio conn = new Conexio();
            Connection con = conn.getConnection();
            String consultaSQL = "SELECT * FROM " + rollUsuari + " WHERE idusuari = ?";
            pstmt = con.prepareStatement(consultaSQL);
            pstmt.setString(1, userInfo[0]);
            rs = pstmt.executeQuery();


            String dataPrimerVol = null;
            int edat = 0;
            String sexe = null;
            String adreça = null;
            int missionsOk = 0;
            int missionsKo = 0;
            String rangMilitar = null;

            while (rs.next()) {
                dataPrimerVol = rs.getString("primer_vol");
                edat = rs.getInt("edat");
                sexe = rs.getString("sexe");
                adreça = rs.getString("adreca");
                missionsOk = rs.getInt("missions_ok");
                missionsKo = rs.getInt("missions_co");
                rangMilitar = rs.getString("rang_militar");

            }
            astronauta = new Astronauta(nom, contrasenya, rol, dataPrimerVol, edat, sexe, adreça, missionsOk, missionsKo, rangMilitar);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return astronauta;
    }

    public Mecanic getInfoCompletaMecanic(String rollUsuari, String [] userInfo){
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Mecanic mecanic = null;

        String nom = userInfo[1];
        String contrasenya = userInfo[2];
        String rol = userInfo[3];

        try {
            Conexio conn = new Conexio();
            Connection con = conn.getConnection();
            String consultaSQL = "SELECT * FROM " + rollUsuari + " WHERE idusuari = ?";
            pstmt = con.prepareStatement(consultaSQL);
            pstmt.setString(1, userInfo[0]);
            rs = pstmt.executeQuery();


            double numeroDelTaller = 0;
            double salari = 0;
            int edat = 0;
            String sexe = null;
            String adreça = null;
            int anyExperiència = 0;
            String ciutatOnTrballa = null;

            while (rs.next()) {
                numeroDelTaller = rs.getDouble("num_taller");
                salari = rs.getDouble("salari");
                edat = rs.getInt("edat");
                sexe = rs.getString("sexe");
                adreça = rs.getString("adreca");
                anyExperiència = rs.getInt("anys_experiencia");
                ciutatOnTrballa = rs.getString("ciutat_on_treballa");

            }
            mecanic = new Mecanic(nom, contrasenya, rol, numeroDelTaller, salari, edat, sexe, adreça, anyExperiència, ciutatOnTrballa);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return mecanic;
    }
}

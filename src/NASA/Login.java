package NASA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                if (user.getText().equals("Joel") && pass.getText().equals("1")) {
                    JOptionPane.showMessageDialog(null, "Hola");
                    new FrameFisic();
                    dispose();
                }else if (user.getText().equals("Joel") && pass.getText().equals("2")) {
                    JOptionPane.showMessageDialog(null, "Hola");
                    new FrameEspia();
                    dispose();
                }else if (user.getText().equals("Joel") && pass.getText().equals("3")) {
                    JOptionPane.showMessageDialog(null, "Hola");
                    new FrameAstronauta();
                    dispose();
                }else if (user.getText().equals("Joel") && pass.getText().equals("4")) {
                    JOptionPane.showMessageDialog(null, "Hola");
                    new FrameMecanic();
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No se quien eres");
                }
            }
        }

        login.addActionListener(new LoginListener());

    }
}

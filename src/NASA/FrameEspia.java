package NASA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameEspia extends JFrame {
    private JPanel panell;

    private JTextField missatge;
    private JButton exit, encriptarMissatge;

    public FrameEspia(Espia espiaInfo){
        setVisible(true);
        setTitle("Espia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panell = new JPanel();

        panell.add(new JLabel("Espia"));

        panell.add(new JLabel("Missatge encriptat: "));
        missatge = new JTextField(10);
        panell.add(missatge);

        encriptarMissatge = new JButton("Encriptar missatge");
        panell.add(encriptarMissatge);

        exit = new JButton("Exit");
        panell.add(exit);

        add(panell, BorderLayout.CENTER);

        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        class  ExitListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
                new Login();
                dispose();
            }
        }
        exit.addActionListener(new ExitListener());

        class  EncriptarMissatgeListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                missatge.setText(espiaInfo.missatgeEncriptat(missatge.getText()));
            }
        }
        encriptarMissatge.addActionListener(new EncriptarMissatgeListener());
    }
}

package NASA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameAstronauta extends JFrame {
    private JPanel panell;

    private JButton exit, getCordenades, encriptarMissatge;

    private JTextField missatge;

    private JLabel latitud, longitud;

    public FrameAstronauta(Astronauta astronautaInfo){
        setVisible(true);
        setTitle("Astronauta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panell = new JPanel();

        panell.add(new JLabel("Astronauta"));

        panell.add(new JLabel("Missatge encriptat: "));
        missatge = new JTextField(10);
        panell.add(new JLabel(""));
        panell.add(missatge);

        encriptarMissatge = new JButton("Encriptar missatge");
        panell.add(encriptarMissatge);

        panell.add(latitud);
        panell.add(longitud);

        getCordenades = new JButton("Localització de l'astronauta");
        panell.add(getCordenades);

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

        class  GetCordenadesListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                latitud.setText(astronautaInfo.localitzacioAstronautaLatitud());
                longitud.setText(astronautaInfo.localitzacioAstronautaLongitud());
                dispose();
            }
        }
        getCordenades.addActionListener(new GetCordenadesListener());



    }
}

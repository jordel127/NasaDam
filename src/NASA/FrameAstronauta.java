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

    public FrameAstronauta(Astronauta astronautaInfo) {
        setVisible(true);
        setTitle("Astronauta - NASA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el panel principal con GridBagLayout para mayor control sobre el diseño
        panell = new JPanel(new GridBagLayout());
        panell.setBackground(new Color(10, 25, 47));  // Fondo oscuro, estilo NASA
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Márgenes entre los componentes

        // Título
        JLabel titleLabel = new JLabel("Astronauta");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(173, 216, 230));  // Azul claro
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // El título ocupa dos columnas
        panell.add(titleLabel, gbc);

        // Campo de texto: Mensaje encriptado
        JLabel missatgeLabel = new JLabel("Missatge encriptat: ");
        missatgeLabel.setForeground(new Color(173, 216, 230));  // Azul claro
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panell.add(missatgeLabel, gbc);

        missatge = new JTextField(15);
        missatge.setFont(new Font("Arial", Font.PLAIN, 14));
        missatge.setBackground(new Color(19, 41, 75));
        missatge.setForeground(Color.WHITE);
        missatge.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2, true));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panell.add(missatge, gbc);

        // Botón: Encriptar Mensaje
        encriptarMissatge = new JButton("Encriptar missatge");
        encriptarMissatge.setFont(new Font("Arial", Font.BOLD, 14));
        encriptarMissatge.setBackground(new Color(173, 216, 230));
        encriptarMissatge.setForeground(Color.BLACK);
        encriptarMissatge.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panell.add(encriptarMissatge, gbc);

        // Latitud
        JLabel latitudLabel = new JLabel("Latitud: ");
        latitudLabel.setForeground(new Color(173, 216, 230));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panell.add(latitudLabel, gbc);

        latitud = new JLabel("");
        latitud.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panell.add(latitud, gbc);

        // Longitud
        JLabel longitudLabel = new JLabel("Longitud: ");
        longitudLabel.setForeground(new Color(173, 216, 230));
        gbc.gridx = 0;
        gbc.gridy = 4;
        panell.add(longitudLabel, gbc);

        longitud = new JLabel("");
        longitud.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panell.add(longitud, gbc);

        // Botón: Localización de astronauta
        getCordenades = new JButton("Localització de l'astronauta");
        getCordenades.setFont(new Font("Arial", Font.BOLD, 14));
        getCordenades.setBackground(new Color(173, 216, 230));
        getCordenades.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panell.add(getCordenades, gbc);

        // Botón: Exit
        exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.BOLD, 14));
        exit.setBackground(new Color(173, 216, 230));
        exit.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panell.add(exit, gbc);

        // Añadir el panel al centro de la ventana
        add(panell, BorderLayout.CENTER);

        setSize(500, 400);
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
            }
        }
        getCordenades.addActionListener(new GetCordenadesListener());

        class  EncriptarMissatgeListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                missatge.setText(astronautaInfo.missatgeEncriptat(missatge.getText()));
            }
        }
        encriptarMissatge.addActionListener(new EncriptarMissatgeListener());



    }
}

package NASA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FrameMecanic extends JFrame {
    private JPanel panell;

    private JTextArea veicles;

    private JButton exit, llistarVehiclesTaller, InmprimirListaVehicles, fixar;

    private Mecanic mecanicInfo; // Declarar como atributo de la clase

    public FrameMecanic(Mecanic mecanicInfo) {
        this.mecanicInfo = mecanicInfo; // Inicializar el atributo

        setTitle("Mecanic - NASA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel con GridBagLayout para mejor disposición
        panell = new JPanel(new GridBagLayout());
        panell.setBackground(new Color(10, 25, 47)); // Fondo oscuro estilo NASA

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta "Mecanic"
        JLabel titleLabel = new JLabel("Mecanic");
        titleLabel.setForeground(new Color(173, 216, 230)); // Azul claro estilo NASA
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panell.add(titleLabel, gbc);

        // Área de texto para listar vehículos
        veicles = new JTextArea(10, 30);
        veicles.setEditable(false);
        veicles.setBackground(new Color(19, 41, 75)); // Fondo oscuro
        veicles.setForeground(Color.WHITE);
        veicles.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panell.add(new JScrollPane(veicles), gbc); // Añadir scroll si el texto es largo

        // Botón "Llistar vehicles taller"
        llistarVehiclesTaller = new JButton("Llistar vehicles taller");
        styleButton(llistarVehiclesTaller);
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panell.add(llistarVehiclesTaller, gbc);

        // Botón "Inmprimir lista vehicles taller"
        InmprimirListaVehicles = new JButton("Inmprimir lista vehicles taller");
        styleButton(InmprimirListaVehicles);
        gbc.gridx = 1;
        panell.add(InmprimirListaVehicles, gbc);

        // Botón "Fixar"
        fixar = new JButton("Fixar");
        styleButton(fixar);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panell.add(fixar, gbc);

        // Botón "Exit"
        exit = new JButton("Exit");
        styleButton(exit);
        gbc.gridx = 1;
        panell.add(exit, gbc);

        // Añadir panel al centro
        add(panell, BorderLayout.CENTER);

        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // Action Listeners
        exit.addActionListener(new ExitListener());
        llistarVehiclesTaller.addActionListener(new LlistarVehiclesTallerListener());
        InmprimirListaVehicles.addActionListener(new InmprimirListaVehiclesListener());
        fixar.addActionListener(new FixarListener());
    }

    // Método para estilizar los botones
    private void styleButton(JButton button) {
        button.setBackground(new Color(173, 216, 230)); // Fondo azul claro
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
    }

    // Clase para el listener del botón Exit
    class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
            new Login();
            dispose();
        }
    }

    // Clase para el listener del botón Llistar vehicles taller
    class LlistarVehiclesTallerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StringBuilder llistaVehicles = mecanicInfo.llistarVeicles((int) mecanicInfo.numeroDelTaller);
            veicles.setText(llistaVehicles.toString());
        }
    }

    // Clase para el listener del botón Imprimir lista vehicles taller
    class InmprimirListaVehiclesListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Seleccionar carpeta");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int userSelection = fileChooser.showDialog(null, "Seleccionar");
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = fileChooser.getSelectedFile();
                System.out.println("Carpeta seleccionada: " + selectedDirectory.getAbsolutePath());
                String rutaCompleta = selectedDirectory.getAbsolutePath() + "/vehicles.txt";
                mecanicInfo.ImorimirVehiclesTaller(rutaCompleta, (int) mecanicInfo.numeroDelTaller);
            }
        }
    }

    // Clase para el listener del botón Fixar
    class FixarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mecanicInfo.fitxar(mecanicInfo.idUsuari);
            JOptionPane.showMessageDialog(null, "Has fitxat correctament");
        }
    }
}

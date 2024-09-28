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
    public FrameMecanic(Mecanic mecanicInfo){
        setVisible(true);
        setTitle("Mecanic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panell = new JPanel();

        panell.add(new JLabel("Mecanic"));

        veicles = new JTextArea();
        veicles.setEditable(false);
        panell.add(veicles);

        llistarVehiclesTaller = new JButton("Llistar vehicles taller");
        panell.add(llistarVehiclesTaller);

        InmprimirListaVehicles = new JButton("Inmprimir lista vehicles taller");
        panell.add(InmprimirListaVehicles);

        fixar = new JButton("Fixar");
        panell.add(fixar);


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

        class  LlistarVehiclesTallerListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                StringBuilder llistaVehicles = mecanicInfo.llistarVeicles((int) mecanicInfo.numeroDelTaller);
                veicles.setText(llistaVehicles.toString());
            }
        }
        llistarVehiclesTaller.addActionListener(new LlistarVehiclesTallerListener());

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
        InmprimirListaVehicles.addActionListener(new InmprimirListaVehiclesListener());

        class  FixarListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                mecanicInfo.fitxar(mecanicInfo.idUsuari);
            }
        }
        fixar.addActionListener(new FixarListener());


    }
}

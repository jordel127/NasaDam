package NASA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameFisic extends JFrame {
    private JPanel panell;

    private JButton exit, funcio1, funcio2, funcio3, fixar;

    private JTextField nomPlaneta;

    private JLabel resposta;

    public FrameFisic(Fisic fisicInfo){
        setTitle("Fisic - NASA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel con GridBagLayout para mejor disposición
        panell = new JPanel(new GridBagLayout());
        panell.setBackground(new Color(10, 25, 47));  // Fondo oscuro estilo NASA

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta "Planeta per comprobar"
        JLabel labelPlaneta = new JLabel("Planeta per comprobar: ");
        labelPlaneta.setForeground(new Color(173, 216, 230));  // Azul claro estilo NASA
        labelPlaneta.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panell.add(labelPlaneta, gbc);

        // Campo de texto para el nombre del planeta
        nomPlaneta = new JTextField(10);
        nomPlaneta.setBackground(new Color(19, 41, 75));  // Fondo oscuro
        nomPlaneta.setForeground(Color.WHITE);
        nomPlaneta.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
        gbc.gridx = 1;
        panell.add(nomPlaneta, gbc);

        // Botón "Temps de viatge"
        funcio1 = new JButton("Temps de viatge");
        styleButton(funcio1);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panell.add(funcio1, gbc);

        // Botón "Cost econòmic"
        funcio2 = new JButton("Cost econòmic");
        styleButton(funcio2);
        gbc.gridy = 2;
        panell.add(funcio2, gbc);

        // Botón "Planeta més econòmic"
        funcio3 = new JButton("Planeta més econòmic");
        styleButton(funcio3);
        gbc.gridy = 3;
        panell.add(funcio3, gbc);

        // Botón "Fixar"
        fixar = new JButton("Fixar");
        styleButton(fixar);
        gbc.gridy = 4;
        panell.add(fixar, gbc);

        // Botón "Exit"
        exit = new JButton("Exit");
        styleButton(exit);
        gbc.gridy = 5;
        panell.add(exit, gbc);

        // Label de respuesta
        resposta = new JLabel();
        resposta.setForeground(Color.WHITE);
        gbc.gridy = 6;
        panell.add(resposta, gbc);

        // Añadir panel al centro
        add(panell, BorderLayout.CENTER);

        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        class  ExitListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
                new Login();
                dispose();
            }
        }

        exit.addActionListener(new ExitListener());

        class  TempsViatgeListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String planeta = nomPlaneta.getText();
                double temps = fisicInfo.tempsDeViatge(planeta);
                resposta.setText("");
                if (planeta.equals("")){
                    resposta.setText("Introdueix un nom de planeta");
                }else if (temps == 0){
                    resposta.setText("No existeix o no es apte aquest planeta");
                }
                else {
                    resposta.setText("El temps de viatge desde la Terra fins "+planeta+" es de: " + temps + " anys");
                }
            }
        }
        funcio1.addActionListener(new TempsViatgeListener());

        class  costEconomicListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String planeta = nomPlaneta.getText();
                double cost = fisicInfo.costEconomicRecorregut(planeta);
                resposta.setText("");
                if (planeta.equals("")){
                    resposta.setText("Introdueix un nom de planeta");
                }else if (cost == 0){
                    resposta.setText("No existeix o no es apte aquest planeta");
                }
                else {
                    resposta.setText("El cost econòmic del planeta "+planeta+" es de: " + (long) cost + " €");
                }
            }
        }


        funcio2.addActionListener(new costEconomicListener());

    class  PlanetaMesEconomicListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String respuesta = fisicInfo.PlanetaMesEconomic();
            resposta.setText(respuesta);
        }
    }
    funcio3.addActionListener(new PlanetaMesEconomicListener());

        class  FixarListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                fisicInfo.fitxar(fisicInfo.idUsuari);
                JOptionPane.showMessageDialog(null, "Has fitxat correctament");
            }
        }
        fixar.addActionListener(new FixarListener());
    }
    private void styleButton(JButton button) {
        button.setBackground(new Color(173, 216, 230));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
    }
}

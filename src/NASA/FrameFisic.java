package NASA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameFisic extends JFrame {
    private JPanel panell;

    private JButton exit, funcio1, funcio2, funcio3;

    private JTextField nomPlaneta;

    private JLabel resposta;

    public FrameFisic() {
        setVisible(true);
        setTitle("Fisic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panell = new JPanel();



        panell.add(new JLabel("Planeta per comprobar: "));
        nomPlaneta = new JTextField(10);
        panell.add(nomPlaneta);

        funcio1 = new JButton("Temps de viatge");
        panell.add(funcio1);

        funcio2 = new JButton("Cost econòmic");
        panell.add(funcio2);

        funcio3 = new JButton("Planeta més econòmic");
        panell.add(funcio3);

        exit = new JButton("Exit");
        panell.add(exit);

        resposta = new JLabel();
        panell.add(resposta);

        add(panell, BorderLayout.CENTER);

        setSize(700, 500);
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

        class  TempsViatgeListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String planeta = nomPlaneta.getText();
                double temps = new Fisic("1", "1", 1, 1, "1", "1", 1, "1", "1").tempsDeViatge(planeta);
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
                double cost = new Fisic("1", "1", 1, 1, "1", "1", 1, "1", "1").costEconomicRecorregut(planeta);
                resposta.setText("");
                if (planeta.equals("")){
                    resposta.setText("Introdueix un nom de planeta");
                }else if (cost == 0){
                    resposta.setText("No existeix o no es apte aquest planeta");
                }
                else {
                    resposta.setText("El cost econòmic del planeta "+planeta+" es de: " + cost + " €");
                }
            }
        }


        funcio2.addActionListener(new costEconomicListener());

    class  PlanetaMesEconomicListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String respuesta = new Fisic("1", "1", 1, 1, "1", "1", 1, "1", "1").PlanetaMesEconomic();
            resposta.setText(respuesta);
        }
    }
    funcio3.addActionListener(new PlanetaMesEconomicListener());
    }
}

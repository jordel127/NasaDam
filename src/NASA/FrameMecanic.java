package NASA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMecanic extends JFrame {
    private JPanel panell;

    private JButton exit;
    public FrameMecanic(Mecanic mecanicInfo){
        setVisible(true);
        setTitle("Mecanic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panell = new JPanel();

        panell.add(new JLabel("Mecanic"));

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
    }
}

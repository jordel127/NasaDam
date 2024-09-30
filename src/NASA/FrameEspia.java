package NASA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameEspia extends JFrame {
    private JPanel panell;

    private JTextField missatge;
    private JButton exit, encriptarMissatge;
    private JTextField campoNombre;
    private JTextField campoContrasenya;
    private JTextField campoRoll;
    private JTextField campoTelefon;
    private JTextField campoIdUsuari;
    private EspaiCRUD espaiCRUD;

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

        espaiCRUD = new EspaiCRUD();
        // Configuracio del jframe
        setTitle("Gestió d'espies");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2)); // Distribució dels component

        // Camps del formulari
        JLabel etiquetaIdUsuari = new JLabel("ID Usuari:");
        campoIdUsuari = new JTextField();

        JLabel etiquetaNombre = new JLabel("Nom:");
        campoNombre = new JTextField();

        JLabel etiquetaContrasenya = new JLabel("Contrasenya:");
        campoContrasenya = new JTextField();

        JLabel etiquetaRoll = new JLabel("Rol:");
        campoRoll = new JTextField();

        JLabel etiquetaTelefon = new JLabel("Teléfon:");
        campoTelefon = new JTextField();

        // Botons
        JButton botonCrear = new JButton("Crear Espía");
        JButton botonActualizar = new JButton("Actualizar Espía");
        JButton botonEliminar = new JButton("Eliminar Espía");
        JButton botonBuscar = new JButton("Buscar Espía");

        // Agregar component al JFrame
        add(etiquetaIdUsuari);
        add(campoIdUsuari);
        add(etiquetaNombre);
        add(campoNombre);
        add(etiquetaContrasenya);
        add(campoContrasenya);
        add(etiquetaRoll);
        add(campoRoll);
        add(etiquetaTelefon);
        add(campoTelefon);

        add(botonCrear);
        add(botonActualizar);
        add(botonEliminar);
        add(botonBuscar);

        // Funció botó crear espía
        botonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearEspia();
            }
        });

        // Funció botó actualitzar espía
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarEspia();
            }
        });

        // Funció botó eliminar espía
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarEspia();
            }
        });

        // Funció botó buscar espía
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEspia();
            }
        });
    }

    // Metode crear espía
    private void crearEspia() {
        String nombre = campoNombre.getText();
        String contrasenya = campoContrasenya.getText();
        String roll = campoRoll.getText();
        String telefon = campoTelefon.getText();

        Espia nuevoEspia = new Espia(nombre, contrasenya, roll, telefon);
        boolean exito = espaiCRUD.insertarEspia(nuevoEspia);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Espía creat");
        } else {
            JOptionPane.showMessageDialog(this, "Error al crear espía");
        }
    }

    // Metode actualitzar espía
    private void actualizarEspia() {
        try {
            int idUsuari = Integer.parseInt(campoIdUsuari.getText());
            String nombre = campoNombre.getText();
            String contrasenya = campoContrasenya.getText();
            String roll = campoRoll.getText();
            String telefon = campoTelefon.getText();

            Espia espiaActualizado = new Espia(nombre, contrasenya, roll, telefon);

            boolean exito = espaiCRUD.actualizarEspia(espiaActualizado, idUsuari);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Espía actualizado");
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar espía");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID de usuario debe ser un número válido.");
        }
    }

    // Métode per eliminar espía
    private void eliminarEspia() {
        int idUsuari = Integer.parseInt(campoIdUsuari.getText());
        boolean exito = espaiCRUD.eliminarEspia(idUsuari);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Espía eliminat");
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar espía");
        }
    }

    private void buscarEspia() {

        int idUsuari = Integer.parseInt(campoIdUsuari.getText());

        Espia espia = espaiCRUD.obtenerEspia(idUsuari);

        if (espia != null) {
            campoNombre.setText(espia.getNom());
            campoContrasenya.setText(espia.getContrasenya());
            campoRoll.setText(espia.getRoll());
            campoTelefon.setText(espia.getTelefon());
            JOptionPane.showMessageDialog(this, "Espía encontrado");
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún espía con ese ID");
        }
    }
}

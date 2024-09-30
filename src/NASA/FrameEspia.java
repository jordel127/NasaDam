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

    public FrameEspia(Espia espiaInfo) {
        setVisible(true);
        setTitle("Gestió d'Espies - NASA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior para encriptación
        panell = new JPanel(new GridBagLayout());
        panell.setBackground(new Color(10, 25, 47)); // Fondo oscuro
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Márgenes entre componentes

        // Título Espia
        JLabel titleLabel = new JLabel("Espia");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(173, 216, 230)); // Azul claro
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centrar el título
        panell.add(titleLabel, gbc);

        // Campo de texto: Mensaje encriptado
        JLabel missatgeLabel = new JLabel("Missatge encriptat: ");
        missatgeLabel.setForeground(new Color(173, 216, 230)); // Azul claro
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END; // Alinea a la derecha
        panell.add(missatgeLabel, gbc);

        missatge = new JTextField(15);
        missatge.setFont(new Font("Arial", Font.PLAIN, 14));
        missatge.setBackground(new Color(19, 41, 75));
        missatge.setForeground(Color.WHITE);
        missatge.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2, true));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START; // Alinea a la izquierda
        panell.add(missatge, gbc);

        // Botón: Encriptar mensaje
        encriptarMissatge = new JButton("Encriptar missatge");
        encriptarMissatge.setFont(new Font("Arial", Font.BOLD, 14));
        encriptarMissatge.setBackground(new Color(173, 216, 230));
        encriptarMissatge.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panell.add(encriptarMissatge, gbc);

        // Botón: Exit
        exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.BOLD, 14));
        exit.setBackground(new Color(173, 216, 230));
        exit.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panell.add(exit, gbc);

        // Añadir el panel superior
        add(panell, BorderLayout.NORTH);

        // Panel para la gestión de espías
        JPanel gestionPanel = new JPanel(new GridBagLayout());
        gestionPanel.setBackground(new Color(10, 25, 47));
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes más pequeños para los formularios

        // Campos del formulario
        JLabel etiquetaIdUsuari = new JLabel("ID Usuari:");
        etiquetaIdUsuari.setForeground(new Color(173, 216, 230));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gestionPanel.add(etiquetaIdUsuari, gbc);

        campoIdUsuari = new JTextField(15);
        campoIdUsuari.setBackground(new Color(19, 41, 75));
        campoIdUsuari.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gestionPanel.add(campoIdUsuari, gbc);

        JLabel etiquetaNombre = new JLabel("Nom:");
        etiquetaNombre.setForeground(new Color(173, 216, 230));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gestionPanel.add(etiquetaNombre, gbc);

        campoNombre = new JTextField(15);
        campoNombre.setBackground(new Color(19, 41, 75));
        campoNombre.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gestionPanel.add(campoNombre, gbc);

        JLabel etiquetaContrasenya = new JLabel("Contrasenya:");
        etiquetaContrasenya.setForeground(new Color(173, 216, 230));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        gestionPanel.add(etiquetaContrasenya, gbc);

        campoContrasenya = new JTextField(15);
        campoContrasenya.setBackground(new Color(19, 41, 75));
        campoContrasenya.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gestionPanel.add(campoContrasenya, gbc);

        JLabel etiquetaRoll = new JLabel("Rol:");
        etiquetaRoll.setForeground(new Color(173, 216, 230));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        gestionPanel.add(etiquetaRoll, gbc);

        campoRoll = new JTextField(15);
        campoRoll.setBackground(new Color(19, 41, 75));
        campoRoll.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        gestionPanel.add(campoRoll, gbc);

        JLabel etiquetaTelefon = new JLabel("Teléfon:");
        etiquetaTelefon.setForeground(new Color(173, 216, 230));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        gestionPanel.add(etiquetaTelefon, gbc);

        campoTelefon = new JTextField(15);
        campoTelefon.setBackground(new Color(19, 41, 75));
        campoTelefon.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        gestionPanel.add(campoTelefon, gbc);

        // Botones de acciones
        JButton botonCrear = new JButton("Crear Espía");
        botonCrear.setBackground(new Color(173, 216, 230));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gestionPanel.add(botonCrear, gbc);

        JButton botonActualizar = new JButton("Actualizar Espía");
        botonActualizar.setBackground(new Color(173, 216, 230));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        gestionPanel.add(botonActualizar, gbc);

        JButton botonEliminar = new JButton("Eliminar Espía");
        botonEliminar.setBackground(new Color(173, 216, 230));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gestionPanel.add(botonEliminar, gbc);

        JButton botonBuscar = new JButton("Buscar Espía");
        botonBuscar.setBackground(new Color(173, 216, 230));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        gestionPanel.add(botonBuscar, gbc);

        // Añadir el panel de gestión de espías en la parte inferior
        add(gestionPanel, BorderLayout.CENTER);

        // Ajustar el tamaño automáticamente según el contenido
        pack();
        setLocationRelativeTo(null); // Centrar la ventana
        setResizable(false);
        espaiCRUD = new EspaiCRUD();

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

        // Funciones para los botones de CRUD
        botonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearEspia();
            }
        });

        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarEspia();
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarEspia();
            }
        });

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

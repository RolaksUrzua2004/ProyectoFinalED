/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocine;

/**
 *
 * @author Sveen Urzua
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Interfaz gráfica para la venta de boletos en un cine.
 * Permite al usuario seleccionar una película, ingresar su nombre y seleccionar asientos disponibles.
 */
public class InterfazCine extends JFrame {
    private JTextField nombreTextField; // Campo de texto para el nombre del cliente
    private JComboBox<String> peliculasComboBox; // Desplegable para seleccionar una película
    private JPanel panelAsientos; // Panel para mostrar los botones de asientos
    private Cine cine; // Objeto principal que gestiona las funciones y boletos del cine
    private List<Asiento> asientosSeleccionados; // Lista de asientos seleccionados por el usuario

    /**
     * Constructor que configura la interfaz gráfica y sus componentes.
     */
    public InterfazCine() {
        cine = new Cine(); // Inicializa el objeto Cine con sus funciones
        asientosSeleccionados = new ArrayList<>(); // Inicializa la lista de asientos seleccionados

        mostrarFuncionesDisponibles(); // Muestra las funciones al inicio

        setTitle("Venta de Boletos - Cine"); // Configura el título de la ventana
        setSize(600, 600); // Establece el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setLayout(new BorderLayout()); // Layout principal de la ventana

        // Panel para el formulario de entrada (nombre y selección de película)
        JPanel panelFormulario = new JPanel(new GridLayout(5, 1));
        nombreTextField = new JTextField(20); // Campo de texto para el nombre del cliente
        peliculasComboBox = new JComboBox<>(new String[]{"Venom el último baile", "Sonríe 2", "Gladiador (ReEstreno)"}); // Películas

        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(nombreTextField);
        panelFormulario.add(new JLabel("Selecciona tu película:"));
        panelFormulario.add(peliculasComboBox);

        // Botón de confirmación
        JButton confirmarButton = new JButton("Confirmar Selección");
        confirmarButton.addActionListener(new ConfirmarListener()); // Añade el ActionListener al botón
        panelFormulario.add(confirmarButton);

        // Panel de asientos con diseño de cuadrícula
        panelAsientos = new JPanel(new GridLayout(4, 4, 10, 10));

        add(panelFormulario, BorderLayout.NORTH);
        add(panelAsientos, BorderLayout.CENTER);

        // Actualiza la vista de asientos cuando se selecciona una película diferente
        peliculasComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarAsientos(); // Actualiza los asientos al cambiar de película
            }
        });

        actualizarAsientos(); // Inicializa la vista de los asientos
    }

    /**
     * Muestra un cuadro de diálogo con las funciones disponibles, horarios y precios.
     */
    private void mostrarFuncionesDisponibles() {
        StringBuilder mensaje = new StringBuilder("Funciones disponibles:\n\n");
        for (Funcion funcion : cine.getFunciones()) {
            mensaje.append(funcion.getNombre())
                    .append(" - ")
                    .append(funcion.getHorario())
                    .append(" - $")
                    .append(funcion.getPrecio())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(this, mensaje.toString(), "Cartelera", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Actualiza la vista de asientos según la función seleccionada.
     * Muestra los asientos ocupados en rojo y los disponibles en verde.
     */
    private void actualizarAsientos() {
        panelAsientos.removeAll(); // Limpia el panel de asientos
        asientosSeleccionados.clear(); // Limpia la lista de asientos seleccionados

        Funcion funcionSeleccionada = cine.getFunciones().get(peliculasComboBox.getSelectedIndex());

        // Crea botones para los asientos
        for (Asiento asiento : funcionSeleccionada.getAsientos()) {
            JButton botonAsiento = new JButton(String.valueOf(asiento.getNumero()));
            botonAsiento.setBackground(asiento.isDisponible() ? Color.GREEN : Color.RED);
            botonAsiento.setEnabled(asiento.isDisponible());

            // Listener para seleccionar/deseleccionar asientos
            botonAsiento.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (botonAsiento.getBackground() == Color.GREEN) {
                        botonAsiento.setBackground(Color.YELLOW); // Marca el asiento como seleccionado
                        asientosSeleccionados.add(asiento);
                    } else if (botonAsiento.getBackground() == Color.YELLOW) {
                        botonAsiento.setBackground(Color.GREEN); // Devuelve el asiento a disponible
                        asientosSeleccionados.remove(asiento);
                    }
                }
            });

            panelAsientos.add(botonAsiento); // Agrega el botón al panel de asientos
        }

        panelAsientos.revalidate();
        panelAsientos.repaint();
    }

    /**
     * Clase interna para manejar la confirmación de la selección del cliente.
     */
    private class ConfirmarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = nombreTextField.getText();
            Funcion funcionSeleccionada = cine.getFunciones().get(peliculasComboBox.getSelectedIndex());

            if (asientosSeleccionados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona al menos un asiento.");
                return;
            }

            for (Asiento asiento : asientosSeleccionados) {
                funcionSeleccionada.venderBoleto(nombre, asiento.getNumero());
            }

            JOptionPane.showMessageDialog(null, "Cliente: " + nombre + "\nPelícula: " + funcionSeleccionada.getNombre() +
                    "\nPrecio por boleto: $" + funcionSeleccionada.getPrecio() +
                    "\nAsientos seleccionados: " + asientosSeleccionados.size());

            actualizarAsientos(); // Refresca los asientos ocupados
        }
    }

    /**
     * Método principal para ejecutar la interfaz gráfica.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazCine().setVisible(true));
    }
}

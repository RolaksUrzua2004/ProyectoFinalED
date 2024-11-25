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
 * Permite al usuario seleccionar su nombre, una película y asientos disponibles.
 * Los asientos seleccionados se almacenan y se confirma la compra al finalizar.
 */
public class InterfazCine extends JFrame {
    private JTextField nombreTextField; // Campo para ingresar el nombre del cliente
    private JComboBox<String> peliculasComboBox; // Desplegable para seleccionar la película
    private JPanel panelAsientos; // Panel que muestra la distribución de asientos
    private Cine cine; // Objeto principal que contiene las funciones y boletos del cine
    private List<Asiento> asientosSeleccionados; // Lista para almacenar los asientos seleccionados por el usuario

    /**
     * Constructor que configura la interfaz gráfica y todos sus componentes.
     * Configura campos de entrada, el panel de asientos, y los botones de confirmación.
     */
    public InterfazCine() {
        cine = new Cine(); // Inicializa el cine con sus funciones
        asientosSeleccionados = new ArrayList<>(); // Inicializa la lista de asientos seleccionados

        setTitle("Venta de Boletos - Cine"); // Configura el título de la ventana
        setSize(500, 500); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura el cierre de la ventana
        setLayout(new BorderLayout()); // Layout principal de la ventana

        // Panel superior para el formulario de nombre y selección de película
        JPanel panelFormulario = new JPanel(new GridLayout(5, 1));
        nombreTextField = new JTextField(20); // Campo de texto para el nombre del cliente
        peliculasComboBox = new JComboBox<>(new String[]{"Venom el último baile", "Sonríe 2", "Gladiador (ReEstreno)"}); // ComboBox de películas

        // Añade etiquetas y campos de entrada al panel del formulario
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(nombreTextField);
        panelFormulario.add(new JLabel("Selecciona tu película:"));
        panelFormulario.add(peliculasComboBox);

        // Botón de confirmación para guardar la selección del cliente
        JButton confirmarButton = new JButton("Confirmar Selección");
        confirmarButton.addActionListener(new ConfirmarListener()); // Añade el ActionListener al botón
        panelFormulario.add(confirmarButton); // Añade el botón al panel del formulario

        // Panel de asientos en una cuadrícula de 4x4
        panelAsientos = new JPanel(new GridLayout(4, 4, 10, 10));

        // Añadir el panel del formulario y el panel de asientos a la ventana principal
        add(panelFormulario, BorderLayout.NORTH);
        add(panelAsientos, BorderLayout.CENTER);

        // Listener para actualizar los asientos cada vez que se cambia la película seleccionada
        peliculasComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarAsientos(); // Actualiza el panel de asientos para la nueva película seleccionada
            }
        });

        actualizarAsientos(); // Llama al método para mostrar la distribución inicial de los asientos
    }

    /**
     * Actualiza el panel de asientos para la función seleccionada.
     * Muestra los asientos disponibles en verde y los ocupados en rojo.
     * Permite al usuario seleccionar y deseleccionar asientos.
     */
    private void actualizarAsientos() {
        panelAsientos.removeAll(); // Limpia el panel de asientos
        asientosSeleccionados.clear(); // Limpia la lista de asientos seleccionados

        // Obtiene la función seleccionada en el ComboBox de películas
        Funcion funcionSeleccionada = cine.getFunciones().get(peliculasComboBox.getSelectedIndex());
        
        // Crea botones para cada asiento en la función seleccionada
        for (Asiento asiento : funcionSeleccionada.getAsientos()) {
            JButton botonAsiento = new JButton(String.valueOf(asiento.getNumero())); // Botón que representa el asiento
            botonAsiento.setBackground(asiento.isDisponible() ? Color.GREEN : Color.RED); // Verde para disponible, rojo para ocupado
            botonAsiento.setEnabled(asiento.isDisponible()); // Habilita el botón solo si el asiento está disponible

            // Listener para manejar la selección de asientos
            botonAsiento.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (asiento.isDisponible()) {
                        // Cambia el color del botón y registra o elimina la selección del asiento
                        if (botonAsiento.getBackground() == Color.GREEN) {
                            botonAsiento.setBackground(Color.YELLOW); // Marca el asiento como seleccionado
                            asientosSeleccionados.add(asiento); // Añade el asiento a la lista de seleccionados
                        } else if (botonAsiento.getBackground() == Color.YELLOW) {
                            botonAsiento.setBackground(Color.GREEN); // Devuelve el asiento a disponible
                            asientosSeleccionados.remove(asiento); // Remueve el asiento de la lista
                        }
                    }
                }
            });

            panelAsientos.add(botonAsiento); // Añade el botón al panel de asientos
        }

        panelAsientos.revalidate(); // Refresca el panel de asientos
        panelAsientos.repaint(); // Redibuja el panel de asientos
    }

    /**
     * Clase interna para manejar la confirmación de la selección del cliente.
     * Crea los boletos de los asientos seleccionados y marca los asientos como ocupados.
     */
    private class ConfirmarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = nombreTextField.getText(); // Obtiene el nombre ingresado
            String pelicula = (String) peliculasComboBox.getSelectedItem(); // Obtiene la película seleccionada
            Funcion funcionSeleccionada = cine.getFunciones().get(peliculasComboBox.getSelectedIndex()); // Función seleccionada

            // Verifica que se haya seleccionado al menos un asiento
            if (asientosSeleccionados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona al menos un asiento.");
                return; // Salir si no se ha seleccionado ningún asiento
            }

            // Recorre los asientos seleccionados y crea un boleto para cada uno
            for (Asiento asiento : asientosSeleccionados) {
                funcionSeleccionada.venderBoleto(nombre, asiento.getNumero(), 100.0); // Precio fijo de ejemplo
                asiento.ocupar(); // Marca el asiento como ocupado
            }

            // Muestra mensaje de confirmación con el nombre, película y cantidad de asientos seleccionados
            JOptionPane.showMessageDialog(null, "Cliente: " + nombre + "\nPelícula: " + pelicula + "\nAsientos: " + asientosSeleccionados.size());

            actualizarAsientos(); // Actualiza el estado de los asientos en la interfaz después de la compra
        }
    }

    /**
     * Método principal para ejecutar la aplicación.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazCine().setVisible(true)); // Muestra la interfaz gráfica
    }
}

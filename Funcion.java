/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocine;

/**
 *
 * @author Sveen Urzua
 */
import java.util.ArrayList;

public class Funcion {
    private final String nombre;             // Nombre de la función (película)
    private final String horario;            // Horario de la función
    private final ArrayList<Asiento> asientos; // Lista de asientos disponibles para esta función
    private final ArrayList<Boleto> boletos;   // Lista de boletos vendidos

    // Constructor que inicializa la función con su nombre y horario, y crea los asientos
    public Funcion(String nombre, String horario) {
        this.nombre = nombre;
        this.horario = horario;
        this.asientos = new ArrayList<>();
        this.boletos = new ArrayList<>();

        // Crear 16 asientos numerados para la función
        for (int i = 1; i <= 16; i++) {
            asientos.add(new Asiento(i));
        }
    }

    // Devuelve el nombre de la función
    public String getNombre() {
        return nombre;
    }

    // Devuelve el horario de la función
    public String getHorario() {
        return horario;
    }

    // Devuelve la lista de asientos
    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    // Vende un boleto y marca el asiento como ocupado
    public void venderBoleto(String cliente, int numeroAsiento, double precio) {
        Asiento asiento = asientos.get(numeroAsiento - 1); // Obtener el asiento
        if (asiento.isDisponible()) {
            asiento.ocupar(); // Marcar el asiento como ocupado
            Boleto boleto = new Boleto(cliente, numeroAsiento, precio);
            boletos.add(boleto); // Agregar el boleto a la lista de boletos vendidos
        }
    }

    // Muestra el diseño de la sala, con asientos disponibles y ocupados
    public void mostrarAsientos() {
        System.out.println("PANTALLA");
        for (int i = 0; i < asientos.size(); i++) {
            // Muestra el estado de cada asiento
            System.out.print(asientos.get(i).mostrarEstado() + " ");
            if ((i + 1) % 4 == 0) { // Salto de línea después de cada 4 asientos
                System.out.println();
            }
        }
    }
}

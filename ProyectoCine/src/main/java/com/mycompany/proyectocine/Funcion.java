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
import java.util.List;

/**
 * Representa una función de cine con un horario, una lista de asientos y boletos vendidos.
 */
public class Funcion {
    private String nombre;
    private String horario;
    private List<Asiento> asientos;
    private List<Boleto> boletosVendidos;

    /**
     * Constructor que inicializa la función con su nombre, horario y crea los asientos.
     * @param nombre Nombre de la película.
     * @param horario Horario de la función.
     */
    public Funcion(String nombre, String horario) {
        this.nombre = nombre;
        this.horario = horario;
        this.asientos = new ArrayList<>();
        this.boletosVendidos = new ArrayList<>();
        inicializarAsientos(); // Crea los asientos disponibles
    }

    /**
     * Inicializa 16 asientos disponibles para la función.
     */
    private void inicializarAsientos() {
        for (int i = 1; i <= 16; i++) {
            asientos.add(new Asiento(i));
        }
    }

    // Obtiene el nombre de la película
    public String getNombre() {
        return nombre;
    }

    // Obtiene el horario de la función
    public String getHorario() {
        return horario;
    }

    // Obtiene la lista de asientos
    public List<Asiento> getAsientos() {
        return asientos;
    }

    // Obtiene la lista de boletos vendidos
    public List<Boleto> getBoletosVendidos() {
        return boletosVendidos;
    }

    /**
     * Vende un boleto si el asiento está disponible.
     * @param cliente Nombre del cliente.
     * @param numeroAsiento Número de asiento.
     * @param precio Precio del boleto.
     */
    public void venderBoleto(String cliente, int numeroAsiento, double precio) {
        Asiento asiento = asientos.get(numeroAsiento - 1);
        if (asiento.isDisponible()) {
            asiento.ocupar(); // Ocupa el asiento
            Boleto boleto = new Boleto(cliente, this, asiento, precio);
            boletosVendidos.add(boleto); // Agrega el boleto a la lista de boletos vendidos
        }
    }

    // Devuelve la cantidad de boletos vendidos
    public int cantidadBoletosVendidos() {
        return boletosVendidos.size();
    }

    // Calcula el total de ganancias de los boletos vendidos
    public double totalGanancias() {
        double total = 0;
        for (Boleto boleto : boletosVendidos) {
            total += boleto.getPrecio();
        }
        return total;
    }
}

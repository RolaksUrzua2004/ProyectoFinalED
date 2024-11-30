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
 * Representa una función de cine.
 * Contiene el nombre de la película, horario, precio de los boletos,
 * lista de asientos y boletos vendidos.
 */
public class Funcion {
    private String nombre; // Nombre de la película
    private String horario; // Horario de la función
    private double precio; // Precio del boleto para esta función
    private List<Asiento> asientos; // Lista de asientos para la función
    private List<Boleto> boletosVendidos; // Lista de boletos vendidos

    /**
     * Constructor que inicializa la función con nombre, horario y precio.
     * También crea una lista de asientos para la función.
     * 
     * @param nombre Nombre de la película.
     * @param horario Horario de la función.
     * @param precio Precio del boleto para esta función.
     */
    public Funcion(String nombre, String horario, double precio) {
        this.nombre = nombre;
        this.horario = horario;
        this.precio = precio;
        this.asientos = new ArrayList<>();
        this.boletosVendidos = new ArrayList<>();
        inicializarAsientos(); // Inicializa los asientos de la sala
    }

    /**
     * Inicializa una lista de 16 asientos disponibles.
     * Cada asiento se crea con un número único del 1 al 16.
     */
    private void inicializarAsientos() {
        for (int i = 1; i <= 16; i++) {
            asientos.add(new Asiento(i)); // Crea asientos numerados
        }
    }

    /**
     * Devuelve el nombre de la película.
     * 
     * @return Nombre de la película.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el horario de la función.
     * 
     * @return Horario de la función.
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Devuelve el precio del boleto para esta función.
     * 
     * @return Precio del boleto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Devuelve la lista de asientos para la función.
     * 
     * @return Lista de asientos.
     */
    public List<Asiento> getAsientos() {
        return asientos;
    }

    /**
     * Devuelve la lista de boletos vendidos.
     * 
     * @return Lista de boletos vendidos.
     */
    public List<Boleto> getBoletosVendidos() {
        return boletosVendidos;
    }

    /**
     * Vende un boleto si el asiento está disponible.
     * Crea un nuevo boleto y lo agrega a la lista de boletos vendidos.
     * 
     * @param cliente Nombre del cliente.
     * @param numeroAsiento Número del asiento que desea reservar.
     */
    public void venderBoleto(String cliente, int numeroAsiento) {
        Asiento asiento = asientos.get(numeroAsiento - 1); // Obtiene el asiento por número
        if (asiento.isDisponible()) { // Verifica si el asiento está disponible
            asiento.ocupar(); // Marca el asiento como ocupado
            Boleto boleto = new Boleto(cliente, this, asiento, precio); // Crea un boleto
            boletosVendidos.add(boleto); // Agrega el boleto a la lista de boletos vendidos
        }
    }

    /**
     * Calcula y devuelve la cantidad de boletos vendidos para esta función.
     * 
     * @return Cantidad de boletos vendidos.
     */
    public int cantidadBoletosVendidos() {
        return boletosVendidos.size();
    }

    /**
     * Calcula y devuelve el total de ganancias de los boletos vendidos.
     * 
     * @return Total de ganancias.
     */
    public double totalGanancias() {
        double total = 0;
        for (Boleto boleto : boletosVendidos) {
            total += boleto.getPrecio(); // Suma el precio de cada boleto
        }
        return total;
    }
}

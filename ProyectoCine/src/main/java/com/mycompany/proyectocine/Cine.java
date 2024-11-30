/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocine;

/**
 *
 * @author user
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Representa el sistema del cine.
 * Contiene una lista de funciones y métodos para generar reportes de ventas.
 */
public class Cine {
    private List<Funcion> funciones; // Lista de funciones disponibles en el cine

    /**
     * Constructor que inicializa la lista de funciones.
     * Llama al método para agregar funciones con sus horarios y precios.
     */
    public Cine() {
        this.funciones = new ArrayList<>();
        agregarFunciones();
    }

    /**
     * Agrega funciones (películas) con sus horarios y precios al sistema del cine.
     */
    private void agregarFunciones() {
        funciones.add(new Funcion("Venom el último baile", "2:00 PM", 120.0)); // Precio: 120
        funciones.add(new Funcion("Sonríe 2", "5:00 PM", 100.0));             // Precio: 100
        funciones.add(new Funcion("Gladiador (ReEstreno)", "8:00 PM", 150.0)); // Precio: 150
    }

    /**
     * Devuelve la lista de funciones disponibles.
     * @return Lista de funciones.
     */
    public List<Funcion> getFunciones() {
        return funciones;
    }

    /**
     * Genera un reporte general con la cantidad de boletos vendidos y las ganancias totales.
     */
    public void reporteGeneral() {
        int totalBoletos = 0;
        double totalGanancias = 0;

        for (Funcion funcion : funciones) {
            totalBoletos += funcion.cantidadBoletosVendidos();
            totalGanancias += funcion.totalGanancias();
        }

        System.out.println("Reporte General de Ventas:");
        System.out.println("Boletos Vendidos: " + totalBoletos);
        System.out.println("Total Ganancias: $" + totalGanancias);
    }

    /**
     * Genera un reporte detallado por función.
     * Muestra la cantidad de boletos vendidos y las ganancias por cada función.
     */
    public void reportePorFuncion() {
        System.out.println("Reporte por Función:");
        for (Funcion funcion : funciones) {
            System.out.println("Función: " + funcion.getNombre() + " - " + funcion.getHorario());
            System.out.println("Boletos Vendidos: " + funcion.cantidadBoletosVendidos());
            System.out.println("Ganancias: $" + funcion.totalGanancias());
            System.out.println();
        }
    }
}

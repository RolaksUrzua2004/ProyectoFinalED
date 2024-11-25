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
 * Representa el cine, que contiene una lista de funciones y puede generar reportes de ventas.
 */
public class Cine {
    private List<Funcion> funciones;

    /**
     * Constructor que inicializa el cine y agrega las funciones disponibles.
     */
    public Cine() {
        this.funciones = new ArrayList<>();
        agregarFunciones();
    }

    /**
     * Agrega funciones con películas y horarios al cine.
     */
    private void agregarFunciones() {
        funciones.add(new Funcion("Venom el último baile", "2:00 PM"));
        funciones.add(new Funcion("Sonríe 2", "5:00 PM"));
        funciones.add(new Funcion("Gladiador (ReEstreno)", "8:00 PM"));
    }

    // Obtiene la lista de funciones
    public List<Funcion> getFunciones() {
        return funciones;
    }

    /**
     * Genera un reporte general con el total de boletos vendidos y ganancias.
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
        System.out.println("Total Ganancias: " + totalGanancias);
    }

    /**
     * Genera un reporte por cada función, con la cantidad de boletos vendidos y ganancias.
     */
    public void reportePorFuncion() {
        System.out.println("Reporte por Función:");
        for (Funcion funcion : funciones) {
            System.out.println("Función: " + funcion.getNombre() + " - " + funcion.getHorario());
            System.out.println("Boletos Vendidos: " + funcion.cantidadBoletosVendidos());
            System.out.println("Ganancias: " + funcion.totalGanancias());
        }
    }
}

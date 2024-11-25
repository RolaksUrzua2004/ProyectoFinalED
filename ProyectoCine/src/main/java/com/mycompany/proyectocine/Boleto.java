/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocine;

/**
 *
 * @author Sveen Urzua
 */
/**
 * Representa un boleto de cine vendido a un cliente.
 * Contiene detalles como el nombre del cliente, la función seleccionada, el asiento y el precio.
 */
public class Boleto {
    private String cliente;
    private Funcion funcion;
    private Asiento asiento;
    private double precio;

    /**
     * Constructor para crear un boleto con los detalles proporcionados.
     * @param cliente Nombre del cliente.
     * @param funcion Función seleccionada.
     * @param asiento Asiento reservado.
     * @param precio Precio del boleto.
     */
    public Boleto(String cliente, Funcion funcion, Asiento asiento, double precio) {
        this.cliente = cliente;
        this.funcion = funcion;
        this.asiento = asiento;
        this.precio = precio;
    }

    // Obtiene el nombre del cliente
    public String getCliente() {
        return cliente;
    }

    // Obtiene la función seleccionada
    public Funcion getFuncion() {
        return funcion;
    }

    // Obtiene el asiento reservado
    public Asiento getAsiento() {
        return asiento;
    }

    // Obtiene el precio del boleto
    public double getPrecio() {
        return precio;
    }
}


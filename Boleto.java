/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocine;

/**
 *
 * @author Sveen Urzua
 */
public class Boleto {
    private final String cliente;  // Nombre del cliente que compró el boleto
    private final int asiento;     // Número de asiento asignado
    private final double precio;   // Precio del boleto

    // Constructor que inicializa el boleto con el cliente, número de asiento y precio
    public Boleto(String cliente, int asiento, double precio) {
        this.cliente = cliente;
        this.asiento = asiento;
        this.precio = precio;
    }

    // Devuelve el nombre del cliente
    public String getCliente() {
        return cliente;
    }

    // Devuelve el número de asiento
    public int getAsiento() {
        return asiento;
    }

    // Devuelve el precio del boleto
    public double getPrecio() {
        return precio;
    }
}



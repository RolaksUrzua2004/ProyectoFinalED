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
 * Representa un asiento en la sala de cine.
 * Cada asiento tiene un número y puede estar disponible u ocupado.
 */
public class Asiento {
    private int numero;
    private boolean disponible;

    /**
     * Constructor para inicializar el asiento con su número y como disponible.
     * @param numero Número del asiento.
     */
    public Asiento(int numero) {
        this.numero = numero;
        this.disponible = true; // Por defecto, el asiento está disponible
    }

    // Obtiene el número del asiento
    public int getNumero() {
        return numero;
    }

    // Verifica si el asiento está disponible
    public boolean isDisponible() {
        return disponible;
    }

    // Ocupa el asiento, marcándolo como no disponible
    public void ocupar() {
        this.disponible = false;
    }

    // Libera el asiento, marcándolo como disponible
    public void liberar() {
        this.disponible = true;
    }
}



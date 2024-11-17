/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocine;

/**
 *
 * @author Sveen Urzua
 */
public class Asiento {
    private final int numero;        // Número de asiento
    private boolean disponible; // Indica si el asiento está disponible o no

    // Constructor que inicializa el asiento con su número y lo marca como disponible
    public Asiento(int numero) {
        this.numero = numero;
        this.disponible = true;
    }

    // Devuelve el número del asiento
    public int getNumero() {
        return numero;
    }

    // Devuelve si el asiento está disponible
    public boolean isDisponible() {
        return disponible;
    }

    // Marca el asiento como ocupado
    public void ocupar() {
        this.disponible = false;
    }

    // Marca el asiento como disponible
    public void liberar() {
        this.disponible = true;
    }

    // Devuelve una representación visual del estado del asiento
    // "[O]" para disponible, "[X]" para ocupado
    public String mostrarEstado() {
        return disponible ? "[O]" : "[X]";
    }
}




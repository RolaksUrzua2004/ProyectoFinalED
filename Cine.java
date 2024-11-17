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

public class Cine {
    private final ArrayList<Funcion> funciones; // Lista de funciones disponibles en el cine

    // Constructor que inicializa la lista de funciones
    public Cine() {
        this.funciones = new ArrayList<>();
    }

    // Agrega una función a la lista
    public void agregarFuncion(Funcion funcion) {
        funciones.add(funcion);
    }

    // Devuelve la lista de funciones
    public ArrayList<Funcion> getFunciones() {
        return funciones;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocine;

/**
 *
 * @author Sveen Urzua
 */
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Cine cine = new Cine();
            
            // Crear algunas funciones y agregarlas al cine
            Funcion funcion1 = new Funcion("Venom el último baile", "2:00 PM");
            Funcion funcion2 = new Funcion("Sonríe 2", "5:00 PM");
            Funcion funcion3 = new Funcion("Gladiador (ReEstreno)", "8:00 PM");
            
            cine.agregarFuncion(funcion1);
            cine.agregarFuncion(funcion2);
            cine.agregarFuncion(funcion3);
            
            OUTER:
            while (true) {
                System.out.println("\n1. Comprar boleto");
                System.out.println("2. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1 -> venderBoleto(cine, scanner);
                    case 2 -> {
                        System.out.println("Gracias por usar el sistema de venta de boletos.");
                        break OUTER;
                    }
                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }
            }
        }
    }

    // Método para vender un boleto
    private static void venderBoleto(Cine cine, Scanner scanner) {
        System.out.println("Seleccione la función:");
        for (int i = 0; i < cine.getFunciones().size(); i++) {
            Funcion funcion = cine.getFunciones().get(i);
            System.out.println((i + 1) + ". " + funcion.getNombre() + " - " + funcion.getHorario());
        }

        int opcionFuncion = scanner.nextInt();
        Funcion funcionSeleccionada = cine.getFunciones().get(opcionFuncion - 1);

        // Mostrar el diseño de la sala
        System.out.println("Diseño de la sala (O = Disponible, X = Ocupado):");
        funcionSeleccionada.mostrarAsientos();

        // Pedir el número de asiento
        System.out.print("Ingrese el número de asiento (1-16): ");
        int numeroAsiento = scanner.nextInt();

        // Verificar si el asiento está disponible
        if (funcionSeleccionada.getAsientos().get(numeroAsiento - 1).isDisponible()) {
            System.out.print("Ingrese el nombre del cliente: ");
            String cliente = scanner.next();

            System.out.print("Ingrese el precio del boleto: ");
            double precio = scanner.nextDouble();

            // Vender el boleto
            funcionSeleccionada.venderBoleto(cliente, numeroAsiento, precio);
            System.out.println("Boleto vendido correctamente.");
        } else {
            System.out.println("El asiento seleccionado ya está ocupado. Intente con otro asiento.");
        }
    }
}


# ProyectoFinalED
Proyecto Final Estructura de Datos Cine
public class Asiento {
  
    private int numero;
    private boolean disponible;

    public Asiento(int numero) {
        this.numero = numero;
        this.disponible = true; // Por defecto, el asiento está disponible
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void ocupar() {
        this.disponible = false; // Ocupa el asiento
    }

    public void liberar() {
        this.disponible = true; // Libera el asiento
    }
}

package Acciones;

public class AccionApostar extends Accion {
    public AccionApostar(int cantidad) {
        super("Apustar", "El jugador Apuesta", cantidad);
    }

    @Override
    public String toString() {
        return String.format("Apostar(%d)", getCantidad());
    }
}

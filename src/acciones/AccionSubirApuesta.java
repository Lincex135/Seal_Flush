package acciones;

public class AccionSubirApuesta extends Accion {
    public AccionSubirApuesta(int cantidad) {
        super("Subir Apuesta","Sube la apuesta de la ronda",cantidad);
    }

    @Override
    public String toString() {
        return String.format("Subir Apuesta(%d)", getCantidad());
    }
}

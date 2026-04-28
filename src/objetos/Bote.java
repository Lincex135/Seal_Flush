package objetos;

public class Bote {

    private int cantidad;
    private static Bote instancia;

    private Bote() {
        this.cantidad = 0;
    }

    public static Bote getInstancia() {
        if (instancia == null) {
            instancia = new Bote();
        }
        return instancia;
    }

    public static Bote getInstancia(int cantidad) {
        if (instancia == null) {
            instancia = new Bote();
        } else {
            instancia.setCantidad(cantidad);
        }
        return instancia;
    }

    @Override
    public String toString() {
        return "BOTE: " + cantidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void actualizarCantidad(int cantidad) {
        this.cantidad = this.cantidad + cantidad;
    }
}
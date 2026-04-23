package acciones;

public abstract class Accion {

    public static final Accion ALL_IN = new AccionAllin();
    public static final Accion APOSTAR = new AccionApostar(0);
    public static final Accion CIEGA_GRANDE = new AccionCiegaGrande();
    public static final Accion CONTESTAR = new AccionContestar();
    public static final Accion PASAR = new AccionPasar();
    public static final Accion CONTINUAR = new AccionContinuar();
    public static final Accion RENDIRSE = new AccionRendirse();
    public static final Accion SUBIR_APUESTA = new AccionSubirApuesta(0);
    public static final Accion CIEGA_PEQUENA = new AccionCiegaPequena();

    private final String nombre;
    private final String descripcion;
    private final int cantidad;

    public Accion(String nombre, String descripcion) {
        this(nombre,descripcion,0);
    }

    public Accion(String nombre, String descripcion, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public final String getNombre() {
        return nombre;
    }

    public final String getDescripcion() {
        return descripcion;
    }

    public final int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

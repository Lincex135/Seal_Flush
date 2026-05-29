package objetos;

/**
 * Representa el bote acumulado en el juego, implementando el patrón de diseño
 * Singleton para garantizar que solo exista una única instancia durante
 * toda la ejecución.
 *
 * El bote almacena una cantidad entera que puede incrementarse o
 * establecerse directamente. Al ser Singleton, todos los componentes del
 * sistema comparten el mismo estado del bote.
 *
 *  @author Ximena López
 *  @author Adrián de Armas
 *  @version 1.0
 */

public class Bote {

    /** Cantidad acumulada en el bote. */
    private int cantidad;

    /** Única instancia de la clase (patrón Singleton). */
    private static Bote instancia;

    /**
     * CONSTRUCTOR privado que inicializa el bote con cantidad 0.
     * Impide la instanciación directa desde fuera de la clase.
     */
    private Bote() {
        this.cantidad = 0;
    }

    /**
     * Devuelve la única instancia de Bote, creándola si aún no existe
     *
     * @return la instancia única de Bote
     */
    public static Bote getInstancia() {
        if (instancia == null) {
            instancia = new Bote();
        }
        return instancia;
    }

    /**
     * Devuelve una representación textual del bote con el formato:
     * BOTE: cantidad
     *
     * @return cadena con el estado actual del bote
     */
    @Override
    public String toString() {
        return "BOTE: " + cantidad;
    }

    /**
     * Devuelve la cantidad acumulada actualmente en el bote.
     *
     * @return cantidad actual del bote
     */
    public int getCantidad() {
        return this.cantidad;
    }

    /**
     * Establece la cantidad del bote a un valor concreto,
     * sobreescribiendo el valor anterior.
     *
     * @param cantidad nuevo valor del bote; se recomienda que sea {@code >= 0}
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Incrementa la cantidad del bote sumando el valor indicado al acumulado actual.
     *
     * @param cantidad valor a sumar al bote; puede ser negativo para decrementar
     */
    public void actualizarCantidad(int cantidad) {
        this.cantidad = this.cantidad + cantidad;
    }
}
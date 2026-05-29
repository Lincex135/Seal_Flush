package estadisticas;

import objetos.Jugador;

/**
 * Esta clase contiene las estadisticas del jugador para el xml
 *
 * @author Ximena López
 * @author Adrián de Armas
 * @version 1.0
 */

public class EstadisticasJugador {

    private String nombre;
    private int fichasFinales;
    private String estadoFinal;

    /**
     * Constructor público que inicializa un jugador de la partida a partir de sus datos
     *
     * @param nombre nombre del jugador
     * @param fichasFinales cantidad de fichas final del jugador
     * @param estadoFinal estado final del jugador
     */
    public EstadisticasJugador(String nombre, int fichasFinales, String estadoFinal) {
        this.nombre = nombre;
        this.fichasFinales = fichasFinales;
        this.estadoFinal = estadoFinal;
    }

    /**
     * Constructor público que inicializa un jugador de la partida a partir de un objeto jugador
     *
     * @param jugador objeto jugador
     */
    public EstadisticasJugador(Jugador jugador) {
        this.nombre = jugador.getNomJugador();
        this.fichasFinales = jugador.getFichas();
        this.estadoFinal = jugador.getEstado().toString();
    }

    public String getNombre() {
        return nombre;
    }

    public int getFichasFinales() {
        return fichasFinales;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }
}

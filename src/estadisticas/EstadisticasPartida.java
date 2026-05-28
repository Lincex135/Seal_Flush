package estadisticas;

import objetos.Jugador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Esta clase contiene las estadisticas de la partida para el xml
 *
 * @author Ximena López
 * @author Adrián de Armas
 * @version 1.0
 */

public class EstadisticasPartida {

    public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private int id;
    private String fechaHora;
    private String ganador;
    private int fichasGanador;
    private int rondasJugadas;
    private int boteMaximo;
    private int numJugadores;
    private ArrayList<EstadisticasJugador> jugadores;

    /**
     *  Constructor público que inicializa los datos del jugador ganador de la partida
     *
     * @param ganador nombre del ganador
     * @param fichasGanador cantidad de fichas del ganador
     * @param rondasJugadas cantidad de rondas jugadas en la partida
     * @param boteMaximo cantidad de fichas en el bote más grande
     * @param listaJugadores lista de jugadores de la partida
     */

    public EstadisticasPartida(String ganador, int fichasGanador, int rondasJugadas, int boteMaximo, ArrayList<Jugador> listaJugadores) {
        this.id = 0;
        this.fechaHora = LocalDateTime.now().format(FORMATO_FECHA);
        this.ganador = ganador;
        this.fichasGanador = fichasGanador;
        this.rondasJugadas = rondasJugadas;
        this.boteMaximo = boteMaximo;
        this.numJugadores = listaJugadores.size();
        this.jugadores = new ArrayList<>();

        for (Jugador jugador : listaJugadores) {
            this.jugadores.add(new EstadisticasJugador(jugador));
        }
    }

    /**
     * Constructor público que inicializa los datos de un jugador de la partida
     *
     * @param id identificador de la partida
     * @param fechaHora fecha y hora de cuando se ha jugado la partida
     * @param ganador nombre del jugador ganador
     * @param fichasGanador cantidad de fichas del jugador
     * @param rondasJugadas cantidad de rondas de las partidas
     * @param boteMaximo cantidad de fichas en el bote más grande
     * @param numJugadores cantidad de jugadores
     * @param jugadores lista de jugadores
     */
    public EstadisticasPartida(int id, String fechaHora, String ganador, int fichasGanador, int rondasJugadas, int boteMaximo, int numJugadores, ArrayList<EstadisticasJugador> jugadores) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.ganador = ganador;
        this.fichasGanador = fichasGanador;
        this.rondasJugadas = rondasJugadas;
        this.boteMaximo = boteMaximo;
        this.numJugadores = numJugadores;
        this.jugadores = jugadores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getGanador() {
        return ganador;
    }

    public int getFichasGanador() {
        return fichasGanador;
    }

    public int getRondasJugadas() {
        return rondasJugadas;
    }

    public int getBoteMaximo() {
        return boteMaximo;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public ArrayList<EstadisticasJugador> getJugadores() {
        return jugadores;
    }
}

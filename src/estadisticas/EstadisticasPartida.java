package estadisticas;

import objetos.Jugador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

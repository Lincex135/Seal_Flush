package estadisticas;

import objetos.Jugador;

public class EstadisticasJugador {

    private String nombre;
    private int fichasFinales;
    private String estadoFinal;

    public EstadisticasJugador(String nombre, int fichasFinales, String estadoFinal) {
        this.nombre = nombre;
        this.fichasFinales = fichasFinales;
        this.estadoFinal = estadoFinal;
    }

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

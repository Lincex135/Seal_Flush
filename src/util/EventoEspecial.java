package util;

import objetos.Jugador;

import java.util.ArrayList;

public class EventoEspecial {

    private boolean selloDorado;
    private boolean selloOscuro;
    private int paloDominante;
    private boolean flushCongelado;
    private Jugador jugadorGoldenSeal;
    private ArrayList<Jugador> jugadoresDarkSeal;
    private static EventoEspecial instancia;

    public EventoEspecial() {
        this.selloDorado = false;
        this.selloOscuro = false;
        this.paloDominante = UtilEventosEspeciales.establecerPaloDominante();
        this.flushCongelado = false;
        this.jugadorGoldenSeal = null;
        this.jugadoresDarkSeal = new ArrayList<>();
    }

    public static EventoEspecial getInstancia() {
        if (instancia == null){
            instancia = new EventoEspecial();
        }
        return instancia;
    }

    //getters
    public boolean isSelloDorado() {
        return selloDorado;
    }

    public boolean isSelloOscuro() {
        return selloOscuro;
    }

    public int getPaloDominante() {
        return paloDominante;
    }

    public boolean isFlushCongelado() {
        return flushCongelado;
    }

    public Jugador getJugadorGoldenSeal() {
        return jugadorGoldenSeal;
    }

    public ArrayList<Jugador> getJugadoresDarkSeal() {
        return jugadoresDarkSeal;
    }

    //setters
    public void setSelloDorado(boolean selloDorado) {
        this.selloDorado = selloDorado;
    }

    public void setSelloOscuro(boolean maldicionDelSelloOscuro) {
        this.selloOscuro = maldicionDelSelloOscuro;
    }

    public void setPaloDominante(int paloDominante) {
        this.paloDominante = paloDominante;
    }

    public void setFlushCongelado(boolean flushCongelado) {
        this.flushCongelado = flushCongelado;
    }

    public void setJugadorGoldenSeal(Jugador jugadorGoldenSeal) {
        this.jugadorGoldenSeal = jugadorGoldenSeal;
    }

    public void setJugadores(ArrayList<Jugador> jugadoresDarkSeal) {
        this.jugadoresDarkSeal = jugadoresDarkSeal;
    }
}

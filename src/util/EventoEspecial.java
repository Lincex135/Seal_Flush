package util;

import objetos.Jugador;

import java.util.ArrayList;

public class EventoEspecial {

    private boolean selloDorado;
    private boolean maldicionDelSelloOscuro;
    private boolean paloDominante;
    private boolean flushCongelado;
    private Jugador jugadorGoldenSeal;
    private ArrayList<Jugador> jugadoresDarkSeal;
    private static EventoEspecial instancia;

    public EventoEspecial() {
        this.selloDorado = selloDorado;
        this.maldicionDelSelloOscuro = maldicionDelSelloOscuro;
        this.paloDominante = paloDominante;
        this.flushCongelado = flushCongelado;
        this.jugadorGoldenSeal = jugadorGoldenSeal;
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

    public boolean isMaldicionDelSelloOscuro() {
        return maldicionDelSelloOscuro;
    }

    public boolean isPaloDominante() {
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

    public void setMaldicionDelSelloOscuro(boolean maldicionDelSelloOscuro) {
        this.maldicionDelSelloOscuro = maldicionDelSelloOscuro;
    }

    public void setPaloDominante(boolean paloDominante) {
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
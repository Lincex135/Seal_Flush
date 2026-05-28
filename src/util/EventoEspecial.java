package util;

import objetos.Jugador;

import java.util.ArrayList;
/**
 *  Clase con booleanos de los eventos especiales activados
 *
 *  @author Ximena López
 *  @author Adrián de Armas
 *  @version 1.0
 */

public class EventoEspecial {

    private boolean selloDorado;
    private boolean selloOscuro;
    private int paloDominante;
    private Jugador jugadorGoldenSeal;
    private ArrayList<Jugador> jugadoresDarkSeal;
    private static EventoEspecial instancia;

    /**
     * Constructor para inicializar los eventos especiales
     */
    public EventoEspecial() {
        this.selloDorado = false;
        this.selloOscuro = false;
        this.paloDominante = UtilEventosEspeciales.establecerPaloDominante();
        this.jugadorGoldenSeal = null;
        this.jugadoresDarkSeal = new ArrayList<>();
    }

    /**
     * Devuelve la única instancia de EventoEspecial, creándola si aún no existe
     *
     * @return la instancia única de EventoEspecial
     */
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

    public void setJugadorGoldenSeal(Jugador jugadorGoldenSeal) {
        this.jugadorGoldenSeal = jugadorGoldenSeal;
    }

    public void setJugadores(ArrayList<Jugador> jugadoresDarkSeal) {
        this.jugadoresDarkSeal = jugadoresDarkSeal;
    }
}

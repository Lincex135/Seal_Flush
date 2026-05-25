package objetos;

import util.Color;

/**
 * Representa un jugador en la partida de póker.
 * Gestiona su mano, fichas, estado y apuestas durante cada ronda.
 * @author Ximena López
 * @author Adrián de Armas
 * @version 1.0
 */

public class Jugador {
    /** Número identificador del jugador. */
    private int numJugador;

    /** Nombre del jugador. */
    private String nomJugador;

    /** Las dos cartas privadas del jugador. */
    private Carta[] mano;

    /** Fichas disponibles. Comienza en 500. */
    private int fichas;

    /** Estado actual del jugador en la ronda (ACTIVO, RETIRADO, ALL_IN, ELIMINADO). */
    private Estado estado;

    /** Cantidad apostada por el jugador en la ronda actual. */
    private int apuestaActual;

    /** Indica si el jugador es el dealer en la ronda actual. */
    public boolean esDealerActual;

    /**
     * Crea un jugador con el número y nombre indicados.
     * Empieza con 500 fichas, mano vacía y estado ACTIVO.
     *
     * @param numJugador número identificador del jugador
     * @param nomJugador nombre del jugador
     */
    public Jugador(int numJugador, String nomJugador) {
        this.numJugador = numJugador;
        this.nomJugador = nomJugador;
        this.fichas = 500;
        this.mano = new Carta[2];
        this.apuestaActual = 0;
        this.estado = Estado.ACTIVO;
        this.esDealerActual = false;
    }

    /**
     * Asigna una carta a la mano del jugador (primera posición libre).
     *
     * @param carta carta a recibir; no puede ser null
     * @throws IllegalArgumentException si carta} es null
     */
    public void recibirCarta(Carta carta) {
        if (carta == null) {
            throw new IllegalArgumentException("La carta no puede ser nula");
        }
        if (this.mano[0] == null) {
            this.mano[0] = carta;
        } else {
            this.mano[1] = carta;
        }
    }

    /** Vacía la mano del jugador, eliminando ambas cartas. */
    public void descartarMano() {
        this.mano[0] = null;
        this.mano[1] = null;
    }

    /** Retira al jugador de la ronda: cambia su estado a RETIRADO y descarta su mano. */
    public void retirarse() {
        estado = Estado.RETIRADO;
        descartarMano();
    }

    /**
     * Prepara al jugador para una nueva ronda: restaura ACTIVO si estaba RETIRADO,
     * marca como ELIMINADO si no tiene fichas, descarta la mano y resetea la apuesta.
     */
    public void reiniciarRonda() {
        if (estado == Estado.RETIRADO || estado == Estado.ALL_IN) {
            estado = Estado.ACTIVO;
        }
        descartarMano();
        setApuestaActual(0);
    }

    /**
     * Realiza una apuesta de la cantidad indicada.
     * Si el jugador no puede pagarla, se retira automáticamente.
     *
     * @param cantidad fichas a apostar
     * @return true si la apuesta se realizó; false si el jugador se retiró
     */
    public boolean apostar(int cantidad) {
        if (!puedeApostar(cantidad)) {
            estado = Estado.RETIRADO;
            return false;
        }
        this.apuestaActual += cantidad;
        actualizarFichas(cantidad);

        return true;
    }

    /**
     * Comprueba si el jugador tiene fichas suficientes para apostar la cantidad indicada.
     *
     * @param cantidad fichas a comprobar
     * @return true si puede apostar; false en caso contrario
     */
    public boolean puedeApostar(int cantidad) {
        return fichas >= cantidad;
    }

    public void actualizarFichas(int cantidad) {
        this.fichas -= cantidad;
        if (fichas == 0) {
            estado = Estado.ALL_IN;
        } else {
            estado = Estado.ACTIVO;  // Si tiene fichas, está activo
        }
    }

    public void printNomJugador() {
        String colorJugador = Color.RESET;
        String subrayado = "";
        if (esDealerActual) {
            subrayado = Color.SUBRAYADO;
        }
        switch (this.estado) {
            case Estado.ACTIVO -> {
                colorJugador = Color.GREEN;
            }
            case Estado.RETIRADO -> {
                colorJugador = Color.ORANGE;
            }
            case Estado.ELIMINADO -> {
                colorJugador = Color.RED;
            }
            case Estado.ALL_IN -> {
                colorJugador = Color.YELLOW;
            }
        }
        System.out.print(colorJugador + subrayado + this.nomJugador + ": " + this.fichas + Color.RESET + "    ");
    }

    public boolean estaActivo() {
        return estado == Estado.ACTIVO;
    }

    public boolean seHaRetirado() {
        return estado == Estado.RETIRADO;
    }

    public boolean estaAllIn() {
        return estado == Estado.ALL_IN;
    }

    public boolean estaEliminado() {
        return estado == Estado.ELIMINADO;
    }

    private boolean esDealer() {
        return esDealerActual;
    }

    public String getNomJugador() {
        return nomJugador;
    }

    public int getNumJugador() {
        return numJugador;
    }

    public int getFichas() {
        return fichas;
    }

    public int getApuestaActual() {
        return apuestaActual;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEsDealerActual(boolean esDealerActual) {
        this.esDealerActual = esDealerActual;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public void setApuestaActual(int apuestaActual) {
        this.apuestaActual = apuestaActual;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Carta[] getMano() {
        return mano;
    }
}

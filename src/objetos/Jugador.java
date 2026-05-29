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
    private boolean esDealerActual;

    /** Indica si el jugador tiene sello dorado. */
    private boolean tieneSelloDorado;

    /** Indica si el jugador tiene sello oscuro. */
    private boolean tieneSelloOscuro;

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
        this.tieneSelloDorado = false;
        this.tieneSelloOscuro = false;
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
        if (fichas <= 0) {
            estado = Estado.ELIMINADO;
        } else if (estado == Estado.RETIRADO) {
            estado = Estado.ACTIVO;
        }else if (estado == Estado.ALL_IN) {
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
        if (estado == Estado.ELIMINADO || fichas <= 0) {
            estado = Estado.ELIMINADO;
            return false;
        }
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


    /**
     * Actualiza las fichas cuando un jugador apuesta
     *
     * @param cantidad representa la cantidad de fichas a actualizar
     */
    public void actualizarFichas(int cantidad) {
        this.fichas -= cantidad;
        if (fichas == 0) {
            estado = Estado.ALL_IN;
        } else {
            estado = Estado.ACTIVO;  // Si tiene fichas, está activo
        }
    }

    /**
     * Escribe el nombre de un jugador de un color diferente dependiendo del estado
     */
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

    /** @return true si está Activo; false si no */
    public boolean estaActivo() {
        return estado == Estado.ACTIVO;
    }

    public boolean estaEliminado() {
        return estado == Estado.ELIMINADO;
    }

    public boolean estaRetirado() {
        return estado == Estado.RETIRADO;
    }

    /** @return true si está All_In; false si no */
    public boolean estaAllIn() {
        return estado == Estado.ALL_IN;
    }

    /** @return estado actual del jugador */
    public Estado getEstado() {
        return estado;
    }

    /** @return nombrejugador */
    public String getNomJugador() {
        return nomJugador;
    }

    /** @return cantidad de fichas */
    public int getFichas() {
        return fichas;
    }

    /** @return cantidad de fichas apostadoas */
    public int getApuestaActual() {
        return apuestaActual;
    }

    /** @return true si tiene activo el Sello Dorado */
    public boolean isTieneSelloDorado() {
        return tieneSelloDorado;
    }

    /** @return true si tiene activo el Sello Oscuro */
    public boolean isTieneSelloOscuro() {
        return tieneSelloOscuro;
    }

    /** @param esDealerActual true si es dealer; false si no */
    public void setEsDealerActual(boolean esDealerActual) {
        this.esDealerActual = esDealerActual;
    }

    /** @param fichas cantidad de fichas */
    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    /** @param apuestaActual cantidad de fichas a apostar */
    public void setApuestaActual(int apuestaActual) {
        this.apuestaActual = apuestaActual;
    }

    /** @return mano del jugador */
    public Carta[] getMano() {
        return mano;
    }

    /** @param tieneSelloDorado true si tiene sello Dorado; false si no */
    public void setTieneSelloDorado(boolean tieneSelloDorado) {
        this.tieneSelloDorado = tieneSelloDorado;
    }

    /** @param tieneSelloOscuro true si tiene sello Oacuro; false si no  */
    public void setTieneSelloOscuro(boolean tieneSelloOscuro) {
        this.tieneSelloOscuro = tieneSelloOscuro;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

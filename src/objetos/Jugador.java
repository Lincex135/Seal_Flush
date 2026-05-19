package objetos;

import util.Color;

public class Jugador {
    private int numJugador;
    private String nomJugador;
    private Carta[] mano;
    private int fichas;
    private Estado estado;
    private int apuestaActual;
    public boolean esDealerActual;

    public Jugador(int numJugador, String nomJugador) {
        this.numJugador = numJugador;
        this.nomJugador = nomJugador;
        this.fichas = 500;
        this.mano = new Carta[2];
        this.apuestaActual = 0;
        this.estado = Estado.ACTIVO;
        this.esDealerActual = false;
    }

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

    public void descartarMano() {
        this.mano[0] = null;
        this.mano[1] = null;
    }

    public void retirarse() {
        estado = Estado.RETIRADO;
        descartarMano();
    }

    public void reiniciarRonda() {
        if (estado == Estado.RETIRADO) {
            estado = Estado.ACTIVO;
        }
        if (fichas == 0 || estado == Estado.ELIMINADO) {
            estado = Estado.ELIMINADO;
        }
        descartarMano();
        setApuestaActual(0);
    }

    public boolean apostar(int cantidad) {
        if (!puedeApostar(cantidad)) {
            estado = Estado.RETIRADO;
            return false;
        }
        this.apuestaActual += cantidad;
        actualizarFichas(cantidad);

        return true;
    }

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

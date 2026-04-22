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
        this.fichas = 20;
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
        }else {
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

    public void recibirFichas(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        fichas += cantidad;
        if (estado == Estado.ALL_IN && fichas > 0) {
            estado = Estado.ACTIVO;
        }else if (fichas > 0) {
            estado = Estado.ACTIVO;
        }else if ( estado == Estado.RETIRADO) {
            estado = Estado.RETIRADO;
        }else{
            estado = Estado.ELIMINADO;
        }
    }

    public void reiniciarRonda() {
        apuestaActual = 0;
        if (estado == Estado.RETIRADO) {
            estado = Estado.ACTIVO;
        }
        if (fichas == 0) {
            estado = Estado.ELIMINADO;
        }
    }

    public boolean apostar(int cantidad) {
        if(cantidad <=0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        if(!puedeApostar(cantidad)) {
            estado = Estado.RETIRADO;
            return false;
        }
        this.apuestaActual += cantidad;
        actualizarFichas(cantidad);

        return true;
    }

    public boolean puedeApostar(int cantidad){
        return fichas >= cantidad;
    }

    public void actualizarFichas(int cantidad) {
        this.fichas -= cantidad;
        if (fichas == 0) {
            estado = Estado.ALL_IN;
        } else if (!puedeApostar(cantidad)) {
            estado = Estado.ELIMINADO;
        }else {
            estado = Estado.ACTIVO;
        }
    }

    public void printNomJugador(){
        String colorJugador = Color.RESET;
        switch (this.estado){
            case ACTIVO -> {
                colorJugador = Color.GREEN;
            }
            case  RETIRADO -> {
                colorJugador = Color.ORANGE;
            }
            case ELIMINADO -> {
                colorJugador = Color.RED;
            }
            case ALL_IN -> {
                colorJugador = Color.YELLOW;
            }
        }
        System.out.println(colorJugador + this.nomJugador + ": " + this.fichas + Color.RESET);
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

    public boolean esDealer() {
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

    public void setFichas(int fichas) {this.fichas = fichas;}
    
    public void setEstado(Estado estado) {this.estado = estado;}
}

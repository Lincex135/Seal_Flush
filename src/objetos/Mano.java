package objetos;


public class Mano {


    private final Carta[] cartas;


    // Recibe un jugador y el tablero
    public Mano(Jugador jugador, Tablero tablero) {
        cartas = new Carta[7];
        cartas[0] = jugador.getMano()[0];
        cartas[1] = jugador.getMano()[1];
        cartas[2] = tablero.getCartas()[0];
        cartas[3] = tablero.getCartas()[1];
        cartas[4] = tablero.getCartas()[2];
        cartas[5] = tablero.getCartas()[3];
        cartas[6] = tablero.getCartas()[4];
    }


    public Carta[] getCartas() {
        return cartas;
    }
}

package objetos;

public class Mano {

    private final Carta[] cartas;

    // Recibe las 2 cartas del jugador y las 5 del tablero
    public Mano(Carta[] cartasJugador, Carta[] cartasTablero) {
        cartas = new Carta[7];
        cartas[0] = cartasJugador[0];
        cartas[1] = cartasJugador[1];
        cartas[2] = cartasTablero[0];
        cartas[3] = cartasTablero[1];
        cartas[4] = cartasTablero[2];
        cartas[5] = cartasTablero[3];
        cartas[6] = cartasTablero[4];
    }

    public Carta[] getCartas() {
        return cartas;
    }
}
package objetos;

/**
 * Representa las 7 cartas disponibles para evaluar la mejor mano de un jugador:
 * sus 2 cartas privadas más las 5 cartas comunitarias del tablero.
 *
 * @author Ximena López
 * @author Adrián de Armas
 * @version 1.0
 */

public class Mano {

    /** Array con las 7 cartas (2 del jugador + 5 del tablero). */
    private final Carta[] cartas;

    /**
     * Construye la mano combinando las cartas del jugador con las del tablero.
     *
     * @param jugador jugador cuyas cartas privadas se incluyen
     * @param tablero tablero con las 5 cartas comunitarias
     */
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

    /**
     * Devuelve las 7 cartas de la mano.
     *
     * @return array de 7 Carta
     */
    public Carta[] getCartas() {
        return cartas;
    }
}

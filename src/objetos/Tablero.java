package objetos;

import util.*;
import java.util.ArrayList;

/**
 * Representa el tablero de juego. Implementa el patrón Singleton.
 * Contiene las cartas comunitarias, los jugadores y la apuesta de la ronda actual.
 *
 *  @author Ximena López
 *  @author Adrián de Armas
 *  @version 1.0
 */
public class Tablero {

    /** Única instancia (Singleton). */
    private static Tablero instancia;

    /** Cartas comunitarias visibles en la mesa (máximo 5). */
    private Carta[] cartas;

    /** Lista de jugadores sentados en la mesa. */
    private ArrayList<Jugador> jugadores;

    /** Apuesta acumulada en la ronda actual. */
    private int apuestaRonda = 0;

    /** Representación visual del tablero en consola con colores ANSI. */
    private final String[] tablero = {
            Color.BROWN_BG + " ┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ " + Color.RESET + "\n",
            Color.BROWN_BG + " │                                                                                                                                                       │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    ┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    │ " + Color.DARK_GREEN_BG + "                                                                                                                                           " + Color.BROWN_BG + " │    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    │ " + Color.DARK_GREEN_BG + "                                                                                                                                           " + Color.BROWN_BG + " │    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    │ " + Color.DARK_GREEN_BG + "                                                                                                                                           " + Color.BROWN_BG + " │    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    │ " + Color.DARK_GREEN_BG + "                                                                                                                                           " + Color.BROWN_BG + " │    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    │ " + Color.DARK_GREEN_BG + "                                                                                                                                           " + Color.BROWN_BG + " │    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    │ " + Color.DARK_GREEN_BG + "                                                                                                                                           " + Color.BROWN_BG + " │    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    │ " + Color.DARK_GREEN_BG + "                                                                                                                                           " + Color.BROWN_BG + " │    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    │ " + Color.DARK_GREEN_BG + "                                                                                                                                           " + Color.BROWN_BG + " │    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    │ " + Color.DARK_GREEN_BG + "                                                                                                                                           " + Color.BROWN_BG + " │    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    │ " + Color.DARK_GREEN_BG + "                                                                                                                                           " + Color.BROWN_BG + " │    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    │ " + Color.DARK_GREEN_BG + "                                                                                                                                           " + Color.BROWN_BG + " │    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    │ " + Color.DARK_GREEN_BG + "                                                                                                                                           " + Color.BROWN_BG + " │    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │    └─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘    │ " + Color.RESET + "\n",
            Color.BROWN_BG + " │                                                                                                                                                       │ " + Color.RESET + "\n",
            Color.BROWN_BG + " └───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ " + Color.RESET + "\n"
    };

    /**
     * Constructor privado. Inicializa el tablero con las cartas y jugadores dados.
     *
     * @param cartas    cartas comunitarias iniciales
     * @param jugadores jugadores de la partida
     */
    private Tablero(Carta[] cartas, ArrayList<Jugador> jugadores) {
        this.cartas = cartas;
        this.jugadores = jugadores;
    }

    /**
     * Devuelve la única instancia del tablero, creándola si no existe.
     *
     * @param cartas    cartas comunitarias
     * @param jugadores jugadores de la partida
     * @return instancia única de {@code Tablero}
     */
    public static Tablero getInstancia(Carta[] cartas, ArrayList<Jugador> jugadores) {
        if (instancia == null) {
            instancia = new Tablero(cartas, jugadores);
        }
        return instancia;
    }

    /**
     * Devuelve la representación visual del tablero con las cartas comunitarias
     * renderizadas en su posición correspondiente.
     *
     * @return cadena con el tablero listo para imprimir en consola
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String[][] lineasCartas = null;
        if (cartas != null) {
            lineasCartas = new String[cartas.length][];
            for (int i = 0; i < cartas.length; i++) {
                lineasCartas[i] = Util.obtenerLineasCarta(cartas[i]);
            }
        }

        for (int fila = 0; fila < tablero.length; fila++) {
            int filaInicio = 6;

            if (lineasCartas != null && fila >= filaInicio && fila < filaInicio + 6) {
                int lineaCarta = fila - filaInicio;

                StringBuilder cartasSb = new StringBuilder();
                for (String[] lineas : lineasCartas) {
                    cartasSb.append(lineas[lineaCarta]).append(Color.DARK_GREEN_BG + "    ");
                }

                String lineaTablero = Color.BROWN_BG + " │    │ " + Color.DARK_GREEN_BG + "                                            "
                        + cartasSb + Color.DARK_GREEN_BG + "                                        "
                        + Color.BROWN_BG + " │    │ " + Color.RESET + "\n";
                sb.append(lineaTablero);
            } else {
                sb.append(tablero[fila]);
            }
        }


        return sb.toString();
    }

    /** @return las cartas comunitarias actuales del tablero. */
    public Carta[] getCartas() {
        return cartas;
    }

    /** @param cartas nuevas cartas comunitarias a establecer. */
    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    /** @param jugadores nueva lista de jugadores en la mesa. */
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /** @return la apuesta acumulada en la ronda actual. */
    public int getApuestaRonda() {
        return apuestaRonda;
    }

    /** @param apuestaRonda nueva apuesta de la ronda actual. */
    public void setApuestaRonda(int apuestaRonda) {
        this.apuestaRonda = apuestaRonda;
    }
}
package objetos;

import util.*;

import java.util.ArrayList;

public class Tablero {

    private static Tablero instancia;
    private Carta[] cartas;
    private ArrayList<Jugador> jugadores;
    private int apuestaRonda = 0;

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

    // Constructor privado: impide instanciación externa
    private Tablero(Carta[] cartas, ArrayList<Jugador> jugadores) {
        this.cartas = cartas;
        this.jugadores = jugadores;
    }

    // Método de acceso a la única instancia
    public static Tablero getInstancia(Carta[] cartas, ArrayList<Jugador> jugadores) {
        if (instancia == null) {
            instancia = new Tablero(cartas, jugadores);
        }
        return instancia;
    }

    // Sobrecarga sin parámetros para cuando la instancia ya existe
    public static Tablero getInstancia() {
        if (instancia == null) {
            throw new IllegalStateException("El Tablero no ha sido inicializado. Llama primero a getInstancia(cartas, jugadores).");
        }
        return instancia;
    }

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

    public Carta[] getCartas() {
        return cartas;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getApuestaRonda() {
        return apuestaRonda;
    }

    public void setApuestaRonda(int apuestaRonda) {
        this.apuestaRonda = apuestaRonda;
    }
}
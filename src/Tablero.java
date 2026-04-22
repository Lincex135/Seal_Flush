import java.util.ArrayList;

public class Tablero {
    private Carta[] cartas;
    private ArrayList<Jugador> jugadores;

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

    public Tablero(Carta[] cartas, ArrayList<Jugador> jugadores) {
        this.cartas = cartas;
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Obtenemos todas las líneas de todas las cartas
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
}
import java.util.ArrayList;

public class Util {

    public static String [] obtenerLineasCarta (Carta carta) {
        String[] lineas = new String[6];
        if (carta.isVuelta()) {
            lineas[0] = Color.PURPLE + Color.BLUE_BG + "╭─────╮" + Color.RESET;
            lineas[1] = Color.PURPLE + Color.BLUE_BG + "│▓▓▓▓▓│" + Color.RESET;
            lineas[2] = Color.PURPLE + Color.BLUE_BG + "│▓▓▓▓▓│" + Color.RESET;
            lineas[3] = Color.PURPLE + Color.BLUE_BG + "│▓▓▓▓▓│" + Color.RESET;
            lineas[4] = Color.PURPLE + Color.BLUE_BG + "│▓▓▓▓▓│" + Color.RESET;
            lineas[5] = Color.PURPLE + Color.BLUE_BG + "╰─────╯" + Color.RESET;
            lineas[6] = "";
        } else {
            lineas = obtenerLineasCarta(carta.getPaloString(), String.valueOf(carta.getRango()));
        }
        return lineas;
    }
    public static String[] obtenerLineasCarta(String palo, String numero) {
        String[] lineas = new String[6]; // 6 líneas por carta

        lineas[0] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "╭─────╮" + Color.RESET;

        switch (palo) {
            case "PICAS" -> {
                lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + numero + " .  " + Color.PURPLE + "│" + Color.RESET;
                lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.BLACK + "/ \\" + Color.PURPLE + " │" + Color.RESET;
                lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + "(_._)" + Color.PURPLE + "│" + Color.RESET;
                lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.BLACK + "╵ " + numero + Color.PURPLE + "│" + Color.RESET;
            }
            case "TRÉBOLES" -> {
                lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + numero + "    " + Color.PURPLE + "│" + Color.RESET;
                lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.BLACK + "(¯)" + Color.PURPLE + " │" + Color.RESET;
                lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + "(_X_)" + Color.PURPLE + "│" + Color.RESET;
                lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.BLACK + "╵ " + numero + Color.PURPLE + "│" + Color.RESET;
            }
            case "DIAMANTES" -> {
                lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + numero + " /\\ " + Color.PURPLE + "│" + Color.RESET;
                lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.RED + "/  \\" + Color.PURPLE + "│" + Color.RESET;
                lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.RED + "\\  /" + Color.PURPLE + "│" + Color.RESET;
                lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.RED + "\\/" + numero + Color.PURPLE + "│" + Color.RESET;
            }
            case "CORAZONES" -> {
                lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + numero + "    " + Color.PURPLE + "│" + Color.RESET;
                lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + "(¯v¯)" + Color.PURPLE + "│" + Color.RESET;
                lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.RED + "\\ /" + Color.PURPLE + " │" + Color.RESET;
                lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.RED + "v " + numero + Color.PURPLE + "│" + Color.RESET;
            }
        }

        lineas[5] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "╰─────╯" + Color.RESET;
        lineas[6] = ""; // línea vacía de separación

        return lineas;
    }

    // Imprime varias cartas horizontalmente, tu mano
    public static void pintarCartas(String[][] cartas) {
        // cartas[i] = { palo, numero } de la carta i
        String[][] todasLineas = new String[cartas.length][];

        for (int i = 0; i < cartas.length; i++) {
            todasLineas[i] = obtenerLineasCarta(cartas[i][0], cartas[i][1]);
        }

        int numLineas = todasLineas[0].length;
        for (int fila = 0; fila < numLineas; fila++) {
            StringBuilder sb = new StringBuilder();
            for (String[] todasLinea : todasLineas) {
                sb.append(todasLinea[fila]);
                sb.append("  "); // espacio entre cartas
            }
            System.out.println(sb);
        }
    }

    public static void printInicio() {
        // Centrado vertical: padding arriba y abajo para cartas
        int altFoca   = Ascii.FOCA.length;    // 25
        int altCartas = Ascii.CARTAS.length;  // 11
        int altMenu   = Ascii.MENU.length;    // 5

        int padCartas = (altFoca - altCartas) / 2;  // offset de cartas respecto a foca
        int padMenu   = (altFoca - altMenu)   / 2;  // offset de menu respecto a foca

        String vacioCarta = "                                              ";
        String vacioMenu  = "                                ";

        for (int i = 0; i < altFoca; i++) {
            int cartaIdx = i - padCartas;
            int menuIdx  = i - padMenu;

            String colMenu  = (menuIdx  >= 0 && menuIdx  < altMenu)   ? Ascii.MENU[menuIdx]    : vacioMenu;
            String colCarta = (cartaIdx >= 0 && cartaIdx < altCartas) ? Ascii.CARTAS[cartaIdx] : vacioCarta;

            System.out.println(Ascii.FOCA[i] + "         " + colMenu + "         " + colCarta);
        }
    }

    public static boolean nombreRepetido(ArrayList<Jugador> listaJugadores, String nombre) {
        for (Jugador jugador : listaJugadores) {
            if (jugador.getNomJugador().equals(nombre)) {
                return true;
            }
        }
        return false;
    }
}
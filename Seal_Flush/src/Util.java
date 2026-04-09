public class Util {
    /*public static void pintarCarta(String palo, String numero) {

        System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "╭─────╮" + Color.RESET);

        if (palo.equals("PICAS")) {
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + numero + " ^  " + Color.PURPLE + "│" + Color.RESET);
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.BLACK + "/ \\" + Color.PURPLE + " │" + Color.RESET);
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + "(_._)" + Color.PURPLE + "│" + Color.RESET);
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.BLACK + "╵ " + numero + Color.PURPLE + "│" + Color.RESET);

        } else if (palo.equals("TRÉBOLES")) {
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + numero + "    " + Color.PURPLE + "│" + Color.RESET);
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.BLACK + "(¯)" + Color.PURPLE + " │" + Color.RESET);
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + "(_'_)" + Color.PURPLE + "│" + Color.RESET);
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.BLACK + "╵" + " " +  numero + Color.PURPLE + "│" + Color.RESET);

        } else if (palo.equals("DIAMANTES")) {
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + numero + " ^  " + Color.PURPLE + "│" + Color.RESET);
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.RED + "/ \\" + Color.PURPLE + " │" + Color.RESET);
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.RED + "\\ /" + Color.PURPLE + " │" + Color.RESET);
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.RED + "v " + numero + Color.PURPLE + "│" + Color.RESET);

        } else if (palo.equals("CORAZONES")) {
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + numero + "    " + Color.PURPLE + "│" + Color.RESET);
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + "(¯v¯)" + Color.PURPLE + "│" + Color.RESET);
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.RED + "\\ /" + Color.PURPLE + " │" + Color.RESET);
            System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.RED + "v " + numero + Color.PURPLE + "│" + Color.RESET);
        }
        System.out.println(Color.PURPLE + Color.LIGHT_YELLOW_BG + "╰─────╯" + Color.RESET);
        System.out.println();

    } */

    public static String[] obtenerLineasCarta(String palo, String numero) {
        String[] lineas = new String[7]; // 7 líneas por carta

        lineas[0] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "╭─────╮" + Color.RESET;

        if (palo.equals("PICAS")) {
            lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + numero + " ^  " + Color.PURPLE + "│" + Color.RESET;
            lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.BLACK + "/ \\" + Color.PURPLE + " │" + Color.RESET;
            lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + "(_._)" + Color.PURPLE + "│" + Color.RESET;
            lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.BLACK + "╵ " + numero + Color.PURPLE + "│" + Color.RESET;

        } else if (palo.equals("TRÉBOLES")) {
            lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + numero + "    " + Color.PURPLE + "│" + Color.RESET;
            lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.BLACK + "(¯)" + Color.PURPLE + " │" + Color.RESET;
            lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + "(_'_)" + Color.PURPLE + "│" + Color.RESET;
            lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.BLACK + "╵ " + numero + Color.PURPLE + "│" + Color.RESET;

        } else if (palo.equals("DIAMANTES")) {
            lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + numero + " ^  " + Color.PURPLE + "│" + Color.RESET;
            lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.RED + "/ \\" + Color.PURPLE + " │" + Color.RESET;
            lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.RED + "\\ /" + Color.PURPLE + " │" + Color.RESET;
            lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.RED + "v " + numero + Color.PURPLE + "│" + Color.RESET;

        } else if (palo.equals("CORAZONES")) {
            lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + numero + "    " + Color.PURPLE + "│" + Color.RESET;
            lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + "(¯v¯)" + Color.PURPLE + "│" + Color.RESET;
            lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.RED + "\\ /" + Color.PURPLE + " │" + Color.RESET;
            lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.RED + "v " + numero + Color.PURPLE + "│" + Color.RESET;
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
            for (int carta = 0; carta < todasLineas.length; carta++) {
                sb.append(todasLineas[carta][fila]);
                sb.append("  "); // espacio entre cartas
            }
            System.out.println(sb);
        }
    }
}
public class Util {
    public static String[] obtenerLineasCarta(String palo, String numero) {
        String[] lineas = new String[7]; // 7 líneas por carta

        lineas[0] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "╭─────╮" + Color.RESET;

        if (palo.equals("PICAS")) {
            lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + numero + " .  " + Color.PURPLE + "│" + Color.RESET;
            lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.BLACK + "/ \\" + Color.PURPLE + " │" + Color.RESET;
            lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + "(_._)" + Color.PURPLE + "│" + Color.RESET;
            lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.BLACK + "╵ " + numero + Color.PURPLE + "│" + Color.RESET;

        } else if (palo.equals("TRÉBOLES")) {
            lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + numero + "    " + Color.PURPLE + "│" + Color.RESET;
            lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.BLACK + "(¯)" + Color.PURPLE + " │" + Color.RESET;
            lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + "(_X_)" + Color.PURPLE + "│" + Color.RESET;
            lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.BLACK + "╵ " + numero + Color.PURPLE + "│" + Color.RESET;

        } else if (palo.equals("DIAMANTES")) {
            lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + numero + " /\\ " + Color.PURPLE + "│" + Color.RESET;
            lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.RED + "/  \\" + Color.PURPLE + "│" + Color.RESET;
            lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│ " + Color.RED + "\\  /" + Color.PURPLE + "│" + Color.RESET;
            lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│  " + Color.RED + "\\/" + numero + Color.PURPLE + "│" + Color.RESET;

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

    public static void printMenu() {
        String[] menu = {
                "╔══════════════════════════════╗",
                "║      S E A L  F L U S H      ║",
                "║                              ║",
                "║    - by Ximena & Adrián -    ║",
                "╚══════════════════════════════╝"
        };

        String[] foca = {
                "               ..-=++=-.                                 ",
                "          ..-+-.       ..=+:..                           ",
                "         .=-.              .-=.                          ",
                "       .-=.                  .--                         ",
                "      .--    .          ....   :-.                       ",
                "      :-. ....         ....     -.                       ",
                "     .--..-%%++.       :+*@#.   :=.                      ",
                "     .-:..-@@@+..=**-. :%@@%.   :=.                      ",
                "     .-.....:...=@@@%:...::.... :=. .....                ",
                "     .-:...:-#=-..==..=++-:..:. :-. .-..--:.   .-----.   ",
                "     .-:-:..--===+:-===--:.:-. .+.  .=.  .--.:=:.  .=.   ",
                "      .-:....     ..     ..  ..#.   .:..   =+:    .::.   ",
                "        .==:.              .:=-     .:-.   ::    .:-.    ",
                "        .=.      . ...     ...=.      .:-=-..:::=-:.     ",
                "        -.                    .*..   .. :=...+...        ",
                "       .+.                      .::--:..    :-           ",
                "       .=                                  :-.           ",
                "       .=.                               .--.            ",
                "      .=.             ...  .::.         .-:              ",
                "     .-:...           .+.  ..-.       .:=.               ",
                " ..--:.               .-     .=:     .-:                 ",
                ".--.      .-+:        .=      ..-+-.=:..                 ",
                " .:=+===+=:.  .==-:....-:.     ....+.                    ",
                "                       .:---:...:--:.                    ",
                "                          ...::...                       "
        };

        String[] cartas = {
                "⠀⠀⠀⠀⠀⠀⣀⣤⣴⣄⠀⢀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
                "⠀⠀⣠⣴⣾⣿⣿⣿⣿⣿⣇⢸⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀",
                "⠀⠀⢿⣿⣿⣿⠛⠿⣿⣿⣿⡀⢻⣿⣿⣿⣿⠀⣸⣿⣶⣦⣄⠀⠀⠀⠀⠀⠀⠀ ",
                "⠀⠀⠘⣿⣿⠃⠀⠀⠀⠈⠙⣧⠈⢿⣿⣿⣿⠀⣿⣿⣿⣿⡟⢀⡀⠀⠀⠀⠀⠀ ",
                "⠀⠀⠀⢹⡇⠀⠀⠀⠀⣀⣠⣿⣇⠘⣿⣿⣿⠀⣿⣿⣿⡿⠀⣾⣿⣷⣄⠀⠀⠀ ",
                "⠀⠀⠀⠀⢿⣦⣤⣾⡆⣹⣿⣿⣿⡄⠹⣿⣿⠀⣿⣿⣿⠃⣸⣿⣿⣿⣿⣷⠀⠀",
                "⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⠗⢀⣿⡏⠀⣿⣿⡏⢠⣿⣿⣿⣿⠟⠁⠀⠀",
                "⠀⠀⠀⠀⠀⠸⢿⠿⠟⠋⠉⠁⠀⠐⠚⠛⠃⣰⣿⡿⠀⣾⣿⣿⡿⠃⠀⠀⠀⠀ ",
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠻⠿⠿⠃⣸⣿⣿⠋⠀⠀⠀⠀⠀⠀  ",
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠢⣤⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀  ",
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀  "
        };

        // Centrado vertical: padding arriba y abajo para cartas
        int altFoca   = foca.length;    // 25
        int altCartas = cartas.length;  // 11
        int altMenu   = menu.length;    // 5

        int padCartas = (altFoca - altCartas) / 2;  // offset de cartas respecto a foca
        int padMenu   = (altFoca - altMenu)   / 2;  // offset de menu respecto a foca

        String vacioCarta = "                                              ";
        String vacioMenu  = "                                ";

        for (int i = 0; i < altFoca; i++) {
            int cartaIdx = i - padCartas;
            int menuIdx  = i - padMenu;

            String colMenu  = (menuIdx  >= 0 && menuIdx  < altMenu)   ? menu[menuIdx]    : vacioMenu;
            String colCarta = (cartaIdx >= 0 && cartaIdx < altCartas) ? cartas[cartaIdx] : vacioCarta;

            System.out.println(foca[i] + "         " + colMenu + "         " + colCarta);
        }

        // Menú
        System.out.println();
        System.out.println("                                                     ════════════════════════════════════════════════════════════");
        System.out.println("                                                       [ 1 ]  Nueva partida     [ 2 ]  Reglas     [ 0 ]  Salir");
        System.out.println("                                                     ════════════════════════════════════════════════════════════");
        System.out.println();
        System.out.print("                                                      > Elige una opción: ");
    }
}
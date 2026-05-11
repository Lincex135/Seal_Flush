package util;

import java.util.Scanner;
import java.util.ArrayList;

import objetos.*;

public class Util {

    public static String[] obtenerLineasCarta(Carta carta) {
        String[] lineas = new String[6];

        if (carta.isVuelta()) {
            lineas[0] = Color.PURPLE + Color.LIGHT_BLUE_BG + "┌─────┐" + Color.RESET;
            lineas[1] = Color.PURPLE + Color.LIGHT_BLUE_BG + "│▓▓▓▓▓│" + Color.RESET;
            lineas[2] = Color.PURPLE + Color.LIGHT_BLUE_BG + "│▓▓▓▓▓│" + Color.RESET;
            lineas[3] = Color.PURPLE + Color.LIGHT_BLUE_BG + "│▓▓▓▓▓│" + Color.RESET;
            lineas[4] = Color.PURPLE + Color.LIGHT_BLUE_BG + "│▓▓▓▓▓│" + Color.RESET;
            lineas[5] = Color.PURPLE + Color.LIGHT_BLUE_BG + "└─────┘" + Color.RESET;
        } else {
            String palo = carta.getPaloString();
            String numero = Carta.SIMB_RANGO[carta.getRango()];
            lineas[0] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "┌─────┐" + Color.RESET;
            lineas[5] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "└─────┘" + Color.RESET;
            String espacio = " ";
            if (numero.length() == 2) {
                espacio = "";
            }
            switch (palo) {
                case "PICAS" -> {
                    lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + numero + espacio + ".  " + Color.PURPLE + "│" + Color.RESET;
                    lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + " / \\" + Color.PURPLE + " │" + Color.RESET;
                    lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + "(_._)" + Color.PURPLE + "│" + Color.RESET;
                    lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + "  |" + espacio + numero + Color.PURPLE + "│" + Color.RESET;
                }
                case "TRÉBOLES" -> {
                    lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + numero + espacio + "   " + Color.PURPLE + "│" + Color.RESET;
                    lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + " (¯)" + Color.PURPLE + " │" + Color.RESET;
                    lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + "(_X_)" + Color.PURPLE + "│" + Color.RESET;
                    lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.BLACK + "  Y" + espacio + numero + Color.PURPLE + "│" + Color.RESET;
                }
                case "DIAMANTES" -> {
                    lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + numero + espacio + "^  " + Color.PURPLE + "│" + Color.RESET;
                    lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + " / \\ " + Color.PURPLE + "│" + Color.RESET;
                    lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + " \\ / " + Color.PURPLE + "│" + Color.RESET;
                    lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + "  v" + espacio + numero + Color.PURPLE + "│" + Color.RESET;
                }
                case "CORAZONES" -> {
                    lineas[1] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + numero + espacio + "   " + Color.PURPLE + "│" + Color.RESET;
                    lineas[2] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + "(¯v¯)" + Color.PURPLE + "│" + Color.RESET;
                    lineas[3] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + " \\ / " + Color.PURPLE + "│" + Color.RESET;
                    lineas[4] = Color.PURPLE + Color.LIGHT_YELLOW_BG + "│" + Color.RED + "  v" + espacio + numero + Color.PURPLE + "│" + Color.RESET;
                }
            }
        }


        return lineas;
    }

    // Imprime varias cartas horizontalmente, tu mano
    public static void pintarCartas(Carta[] cartas) {
        String[][] todasLineas = new String[cartas.length][];


        for (int i = 0; i < cartas.length; i++) {
            todasLineas[i] = obtenerLineasCarta(cartas[i]);
        }

        for (int fila = 0; fila < todasLineas[0].length; fila++) {
            StringBuilder sb = new StringBuilder();
            for (String[] todasLinea : todasLineas) {
                sb.append(todasLinea[fila]);
                sb.append("  ");
            }
            System.out.println(sb);
        }
    }

    public static void printInicio() {
        // Centrado vertical: padding arriba y abajo para cartas
        int altFoca = Ascii.FOCA.length;    // 25
        int altCartas = Ascii.CARTAS.length;  // 11
        int altMenu = Ascii.MENU.length;    // 5

        int padCartas = (altFoca - altCartas) / 2;  // offset de cartas respecto a foca
        int padMenu = (altFoca - altMenu) / 2;  // offset de menu respecto a foca

        String vacioCarta = "                                              ";
        String vacioMenu = "                                ";

        for (int i = 0; i < altFoca; i++) {
            int cartaIdx = i - padCartas;
            int menuIdx = i - padMenu;


            String colMenu = (menuIdx >= 0 && menuIdx < altMenu) ? Ascii.MENU[menuIdx] : vacioMenu;
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

    public static void limpiar() {
        try {
            String os = System.getProperty("os.name").toLowerCase();


            if (os.contains("windows")) {
                // Comando para Windows
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            } else {
                // Comando para Linux / macOS
                new ProcessBuilder("clear")
                        .inheritIO()
                        .start()
                        .waitFor();
            }
        } catch (Exception e) {
            // Si falla, usar alternativa ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static void printEstadoPartida(Tablero tablero, Bote bote, ArrayList<Jugador> listaJugadores, String fase) {
        System.out.println("                                                                    -----  " + fase + "  -----");
        System.out.println();
        System.out.println(tablero);
        System.out.println("                                                               ----------  " + bote + "  ----------");
        System.out.println();
        for (Jugador jugador : listaJugadores) {
            jugador.printNomJugador();
        }
        System.out.println();
        System.out.println();
        if (bote.getCantidad() > 0) {
            System.out.println("                                                           ----------  APUESTAS ACTUALES  ----------");
        }
        for (Jugador jugador : listaJugadores) {
            if (jugador.getApuestaActual() > 0) {
                System.out.println(jugador.getNomJugador() + " ha apostado " + jugador.getApuestaActual() + " fichas.");
                System.out.println();
            }
        }
    }

    public static ArrayList<Jugador> reordenar(ArrayList<Jugador> listaJugadores, int aleatorio) {
        int n = listaJugadores.size();
        ArrayList<Jugador> ordenJugadores = new ArrayList<Jugador>();

        for (int i = 0; i < n; i++) {
            if (i < aleatorio) {
                ordenJugadores.add(listaJugadores.get(aleatorio - 1 - i));
            } else {
                ordenJugadores.add(listaJugadores.get(n - 1 - (i - aleatorio)));
            }
        }

        return ordenJugadores;
    }

    public static void apostarCiegas(ArrayList<Jugador> ordenJugadores, Bote bote, Tablero tablero) {
        System.out.println("Apostando las ciegas:");
        System.out.println("La ciega pequeña (" + ordenJugadores.get(0).getNomJugador() + ") son 5 fichas " +
                "y la ciega grande (" + ordenJugadores.get(1).getNomJugador() + ") son 10 fichas.");
        System.out.println();
        ordenJugadores.get(0).apostar(5);
        ordenJugadores.get(1).apostar(10);
        bote.actualizarCantidad(15);
        tablero.setApuestaRonda(10);
    }

    public static void establecerDealer(ArrayList<Jugador> listaJugadores, int aleatorio) {
        for (Jugador jugador : listaJugadores) {
            jugador.setEsDealerActual(false);
        }
        listaJugadores.get(aleatorio).setEsDealerActual(true);
    }

    public static boolean ejecutarAccion(int opcion, Jugador jugador, Bote bote,
                                         Tablero tablero, Scanner teclado) {
        switch (opcion) {
            case 1 -> { // Igualar
                int diferencia = tablero.getApuestaRonda() - jugador.getApuestaActual();
                if (diferencia <= 0) {
                    System.out.println(jugador.getNomJugador() + " pasa.");
                } else if (!jugador.puedeApostar(diferencia)) {
                    System.out.println("No tienes fichas suficientes para igualar (" + diferencia + "). Elige otra opción.");
                    return false;
                } else {
                    jugador.apostar(diferencia);
                    bote.actualizarCantidad(diferencia);
                    System.out.println(jugador.getNomJugador() + " iguala " + diferencia + " fichas. Fichas restantes: " + jugador.getFichas());
                    System.out.println();
                }
                return true;
            }
            case 2 -> { // Subir apuesta
                int subida;
                do {
                    System.out.print("¿Cuánto quieres subir sobre la apuesta actual (" + tablero.getApuestaRonda() + ")? ");
                    try {
                        subida = Integer.parseInt(teclado.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println(Color.RED + "ERROR. Formato no válido. Escriba un número" + Color.RESET);
                        System.out.println();
                        subida = -1;
                    }
                    System.out.println();
                    if (subida <= 0) {
                        System.out.println("La subida debe ser mayor a 0.");
                    } else if (subida % 5 != 0) {
                        System.out.println(Color.RED + "ERROR. La cantidad debe ser múltiplo de 5" + Color.RESET);
                        System.out.println();
                    }
                } while (subida <= 0 || subida % 5 != 0);

                int total = tablero.getApuestaRonda() - jugador.getApuestaActual() + subida;
                if (!jugador.puedeApostar(total)) {
                    System.out.println("No tienes fichas suficientes. Necesitas " + total + " y tienes " + jugador.getFichas() + ".");
                    return false;
                }
                jugador.apostar(total);
                bote.actualizarCantidad(total);
                tablero.setApuestaRonda(tablero.getApuestaRonda() + subida);
                System.out.println(jugador.getNomJugador() + " sube la apuesta. Nueva apuesta más alta de la ronda: " + tablero.getApuestaRonda() + ". Fichas restantes: " + jugador.getFichas());
                System.out.println();
                return true;
            }
            case 3 -> { // Retirarse
                jugador.retirarse();
                System.out.println(jugador.getNomJugador() + " se retira.");
                System.out.println();
                return true;
            }
            default -> {
                System.out.println("Opción no válida.");
                return false;
            }
        }
    }

    public static boolean ejecutarTurno(Jugador jugador, Bote bote, Tablero tablero,
                                        ArrayList<Jugador> listaJugadores, String fase, Scanner teclado) {

        int activos = 0;
        for (Jugador j : listaJugadores) {
            if (j.estaActivo()) activos++;
        }
        if (!jugador.estaActivo() || activos == 1) {
            return false;
        }

        System.out.print("Pulse enter para empezar el turno de " + jugador.getNomJugador() + " ");
        teclado.nextLine();
        Util.limpiar();
        System.out.println("Turno de " + jugador.getNomJugador());

        int respuestaJ;
        do {
            System.out.print(Ascii.MENU_JUGADOR);
            respuestaJ = Integer.parseInt(teclado.nextLine());

            System.out.println();
            switch (respuestaJ) {
                case 1 -> {
                    boolean turnoAcabado = false;
                    int respuestaAcc;
                    do {
                        System.out.print(Ascii.MENU_ACCIONES);
                        respuestaAcc = Integer.parseInt(teclado.nextLine());
                        System.out.println();
                        if (respuestaAcc != 0) {
                            turnoAcabado = Util.ejecutarAccion(respuestaAcc, jugador, bote, tablero, teclado);
                        }
                    } while (!turnoAcabado && respuestaAcc != 0);

                    if (!turnoAcabado) respuestaJ = 0; // volvió con 0, repetir MENU_JUGADOR
                }
                case 2 -> {
                    System.out.println("---- Tu mano ----");
                    System.out.println();
                    Util.pintarCartas(jugador.getMano());
                    System.out.println();
                    respuestaJ = 0; // ver mano no termina el turno
                }

                case 3 -> {
                    Util.printEstadoPartida(tablero, bote, listaJugadores, fase);
                    System.out.println();
                    respuestaJ = 0; // ver estado no termina el turno
                }
                case 0 -> {
                    // Vacío, caso de volver
                }
                default -> System.out.println(Color.RED + "ERROR. Elija una opción válida" + Color.RESET);
            }
        } while (respuestaJ != 1);
        return true;
    }

    public static boolean soloQuedaUnJugador(ArrayList<Jugador> listaJugadores) {
        int jugadoresActivos = 0;
        String nomGanador = "";

        for (Jugador jugador : listaJugadores) {
            if (jugador.estaActivo()) {
                nomGanador = jugador.getNomJugador();
                jugadoresActivos++;
            }
        }
        boolean quedaUno = jugadoresActivos == 1;
        if (quedaUno) {
            System.out.println("Enhorabuena gana " + nomGanador);
        }
        return quedaUno;
    }

}
package util;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

import objetos.*;

/**
 * Clase util para la optimización del proyecto
 *
 *  @author Ximena López
 *  @author Adrián de Armas
 *  @version 1.0
 */
public class Util {

    /**
     * Metodo estático para obtener las líneas de las cartas
     *
     * @param carta objeto de tipo Carta
     * @return devuelve un array de String que representa la carta en diferentes líneas
     */
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

    /**
     * Metodo que sirve para mostrar las cartas en pantalla
     *
     * @param cartas array de tipo Carta
     */
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
        System.out.println();
    }

    /**
     * Metodo que muestra en pantalla el inicio que es una foca y unas cartas
     */
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

    /**
     * Metodo para comprobar que el nombre del jugador no está repetido
     *
     * @param listaJugadores lista de jugadores
     * @param nombre nombre del jugador
     * @return devuelve true si el jugador está repetido y false si no
     */
    public static boolean nombreRepetido(ArrayList<Jugador> listaJugadores, String nombre) {
        for (Jugador jugador : listaJugadores) {
            if (jugador.getNomJugador().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para limpiar la terminal al pasar de turno
     */
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

    /**
     * Metodo para mostrar por pantalla el estado de la partida
     *
     * @param tablero objeto de tipo Tablero
     * @param bote objeto de tipo Bote
     * @param listaJugadores lista de jugadores
     * @param fase nombre de la fase
     */
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
                System.out.println(Color.PINK + jugador.getNomJugador() + Color.RESET + " ha apostado " + Color.YELLOW + jugador.getApuestaActual() + " fichas." + Color.RESET);
                System.out.println();
            }
        }
    }

    /**
     * Metodo que ordena los jugadores de la lista de jugadores
     *
     * @param listaJugadores lista de jugadores
     * @param aleatorio numero aleatorio
     * @return devuelve una lista ordenada de los jugadores
     */
    public static ArrayList<Jugador> reordenar(ArrayList<Jugador> listaJugadores, int aleatorio) {
        int n = listaJugadores.size();
        ArrayList<Jugador> ordenJugadores = new ArrayList<Jugador>();

        for (int i = 0; i < n; i++) {
            Jugador jugador = listaJugadores.get((aleatorio - 1 - i + n) % n);
            if (!jugador.estaEliminado()) {
                ordenJugadores.add(jugador);
            }
        }

        return ordenJugadores;
    }

    /**
     * Metodo para apostar las ciegas
     *
     * @param ordenJugadores lista de jugadores ordenada
     * @param bote objeto bote
     * @param tablero objeto talbero
     */
    public static void apostarCiegas(ArrayList<Jugador> ordenJugadores, Bote bote, Tablero tablero) {
        if (ordenJugadores.size() < 2) {
            return;
        }

        // Con 2 jugadores, el dealer (último en ordenJugadores) paga la ciega pequeña
        int indicePequena = 0;
        int indiqueGrande = 1;
        if (ordenJugadores.size() == 2) {
            indicePequena = 1;
            indiqueGrande = 0;
        }

        System.out.println("Apostando las ciegas:" + "\n");
        System.out.println("La ciega pequeña (" + ordenJugadores.get(indicePequena).getNomJugador() + ") son 5 fichas " +
                "y la ciega grande (" + ordenJugadores.get(indiqueGrande).getNomJugador() + ") son 10 fichas.");
        System.out.println();
        ordenJugadores.get(indicePequena).apostar(5);
        ordenJugadores.get(indiqueGrande).apostar(10);
        bote.actualizarCantidad(15);
        tablero.setApuestaRonda(10);
    }

    /**
     * Metodo para establecer el dealer la primera ronda
     *
     * @param listaJugadores lista de jugadores
     * @param aleatorio numero aleatorio
     */
    public static void establecerDealer(ArrayList<Jugador> listaJugadores, int aleatorio) {
        for (Jugador jugador : listaJugadores) {
            jugador.setEsDealerActual(false);
        }
        listaJugadores.get(aleatorio).setEsDealerActual(true);
    }

    /**
     * Metodo para obtener el dealer a partir de la segunda ronda
     *
     * @param listaJugadores lista de jugadores
     * @param dealerActual posicion del dealer actual
     * @return devuelve la posición del siguiente dealer
     */
    public static int obtenerSiguienteDealer(ArrayList<Jugador> listaJugadores, int dealerActual) {
        int n = listaJugadores.size();
        int siguienteDealer = dealerActual;

        do {
            siguienteDealer = (siguienteDealer - 1 + n) % n;
        } while (listaJugadores.get(siguienteDealer).estaEliminado());

        return siguienteDealer;
    }

    /**
     * Metodo para ejecutar las diferentes acciones que puede hacer el jugador durante la partida
     *
     * @param opcion numero de la opcion
     * @param jugador objeto Jugador
     * @param bote objeto Bote
     * @param tablero objeto Tablero
     * @param teclado objeto Scanner
     * @return devuelve true si la opción elegida es válida y false si no
     */
    public static boolean ejecutarAccion(int opcion, Jugador jugador, Bote bote,
                                         Tablero tablero, Scanner teclado) {
        switch (opcion) {
            case 1 -> { // Igualar
                int diferencia = tablero.getApuestaRonda() - jugador.getApuestaActual();
                if (diferencia <= 0) {
                    System.out.println(jugador.getNomJugador() + " pasa." + "\n");

                } else if (!jugador.puedeApostar(diferencia)) {
                    System.out.println("No tienes fichas suficientes para igualar (" + diferencia + "). Elige otra opción.");
                    return false;
                } else {
                    jugador.apostar(diferencia);
                    bote.actualizarCantidad(diferencia);
                    System.out.println(jugador.getNomJugador() + " iguala " + diferencia + " fichas. Fichas restantes: " + jugador.getFichas() + "\n");
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
                        System.out.println(Color.RED + "ERROR. La cantidad debe ser múltiplo de 5" + Color.RESET + "\n");
                    }
                } while (subida <= 0 || subida % 5 != 0);

                int total = tablero.getApuestaRonda() - jugador.getApuestaActual() + subida;
                if (!jugador.puedeApostar(total)) {
                    System.out.println("No tienes fichas suficientes. Necesitas " + total + " y tienes " + jugador.getFichas() + ".");
                    return false;
                }
                jugador.apostar(total);
                if (jugador.estaAllIn()) {
                    System.out.println(Color.YELLOW + "¡¡¡" + jugador.getNomJugador() + " hace ALL-IN!!!" + Color.RESET + "\n");
                }

                bote.actualizarCantidad(total);
                tablero.setApuestaRonda(tablero.getApuestaRonda() + subida);
                System.out.println(jugador.getNomJugador() + " sube la apuesta. Nueva apuesta más alta de la ronda: " + tablero.getApuestaRonda() + ". Fichas restantes: " + jugador.getFichas() + "\n");
                return true;
            }
            case 3 -> { // Retirarse
                jugador.retirarse();
                System.out.println(jugador.getNomJugador() + " se retira." + "\n");
                return true;
            }
            default -> {
                System.out.println("Opción no válida.");
                return false;
            }
        }
    }

    /**
     * Metodo para ejecutar el torneo
     *
     * @param jugador objeto Jugador
     * @param bote objeto Bote
     * @param tablero objeto Tablero
     * @param listaJugadores lista de jugadores
     * @param fase nombre de fase
     * @param teclado objeto escaner
     * @return devuelve true si el torneo se puede ejecutar y false si no
     */
    public static boolean ejecutarTurno(Jugador jugador, Bote bote, Tablero tablero, ArrayList<Jugador> listaJugadores, String fase, Scanner teclado) {

        int puedenActuar = 0;
        for (Jugador j : listaJugadores) {
            if (j.estaActivo()) puedenActuar++;
        }
        if (!jugador.estaActivo() || puedenActuar == 0) {
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
                    System.out.println("---- Tu mano ----" + "\n");
                    Util.pintarCartas(jugador.getMano());
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
                default -> System.out.println(Color.RED + "ERROR. Elija una opción válida" + Color.RESET + "\n");
            }
        } while (respuestaJ != 1);
        return true;
    }

    /**
     * Metodo para saver si queda solo un jugador
     *
     * @param listaJugadores lista de jugadores
     * @return devuelve true si solo queda un jugador activo y false si no
     */
    public static boolean soloQuedaUnJugador(ArrayList<Jugador> listaJugadores) {
        int jugadoresActivos = 0;
        for (Jugador jugador : listaJugadores) {
            if (jugador.estaActivo() || jugador.estaAllIn()) {
                jugadoresActivos++;
            }
        }
        return jugadoresActivos == 1;
    }

    /**
     * Determina quién gana la ronda entre los jugadores que no se han retirado,
     * muestra el resultado por pantalla y entrega el bote al ganador.
     * En caso de empate, el bote se reparte a partes iguales.
     * Si no se puede repartir equitativamente, el bote se quedará con un resto lo demás se repartirá en múltiplos de 5
     *
     * @param listaJugadores lista de jugadores
     * @param tablero objeto Tablero
     * @param bote objeto Bote
     * @param eventos objeto EventosEspeciales
     */
    public static void resolverShowdown(ArrayList<Jugador> listaJugadores, Tablero tablero, Bote bote, EventoEspecial eventos) {

        int resto = 0; // El resto del bote (puede no ser 0)
        // Recopilar solo los jugadores que siguen activos (no se han retirado)
        ArrayList<Jugador> jugadoresActivos = obtenerJugadoresActivos(listaJugadores);

        System.out.println();
        System.out.println(Color.CYAN + "══════════════  SHOWDOWN  ══════════════" + Color.RESET + "\n");
        Carta[] cartasTablero = tablero.getCartas();
        for (Carta carta : cartasTablero) {
            carta.setVuelta(false);
        }
        System.out.println(tablero + "\n");

        // Caso especial: todos se retiraron menos uno (hay que entregarle el bote)
        if (jugadoresActivos.size() == 1) {
            Jugador jugadorGanador = jugadoresActivos.getFirst();
            System.out.println(Color.GREEN + "Enhorabuena gana " + Color.PINK + jugadorGanador.getNomJugador() + Color.GREEN + " porque el resto de jugadores se han retirado" + Color.RESET + "\n");
            Util.pintarCartas(jugadorGanador.getMano());
            entregarBote(jugadorGanador, bote.getCantidad(), false);
            bote.setCantidad(0);
            return;
        }

        // Evaluar la mano de cada jugador activo y mostrar sus cartas
        HashMap<Jugador, EvaluadorMano> jugadoresYEvaluacion = devolverJugadoresYEvaluacion(jugadoresActivos, tablero);
        HashMap<Jugador, TipoMano> jugadoresYTipoMano = devolverJugadoresYTipoMano(jugadoresActivos, tablero);
        for (Jugador jugadorActual : jugadoresActivos) {
            System.out.println(Color.PINK + jugadorActual.getNomJugador() + ":" + Color.RESET);
            System.out.println();
            pintarCartas(jugadorActual.getMano());
            TipoMano manoJugador = jugadoresYTipoMano.get(jugadorActual);
            System.out.println(Color.YELLOW + manoJugador.getDescripcion() + Color.RESET);
        }

        int valorManoGanadora = obtenerValorManoGanadora(jugadoresYEvaluacion, jugadoresActivos);

        // Recopilar los jugadores que tienen ese valor máximo (puede haber empate)
        ArrayList<Jugador> listaGanadores = obtenerJugadoresGanadores(jugadoresActivos, jugadoresYEvaluacion, valorManoGanadora);

        // Entregar el bote y mostrar el resultado
        System.out.println();
        int cantidadDelBote = bote.getCantidad();

        if (listaGanadores.size() == 1) {
            Jugador jugadorGanador = listaGanadores.getFirst();
            EvaluadorMano evaluacionGanadora = jugadoresYEvaluacion.get(jugadorGanador);
            TipoMano tipoManoGanadora = evaluacionGanadora.getTipo();
            boolean tieneFlushDominante = UtilEventosEspeciales.esFlushDominante(evaluacionGanadora, eventos.getPaloDominante());

            System.out.println(Color.GREEN + "Ganador: " + Color.PINK + jugadorGanador.getNomJugador() + Color.GREEN
                    + " gana " + cantidadDelBote + " fichas con "
                    + Color.YELLOW + tipoManoGanadora.getDescripcion() + Color.RESET);
            entregarBote(jugadorGanador, cantidadDelBote, tieneFlushDominante);

        } else {
            // Empate: repartir el bote en partes iguales
            int numGanadores = listaGanadores.size();
            resto = cantidadDelBote % numGanadores;
            if (resto != 0) {
                bote.setCantidad(bote.getCantidad() - resto);
            }
            int fichasPorJugador = (cantidadDelBote - resto) / numGanadores;

            System.out.print(Color.GREEN + "Empate entre: ");
            for (int posicion = 0; posicion < listaGanadores.size(); posicion++) {
                System.out.print(listaGanadores.get(posicion).getNomJugador());
                if (posicion < listaGanadores.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println("Cada uno recibe " + fichasPorJugador + " fichas." + Color.RESET);
            // tras repartir fichas del bote, marcar como eliminado quien tenga 0
            for (Jugador jugador : listaJugadores) {
                if (jugador.getFichas() == 0 && !jugador.estaEliminado()) {
                    jugador.setEstado(Estado.ELIMINADO);
                }
            }

            for (Jugador jugadorGanador : listaGanadores) {
                boolean tieneFlushDominante = UtilEventosEspeciales.esFlushDominante(jugadoresYEvaluacion.get(jugadorGanador), eventos.getPaloDominante());
                entregarBote(jugadorGanador, fichasPorJugador, tieneFlushDominante);
            }
        }
        comprobarEventosEspeciales(eventos, jugadoresActivos, tablero, listaGanadores);
        bote.setCantidad(resto);
        System.out.println();
    }

    /**
     * Metodo para entregar el bote al jugador ganador
     *
     * @param jugadorGanador jugador ganador
     * @param cantidadBase cantidad de fichas en el bote
     * @param tieneFlushDominante true si está activo y false si no
     */
    public static void entregarBote(Jugador jugadorGanador, int cantidadBase, boolean tieneFlushDominante) {
        int cantidadFinal = cantidadBase;

        if (tieneFlushDominante) {
            int bonusDominante = UtilEventosEspeciales.calcularPorcentaje(cantidadBase, 50);
            cantidadFinal += bonusDominante;
            System.out.println(Color.CYAN + "Sello dominante: +" + bonusDominante + " fichas para " + jugadorGanador.getNomJugador() + Color.RESET);
        }

        if (jugadorGanador.isTieneSelloDorado()) {
            int bonusDorado = UtilEventosEspeciales.calcularPorcentaje(cantidadBase, 10);
            cantidadFinal += bonusDorado;
            jugadorGanador.setTieneSelloDorado(false);
            System.out.println(Color.YELLOW + "Sello Dorado: +" + bonusDorado + " fichas para " + jugadorGanador.getNomJugador() + Color.RESET);
        }

        if (jugadorGanador.isTieneSelloOscuro()) {
            int penalizacionOscura = UtilEventosEspeciales.calcularPorcentaje(cantidadBase, 10);
            cantidadFinal -= penalizacionOscura;
            jugadorGanador.setTieneSelloOscuro(false);
            System.out.println(Color.PURPLE + "Sello Oscuro: -" + penalizacionOscura + " fichas para " + jugadorGanador.getNomJugador() + Color.RESET);
        }

        jugadorGanador.setFichas(jugadorGanador.getFichas() + cantidadFinal);
    }

    /**
     * Metodo para obtener los eventos especiales
     *
     * @param eventos objeto EventoEspecial
     * @param listaJugadores lista de jugadores
     * @param tablero objeto Tablero
     * @param jugadoresGanadores lista de jugadores ganadores
     */
    public static void comprobarEventosEspeciales(EventoEspecial eventos, ArrayList<Jugador> listaJugadores, Tablero tablero, ArrayList<Jugador> jugadoresGanadores) {
        HashMap<Jugador,TipoMano> jugadoresYTipoMano = devolverJugadoresYTipoMano(listaJugadores,tablero);
        UtilEventosEspeciales.comprobarSelloDorado(eventos,jugadoresGanadores,jugadoresYTipoMano);
        UtilEventosEspeciales.comprobarSelloOscuro(eventos,jugadoresGanadores,jugadoresYTipoMano,listaJugadores);
    }

    /**
     * Metodo que devuelve los jugadores y su tipo de mano
     *
     * @param listaJugadores lista de jugadores
     * @param tablero objeto tablero
     * @return devuelve un HashMap que muestra el jugador y su tipo de mano
     */
    public static HashMap<Jugador,TipoMano> devolverJugadoresYTipoMano(ArrayList<Jugador> listaJugadores, Tablero tablero) {
        HashMap<Jugador,TipoMano> jugadoresYTipoMano = new HashMap<Jugador,TipoMano>();
        for (Jugador jugadorActual : listaJugadores) {
            Mano manoJugador = new Mano(jugadorActual, tablero);
            EvaluadorMano evaluacionJugador = new EvaluadorMano(manoJugador);
            jugadoresYTipoMano.put(jugadorActual, evaluacionJugador.getTipo());
        }
        return jugadoresYTipoMano;
    }

    /**
     * Metodo que devuelve los jugadores y su mano evaluada
     *
     * @param listaJugadores lista de jugadores
     * @param tablero objeto tablero
     * @return devuelve un HashMap que muestra los jugadores y su mano evaluada
     */
    public static HashMap<Jugador, EvaluadorMano> devolverJugadoresYEvaluacion(ArrayList<Jugador> listaJugadores, Tablero tablero) {
        HashMap<Jugador, EvaluadorMano> jugadoresYEvaluacion = new HashMap<Jugador, EvaluadorMano>();
        for (Jugador jugadorActual : listaJugadores) {
            Mano manoJugador = new Mano(jugadorActual, tablero);
            EvaluadorMano evaluacionJugador = new EvaluadorMano(manoJugador);
            jugadoresYEvaluacion.put(jugadorActual, evaluacionJugador);
        }
        return jugadoresYEvaluacion;
    }

    /**
     * Metodo para obtener los jugadores ganadores
     *
     * @param jugadoresActivos lista de jugadores activos
     * @param jugadoresYEvaluacion HashMap de Jugador y EvaluadorMano
     * @param valorManoGanadora valor de la mano ganadora
     * @return
     */
    public static ArrayList<Jugador> obtenerJugadoresGanadores(ArrayList<Jugador> jugadoresActivos, HashMap<Jugador, EvaluadorMano> jugadoresYEvaluacion, int valorManoGanadora) {
        ArrayList<Jugador> listaGanadores = new ArrayList<>();
        for (Jugador jugadorActual : jugadoresActivos) {
            if (jugadoresYEvaluacion.get(jugadorActual).getValor() == valorManoGanadora) {
                listaGanadores.add(jugadorActual);
            }
        }
        return listaGanadores;
    }

    /**
     * Metodo para obtener los jugadores activos
     *
     * @param listaJugadores lista de jugadores
     * @return devuelve un ArrayList de los jugadores activos
     */
    public static ArrayList<Jugador> obtenerJugadoresActivos(ArrayList<Jugador> listaJugadores) {
        ArrayList<Jugador> jugadoresActivos = new ArrayList<>();
        for (Jugador jugadorActual : listaJugadores) {
            if (jugadorActual.estaActivo() || jugadorActual.estaAllIn()) {
                jugadoresActivos.add(jugadorActual);
            }
        }
        return jugadoresActivos;
    }

    /**
     * Metodo para obtener el valor de la mano ganadora
     *
     * @param jugadoresYEvaluacion HashMap de Jugador y EvaluadorMano
     * @param jugadoresActivos lista de jugadores activos
     * @return
     */
    public static int obtenerValorManoGanadora(HashMap<Jugador, EvaluadorMano> jugadoresYEvaluacion, ArrayList<Jugador> jugadoresActivos) {
        int valorManoGanadora = -1;
        for (Jugador jugadorActual : jugadoresActivos) {
            if (jugadoresYEvaluacion.get(jugadorActual).getValor() > valorManoGanadora) {
                valorManoGanadora = jugadoresYEvaluacion.get(jugadorActual).getValor();
            }
        }
        return valorManoGanadora;
    }

    /**
     * Metodo para obtener el nombre del jugador ganador
     *
     * @param listaJugadores lista de jugadores
     * @return devuelve el nombre del jugador ganador
     */
    public static String obtenerNomJugadorGanador(ArrayList<Jugador> listaJugadores) {
        String nomJugadorGanador = "";
        int fichasMaximas = -1;
        for (Jugador jugador : listaJugadores) {
            if (jugador.getFichas() > fichasMaximas) {
                fichasMaximas = jugador.getFichas();
                nomJugadorGanador = jugador.getNomJugador();
            }
        }
        return nomJugadorGanador;
    }
}

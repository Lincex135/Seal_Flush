import java.util.ArrayList;
import java.util.Scanner;

import util.*;
import objetos.*;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Util.printInicio();
        System.out.println();
        int respuesta1, respuestaModo = -1, numRondas = -1, rondaActual;
        boolean empezar = false;
        boolean primeraPartida = false;
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        do {
            System.out.print(Ascii.MENU1);
            respuesta1 = Integer.parseInt(teclado.nextLine());
            System.out.println();
            switch (respuesta1) {
                case 0:
                    System.out.println("Saliendo del programa. ¡Muchas Gracias por jugar! \uD83E\uDDAD");
                    break;

                case 1:

                    do {
                        System.out.print(Ascii.MENU2);
                        respuestaModo = Integer.parseInt(teclado.nextLine());
                        System.out.println();
                        switch (respuestaModo) {
                            case 0: // vacío, caso de volver
                                break;
                            case 1:
                                do {
                                    System.out.print("¿Cuántas rondas va a durar la partida?: ");
                                    numRondas = Integer.parseInt(teclado.nextLine());
                                    System.out.println();
                                    if (numRondas < 5) {
                                        System.out.println(Color.RED + "ERROR. Numero de rondas muy bajo, se pondrá a 5" + Color.RESET);
                                        System.out.println();
                                        numRondas = 5;
                                    }
                                } while (numRondas < 5);
                            case 2:
                                int respuesta3;
                                do {
                                    System.out.print(Ascii.MENU3);
                                    respuesta3 = Integer.parseInt(teclado.nextLine());
                                    System.out.println();
                                    switch (respuesta3) {
                                        case 0: // vacío, caso de volver
                                            break;

                                        case 1:
                                            empezar = true;
                                            int numJugadores;
                                            do {
                                                System.out.print("Introduce el número de jugadores (2-10): ");
                                                numJugadores = Integer.parseInt(teclado.nextLine());
                                                System.out.println();
                                                if (numJugadores < 2 || numJugadores > 10) {
                                                    System.out.println(Color.RED + "ERROR. El número de jugadores debe estar entre 2 y 10" + Color.RESET);
                                                    System.out.println();
                                                }
                                            } while (numJugadores < 2 || numJugadores > 10);
                                            System.out.println("Introduce los nombres de los jugadores (en minúsculas)");
                                            System.out.println();
                                            for (int i = 1; i <= numJugadores; i++) {
                                                String nombreJugador;
                                                boolean nombreRepetido, longitudInvalida;
                                                do {
                                                    System.out.print("  - Jugador " + i + ": ");
                                                    nombreJugador = teclado.nextLine().toLowerCase();
                                                    nombreRepetido = Util.nombreRepetido(listaJugadores, nombreJugador);
                                                    longitudInvalida = false;
                                                    System.out.println();
                                                    if (nombreJugador.length() < 3 || nombreJugador.length() > 10) {
                                                        longitudInvalida = true;
                                                        System.out.println(Color.RED + "ERROR. Longitud del nombre inválida" + Color.RESET);
                                                        System.out.println();
                                                    } else if (nombreRepetido) {
                                                        System.out.println(Color.RED + "ERROR. Nombre del jugador repetido" + Color.RESET);
                                                        System.out.println();
                                                    }
                                                } while (nombreRepetido || longitudInvalida);

                                                listaJugadores.add(new Jugador(i, nombreJugador));
                                            }
                                            break;

                                        case 2:
                                            System.out.println(new Instrucciones());
                                            break;

                                        default:
                                            System.out.println(Color.RED + "ERROR. Introduzca una opción válida" + Color.RESET);
                                            System.out.println();
                                    }
                                } while (respuesta3 != 0 && !empezar);
                                break;

                            default:
                                System.out.println(Color.RED + "ERROR. Introduzca una opción válida" + Color.RESET);
                                System.out.println();
                        }
                    } while (respuestaModo != 0 && !empezar);
                    break;

                case 2:
                    System.out.println("Mostrando estadísticas");
                    break;

                default:
                    System.out.println(Color.RED + "ERROR. Introduzca una opción válida" + Color.RESET);
                    System.out.println();
            }
        } while (respuesta1 != 0 && !empezar);

        if (empezar) { // Esto es importante porque si por ejemplo, nos salimos a la primera vez que se printea el menú, el código de dentro de este bloque se ejecutaría igualmente
            Mazo mazo = Mazo.getInstancia();
            Bote bote = Bote.getInstancia();
            EventoEspecial eventos = EventoEspecial.getInstancia();
            boolean partidaAcabada = false;
            boolean rondaAcabada = false;

            for (rondaActual = 1; !partidaAcabada; rondaActual++) {
                rondaAcabada = false;
                int aleatorio = 0;
                if (rondaActual == 1) {
                    int min = 0, max = listaJugadores.size() - 1;
                    aleatorio = (int) (Math.random() * (max - min + 1)) + min;
                    Util.establecerDealer(listaJugadores, aleatorio);
                } else {
                    aleatorio = (aleatorio - 1 + listaJugadores.size()) % listaJugadores.size();
                    Util.establecerDealer(listaJugadores, aleatorio);
                    for (Jugador jugador : listaJugadores) {
                        jugador.reiniciarRonda();
                    }
                }

                for (Jugador jugador : listaJugadores) {
                    jugador.setEstado(Estado.ACTIVO);
                    jugador.setApuestaActual(0);
                }

                if (bote.getCantidad() != 5) {
                    bote.setCantidad(0);
                }

                mazo.barajar();
                Carta[] cartasTablero = new Carta[5];
                for (int i = 0; i < cartasTablero.length; i++) {
                    cartasTablero[i] = mazo.devolverCarta();
                    cartasTablero[i].setVuelta(true);
                }

                for (Jugador jugador : listaJugadores) {
                    Carta carta1 = mazo.devolverCarta();
                    Carta carta2 = mazo.devolverCarta();
                    jugador.recibirCarta(carta1);
                    jugador.recibirCarta(carta2);
                }

                Tablero tablero = Tablero.getInstancia(cartasTablero, listaJugadores);
                tablero.setCartas(cartasTablero);
                if (!primeraPartida) {
                    tablero.setJugadores(listaJugadores);
                }

                for (int numFase = 1; !rondaAcabada; numFase++) {
                    if (numFase == 1) {
                        tablero.setApuestaRonda(0);
                    }

                    String fase = switch (numFase) {
                        case 1 -> "Pre-Flop";
                        case 2 -> "Flop";
                        case 3 -> "Turn";
                        case 4 -> "River";
                        default -> "";
                    };

                    switch (numFase) {
                        case 2 -> { // Flop: revelar cartas 0, 1, 2
                            cartasTablero[0].setVuelta(false);
                            cartasTablero[1].setVuelta(false);
                            cartasTablero[2].setVuelta(false);
                        }
                        case 3 -> cartasTablero[3].setVuelta(false);  // Turno: revelar carta 3
                        case 4 -> cartasTablero[4].setVuelta(false);  // River: revelar carta 4
                    }

                    System.out.println("                                                               ----------  RONDA " + rondaActual + "  ----------");
                    System.out.println("El dealer en la ronda " + rondaActual + " es " + listaJugadores.get(aleatorio).getNomJugador() + " (el jugador subrayado)");
                    Util.printEstadoPartida(tablero, bote, listaJugadores, fase);

                    ArrayList<Jugador> ordenJugadores = Util.reordenar(listaJugadores, aleatorio);

                    // Pagar ciegas (solo Pre-Flop)
                    if (numFase == 1) {
                        Util.apostarCiegas(ordenJugadores, bote, tablero);
                        Util.printEstadoPartida(tablero, bote, listaJugadores, fase);
                    }

                    // Jugadores que deciden primero (desde índice 2 en Pre-Flop, desde 0 en el resto)
                    int indiceInicio = (numFase == 1) ? 2 : 0;
                    for (int i = indiceInicio; i < ordenJugadores.size(); i++) {
                        Util.ejecutarTurno(ordenJugadores.get(i), bote, tablero, listaJugadores, fase, teclado);
                    }

                    // En Pre-Flop, las ciegas juegan al final
                    if (numFase == 1) {
                        for (int i = 0; i < 2; i++) {
                            Util.ejecutarTurno(ordenJugadores.get(i), bote, tablero, listaJugadores, fase, teclado);
                        }
                    }
                    if (Util.soloQuedaUnJugador(listaJugadores) || numFase == 4) {
                        Util.resolverShowdown(listaJugadores, tablero, bote);
                        rondaAcabada = true;
                    }
                }
                if (respuestaModo == 1) {
                    if (rondaActual == numRondas) {
                        partidaAcabada = true;
                    }
                }
            }
        }
    }
}
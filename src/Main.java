import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Util.printInicio();
        System.out.println();
        int respuesta1;
        boolean empezar = false;
        ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
        do {
            System.out.print(Ascii.MENU1);
            respuesta1 = Integer.parseInt(teclado.nextLine());
            System.out.println();
            switch (respuesta1) {
                case 0:
                    System.out.println("Saliendo del programa. ¡Muchas Gracias por jugar! \uD83E\uDDAD");
                    break;

                case 1:
                    int respuestaJuego;
                    do {
                        System.out.print(Ascii.MENU2);
                        respuestaJuego = Integer.parseInt(teclado.nextLine());
                        System.out.println();
                        switch (respuestaJuego) {
                            case 0: // vacío, caso de volver
                                break;
                            case 1:
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
                                                    System.out.println("ERROR. El número de jugadores debe estar entre 2 y 10");
                                                }
                                            } while (numJugadores < 2 || numJugadores > 10);
                                            System.out.println("Introduce los nombres de los jugadores (en minúsculas)");
                                            System.out.println();
                                            for (int i = 1; i <= numJugadores; i++) {
                                                String nombreJugador;
                                                boolean nombreRepetido;
                                                do {
                                                    System.out.print("  - Jugador " + i + ": ");
                                                    nombreJugador = teclado.nextLine().toLowerCase();
                                                    System.out.println();
                                                    nombreRepetido = Util.nombreRepetido(listaJugadores, nombreJugador);
                                                    if (nombreRepetido) {
                                                        System.out.println("ERROR. Nombre del jugador repetido");
                                                        System.out.println();
                                                    }
                                                } while (nombreRepetido);
                                                listaJugadores.add(new Jugador(i, nombreJugador));
                                            }
                                            break;

                                        case 2:
                                            if (respuestaJuego == 1) {
                                                System.out.println(new Instrucciones(Juego.POKER));
                                            }
                                            break;

                                        default:
                                            System.out.println("ERROR. Introduzca una opción válida");
                                    }
                                } while (respuesta3 != 0 && !empezar);
                                break;

                            default:
                                System.out.println("ERROR. Introduzca una opción válida");
                        }
                    } while (respuestaJuego != 0 && !empezar);
                    break;

                case 2:
                    System.out.println("Mostrando estadísticas");
                    break;

                default:
                    System.out.println("ERROR. Introduzca una opción válida");
            }
        } while (respuesta1 != 0 && !empezar);

        if (empezar) { // Esto es importante porque si por ejemplo, nos salimos a la primera vez que se printea el menú, el código de dentro de este bloque se ejecutaría igualmente
            Carta[] cartasTablero = new Carta[5];
            for (int i = 0; i < cartasTablero.length; i++) {
                cartasTablero[i] = new Carta(i, 2);
            }
            cartasTablero[3].setVuelta(true);
            cartasTablero[4].setVuelta(true);
            System.out.println(new Tablero(cartasTablero, listaJugadores));
            for (Jugador jugador : listaJugadores) {
                jugador.printNomJugador();
            }
        }

    }
}

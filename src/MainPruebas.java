import objetos.Carta;
import objetos.Jugador;
import objetos.Tablero;
import util.Util;

import java.util.ArrayList;

public class MainPruebas {
    public static void main(String[] args) {
        // util.Instrucciones instrucciones = new util.Instrucciones(util.Juego.POKER);
        // new util.JerarquiaDeManos().imprimir();

        ArrayList<Jugador> jugadores = new ArrayList<>();

        Carta[] cartas = new Carta[5];
        Carta cartaVuelta = new Carta(1, 1);
        cartaVuelta.setVuelta(true);
        cartas[0] = cartaVuelta;
        cartas[1] = cartaVuelta;
        cartas[2] = cartaVuelta;
        cartas[3] = cartaVuelta;
        cartas[4] = cartaVuelta;

        Util.pintarCartas(cartas);

        System.out.println();
        System.out.println(new Tablero(cartas, jugadores));
        Jugador ximena = new Jugador(1, "Ximena");
        jugadores.add(ximena);
        ximena.printNomJugador();
        System.out.println();
    }
}
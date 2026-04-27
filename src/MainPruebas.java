import objetos.*;
import util.Util;

import java.util.ArrayList;

public class MainPruebas {
    public static void main(String[] args) {
        // util.Instrucciones instrucciones = new util.Instrucciones(util.Juego.POKER);
        // new util.JerarquiaDeManos().imprimir();

        ArrayList<Jugador> jugadores = new ArrayList<>();

        Carta[] cartas = new Carta[5];
        Carta cartaP = new Carta(1, 0);
        cartas[0] = cartaP;
        cartas[1] = cartaP;
        cartas[2] = cartaP;
        cartas[3] = cartaP;
        cartas[4] = cartaP;
        Util.pintarCartas(cartas);

        System.out.println();
        Tablero tablero = Tablero.getInstancia(cartas, jugadores);
        Jugador ximena = new Jugador(1, "Ximena");
        jugadores.add(ximena);
        ximena.printNomJugador();
        System.out.println();

        Mazo mazo = Mazo.getInstancia();
        Mazo mazo1 = Mazo.getInstancia();
        System.out.println();
        Bote botePrueba = Bote.getInstancia();
        Bote bote1 = Bote.getInstancia();

        System.out.println(mazo);
        System.out.println(mazo1);
        System.out.println(botePrueba);
        System.out.println(bote1);
        mazo.barajar();
        System.out.println(mazo);
    }
}
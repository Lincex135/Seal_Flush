package util;

import objetos.Carta;

/**
 * Clase con atributos Estaticos que muestran en pantalla ejemplos de los diferentes tipos de manos que existen
 *
 * @author Ximena López
 * @author Adrián de Armas
 * @version 1.0
 */
public class JerarquiaDeManos {

    public static final Carta[] ESCALERA_REAL = {
            new Carta(Carta.DIEZ, Carta.PICAS),
            new Carta(Carta.JOTA, Carta.PICAS),
            new Carta(Carta.REINA, Carta.PICAS),
            new Carta(Carta.REY, Carta.PICAS),
            new Carta(Carta.AS, Carta.PICAS),
    };

    public static final Carta[] ESCALERA_DE_COLOR = {
            new Carta(Carta.SEIS, Carta.CORAZONES),
            new Carta(Carta.SIETE, Carta.CORAZONES),
            new Carta(Carta.OCHO, Carta.CORAZONES),
            new Carta(Carta.NUEVE, Carta.CORAZONES),
            new Carta(Carta.DIEZ, Carta.CORAZONES),
    };

    public static final Carta[] POKER = {
            new Carta(Carta.DIEZ, Carta.CORAZONES),
            new Carta(Carta.DIEZ, Carta.PICAS),
            new Carta(Carta.DIEZ, Carta.DIAMANTES),
            new Carta(Carta.DIEZ, Carta.TREBOLES),
    };

    public static final Carta[] FULL_HOUSE = {
            new Carta(Carta.AS, Carta.DIAMANTES),
            new Carta(Carta.AS, Carta.PICAS),
            new Carta(Carta.AS, Carta.CORAZONES),
            new Carta(Carta.SIETE, Carta.TREBOLES),
            new Carta(Carta.SIETE, Carta.DIAMANTES),
    };

    public static final Carta[] COLOR = {
            new Carta(Carta.AS, Carta.DIAMANTES),
            new Carta(Carta.JOTA, Carta.DIAMANTES),
            new Carta(Carta.OCHO, Carta.DIAMANTES),
            new Carta(Carta.CINCO, Carta.DIAMANTES),
            new Carta(Carta.SIETE, Carta.DIAMANTES),
    };

    public static final Carta[] ESCALERA = {
            new Carta(Carta.SEIS, Carta.PICAS),
            new Carta(Carta.SIETE, Carta.TREBOLES),
            new Carta(Carta.OCHO, Carta.DIAMANTES),
            new Carta(Carta.NUEVE, Carta.PICAS),
            new Carta(Carta.DIEZ, Carta.CORAZONES),
    };

    public static final Carta[] TRIO = {
            new Carta(Carta.REINA, Carta.CORAZONES),
            new Carta(Carta.REINA, Carta.PICAS),
            new Carta(Carta.REINA, Carta.DIAMANTES),
    };

    public static final Carta[] DOBLE_PAREJA = {
            new Carta(Carta.JOTA, Carta.CORAZONES),
            new Carta(Carta.JOTA, Carta.TREBOLES),
            new Carta(Carta.NUEVE, Carta.DIAMANTES),
            new Carta(Carta.NUEVE, Carta.TREBOLES),
    };

    public static final Carta[] PAREJA = {
            new Carta(Carta.REINA, Carta.PICAS),
            new Carta(Carta.REINA, Carta.CORAZONES),
    };

    public static final Carta[] CARTA_ALTA = {
            new Carta(Carta.AS, Carta.CORAZONES),
    };

    public void imprimir() {
        System.out.println("Escalera Real: 5 cartas D, J, Q, K y A del mismo palo:\n");
        Util.pintarCartas(ESCALERA_REAL);
        System.out.println();
        System.out.println("Escalera de color: 5 cartas del mismo palo en orden:\n");
        Util.pintarCartas(ESCALERA_DE_COLOR);
        System.out.println();
        System.out.println("Poker: 4 cartas del mismo valor:\n");
        Util.pintarCartas(POKER);
        System.out.println();
        System.out.println("Full house: Un trío y una pareja:\n");
        Util.pintarCartas(FULL_HOUSE);
        System.out.println();
        System.out.println("Color: 5 cartas del mismo palo:\n");
        Util.pintarCartas(COLOR);
        System.out.println();
        System.out.println("Escalera: 5 cartas en orden:\n");
        Util.pintarCartas(ESCALERA);
        System.out.println();
        System.out.println("Trío: 3 cartas del mismo valor:\n");
        Util.pintarCartas(TRIO);
        System.out.println();
        System.out.println("Doble pareja: 2 parejas diferentes:\n");
        Util.pintarCartas(DOBLE_PAREJA);
        System.out.println();
        System.out.println("Pareja: 2 cartas del mismo valor:\n");
        Util.pintarCartas(PAREJA);
        System.out.println();
        System.out.println("Carta alta: la carta más alta de la mesa:\n");
        Util.pintarCartas(CARTA_ALTA);
    }
}
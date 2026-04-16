public class JerarquiaDeManos {
    public static final String[][] ESCALERA_REAL= {
            {"PICAS", "D"},
            {"PICAS", "J"},
            {"PICAS", "Q"},
            {"PICAS", "K"},
            {"PICAS", "A"},
    };

    public static final String[][] ESCALERA_DE_COLOR = {
            {"CORAZONES", "6"},
            {"CORAZONES", "7"},
            {"CORAZONES", "8"},
            {"CORAZONES", "9"},
            {"CORAZONES", "D"},
    };

    public static final String[][] POKER = {
            {"CORAZONES", "D"},
            {"PICAS", "D"},
            {"DIAMANTES", "D"},
            {"TRÉBOLES", "D"},
    };

    public static final String[][] FULL_HOUSE = {
            {"DIAMANTES", "A"},
            {"PICAS", "A"},
            {"CORAZONES", "A"},
            {"TRÉBOLES", "7"},
            {"DIAMANTES", "7"},
    };

    public static final String[][] COLOR = {
            {"DIAMANTES", "A"},
            {"DIAMANTES", "J"},
            {"DIAMANTES", "8"},
            {"DIAMANTES", "5"},
            {"DIAMANTES", "7"},
    };

    public static final String[][] ESCALERA = {
            {"PICAS", "6"},
            {"TRÉBOLES", "7"},
            {"DIAMANTES", "8"},
            {"PICAS", "9"},
            {"CORAZONES", "D"},
    };

    public static final String[][] TRIO = {
            {"CORAZONES", "Q"},
            {"PICAS", "Q"},
            {"DIAMANTES", "Q"},
    };

    public static final String[][] DOBLE_PAREJA = {
            {"CORAZONES", "J"},
            {"TRÉBOLES", "J"},
            {"DIAMANTES", "9"},
            {"TRÉBOLES", "9"},
    };

    public static final String[][] PAREJA = {
            {"PICAS", "Q"},
            {"CORAZONES", "Q"},
    };

    public static final String[][] CARTA_ALTA = {
            {"CORAZONES", "A"},
    };

    public void imprimir() {
        System.out.println("Escalera Real: 5 cartas D, J, Q, K y A del mismo palo");
        Util.pintarCartas(ESCALERA_REAL);
        System.out.println("Escalera de color: 5 cartas del mismo palo en orden");
        Util.pintarCartas(ESCALERA_DE_COLOR);
        System.out.println("Poker: 4 cartas del mismo valor");
        Util.pintarCartas(POKER);
        System.out.println("Full house: Un trío y una pareja");
        Util.pintarCartas(FULL_HOUSE);
        System.out.println("Color: 5 cartas del mismo palo");
        Util.pintarCartas(COLOR);
        System.out.println("Escalera: 5 cartas en orden");
        Util.pintarCartas(ESCALERA);
        System.out.println("Trío: 3 cartas del mismo valor");
        Util.pintarCartas(TRIO);
        System.out.println("Doble pareja: 2 parejas diferentes");
        Util.pintarCartas(DOBLE_PAREJA);
        System.out.println("Pareja: 2 cartas del mismo valor");
        Util.pintarCartas(PAREJA);
        System.out.println("Carta alta: la carta más alta de la mesa");
        Util.pintarCartas(CARTA_ALTA);
    }
}

public class MainPruebas {
    public static void main(String[] args) {
        Instrucciones instrucciones = new Instrucciones(Juego.POKER);
        String[][] mano = {
                {"PICAS", "A"},
                {"CORAZONES", "2"},
                {"DIAMANTES", "3"},
                {"TRÉBOLES", "4"}
        };
        Util.pintarCartas(mano);
        Carta cartaVuelta = new Carta (1, 1, true);
        Carta[] cartas = new Carta[1];
        cartas[0] = cartaVuelta;
        Util.pintarCartas(cartas);
        System.out.println();
    }
}
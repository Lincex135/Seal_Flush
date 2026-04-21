import java.util.ArrayList;

public class MainPruebas {
    public static void main(String[] args) {
        Instrucciones instrucciones = new Instrucciones(Juego.POKER);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        String[][] mano = {
                {"PICAS", "A"},
                {"CORAZONES", "2"},
                {"DIAMANTES", "3"},
                {"TRÉBOLES", "4"}
        };
        Util.pintarCartas(mano);
//        Carta cartaVuelta = new Carta(1,1);
//        cartaVuelta.setVuelta(true);
//        Util.pintarCartas(cartaVuelta);
        System.out.println();
        System.out.println(new Tablero());
        Jugador ximena = new Jugador(1,"Ximena");
        jugadores.add(ximena);
        ximena.printNomJugador();
        System.out.println();
    }
}
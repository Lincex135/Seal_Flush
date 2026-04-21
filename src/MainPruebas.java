
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
        System.out.println(instrucciones);
        Util.printInicio();
        System.out.println();
        JerarquiaDeManos jerarquiaDeManos = new JerarquiaDeManos();
        jerarquiaDeManos.imprimir();
    }
}
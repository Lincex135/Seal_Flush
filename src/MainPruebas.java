
public class MainPruebas {
    public static void main(String[] args) {
        String[][] mano = {
                {"PICAS", "A"},
                {"CORAZONES", "2"},
                {"DIAMANTES", "3"},
                {"TRÉBOLES", "4"}
        };
        Util.pintarCartas(mano);
        Util.printMenu();
    }
}
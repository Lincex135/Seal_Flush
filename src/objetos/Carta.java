package objetos;

public class Carta {

    private final int rango;
    private final int palo;
    private boolean vuelta = false;
    public static final int NUM_DE_RANGOS = 13;
    public static final int NUM_DE_PALOS = 4;

    public static final int AS = 12;
    public static final int REY = 11;
    public static final int REINA = 10;
    public static final int JOTA = 9;
    public static final int DIEZ = 8;
    public static final int NUEVE = 7;
    public static final int OCHO = 6;
    public static final int SIETE = 5;
    public static final int SEIS = 4;
    public static final int CINCO = 3;
    public static final int CUATRO = 2;
    public static final int TRES = 1;
    public static final int DOS = 0;

    public static final int PICAS = 3;
    public static final int CORAZONES = 2;
    public static final int TREBOLES = 1;
    public static final int DIAMANTES = 0;

    public static final String[] SIMB_RANGO = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    };

    /** Los símbolos de los palos.
     * d - diamantes
     * c - tréboles
     * h - corazones
     * s - picas */
    public static final char[] SIMB_PALO = {'d', 'c', 'h', 's'};

    public Carta (int rango, int palo) {
        if (rango < 0 || rango > NUM_DE_RANGOS - 1) {
            throw new IllegalArgumentException("Número inválido");
        }
        if (palo < 0 || palo > NUM_DE_PALOS - 1) {
            throw new IllegalArgumentException("Palo inválido");
        }
        this.rango = rango;
        this.palo = palo;
    }

    public String getPaloString() {
        return switch (this.palo) {
            case 0 -> "DIAMANTES";
            case 1 -> "TRÉBOLES";
            case 2 -> "CORAZONES";
            case 3 -> "PICAS";
            default -> "";
        };
    }

    public int getPalo() {
        return this.palo;
    }

    public int getRango() {
        return rango;
    }

    public boolean isVuelta() {
        return vuelta;
    }

    public void setVuelta(boolean vuelta) {
        this.vuelta = vuelta;
    }

    @Override
    public int hashCode() {
        return (rango * NUM_DE_PALOS + palo);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Carta) {
            return ((Carta) obj).hashCode() == hashCode();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return SIMB_RANGO[rango] + SIMB_PALO[palo];
    }
}
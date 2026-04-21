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

    // Los símbolos de los rangos. Tener en cuenta que T es el 10.
    public static final String[] SIMB_RANGO = {
            "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"
    };

    /** Los símbolos de los palos.
     * d - diamantes
     * c - tréboles
     * h - corazones
     * s - picas */
    public static final char[] SIMB_PALO = {'d', 'c', 'h', 's'};

    public Carta(int rango, int palo) {
        if (rango < 0 || rango > NUM_DE_RANGOS - 1) {
            throw new IllegalArgumentException("Número inválido");
        }
        if (palo < 0 || palo > NUM_DE_PALOS - 1) {
            throw new IllegalArgumentException("Palo inválido");
        }
        this.rango = rango;
        this.palo = palo;
    }

    public Carta(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String nulo o longitud inválida");
        }
        s = s.trim();
        if (s.length() != 2) {
            throw new IllegalArgumentException("String vacío o longitud inválida");
        }

        // Parsea el caracter del rango.
        String simb_rango = s.substring(0, 1);
        char simb_palo = s.charAt(1);
        int rango = -1;
        for (int i = 0; i < Carta.NUM_DE_RANGOS; i++) {
            if (simb_rango.equals(SIMB_RANGO[i])) {
                rango = i;
                break;
            }
        }
        if (rango == -1) {
            throw new IllegalArgumentException("Rango desconocido: " + simb_rango);
        }
        // Parse the suit character.
        int palo = -1;
        for (int i = 0; i < Carta.NUM_DE_PALOS; i++) {
            if (simb_palo == SIMB_PALO[i]) {
                palo = i;
                break;
            }
        }
        if (palo == -1) {
            throw new IllegalArgumentException("Palo desconocido: " + simb_palo);
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

    public int compareTo(Carta carta) {
        int thisValue = hashCode();
        int otherValue = carta.hashCode();
        if (thisValue < otherValue) {
            return -1;
        } else if (thisValue > otherValue) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return SIMB_RANGO[rango] + SIMB_PALO[palo];
    }
}
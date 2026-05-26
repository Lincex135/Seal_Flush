package objetos;

/**
 * Representa una carta de una baraja estándar de 52 cartas (4 palos × 13 rangos).
 * Cada carta es inmutable en cuanto a su rango y palo, aunque puede cambiar
 * su estado de visibilidad (vuelta). Los rangos y palos se representan
 * como enteros definidos como constantes.
 *  @author Ximena López
 *  @author Adrián de Armas
 *  @version 1.0
 */

public class Carta {

    /** Rango de la carta (0–12). Inmutable tras la construcción. */
    private final int rango;

    /** Palo de la carta (0–3). Inmutable tras la construcción. */
    private final int palo;

    /** Indica si la carta está visible (false -> boca arriba). */
    private boolean vuelta = false;

    /** Número total de rangos en la baraja. */
    public static final int NUM_DE_RANGOS = 13;

    /** Número total de palos en la baraja. */
    public static final int NUM_DE_PALOS = 4;

    /** Constantes de rango (índices 0–12). */
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

    /** Constantes de palo (índices 0–3). */
    public static final int PICAS = 3;
    public static final int CORAZONES = 2;
    public static final int TREBOLES = 1;
    public static final int DIAMANTES = 0;


    /**
     * Símbolos de rango indexados de 0 (Dos) a 12 (As).
     * Usados en toString() para representar la carta.
     */
    public static final String[] SIMB_RANGO = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    };

    /**
     * Símbolos de palo indexados de 0 a 3:
     * 'd' — Diamantes
     * 'c' — Tréboles
     * 'h' — Corazones
     * 's' — Picas
     */
    public static final char[] SIMB_PALO = {'d', 'c', 'h', 's'};

    /**
     * CONSTRUCTOR
     * Crea una carta con el rango y palo indicados, inicialmente boca abajo.
     *
     * @param rango rango de la carta; debe estar en el rango 0, NUM_DE_RANGOS - 1
     * @param palo  palo de la carta; debe estar en el rango 0, NUM_DE_PALOS - 1
     * @throws IllegalArgumentException si rango o palo están fuera de rango
     */
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

    /**
     * Devuelve el nombre completo del palo en mayúsculas.
     *
     * @return "DIAMANTES", "TRÉBOLES", "CORAZONES" o "PICAS" según corresponda;
     * cadena vacía si el valor es inesperado
     */
    public String getPaloString() {
        return switch (this.palo) {
            case 0 -> "DIAMANTES";
            case 1 -> "TRÉBOLES";
            case 2 -> "CORAZONES";
            case 3 -> "PICAS";
            default -> "";
        };
    }

    /** @return valor entre 0 (DIAMANTES) y 3 (PICAS) */
    public int getPalo() {
        return this.palo;
    }

    /** @return valor entre 0 (DOS) y 12 (AS) */
    public int getRango() {
        return rango;
    }

    /** @return true si la carta está boca abajo; false si está boca arriba */
    public boolean isVuelta() {
        return vuelta;
    }

    /** @param vuelta false para poner la carta boca arriba; true para ponerla boca abajo */
    public void setVuelta(boolean vuelta) {
        this.vuelta = vuelta;
    }

    /**
     * Devuelve la representación compacta de la carta combinando símbolo de rango y símbolo de palo
     *
     * @return cadena con el formato SIMB_RANGO[rango] + SIMB_PALO[palo]
     */
    @Override
    public String toString() {
        return SIMB_RANGO[rango] + SIMB_PALO[palo];
    }
}
package util;

/**
 * Clase con atributos Estaticos que muestran las instrucciones del juego
 *
 * @author Ximena López
 * @author Adrián de Armas
 * @version 1.0
 */
public class Instrucciones {

    public Instrucciones() {
    }
    // -------------------------------------------------------------------------
    // OBJETIVO DEL JUEGO
    // -------------------------------------------------------------------------

    public static final String OBJETIVO =
            "El objetivo del Texas Hold'em es ganar el bote (pot), que es la suma " +
                    "de todas las apuestas realizadas en una mano. Para ello, debes formar " +
                    "la mejor combinación de 5 cartas posible usando tus 2 cartas privadas " +
                    "(hole cards) y las 5 cartas comunitarias de la mesa.";

    // -------------------------------------------------------------------------
    // ESTRUCTURA DE UNA MANO
    // -------------------------------------------------------------------------

    public static final String ESTRUCTURA_DE_UNA_MANO =
            "Una mano de Texas Hold'em se divide en cuatro fases:\n" +
                    "  1. Pre-Flop:  Se reparten 2 cartas privadas a cada jugador. " +
                    "Comienza la primera ronda de apuestas.\n" +
                    "  2. Flop:      Se revelan 3 cartas comunitarias boca arriba en la mesa. " +
                    "Segunda ronda de apuestas.\n" +
                    "  3. Turn:      Se revela una cuarta carta comunitaria. " +
                    "Tercera ronda de apuestas.\n" +
                    "  4. River:     Se revela la quinta y última carta comunitaria. " +
                    "Cuarta y última ronda de apuestas.\n" +
                    "Si queda más de un jugador tras el river, se produce el Showdown: " +
                    "los jugadores muestran sus cartas y gana el que tenga la mejor mano.";

    // -------------------------------------------------------------------------
    // LAS CIEGAS (BLINDS)
    // -------------------------------------------------------------------------

    public static final String CIEGAS =
            "Antes de repartir las cartas, dos jugadores deben poner apuestas " +
                    "obligatorias llamadas ciegas (blinds):\n" +
                    "  - Small Blind (SB): el jugador a la izquierda del dealer pone " +
                    "la mitad de la apuesta mínima.\n" +
                    "  - Big Blind (BB):   el siguiente jugador pone la apuesta mínima completa.\n" +
                    "Las ciegas rotan una posición a la izquierda cada mano, de modo que " +
                    "todos los jugadores contribuyen por igual a lo largo del tiempo.";

    // -------------------------------------------------------------------------
    // ACCIONES DISPONIBLES
    // -------------------------------------------------------------------------

    public static final String ACCIONES =
            "En cada ronda de apuestas, cuando es tu turno puedes realizar una " +
                    "de las siguientes acciones:\n" +
                    "  - Check:  Pasar sin apostar (solo posible si nadie ha apostado antes).\n" +
                    "  - Call:   Igualar la apuesta actual de otro jugador.\n" +
                    "  - Bet:    Realizar la primera apuesta de la ronda.\n" +
                    "  - Raise:  Subir la apuesta actual de otro jugador.\n" +
                    "  - Fold:   Retirarse de la mano y perder las apuestas ya realizadas.\n" +
                    "  - All-In: Apostar todas tus fichas. Si ganas con menos fichas que " +
                    "otro jugador, solo puedes ganar el bote proporcional a tu apuesta.";

    // -------------------------------------------------------------------------
    // JERARQUÍA DE MANOS
    // -------------------------------------------------------------------------

    public static final String JERARQUIA_DE_MANOS =
            "Las manos se ordenan de mayor a menor valor:\n" +
                    "  1. Royal Flush:        A-K-Q-J-10 del mismo palo. La mano más alta posible.\n" +
                    "  2. Straight Flush:     Cinco cartas consecutivas del mismo palo.\n" +
                    "  3. Four of a Kind:     Cuatro cartas del mismo valor (poker).\n" +
                    "  4. Full House:         Tres cartas del mismo valor + un par.\n" +
                    "  5. Flush:              Cinco cartas del mismo palo, no consecutivas.\n" +
                    "  6. Straight:           Cinco cartas consecutivas de distintos palos.\n" +
                    "  7. Three of a Kind:    Tres cartas del mismo valor.\n" +
                    "  8. Two Pair:           Dos pares distintos.\n" +
                    "  9. One Pair:           Dos cartas del mismo valor.\n" +
                    " 10. High Card:          Ninguna combinación. Gana la carta más alta.";

    // -------------------------------------------------------------------------
    // DESEMPATES
    // -------------------------------------------------------------------------

    public static final String DESEMPATES =
            "Cuando dos jugadores tienen el mismo tipo de mano, se aplican estas reglas:\n" +
                    "  - Se comparan los valores de las cartas de mayor a menor.\n" +
                    "  - Si dos manos son completamente idénticas, el bote se divide " +
                    "en partes iguales (split pot).\n" +
                    "  - En escaleras y flushes, el As puede actuar como carta alta (A-K-Q-J-10) " +
                    "o como carta baja (A-2-3-4-5, la escalera más baja posible).\n" +
                    "  - El palo de las cartas nunca se usa como desempate en Texas Hold'em.";

    // -------------------------------------------------------------------------
    // VARIANTES DEL JUEGO
    // -------------------------------------------------------------------------

    public static final String VARIANTES =
            "Este juego soporta dos variantes principales:\n" +
                    "  - Fixed-Limit: Las apuestas y subidas tienen un importe fijo " +
                    "predeterminado. Solo se permiten un máximo de 4 subidas por ronda.\n" +
                    "  - No-Limit:    Puedes apostar cualquier cantidad, hasta la totalidad " +
                    "de tus fichas (All-In), en cualquier momento.";

    // -------------------------------------------------------------------------
    // POSICIONES EN LA MESA
    // -------------------------------------------------------------------------

    public static final String POSICIONES =
            "La posición en la mesa es muy importante en el poker:\n" +
                    "  - Dealer (Button): Actúa el último en todas las rondas post-flop. " +
                    "Es la posición más ventajosa.\n" +
                    "  - Small Blind:     Actúa el penúltimo post-flop, pero primero pre-flop " +
                    "tras los blinds.\n" +
                    "  - Big Blind:       Tiene la opción de subir pre-flop incluso si nadie " +
                    "más ha subido (opción).\n" +
                    "  - Early position:  Actúa de los primeros. Requiere manos más fuertes.\n" +
                    "  - Late position:   Actúa de los últimos. Mayor información disponible " +
                    "antes de decidir.";

    // -------------------------------------------------------------------------
    // RESUMEN RÁPIDO
    // -------------------------------------------------------------------------

    public static final String RESUMEN =
            "Texas Hold'em en 5 pasos:\n" +
                    "  1. Cada jugador recibe 2 cartas privadas.\n" +
                    "  2. Se apuesta (Pre-Flop).\n" +
                    "  3. Se revelan 3 cartas en la mesa y se apuesta (Flop).\n" +
                    "  4. Se revela 1 carta más y se apuesta (Turn).\n" +
                    "  5. Se revela la última carta y se apuesta (River). " +
                    "Si hay empate, el mejor jugador gana el bote.";

    @Override
    public String toString() {
        return OBJETIVO + "\n \n" +
                ESTRUCTURA_DE_UNA_MANO + " \n \n" +
                CIEGAS + "\n \n" +
                ACCIONES + "\n \n" +
                JERARQUIA_DE_MANOS + "\n \n" +
                DESEMPATES + "\n \n" +
                VARIANTES + "\n \n" +
                POSICIONES + "\n \n" +
                RESUMEN;
    }
}
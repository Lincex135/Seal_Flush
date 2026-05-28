package util;

public class Instrucciones {

    public Instrucciones() {
    }

    public static final String OBJETIVO =
            "El objetivo de Seal Flush es ganar el bote, que es la suma de todas " +
                    "las apuestas realizadas en una mano. Para ello debes formar la mejor " +
                    "combinación de 5 cartas posible usando tus 2 cartas privadas y las 5 cartas " +
                    "comunitarias de la mesa.\n" +
                    "Seal Flush es una variante del Texas Hold'em con mecánicas especiales " +
                    "basadas en los flushes (color). Ganar o perder con un flush tiene " +
                    "consecuencias que se arrastran a la siguiente mano.";

    public static final String MODOS_DE_JUEGO =
            "Seal Flush ofrece dos modos de juego:\n\n" +
                    "  - Rondas limitadas: se juega un número fijo de rondas elegido al inicio.\n" +
                    "    Al terminar la última ronda, gana el jugador con más fichas.\n" +
                    "    Si hay empate de fichas, el bote se divide entre los empatados.\n\n" +
                    "  - Sin límite: se juega hasta que solo queda un jugador con fichas.\n" +
                    "    Los jugadores que se quedan a 0 fichas quedan eliminados.\n" +
                    "    Gana el último jugador en pie.";

    public static final String ESTRUCTURA_DE_UNA_MANO =
            "Una mano de Seal Flush se divide en cuatro fases:\n" +
                    "  1. Pre-Flop:  Se reparten 2 cartas privadas a cada jugador.\n" +
                    "                Se activan los eventos especiales de la ronda.\n" +
                    "                Comienza la primera ronda de apuestas.\n" +
                    "  2. Flop:      Se revelan 3 cartas comunitarias boca arriba en la mesa.\n" +
                    "                Segunda ronda de apuestas.\n" +
                    "  3. Turn:      Se revela una cuarta carta comunitaria.\n" +
                    "                Tercera ronda de apuestas.\n" +
                    "  4. River:     Se revela la quinta y última carta comunitaria.\n" +
                    "                Cuarta y última ronda de apuestas.\n\n" +
                    "Si queda más de un jugador tras el river, se produce el Showdown:\n" +
                    "los jugadores muestran sus cartas y gana el que tenga la mejor mano.";

    public static final String CIEGAS =
            "Antes de repartir las cartas, dos jugadores deben poner apuestas " +
                    "obligatorias llamadas ciegas (blinds):\n" +
                    "  - Ciega Pequeña: el jugador a la izquierda del dealer pone 5 fichas.\n" +
                    "  - Ciega Grande: el siguiente jugador pone 10 fichas.\n\n" +
                    "Las ciegas rotan una posición a la izquierda cada mano, de modo que " +
                    "todos los jugadores contribuyen por igual a lo largo del tiempo.\n" +
                    "Con 2 jugadores, el propio dealer paga la ciega pequeña.";

    public static final String ACCIONES =
            "En cada ronda de apuestas, cuando es tu turno puedes realizar una " +
                    "de las siguientes acciones:\n" +
                    "  - Pasar:  Pasar sin apostar (solo posible si nadie ha apostado antes).\n" +
                    "  - Igualar:   Igualar la apuesta actual de otro jugador.\n" +
                    "  - Subir:  Subir la apuesta actual.\n" +
                    "  - Retirarse:   Retirarse de la mano y perder las apuestas ya realizadas.\n";

    public static final String JERARQUIA_DE_MANOS =
            "Las manos se ordenan de mayor a menor valor:\n" +
                    "   1. Escalera Real:    A-K-Q-J-10 del mismo palo. La mano más alta posible.\n" +
                    "   2. Escalera Color:   Cinco cartas consecutivas del mismo palo.\n" +
                    "   3. Poker:            Cuatro cartas del mismo valor.\n" +
                    "   4. Full:             Tres cartas del mismo valor + un par.\n" +
                    "   5. Color:            Cinco cartas del mismo palo, no consecutivas.\n" +
                    "   6. Escalera:         Cinco cartas consecutivas de distintos palos.\n" +
                    "   7. Trío:             Tres cartas del mismo valor.\n" +
                    "   8. Doble Pareja:     Dos pares distintos.\n" +
                    "   9. Pareja:           Dos cartas del mismo valor.\n" +
                    "  10. Carta Alta:       Ninguna combinación. Gana la carta más alta.\n\n";

    public static final String DESEMPATES =
            "Cuando dos jugadores tienen el mismo tipo de mano, se aplican estas reglas:\n" +
                    "  - Se comparan los valores de las cartas de mayor a menor.\n" +
                    "  - Si dos manos son completamente idénticas, el bote se divide\n" +
                    "    en partes iguales (split pot).\n" +
                    "  - El As puede actuar como carta alta (A-K-Q-J-10) o como carta baja\n" +
                    "    (A-2-3-4-5, la escalera más baja posible).\n" +
                    "  - El palo de las cartas nunca se usa como desempate.";

    public static final String EVENTOS_ESPECIALES =
            "Seal Flush añade tres mecánicas exclusivas basadas en los flushes:\n\n" +
                    "     SELLO DORADO\n" +
                    "     Se activa cuando un jugador gana una mano con flush (color,\n" +
                    "     escalera de color o escalera real).\n" +
                    "     Efecto: en la siguiente mano que gane ese jugador, recibe un\n" +
                    "     bono adicional del 10% del bote ganado.\n" +
                    "     El sello se consume al ganar la siguiente mano, sea con flush o no.\n\n" +
                    "     SELLO OSCURO\n" +
                    "     Se activa cuando un jugador pierde una mano teniendo flush.\n" +
                    "     Efecto: en la siguiente ronda, ese jugador paga una penalización\n" +
                    "     del 10% de sus fichas actuales antes de que comience la mano.\n" +
                    "     El sello desaparece tras aplicarse la penalización.\n\n" +
                    "     PALO DOMINANTE\n" +
                    "     Al inicio de cada partida se revela aleatoriamente un palo dominante.\n" +
                    "     Efecto: si un jugador gana con flush de ese palo concreto, recibe\n" +
                    "     un 50% adicional del bote en lugar del bono normal.\n" +
                    "     Los flushes de otros palos ganan el bote sin modificación.";

    public static final String RESUMEN =
            "Seal Flush en 6 pasos:\n" +
                    "  1. Se elige modo de juego y número de jugadores.\n" +
                    "  2. Se revela el palo dominante de la partida.\n" +
                    "  3. Cada jugador recibe 2 cartas privadas y se apuesta (Pre-Flop).\n" +
                    "  4. Se revelan 3 cartas en la mesa y se apuesta (Flop).\n" +
                    "  5. Se revelan 2 cartas más, una a una, apostando tras cada una (Turn y River).\n" +
                    "  6. El mejor jugador gana el bote. Si tiene flush, puede activarse\n" +
                    "     el Sello Dorado o el Sello Oscuro para la siguiente mano.";

    @Override
    public String toString() {
        return OBJETIVO + "\n\n" +
                MODOS_DE_JUEGO + "\n\n" +
                ESTRUCTURA_DE_UNA_MANO + "\n\n" +
                CIEGAS + "\n\n" +
                ACCIONES + "\n\n" +
                JERARQUIA_DE_MANOS + "\n\n" +
                DESEMPATES + "\n\n" +
                EVENTOS_ESPECIALES + "\n\n" +
                RESUMEN;
    }
}

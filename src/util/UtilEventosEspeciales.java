package util;

import objetos.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase util para los eventos especiales
 *
 * @author Ximena López
 * @author Adrián de Armas
 * @version 1.0
 */
public class UtilEventosEspeciales {

    /**
     * Metodo que comprueba si el evento especial sello dorado está activo
     *
     * @param eventos objeto EventoEspecial
     * @param jugadoresGanadores lista de jugadores ganadores
     * @param jugadoresYTipoMano hashmap de jugadores y su tipo de mano
     */
    public static void comprobarSelloDorado(EventoEspecial eventos, ArrayList<Jugador> jugadoresGanadores, HashMap<Jugador, TipoMano> jugadoresYTipoMano) {
        for (Jugador jugadorActual : jugadoresGanadores) {
            if (jugadoresYTipoMano.containsKey(jugadorActual)) {
                if (esFlush(jugadoresYTipoMano.get(jugadorActual))) {
                    eventos.setSelloDorado(true);
                    jugadorActual.setTieneSelloDorado(true);
                }
            }
        }
    }

    /**
     * Metodo que comprueba si el evento especial sello oscuro está activo
     *
     * @param eventos objeto EventoEspecial
     * @param listaJugadores lista de jugadores
     * @param jugadoresYTipoMano hashmap de jugadores y su tipo de mano
     * @param jugadoresGanadores lista de jugadores ganadores
     */
    public static void comprobarSelloOscuro(EventoEspecial eventos, ArrayList<Jugador> listaJugadores, HashMap<Jugador, TipoMano> jugadoresYTipoMano, ArrayList<Jugador> jugadoresGanadores) {
        for (Jugador jugadorActual : listaJugadores) {
            if (jugadoresYTipoMano.containsKey(jugadorActual)) {
                if (esFlush(jugadoresYTipoMano.get(jugadorActual)) && !jugadoresGanadores.contains(jugadorActual)) {
                    eventos.setSelloOscuro(true);
                    jugadorActual.setTieneSelloOscuro(true);
                }
            }
        }
    }

    /**
     * Metodo que determina el valor del palo dominante
     *
     * @return devuelve un número aleatorio entre 0 y 3
     */
    public static int establecerPaloDominante() {
        int min = 0, max = 3;
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /**
     * Metodo estatico que determina si es flush o no
     *
     * @param tipoMano objeto TipoMano
     * @return devuelve true si es flush y false si no
     */
    public static boolean esFlush(TipoMano tipoMano) {
        return tipoMano == TipoMano.COLOR || tipoMano == TipoMano.ESCALERA_DE_COLOR || tipoMano == TipoMano.ESCALERA_REAL;
    }

    /**
     * Metodo estatico que determina si es flush dominate o no
     *
     * @param evaluacion objeto de tipo Evaluado mano
     * @param paloDominante numero del palo dominante
     * @return devuelve true si es flush dominante y false si no
     */
    public static boolean esFlushDominante(EvaluadorMano evaluacion, int paloDominante) {
        return esFlush(evaluacion.getTipo()) && evaluacion.getPaloDelColor() == paloDominante;
    }

    /**
     * Metodo que calcula el porcentaje extra que ganan o pierden los jugadores ganadores cuando están los diferentes tipos de eventoss especiales activos
     *
     * @param cantidad cantidad de fichas del bote
     * @param porcentaje cantidad de jugadores a repartir el bote
     * @return devuelve la cantidad de fichas extra que conseguirá el jugador ganador
     */
    public static int calcularPorcentaje(int cantidad, int porcentaje) {
        return cantidad * porcentaje / 100;
    }

    /**
     * Metodo que recibiendo el número del palo indicado devuelve el nombre de este
     *
     * @param palo numero del palo
     * @return devuelve el nombre del palo
     */
    public static String obtenerNombrePalo(int palo) {
        return switch (palo) {
            case 0 -> "DIAMANTES";
            case 1 -> "TREBOLES";
            case 2 -> "CORAZONES";
            case 3 -> "PICAS";
            default -> "DESCONOCIDO";
        };
    }
}

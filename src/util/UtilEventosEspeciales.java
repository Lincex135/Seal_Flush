package util;

import objetos.*;

import java.util.ArrayList;
import java.util.HashMap;

public class UtilEventosEspeciales {

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

    public static int establecerPaloDominante() {
        int min = 0, max = 3;
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static boolean esFlush(TipoMano tipoMano) {
        return tipoMano == TipoMano.COLOR || tipoMano == TipoMano.ESCALERA_DE_COLOR || tipoMano == TipoMano.ESCALERA_REAL;
    }

    public static boolean esFlushDominante(EvaluadorMano evaluacion, int paloDominante) {
        return esFlush(evaluacion.getTipo()) && evaluacion.getPaloDelColor() == paloDominante;
    }

    public static int calcularPorcentaje(int cantidad, int porcentaje) {
        return cantidad * porcentaje / 100;
    }

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

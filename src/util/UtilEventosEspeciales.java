package util;

import objetos.*;

import java.util.ArrayList;
import java.util.HashMap;

public class UtilEventosEspeciales {

    public static void comprobarSelloDorado(EventoEspecial eventos, ArrayList<Jugador> jugadoresGanadores, HashMap<Jugador,TipoMano> jugadoresYTipoMano) {
        for (Jugador jugadorActual : jugadoresGanadores) {
            if (jugadoresYTipoMano.containsKey(jugadorActual)){
                jugadoresYTipoMano.get(jugadorActual);
                if (jugadoresYTipoMano.get(jugadorActual).toString().contains("ESCALERA")){
                    eventos.setSelloDorado(true);
                    jugadorActual.setTieneSelloDorado(true);
                }
            }
        }
    }

    public static void comprobarSelloOscuro(EventoEspecial eventos, ArrayList<Jugador> listaJugadores, HashMap<Jugador,TipoMano> jugadoresYTipoMano, ArrayList<Jugador> jugadoresGanadores) {
        for (Jugador jugadorActual : listaJugadores) {
            if (jugadoresYTipoMano.containsKey(jugadorActual)){
                jugadoresYTipoMano.get(jugadorActual);
                if (jugadoresYTipoMano.get(jugadorActual).toString().contains("ESCALERA") && !jugadoresGanadores.contains(jugadorActual)){
                    eventos.setSelloOscuro(true);
                    jugadorActual.setTieneSelloOscuro(true);
                }
            }
        }
    }

    public static int establecerPaloDominante(){
        int min=0, max=3;
        int aleatorio = (int) (Math.random() * (max - min + 1)) + min;
        return aleatorio;
    }
}

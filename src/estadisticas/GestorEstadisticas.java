package estadisticas;

import util.Color;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestorEstadisticas {

    private static final Path RUTA_XML = Paths.get("../datos", "estadisticas.xml");

    public static void guardarPartida(EstadisticasPartida partidaNueva) {
        try {
            ArrayList<EstadisticasPartida> partidas = leerPartidas();
            partidaNueva.setId(partidas.size() + 1);
            partidas.add(partidaNueva);
            escribirXml(partidas);
            System.out.println(Color.GREEN + "Estadisticas guardadas en " + RUTA_XML + Color.RESET);
        } catch (IOException e) {
            System.out.println(Color.RED + "ERROR. No se han podido guardar las estadisticas." + Color.RESET);
        }
    }

    public static void mostrarEstadisticas() {
        try {
            ArrayList<EstadisticasPartida> partidas = leerPartidas();
            if (partidas.isEmpty()) {
                System.out.println(Color.YELLOW + "Todavia no hay estadisticas guardadas." + Color.RESET);
                System.out.println();
                return;
            }

            EstadisticasPartida boteMaximo = obtenerPartidaBoteMaximo(partidas);
            EstadisticasPartida masFichas = obtenerPartidaMasFichas(partidas);
            EstadisticasPartida masLarga = obtenerPartidaMasLarga(partidas);

            System.out.println(Color.CYAN + "---------- ESTADISTICAS HISTORICAS ----------" + Color.RESET);
            System.out.println("Partidas jugadas: " + Color.YELLOW + partidas.size() + Color.RESET);
            System.out.println("Bote maximo historico: " + Color.YELLOW + boteMaximo.getBoteMaximo() + Color.RESET
                    + " fichas (" + boteMaximo.getFechaHora() + ")");
            System.out.println("Jugador con mas fichas: " + Color.PINK + masFichas.getGanador() + Color.RESET
                    + " con " + Color.YELLOW + masFichas.getFichasGanador() + Color.RESET
                    + " fichas (" + masFichas.getFechaHora() + ")");
            System.out.println("Partida mas larga: " + Color.YELLOW + masLarga.getRondasJugadas() + Color.RESET
                    + " rondas, ganada por " + Color.PINK + masLarga.getGanador() + Color.RESET
                    + " (" + masLarga.getFechaHora() + ")");
            System.out.println();

            mostrarHallFama(partidas);
        } catch (IOException e) {
            System.out.println(Color.RED + "ERROR. No se han podido leer las estadisticas." + Color.RESET);
        }
    }

    private static ArrayList<EstadisticasPartida> leerPartidas() throws IOException {
        ArrayList<EstadisticasPartida> partidas = new ArrayList<>();

        if (!Files.exists(RUTA_XML)) {
            return partidas;
        }

        String xml = Files.readString(RUTA_XML, StandardCharsets.UTF_8);
        Pattern patronPartida = Pattern.compile("<partida id=\"(\\d+)\" fechaHora=\"([^\"]*)\">([\\s\\S]*?)</partida>");
        Matcher matcherPartida = patronPartida.matcher(xml);

        while (matcherPartida.find()) {
            int id = Integer.parseInt(matcherPartida.group(1));
            String fechaHora = desescaparXml(matcherPartida.group(2));
            String bloquePartida = matcherPartida.group(3);
            String ganador = obtenerTextoEtiqueta(bloquePartida, "ganador");
            int fichasGanador = obtenerEnteroEtiqueta(bloquePartida, "fichasGanador");
            int rondasJugadas = obtenerEnteroEtiqueta(bloquePartida, "rondasJugadas");
            int boteMaximo = obtenerEnteroEtiqueta(bloquePartida, "boteMaximo");
            int numJugadores = obtenerEnteroEtiqueta(bloquePartida, "numJugadores");
            ArrayList<EstadisticasJugador> jugadores = leerJugadores(bloquePartida);

            partidas.add(new EstadisticasPartida(id, fechaHora, ganador, fichasGanador, rondasJugadas, boteMaximo, numJugadores, jugadores));
        }

        return partidas;
    }

    private static ArrayList<EstadisticasJugador> leerJugadores(String bloquePartida) {
        ArrayList<EstadisticasJugador> jugadores = new ArrayList<>();
        Pattern patronJugador = Pattern.compile("<jugador nombre=\"([^\"]*)\" fichasFinales=\"(\\d+)\" estado=\"([^\"]*)\" />");
        Matcher matcherJugador = patronJugador.matcher(bloquePartida);

        while (matcherJugador.find()) {
            String nombre = desescaparXml(matcherJugador.group(1));
            int fichasFinales = Integer.parseInt(matcherJugador.group(2));
            String estado = desescaparXml(matcherJugador.group(3));
            jugadores.add(new EstadisticasJugador(nombre, fichasFinales, estado));
        }

        return jugadores;
    }

    private static void escribirXml(ArrayList<EstadisticasPartida> partidas) throws IOException {
        if (!Files.exists(RUTA_XML.getParent())) {
            Files.createDirectories(RUTA_XML.getParent());
        }

        StringBuilder xml = new StringBuilder();
        EstadisticasPartida boteMaximo = obtenerPartidaBoteMaximo(partidas);
        EstadisticasPartida masFichas = obtenerPartidaMasFichas(partidas);
        EstadisticasPartida masLarga = obtenerPartidaMasLarga(partidas);

        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xml.append("<estadisticas fechaActualizacion=\"").append(escaparXml(partidas.get(partidas.size() - 1).getFechaHora())).append("\">\n");
        xml.append("    <resumen>\n");
        xml.append("        <partidasJugadas>").append(partidas.size()).append("</partidasJugadas>\n");
        xml.append("        <boteMaximoHistorico valor=\"").append(boteMaximo.getBoteMaximo()).append("\" fechaHora=\"").append(escaparXml(boteMaximo.getFechaHora())).append("\" ganador=\"").append(escaparXml(boteMaximo.getGanador())).append("\" />\n");
        xml.append("        <jugadorConMasFichas nombre=\"").append(escaparXml(masFichas.getGanador())).append("\" fichas=\"").append(masFichas.getFichasGanador()).append("\" fechaHora=\"").append(escaparXml(masFichas.getFechaHora())).append("\" />\n");
        xml.append("        <partidaMasLarga rondas=\"").append(masLarga.getRondasJugadas()).append("\" fechaHora=\"").append(escaparXml(masLarga.getFechaHora())).append("\" ganador=\"").append(escaparXml(masLarga.getGanador())).append("\" />\n");
        xml.append("    </resumen>\n");
        escribirHallFama(xml, partidas);
        escribirPartidas(xml, partidas);
        xml.append("</estadisticas>\n");

        Files.writeString(RUTA_XML, xml.toString(), StandardCharsets.UTF_8);
    }

    private static void escribirHallFama(StringBuilder xml, ArrayList<EstadisticasPartida> partidas) {
        ArrayList<EstadisticasPartida> hallFama = ordenarPorFichas(partidas);

        xml.append("    <hallFama>\n");
        for (int i = 0; i < hallFama.size() && i < 5; i++) {
            EstadisticasPartida partida = hallFama.get(i);
            xml.append("        <entrada posicion=\"").append(i + 1)
                    .append("\" jugador=\"").append(escaparXml(partida.getGanador()))
                    .append("\" fichas=\"").append(partida.getFichasGanador())
                    .append("\" fechaHora=\"").append(escaparXml(partida.getFechaHora()))
                    .append("\" rondas=\"").append(partida.getRondasJugadas())
                    .append("\" />\n");
        }
        xml.append("    </hallFama>\n");
    }

    private static void escribirPartidas(StringBuilder xml, ArrayList<EstadisticasPartida> partidas) {
        xml.append("    <partidas>\n");
        for (EstadisticasPartida partida : partidas) {
            xml.append("        <partida id=\"").append(partida.getId()).append("\" fechaHora=\"").append(escaparXml(partida.getFechaHora())).append("\">\n");
            xml.append("            <ganador>").append(escaparXml(partida.getGanador())).append("</ganador>\n");
            xml.append("            <fichasGanador>").append(partida.getFichasGanador()).append("</fichasGanador>\n");
            xml.append("            <rondasJugadas>").append(partida.getRondasJugadas()).append("</rondasJugadas>\n");
            xml.append("            <boteMaximo>").append(partida.getBoteMaximo()).append("</boteMaximo>\n");
            xml.append("            <numJugadores>").append(partida.getNumJugadores()).append("</numJugadores>\n");
            xml.append("            <jugadores>\n");
            for (EstadisticasJugador jugador : partida.getJugadores()) {
                xml.append("                <jugador nombre=\"").append(escaparXml(jugador.getNombre()))
                        .append("\" fichasFinales=\"").append(jugador.getFichasFinales())
                        .append("\" estado=\"").append(escaparXml(jugador.getEstadoFinal()))
                        .append("\" />\n");
            }
            xml.append("            </jugadores>\n");
            xml.append("        </partida>\n");
        }
        xml.append("    </partidas>\n");
    }

    private static void mostrarHallFama(ArrayList<EstadisticasPartida> partidas) {
        ArrayList<EstadisticasPartida> hallFama = ordenarPorFichas(partidas);

        System.out.println(Color.CYAN + "---------- HALL DE LA FAMA ----------" + Color.RESET);
        for (int i = 0; i < hallFama.size() && i < 5; i++) {
            EstadisticasPartida partida = hallFama.get(i);
            System.out.println((i + 1) + ". " + Color.PINK + partida.getGanador() + Color.RESET
                    + " - " + Color.YELLOW + partida.getFichasGanador() + Color.RESET
                    + " fichas | " + partida.getRondasJugadas() + " rondas | " + partida.getFechaHora());
        }
        System.out.println();
    }

    private static ArrayList<EstadisticasPartida> ordenarPorFichas(ArrayList<EstadisticasPartida> partidas) {
        ArrayList<EstadisticasPartida> copia = new ArrayList<>(partidas);

        for (int vuelta = 0; vuelta < copia.size() - 1; vuelta++) {
            for (int posicion = 0; posicion < copia.size() - 1 - vuelta; posicion++) {
                if (copia.get(posicion).getFichasGanador() < copia.get(posicion + 1).getFichasGanador()) {
                    EstadisticasPartida temporal = copia.get(posicion);
                    copia.set(posicion, copia.get(posicion + 1));
                    copia.set(posicion + 1, temporal);
                }
            }
        }

        return copia;
    }

    private static EstadisticasPartida obtenerPartidaBoteMaximo(ArrayList<EstadisticasPartida> partidas) {
        EstadisticasPartida mejor = partidas.get(0);
        for (EstadisticasPartida partida : partidas) {
            if (partida.getBoteMaximo() > mejor.getBoteMaximo()) {
                mejor = partida;
            }
        }
        return mejor;
    }

    private static EstadisticasPartida obtenerPartidaMasFichas(ArrayList<EstadisticasPartida> partidas) {
        EstadisticasPartida mejor = partidas.get(0);
        for (EstadisticasPartida partida : partidas) {
            if (partida.getFichasGanador() > mejor.getFichasGanador()) {
                mejor = partida;
            }
        }
        return mejor;
    }

    private static EstadisticasPartida obtenerPartidaMasLarga(ArrayList<EstadisticasPartida> partidas) {
        EstadisticasPartida mejor = partidas.get(0);
        for (EstadisticasPartida partida : partidas) {
            if (partida.getRondasJugadas() > mejor.getRondasJugadas()) {
                mejor = partida;
            }
        }
        return mejor;
    }

    private static String obtenerTextoEtiqueta(String bloque, String etiqueta) {
        Pattern patron = Pattern.compile("<" + etiqueta + ">(.*?)</" + etiqueta + ">");
        Matcher matcher = patron.matcher(bloque);
        if (matcher.find()) {
            return desescaparXml(matcher.group(1));
        }
        return "";
    }

    private static int obtenerEnteroEtiqueta(String bloque, String etiqueta) {
        String texto = obtenerTextoEtiqueta(bloque, etiqueta);
        if (texto.equals("")) {
            return 0;
        }
        return Integer.parseInt(texto);
    }

    private static String escaparXml(String texto) {
        return texto.replace("&", "&amp;")
                .replace("\"", "&quot;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }

    private static String desescaparXml(String texto) {
        return texto.replace("&quot;", "\"")
                .replace("&lt;", "<")
                .replace("&gt;", ">")
                .replace("&amp;", "&");
    }
}

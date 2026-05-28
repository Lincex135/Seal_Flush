package estadisticas;

import util.Color;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Esta clase se encarga de leer y guardar los datos de las partidas en un archivo xml
 *
 * @author Ximena López
 * @author Adrián de Armas
 * @version 1.0
 */

public class GestorEstadisticas {

    private static final Path RUTA_XML = Paths.get("../datos", "estadisticas.xml");

    /**
     * Metodo para guardar la partida jugada en el archivo xml
     *
     * @param partidaNueva estadisticas de la nueva partida
     */
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

    /**
     * Metodo para mostrar en pantalla las estadisticas
     */
    public static void mostrarEstadisticas() {
        try {
            ArrayList<EstadisticasPartida> partidas = leerPartidas();

            if (partidas.isEmpty()) {
                System.out.println(Color.YELLOW + "Todavía no hay estadísticas guardadas." + Color.RESET);
                System.out.println();
                return;
            }

            EstadisticasPartida boteMaximo = obtenerPartidaBoteMaximo(partidas);
            EstadisticasPartida masFichas = obtenerPartidaMasFichas(partidas);
            EstadisticasPartida masLarga = obtenerPartidaMasLarga(partidas);

            System.out.println(Color.CYAN + "---------- ESTADÍSTICAS HISTÓRICAS ----------" + Color.RESET);
            System.out.println("Partidas jugadas: " + Color.YELLOW + partidas.size() + Color.RESET);

            System.out.println("Bote máximo histórico: "
                    + Color.YELLOW + boteMaximo.getBoteMaximo() + Color.RESET
                    + " fichas (" + boteMaximo.getFechaHora() + ")");

            System.out.println("Jugador con más fichas: "
                    + Color.PINK + masFichas.getGanador() + Color.RESET
                    + " con " + Color.YELLOW + masFichas.getFichasGanador() + Color.RESET
                    + " fichas (" + masFichas.getFechaHora() + ")");

            System.out.println("Partida más larga: "
                    + Color.YELLOW + masLarga.getRondasJugadas() + Color.RESET
                    + " rondas, ganada por "
                    + Color.PINK + masLarga.getGanador() + Color.RESET
                    + " (" + masLarga.getFechaHora() + ")");

            System.out.println();

            mostrarHallFama(partidas);

        } catch (IOException e) {
            System.out.println(Color.RED + "ERROR. No se han podido leer las estadísticas." + Color.RESET);
        }
    }

    /**
     * Metodo para leer las estadisticas de la partida del documento xml
     *
     * @return devuelve un ArrayList de EstadisticasPartida
     * @throws IOException
     */
    private static ArrayList<EstadisticasPartida> leerPartidas() throws IOException {

        ArrayList<EstadisticasPartida> partidas = new ArrayList<>();

        if (!Files.exists(RUTA_XML)) {
            return partidas;
        }

        String xml = Files.readString(RUTA_XML);

        String bloquePartidas = obtenerBloqueEtiqueta(xml, "partidas");

        int posicion = 0;

        while (bloquePartidas.indexOf("<partida ", posicion) != -1) {

            int inicioPartida = bloquePartidas.indexOf("<partida ", posicion);
            int finCabecera = bloquePartidas.indexOf(">", inicioPartida);
            int finPartida = bloquePartidas.indexOf("</partida>", finCabecera);

            String cabeceraPartida = bloquePartidas.substring(inicioPartida, finCabecera + 1);
            String bloquePartida = bloquePartidas.substring(finCabecera + 1, finPartida);

            int id = Integer.parseInt(obtenerAtributo(cabeceraPartida, "id"));

            String fechaHora = obtenerAtributo(cabeceraPartida, "fechaHora");

            String ganador = obtenerTextoEtiqueta(bloquePartida, "ganador");

            int fichasGanador = obtenerEnteroEtiqueta(bloquePartida, "fichasGanador");

            int rondasJugadas = obtenerEnteroEtiqueta(bloquePartida, "rondasJugadas");

            int boteMaximo = obtenerEnteroEtiqueta(bloquePartida, "boteMaximo");

            int numJugadores = obtenerEnteroEtiqueta(bloquePartida, "numJugadores");

            ArrayList<EstadisticasJugador> jugadores = leerJugadores(bloquePartida);

            partidas.add(new EstadisticasPartida(id, fechaHora, ganador, fichasGanador, rondasJugadas, boteMaximo, numJugadores, jugadores));

            posicion = finPartida + "</partida>".length();
        }

        return partidas;
    }

    /**
     * Metodo que lee del xml las estadisticas de los jugadores y las guarda en un ArrayList
     *
     * @param bloquePartida es la etiqueta partida
     * @return devuelve un ArrayList de EstadisticasJugador
     */
    private static ArrayList<EstadisticasJugador> leerJugadores(String bloquePartida) {

        ArrayList<EstadisticasJugador> jugadores = new ArrayList<>();
        String bloqueJugadores = obtenerBloqueEtiqueta(bloquePartida, "jugadores");
        String[] lineas = bloqueJugadores.split("\n");
        for (String linea : lineas) {
            linea = linea.trim();

            if (linea.startsWith("<jugador ")) {
                String nombre = obtenerAtributo(linea, "nombre")                ;

                int fichasFinales = Integer.parseInt(obtenerAtributo(linea, "fichasFinales"));

                String estado = obtenerAtributo(linea, "estado");

                jugadores.add(new EstadisticasJugador(nombre, fichasFinales, estado));
            }
        }

        return jugadores;
    }

    /**
     * Metodo para escribir los datos de la partida en el XML
     *
     * @param partidas ArrayList de EstadisticasPartida
     * @throws IOException
     */
    private static void escribirXml(ArrayList<EstadisticasPartida> partidas) throws IOException {

        if (!Files.exists(RUTA_XML.getParent())) {
            Files.createDirectories(RUTA_XML.getParent());
        }

        StringBuilder xml = new StringBuilder();

        EstadisticasPartida boteMaximo = obtenerPartidaBoteMaximo(partidas);
        EstadisticasPartida masFichas = obtenerPartidaMasFichas(partidas);
        EstadisticasPartida masLarga = obtenerPartidaMasLarga(partidas);

        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

        xml.append("<estadisticas fechaActualizacion=\"")
                .append(partidas.get(partidas.size() - 1).getFechaHora())
                .append("\">\n");

        xml.append("    <resumen>\n");

        xml.append("        <partidasJugadas>")
                .append(partidas.size())
                .append("</partidasJugadas>\n");

        xml.append("        <boteMaximoHistorico valor=\"")
                .append(boteMaximo.getBoteMaximo())
                .append("\" fechaHora=\"")
                .append(boteMaximo.getFechaHora())
                .append("\" ganador=\"")
                .append(boteMaximo.getGanador())
                .append("\" />\n");

        xml.append("        <jugadorConMasFichas nombre=\"")
                .append(masFichas.getGanador())
                .append("\" fichas=\"")
                .append(masFichas.getFichasGanador())
                .append("\" fechaHora=\"")
                .append(masFichas.getFechaHora())
                .append("\" />\n");

        xml.append("        <partidaMasLarga rondas=\"")
                .append(masLarga.getRondasJugadas())
                .append("\" fechaHora=\"")
                .append(masLarga.getFechaHora())
                .append("\" ganador=\"")
                .append(masLarga.getGanador())
                .append("\" />\n");

        xml.append("    </resumen>\n");

        escribirHallFama(xml, partidas);
        escribirPartidas(xml, partidas);

        xml.append("</estadisticas>\n");

        Files.writeString(RUTA_XML, xml.toString());
    }

    /**
     * Metodo para escribir los datos del Hall de la fama en el xml
     *
     * @param xml StringBuilder
     * @param partidas ArrayList de EstadisticasPartidas
     */
    private static void escribirHallFama(StringBuilder xml, ArrayList<EstadisticasPartida> partidas) {
        ArrayList<EstadisticasPartida> hallFama = ordenarPorFichas(partidas);

        xml.append("    <hallFama>\n");
        for (int i = 0; i < hallFama.size() && i < 5; i++) {
            EstadisticasPartida partida = hallFama.get(i);
            xml.append("        <entrada posicion=\"").append(i + 1)
                    .append("\" jugador=\"").append(partida.getGanador())
                    .append("\" fichas=\"").append(partida.getFichasGanador())
                    .append("\" fechaHora=\"").append(partida.getFechaHora())
                    .append("\" rondas=\"").append(partida.getRondasJugadas())
                    .append("\" />\n");
        }
        xml.append("    </hallFama>\n");
    }

    /**
     * Metodo para escribir los datos de las partidas en el xml
     *
     * @param xml StringBuilder
     * @param partidas ArrayList de EstadisticasPartidas
     */
    private static void escribirPartidas(StringBuilder xml, ArrayList<EstadisticasPartida> partidas) {
        xml.append("    <partidas>\n");
        for (EstadisticasPartida partida : partidas) {
            xml.append("        <partida id=\"").append(partida.getId()).append("\" fechaHora=\"").append(partida.getFechaHora()).append("\">\n");
            xml.append("            <ganador>").append(partida.getGanador()).append("</ganador>\n");
            xml.append("            <fichasGanador>").append(partida.getFichasGanador()).append("</fichasGanador>\n");
            xml.append("            <rondasJugadas>").append(partida.getRondasJugadas()).append("</rondasJugadas>\n");
            xml.append("            <boteMaximo>").append(partida.getBoteMaximo()).append("</boteMaximo>\n");
            xml.append("            <numJugadores>").append(partida.getNumJugadores()).append("</numJugadores>\n");
            xml.append("            <jugadores>\n");
            for (EstadisticasJugador jugador : partida.getJugadores()) {
                xml.append("                <jugador nombre=\"").append(jugador.getNombre())
                        .append("\" fichasFinales=\"").append(jugador.getFichasFinales())
                        .append("\" estado=\"").append(jugador.getEstadoFinal())
                        .append("\" />\n");
            }
            xml.append("            </jugadores>\n");
            xml.append("        </partida>\n");
        }
        xml.append("    </partidas>\n");
    }

    /**
     * Metodo para mostrar el hall de la fama
     *
     * @param partidas ArrayList de EstadisticasPartida
     */
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

    /**
     * Metodo para ordenar los jugadores por cantidad de fichas
     *
     * @param partidas ArrayList de EstadisticasPartida
     * @return devuelve un ArrayList de EstadisticasPartida
     */
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

    /**
     * Metodo para obtener el bote maximo de todas las partidas
     *
     * @param partidas ArrayList de EstadisticasPartida
     * @return devuelve EstadisticasPartida
     */
    private static EstadisticasPartida obtenerPartidaBoteMaximo(ArrayList<EstadisticasPartida> partidas) {
        EstadisticasPartida mejor = partidas.get(0);
        for (EstadisticasPartida partida : partidas) {
            if (partida.getBoteMaximo() > mejor.getBoteMaximo()) {
                mejor = partida;
            }
        }
        return mejor;
    }

    /**
     * Metodo para obtener las fichas finales del jugador con mayor número de estas
     *
     * @param partidas ArrayList de EstadisticasPartida
     * @return devuelve EstadisticasPartida
     */
    private static EstadisticasPartida obtenerPartidaMasFichas(ArrayList<EstadisticasPartida> partidas) {
        EstadisticasPartida mejor = partidas.get(0);
        for (EstadisticasPartida partida : partidas) {
            if (partida.getFichasGanador() > mejor.getFichasGanador()) {
                mejor = partida;
            }
        }
        return mejor;
    }

    /**
     * Metodo para obtener la duración de la partida más larga
     *
     * @param partidas ArrayList de EstadisticasPartida
     * @return devuelve EstadisticasPartida
     */
    private static EstadisticasPartida obtenerPartidaMasLarga(ArrayList<EstadisticasPartida> partidas) {
        EstadisticasPartida mejor = partidas.get(0);
        for (EstadisticasPartida partida : partidas) {
            if (partida.getRondasJugadas() > mejor.getRondasJugadas()) {
                mejor = partida;
            }
        }
        return mejor;
    }

    /**
     * Metodo para obtener el contenido de una etiqueta del xml
     *
     * @param bloque String
     * @param etiqueta String
     * @return devuelve un String
     */
    private static String obtenerTextoEtiqueta(String bloque, String etiqueta) {
        return obtenerBloqueEtiqueta(bloque, etiqueta);
    }

    /**
     * Metodo para obtener un bloque del xml
     *
     * @param bloque String
     * @param etiqueta String
     * @return devuelve un String
     */
    private static String obtenerBloqueEtiqueta(String bloque, String etiqueta) {
        String inicioEtiqueta = "<" + etiqueta + ">";
        String finEtiqueta = "</" + etiqueta + ">";
        int inicio = bloque.indexOf(inicioEtiqueta);
        int fin = bloque.indexOf(finEtiqueta);

        if (inicio != -1 && fin != -1) {
            inicio = inicio + inicioEtiqueta.length();
            return bloque.substring(inicio, fin);
        }
        return "";
    }

    /**
     * Metodo para obtener un atributo del xml
     *
     * @param linea String
     * @param atributo String
     * @return devuelve un String
     */
    private static String obtenerAtributo(String linea, String atributo) {
        String textoBuscado = atributo + "=\"";
        int inicio = linea.indexOf(textoBuscado);

        if (inicio == -1) {
            return "";
        }

        inicio = inicio + textoBuscado.length();
        int fin = linea.indexOf("\"", inicio);
        return linea.substring(inicio, fin);
    }

    /**
     * Metodo para obtener un número de Etiqueta del xml
     *
     * @param bloque String
     * @param etiqueta String
     * @return devuelve un String
     */
    private static int obtenerEnteroEtiqueta(String bloque, String etiqueta) {
        String texto = obtenerTextoEtiqueta(bloque, etiqueta);
        if (texto.equals("")) {
            return 0;
        }
        return Integer.parseInt(texto);
    }
}
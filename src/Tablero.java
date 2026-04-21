import java.util.ArrayList;


public class Tablero {
    private Carta[] cartas;
    private ArrayList<Jugador> jugadores;
    private String[] tablero = {
            Color.BROWN_BG + " ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ " + Color.RESET + "\n",
            Color.BROWN_BG + " |                                                                                                                                                        | " + Color.RESET + "\n",
            Color.BROWN_BG + " |    ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐    | " + Color.RESET + "\n",
            Color.BROWN_BG + " |    | " + Color.DARK_GREEN_BG + "                                                                                                                                            " + Color.BROWN_BG + " |    | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " |    | " + Color.DARK_GREEN_BG + "                                                                                                                                            " + Color.BROWN_BG + " |    | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " |    | " + Color.DARK_GREEN_BG + "                                                                                                                                            " + Color.BROWN_BG + " |    | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " |    | " + Color.DARK_GREEN_BG + "                                                                                                                                            " + Color.BROWN_BG + " |    | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " |    | " + Color.DARK_GREEN_BG + "                                                                                                                                            " + Color.BROWN_BG + " |    | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " |    | " + Color.DARK_GREEN_BG + "                                                                                                                                            " + Color.BROWN_BG + " |    | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " |    | " + Color.DARK_GREEN_BG + "                                                                                                                                            " + Color.BROWN_BG + " |    | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " |    | " + Color.DARK_GREEN_BG + "                                                                                                                                            " + Color.BROWN_BG + " |    | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " |    | " + Color.DARK_GREEN_BG + "                                                                                                                                            " + Color.BROWN_BG + " |    | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " |    | " + Color.DARK_GREEN_BG + "                                                                                                                                            " + Color.BROWN_BG + " |    | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " |    | " + Color.DARK_GREEN_BG + "                                                                                                                                            " + Color.BROWN_BG + " |    | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " |    | " + Color.DARK_GREEN_BG + "                                                                                                                                            " + Color.BROWN_BG + " |    | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " |    └──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘    | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " |                                                                                                                                                        | " + Color.RESET + "\n" ,
            Color.BROWN_BG + " └────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ " + Color.RESET + "\n"
    };


    public Tablero(Carta[] cartas, ArrayList<Jugador> jugadores) {
        this.cartas = cartas;
        this.jugadores = jugadores;
        this.tablero = tablero;
    }


    public Tablero() {
    }


}

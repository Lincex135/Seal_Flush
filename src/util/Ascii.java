package util;

/**
 *  Clase que tiene atributos estaticos de tipo String y String[] para los menús
 *
 *  @author Ximena López
 *  @author Adrián de Armas
 *  @version 1.0
 */
public class Ascii {
    public static final String[] MENU = {
            Color.PINK + "╔══════════════════════════════╗" + Color.RESET,
            Color.PINK + "║      S E A L  F L U S H      ║" + Color.RESET,
            Color.PINK + "║                              ║" + Color.RESET,
            Color.PINK + "║    - by Ximena & Adrián -    ║" + Color.RESET,
            Color.PINK + "╚══════════════════════════════╝" + Color.RESET
    };

    public static final String[] FOCA = {
            Color.GRAY + "               ..-=++=-.                                 " + Color.RESET,
            Color.GRAY + "          ..-+-.       ..=+:..                           " + Color.RESET,
            Color.GRAY + "         .=-.              .-=.                          " + Color.RESET,
            Color.GRAY + "       .-=.                  .--                         " + Color.RESET,
            Color.GRAY + "      .--    .          ....   :-.                       " + Color.RESET,
            Color.GRAY + "      :-. ....         ....     -.                       " + Color.RESET,
            Color.GRAY + "     .--..-%%++.       :+*@#.   :=.                      " + Color.RESET,
            Color.GRAY + "     .-:..-@@@+..=**-. :%@@%.   :=.                      " + Color.RESET,
            Color.GRAY + "     .-.....:...=@@@%:...::.... :=. .....                " + Color.RESET,
            Color.GRAY + "     .-:...:-#=-..==..=++-:..:. :-. .-..--:.   .-----.   " + Color.RESET,
            Color.GRAY + "     .-:-:..--===+:-===--:.:-. .+.  .=.  .--.:=:.  .=.   " + Color.RESET,
            Color.GRAY + "      .-:....     ..     ..  ..#.   .:..   =+:    .::.   " + Color.RESET,
            Color.GRAY + "        .==:.              .:=-     .:-.   ::    .:-.    " + Color.RESET,
            Color.GRAY + "        .=.      . ...     ...=.      .:-=-..:::=-:.     " + Color.RESET,
            Color.GRAY + "        -.                    .*..   .. :=...+...        " + Color.RESET,
            Color.GRAY + "       .+.                      .::--:..    :-           " + Color.RESET,
            Color.GRAY + "       .=                                  :-.           " + Color.RESET,
            Color.GRAY + "       .=.                               .--.            " + Color.RESET,
            Color.GRAY + "      .=.             ...  .::.         .-:              " + Color.RESET,
            Color.GRAY + "     .-:...           .+.  ..-.       .:=.               " + Color.RESET,
            Color.GRAY + " ..--:.               .-     .=:     .-:                 " + Color.RESET,
            Color.GRAY + ".--.      .-+:        .=      ..-+-.=:..                 " + Color.RESET,
            Color.GRAY + " .:=+===+=:.  .==-:....-:.     ....+.                    " + Color.RESET,
            Color.GRAY + "                       .:---:...:--:.                    " + Color.RESET,
            Color.GRAY + "                          ...::...                       " + Color.RESET
    };
    public static final String[] CARTAS = {
            Color.PURPLE + "                  ..:....:.                       " + Color.RESET,
            Color.PURPLE + "               .::+::---=+*#++=-::.               " + Color.RESET,
            Color.PURPLE + "             .=+.=:       #.   .**:..-**.         " + Color.RESET,
            Color.PURPLE + "            :#+*=+-     .+:        -+=--=         " + Color.RESET,
            Color.PURPLE + "        .:+=-.. .=:    .-=.           .-=+-.      " + Color.RESET,
            Color.PURPLE + "      .%:...    :=.    .*.               ..:**.   " + Color.RESET,
            Color.PURPLE + "      :+        -+    .%.                     :+  " + Color.RESET,
            Color.PURPLE + "     .+=+       -=   .*.       ..-+.          *:  " + Color.RESET,
            Color.PURPLE + "    -+..-=      =.  .+:    ..+%@@@@-         *:   " + Color.RESET,
            Color.PURPLE + "  :*.   .=-.   .#  .=-  .:#@@@@@@@@%:      .=-    " + Color.RESET,
            Color.PURPLE + "  =-     .*.   :+  =-  .*@@@@@@@@@@@*.     :=.    " + Color.RESET,
            Color.PURPLE + "  ..#:.   .%.  +: -=.  =@@@@@@@@@@@@%-    .*.     " + Color.RESET,
            Color.PURPLE + "    .:+-.  .*..%.-=    -@@@@@@@@@@@@@-   .#.      " + Color.RESET,
            Color.PURPLE + "      .:+-. :=:#:=.    .-**=*@%@@@@@%:  .+.       " + Color.RESET,
            Color.PURPLE + "         .#:.=*-*.         %@+.@@@@@=. .=:        " + Color.RESET,
            Color.PURPLE + "           .+-##.       .=@@@=..=+:.   =-.        " + Color.RESET,
            Color.PURPLE + "            .:#.          .:=:        =#:         " + Color.RESET,
            Color.PURPLE + "             :#+                     ==.          " + Color.RESET,
            Color.PURPLE + "             .+==##-:.             .-=            " + Color.RESET,
            Color.PURPLE + "                 :*.:=++:.        ::+.            " + Color.RESET,
            Color.PURPLE + "                  .%   .-%%=.   +. #.             " + Color.RESET,
            Color.PURPLE + "                   .*++:-=-==++-::#.              " + Color.RESET,
            Color.PURPLE + "                     ==-++--.::.#:                " + Color.RESET,
            Color.PURPLE + "                         =+=-:#                   " + Color.RESET,
            Color.PURPLE + "                           :.:                    " + Color.RESET
    };
    public static final String MENU1 =
            "═══════════════════════════════════════════════════════════════════\n" +
                    "  [ 1 ]  Empezar Partida     [ 2 ]  Estadísticas     [ 0 ]  Salir\n" +
                    "═══════════════════════════════════════════════════════════════════\n" +
                    " > Elige una opción: ";

    public static final String MENU2 =
            "          ════════════════════════════════════════════════════════════════════════════════════\n" +
                    "            [ 1 ] Número limitado de rondas     [ 2 ] Sin limite de rondas     [ 0 ]  Volver\n" +
                    "          ════════════════════════════════════════════════════════════════════════════════════\n" +
                    "           > Elige una opción: ";

    public static final String MENU3 =
            "                    ═════════════════════════════════════════════════════════════════\n" +
                    "                      [ 1 ]  Nueva partida    [ 2 ]  Instrucciones    [ 0 ]  Volver\n" +
                    "                    ═════════════════════════════════════════════════════════════════\n" +
                    "                     > Elige una opción: ";

    public static final String MENU4 =
                    "                              ══════════════════════════════════════════════════\n" +
                    "                                [ 1 ]  Mostrar ejemplos manos    [ 0 ]  Volver\n" +
                    "                              ══════════════════════════════════════════════════\n" +
                    "                               > Elige una opción: ";

    public static final String MENU_JUGADOR =
            "════════════════════════════════════════════════════════════════════════\n" +
                    "  [ 1 ]  Jugar     [ 2 ]  Ver mano     [ 3 ]  Ver estado de la partida\n" +
                    "════════════════════════════════════════════════════════════════════════\n" +
                    " > Elige una opción: ";

    public static final String MENU_ACCIONES =
            "          ═══════════════════════════════════════════════════════════════════════════════\n" +
                    "            [ 1 ]  Igualar/Pasar     [ 2 ]  Subir     [ 3 ]  Retirarse    [ 0 ]  Volver\n" +
                    "          ═══════════════════════════════════════════════════════════════════════════════\n" +
                    "           > Elige una opción: ";
}

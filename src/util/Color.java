package util;
/**
 *  Clase que tiene atributos estaticos de tipo String para determinar los colores de los textos en la terminal
 *
 *  @author Ximena López
 *  @author Adrián de Armas
 *  @version 1.0
 */
public class Color {

    public static final String RESET = "\u001B[0m";
    public static final String SUBRAYADO = "\u001B[4m";

    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[38;2;98;255;60m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[38;5;54m";
    public static final String ORANGE = "\u001B[38;5;208m";
    public static final String CYAN = "\u001B[36m";
    public static final String PINK = "\u001B[38;5;211m";

    public static final String LIGHT_YELLOW_BG = "\u001B[48;5;230m";
    public static final String DARK_GREEN_BG = "\u001B[48;2;0;100;0m";
    public static final String BROWN_BG = "\u001B[48;2;101;67;33m";
    public static final String LIGHT_BLUE_BG = "\u001B[48;2;173;216;230m";
}
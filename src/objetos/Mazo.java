package objetos;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Mazo de 52 cartas. Implementa el patrón Singleton.
 * Permite barajar y repartir cartas de forma segura mediante SecureRandom.
 *
 *  @author Ximena López
 *  @author Adrián de Armas
 *  @version 1.0
 */
public class Mazo {

    /** Número total de cartas del mazo (rangos × palos = 52). */
    private static final int NUM_DE_CARTAS = Carta.NUM_DE_RANGOS * Carta.NUM_DE_PALOS;

    /** Array interno de cartas. */
    private Carta[] cartas;

    /** Índice de la próxima carta a repartir. */
    private int indiceSiguienteCarta = 0;

    /** Generador de números aleatorios criptográficamente seguro. */
    private Random random = new SecureRandom();

    /** Única instancia (Singleton). */
    private static Mazo instancia;

    /**
     * CONSTRUCTOR privado. Inicializa el mazo con las 52 cartas ordenadas.
     */
    private Mazo() {
        cartas = new Carta[NUM_DE_CARTAS];
        int indice = 0;
        for (int palo = Carta.NUM_DE_PALOS - 1; palo >= 0; palo--) {
            for (int rango = Carta.NUM_DE_RANGOS - 1; rango >= 0; rango--) {
                cartas[indice++] = new Carta(rango, palo);
            }
        }
    }

    /**
     * Devuelve la única instancia del mazo, creándola si no existe.
     *
     * @return instancia única de Mazo
     */
    public static Mazo getInstancia() {
        if (instancia == null) {
            instancia = new Mazo();
        }
        return instancia;
    }

    /**
     * Baraja las cartas aleatoriamente mediante Fisher-Yates y reinicia el índice de reparto.
     */
    public void barajar() {
        for (int indiceActual = 0; indiceActual < NUM_DE_CARTAS; indiceActual++) {
            int indiceAleatorio = random.nextInt(NUM_DE_CARTAS);
            Carta cartaTemporal = cartas[indiceActual];
            cartas[indiceActual] = cartas[indiceAleatorio];
            cartas[indiceAleatorio] = cartaTemporal;
        }
        this.indiceSiguienteCarta = 0;
    }

    /**
     * Reparte la siguiente carta disponible del mazo.
     *
     * @return la carta repartida
     * @throws IllegalStateException si no quedan cartas en el mazo
     */
    public Carta repartirCarta() {
        boolean noHayCartasRestantes = (this.indiceSiguienteCarta + 1) >= NUM_DE_CARTAS;
        if (noHayCartasRestantes) {
            throw new IllegalStateException("No quedan cartas en el mazo");
        }

        Carta cartaARepartir = cartas[this.indiceSiguienteCarta];
        this.indiceSiguienteCarta++;
        return cartaARepartir;
    }
}
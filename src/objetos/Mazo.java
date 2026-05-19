package objetos;

import java.security.SecureRandom;
import java.util.Random;

public class Mazo {

    private static final int NUM_DE_CARTAS = Carta.NUM_DE_RANGOS * Carta.NUM_DE_PALOS; // Número de cartas total, 52

    private Carta[] cartas;
    private int indiceSiguienteCarta = 0;
    private Random random = new SecureRandom();
    private static Mazo instancia;

    private Mazo() {
        cartas = new Carta[NUM_DE_CARTAS];
        int indice = 0;
        for (int palo = Carta.NUM_DE_PALOS - 1; palo >= 0; palo--) {
            for (int rango = Carta.NUM_DE_RANGOS - 1; rango >= 0; rango--) {
                cartas[indice++] = new Carta(rango, palo);
            }
        }
    }

    public static Mazo getInstancia() {
        if (instancia == null) {
            instancia = new Mazo();
        }
        return instancia;
    }

    public void barajar() {
        for (int indiceActual = 0; indiceActual < NUM_DE_CARTAS; indiceActual++) {
            int indiceAleatorio = random.nextInt(NUM_DE_CARTAS);
            Carta cartaTemporal = cartas[indiceActual];
            cartas[indiceActual] = cartas[indiceAleatorio];
            cartas[indiceAleatorio] = cartaTemporal;
        }
        this.indiceSiguienteCarta = 0;
    }

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
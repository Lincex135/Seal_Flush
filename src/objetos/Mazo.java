package objetos;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class Mazo {

    private static final int NUM_DE_CARTAS = Carta.NUM_DE_RANGOS * Carta.NUM_DE_PALOS; //Número de cartas total, 52

    private Carta[] cartas;
    private int nextCardIndex = 0;
    private Random random = new SecureRandom();

    public Mazo() {
        cartas = new Carta[NUM_DE_CARTAS];
        int index = 0;
        for (int palo = Carta.NUM_DE_PALOS - 1; palo >= 0; palo--) {
            for (int rango = Carta.NUM_DE_RANGOS - 1; rango >= 0; rango--) {
                cartas[index++] = new Carta(rango, palo);
            }
        }
    }

    public void barajar() {
        for (int oldIndex = 0; oldIndex < NUM_DE_CARTAS; oldIndex++) {
            int newIndex = random.nextInt(NUM_DE_CARTAS);
            Carta tempCard = cartas[oldIndex];
            cartas[oldIndex] = cartas[newIndex];
            cartas[newIndex] = tempCard;
        }
        nextCardIndex = 0;
    }

    public void reset() {
        nextCardIndex = 0;
    }

    public Carta devolverCarta() {
        boolean noHayCartasRestantes = (nextCardIndex + 1) >= NUM_DE_CARTAS;
        if (noHayCartasRestantes) {
            throw new IllegalStateException("No quedan cartas en el mazo");
        }

        Carta cartaARepartir = cartas[nextCardIndex];
        nextCardIndex++;
        return cartaARepartir;
    }

    public ArrayList<Carta> devolverCartas(int numDeCartas) {
        if (numDeCartas < 1) {
            throw new IllegalArgumentException("Número de cartas < 1");
        }
        if (nextCardIndex + numDeCartas >= NUM_DE_CARTAS) {
            throw new IllegalStateException("No quedan cartas en el mazo");
        }
        ArrayList<Carta> cartasRepartidas = new ArrayList<Carta>();
        for (int i = 0; i < numDeCartas; i++) {
            cartasRepartidas.add(cartas[nextCardIndex++]);
        }
        return cartasRepartidas;
    }

    public Carta repartirCarta(int rango, int palo) {
        if (nextCardIndex + 1 >= NUM_DE_CARTAS) {
            throw new IllegalStateException("No cards left in deck");
        }
        Carta carta = null;
        int index = -1;
        for (int i = nextCardIndex; i < NUM_DE_CARTAS; i++) {
            if ((cartas[i].getRango() == rango) && (cartas[i].getPalo() == palo)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            if (index != nextCardIndex) {
                Carta sigCarta = cartas[nextCardIndex];
                cartas[nextCardIndex] = cartas[index];
                cartas[index] = sigCarta;
            }
            carta = devolverCarta();
        }
        return carta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Carta carta : cartas) {
            sb.append(carta);
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}
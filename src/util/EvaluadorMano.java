package util;

import objetos.Carta;
import objetos.Mano;

public class EvaluadorMano {

    // Número de posiciones de desempate que usamos para calcular el valor final.
    // 1 para el tipo de mano y 5 para las cartas
    private static final int NUM_POSICIONES_DESEMPATE = 6;

    // Factores de peso para el valor numérico final (potencias de 13, el número de rangos).
    // Así el tipo de mano pesa mucho más que el desempate por carta alta
    private static final int[] FACTORES_PESO = {371293, 28561, 2197, 169, 13, 1};

    private TipoMano tipoMano;
    private int valorNumerico = 0;

    private Carta[] cartasOrdenadas;       // las 7 cartas de mayor a menor rango

    private int[] cartasPorRango;          // cuántas cartas hay de cada rango (0..12)
    private int[] cartasPorPalo;           // cuántas cartas hay de cada palo (0..3)

    private int numeroDeParejas = 0;
    private int[] rangoDeLasParejas;       // rangos de las parejas encontradas (máx. 2)

    private int paloDeLaEscaleraDeColor = -1;       // palo del color, -1 si no hay

    private int rangoMayorDeLaEscalera = -1;        // carta más alta de la escalera
    private boolean tieneAsRueda = false;            // escalera A-2-3-4-5

    private int rangoDelTrio = -1;
    private int segundoRangoDelTrio = -1;
    private int rangoDeLaPoker = -1;

    private int[] posicionesDesempate;      // componentes del valor final

    public EvaluadorMano(Mano manoJugador) {
        cartasOrdenadas = ordenarCartasDeMayorAMenor(manoJugador.getCartas());
        cartasPorRango = new int[Carta.NUM_DE_RANGOS];
        cartasPorPalo = new int[Carta.NUM_DE_PALOS];
        rangoDeLasParejas = new int[2];
        posicionesDesempate = new int[NUM_POSICIONES_DESEMPATE];

        calcularDistribuciones();
        buscarEscalera();
        buscarColor();
        buscarDuplicados();

        boolean hayManoEspecial =
                esEscaleraDeColor() || esPoker() || esFullHouse() || esColor() || esEscalera() || esTrio() || esDoblePareja() || esPareja();

        if (!hayManoEspecial) {
            calcularCartaAlta();
        }

        // Calcular el valor numérico final sumando cada posición multiplicada por su peso
        for (int posicion = 0; posicion < NUM_POSICIONES_DESEMPATE; posicion++) {
            valorNumerico += posicionesDesempate[posicion] * FACTORES_PESO[posicion];
        }
    }

    public TipoMano getTipo() {
        return tipoMano;
    }

    public int getValor() {
        return valorNumerico;
    }

    public int getPaloDelColor() {
        return paloDeLaEscaleraDeColor;
    }

    // Ordenar las 7 cartas de mayor a menor rango (burbuja)
    private Carta[] ordenarCartasDeMayorAMenor(Carta[] cartasOriginales) {
        // Copiar el array manualmente para no modificar el original
        Carta[] cartasCopiadas = new Carta[cartasOriginales.length];
        cartasCopiadas = cartasOriginales.clone();

        // Ordenación burbuja: intercambiar si la carta de la izquierda es menor
        for (int vuelta = 0; vuelta < cartasCopiadas.length - 1; vuelta++) {
            for (int posicion = 0; posicion < cartasCopiadas.length - 1 - vuelta; posicion++) {
                if (cartasCopiadas[posicion].getRango() < cartasCopiadas[posicion + 1].getRango()) {
                    Carta cartaTemporal = cartasCopiadas[posicion];
                    cartasCopiadas[posicion] = cartasCopiadas[posicion + 1];
                    cartasCopiadas[posicion + 1] = cartaTemporal;
                }
            }
        }
        return cartasCopiadas;
    }

    // Contar cuántas cartas hay de cada rango y de cada palo
    private void calcularDistribuciones() {
        for (Carta cartaActual : cartasOrdenadas) {
            cartasPorRango[cartaActual.getRango()]++;
            cartasPorPalo[cartaActual.getPalo()]++;
        }
    }

    // Buscar si hay escalera (5 cartas de rangos consecutivos)
    private void buscarEscalera() {
        boolean dentroDeUnaEscalera = false;
        int rangoInicioEscalera = -1;
        int cartasConsecutivas = 0;

        for (int rangoActual = Carta.NUM_DE_RANGOS - 1; rangoActual >= 0; rangoActual--) {
            if (cartasPorRango[rangoActual] == 0) {
                // No hay carta de este rango: se rompe la escalera
                dentroDeUnaEscalera = false;
                cartasConsecutivas = 0;
            } else {
                if (!dentroDeUnaEscalera) {
                    // Primera carta de una posible escalera
                    dentroDeUnaEscalera = true;
                    rangoInicioEscalera = rangoActual;
                }
                cartasConsecutivas++;
                if (cartasConsecutivas >= 5) {
                    rangoMayorDeLaEscalera = rangoInicioEscalera;
                    break;
                }
            }
        }

        // Caso especial: escalera rueda A-2-3-4-5
        if (cartasConsecutivas == 4 && rangoInicioEscalera == Carta.CINCO
                && cartasPorRango[Carta.AS] > 0) {
            tieneAsRueda = true;
            rangoMayorDeLaEscalera = rangoInicioEscalera;
        }
    }

    // Buscar si hay color (5 o más cartas del mismo palo)
    private void buscarColor() {
        for (int paloActual = 0; paloActual < Carta.NUM_DE_PALOS; paloActual++) {
            if (cartasPorPalo[paloActual] >= 5) {
                paloDeLaEscaleraDeColor = paloActual;
                break;
            }
        }
    }

    // Buscar parejas, tríos y pókers
    private void buscarDuplicados() {
        for (int rangoActual = Carta.NUM_DE_RANGOS - 1; rangoActual >= 0; rangoActual--) {
            if (cartasPorRango[rangoActual] == 4) {
                rangoDeLaPoker = rangoActual;
            } else if (cartasPorRango[rangoActual] == 3) {
                if (rangoDelTrio == -1) {
                    rangoDelTrio = rangoActual;
                } else if (segundoRangoDelTrio == -1) {
                    segundoRangoDelTrio = rangoActual;
                }
            } else if (cartasPorRango[rangoActual] == 2) {
                if (numeroDeParejas < 2) {
                    rangoDeLasParejas[numeroDeParejas] = rangoActual;
                    numeroDeParejas++;
                }
            }
        }
    }

    // Escalera de color y escalera real
    private boolean esEscaleraDeColor() {
        int mejorRango = -1;
        int mejorPalo = -1;

        for (int paloActual = 0; paloActual < Carta.NUM_DE_PALOS; paloActual++) {
            int rangoEscalera = obtenerRangoEscaleraMismoPalo(paloActual);
            if (rangoEscalera > mejorRango) {
                mejorRango = rangoEscalera;
                mejorPalo = paloActual;
            }
        }

        if (mejorRango != -1) {
            paloDeLaEscaleraDeColor = mejorPalo;
            if (mejorRango == Carta.AS) {
                tipoMano = TipoMano.ESCALERA_REAL;
            } else {
                tipoMano = TipoMano.ESCALERA_DE_COLOR;
            }
            posicionesDesempate[0] = tipoMano.getValue();
            posicionesDesempate[1] = mejorRango;
            return true;
        }

        return false;
    }

    private int obtenerRangoEscaleraMismoPalo(int paloBuscado) {
        boolean[] rangosDelPalo = new boolean[Carta.NUM_DE_RANGOS];

        for (Carta cartaActual : cartasOrdenadas) {
            if (cartaActual.getPalo() == paloBuscado) {
                rangosDelPalo[cartaActual.getRango()] = true;
            }
        }

        int cartasConsecutivas = 0;
        int rangoInicioEscalera = -1;
        for (int rangoActual = Carta.NUM_DE_RANGOS - 1; rangoActual >= 0; rangoActual--) {
            if (rangosDelPalo[rangoActual]) {
                if (cartasConsecutivas == 0) {
                    rangoInicioEscalera = rangoActual;
                }
                cartasConsecutivas++;
                if (cartasConsecutivas >= 5) {
                    return rangoInicioEscalera;
                }
            } else {
                cartasConsecutivas = 0;
            }
        }

        if (rangosDelPalo[Carta.AS] && rangosDelPalo[Carta.DOS] && rangosDelPalo[Carta.TRES]
                && rangosDelPalo[Carta.CUATRO] && rangosDelPalo[Carta.CINCO]) {
            return Carta.CINCO;
        }

        return -1;
    }

    // Póker (4 cartas del mismo rango)
    private boolean esPoker() {
        if (rangoDeLaPoker == -1) {
            return false;
        }
        tipoMano = TipoMano.POKER;
        posicionesDesempate[0] = tipoMano.getValue();
        posicionesDesempate[1] = rangoDeLaPoker;
        // La carta sobrante (kicker) es la primera que no pertenece al póker
        for (Carta cartaActual : cartasOrdenadas) {
            if (cartaActual.getRango() != rangoDeLaPoker) {
                posicionesDesempate[2] = cartaActual.getRango();
                break;
            }
        }
        return true;
    }

    // Full house (trío + pareja)
    private boolean esFullHouse() {
        if (rangoDelTrio == -1 || (numeroDeParejas == 0 && segundoRangoDelTrio == -1)) {
            return false;
        }
        tipoMano = TipoMano.FULL_HOUSE;
        posicionesDesempate[0] = tipoMano.getValue();
        posicionesDesempate[1] = rangoDelTrio;
        if (segundoRangoDelTrio != -1) {
            posicionesDesempate[2] = segundoRangoDelTrio;
        } else {
            posicionesDesempate[2] = rangoDeLasParejas[0];
        }
        return true;
    }

    // Color (5 cartas del mismo palo)
    private boolean esColor() {
        if (paloDeLaEscaleraDeColor == -1) {
            return false;
        }
        tipoMano = TipoMano.COLOR;
        posicionesDesempate[0] = tipoMano.getValue();

        // Rellenar las 5 cartas del color de mayor a menor (para desempate)
        int posicionDesempate = 1;
        for (Carta cartaActual : cartasOrdenadas) {
            if (cartaActual.getPalo() == paloDeLaEscaleraDeColor) {
                posicionesDesempate[posicionDesempate] = cartaActual.getRango();
                posicionDesempate++;
                if (posicionDesempate > 5) {
                    break;
                }
            }
        }
        return true;
    }

    // Escalera (5 cartas consecutivas)
    private boolean esEscalera() {
        if (rangoMayorDeLaEscalera == -1) {
            return false;
        }
        tipoMano = TipoMano.ESCALERA;
        posicionesDesempate[0] = tipoMano.getValue();
        posicionesDesempate[1] = rangoMayorDeLaEscalera;
        return true;
    }

    // Trío (3 cartas del mismo rango)
    private boolean esTrio() {
        if (rangoDelTrio == -1) {
            return false;
        }
        tipoMano = TipoMano.TRIO;
        posicionesDesempate[0] = tipoMano.getValue();
        posicionesDesempate[1] = rangoDelTrio;

        // Las dos cartas restantes más altas sirven para desempate
        int posicionDesempate = 2;
        for (Carta cartaActual : cartasOrdenadas) {
            if (cartaActual.getRango() != rangoDelTrio) {
                posicionesDesempate[posicionDesempate] = cartaActual.getRango();
                posicionDesempate++;
                if (posicionDesempate > 3) {
                    break;
                }
            }
        }
        return true;
    }

    // Doble pareja
    private boolean esDoblePareja() {
        if (numeroDeParejas < 2) {
            return false;
        }
        tipoMano = TipoMano.DOBLE_PAREJA;
        posicionesDesempate[0] = tipoMano.getValue();

        int rangoParejaMayor = rangoDeLasParejas[0];
        int rangoParejaMenor = rangoDeLasParejas[1];
        posicionesDesempate[1] = rangoParejaMayor;
        posicionesDesempate[2] = rangoParejaMenor;

        // La carta sobrante es la más alta que no forma parte de ninguna pareja
        for (Carta cartaActual : cartasOrdenadas) {
            if (cartaActual.getRango() != rangoParejaMayor
                    && cartaActual.getRango() != rangoParejaMenor) {
                posicionesDesempate[3] = cartaActual.getRango();
                break;
            }
        }
        return true;
    }

    // Pareja (2 cartas del mismo rango)
    private boolean esPareja() {
        if (numeroDeParejas != 1) {
            return false;
        }
        tipoMano = TipoMano.PAREJA;
        posicionesDesempate[0] = tipoMano.getValue();

        int rangoDelaPareja = rangoDeLasParejas[0];
        posicionesDesempate[1] = rangoDelaPareja;

        // Las tres cartas restantes más altas sirven para desempate
        int posicionDesempate = 2;
        for (Carta cartaActual : cartasOrdenadas) {
            if (cartaActual.getRango() != rangoDelaPareja) {
                posicionesDesempate[posicionDesempate] = cartaActual.getRango();
                posicionDesempate++;
                if (posicionDesempate > 4) {
                    break;
                }
            }
        }
        return true;
    }

    // Carta alta (ninguna combinación especial)
    private void calcularCartaAlta() {
        tipoMano = TipoMano.CARTA_ALTA;
        posicionesDesempate[0] = tipoMano.getValue();
        int posicionDesempate = 1;
        for (Carta cartaActual : cartasOrdenadas) {
            posicionesDesempate[posicionDesempate] = cartaActual.getRango();
            posicionDesempate++;
            if (posicionDesempate > 5) {
                break;
            }
        }
    }
}

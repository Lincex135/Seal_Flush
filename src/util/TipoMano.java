package util;

// Los tipos de mano del poker, ordenados de menor a mayor valor
public enum TipoMano {

    CARTA_ALTA(0),
    PAREJA(1),
    DOBLE_PAREJA(2),
    TRIO(3),
    ESCALERA(4),
    COLOR(5),
    FULL_HOUSE(6),
    POKER(7),
    ESCALERA_DE_COLOR(8),
    ESCALERA_REAL(9);

    private final int valor;

    TipoMano(int valor) {
        this.valor = valor;
    }

    public int getValue() {
        return valor;
    }
}
package util;

// Los tipos de mano del poker, ordenados de menor a mayor valor
public enum TipoMano {
    CARTA_ALTA("Carta alta", 0),
    PAREJA("Pareja", 1),
    DOBLE_PAREJA("Doble pareja", 2),
    TRIO("Trío", 3),
    ESCALERA("Escalera", 4),
    COLOR("Color", 5),
    FULL_HOUSE("Full house", 6),
    POKER("Póker", 7),
    ESCALERA_DE_COLOR("Escalera de color", 8),
    ESCALERA_REAL("Escalera real", 9);

    private final String descripcion;
    private final int valor;

    TipoMano(String descripcion, int valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getValue() {
        return valor;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
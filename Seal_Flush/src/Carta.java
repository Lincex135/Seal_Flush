public class Carta {
    private String numero;
    private Palo palo;

    public Carta (String numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public String getColor() {
        if (palo.toString().equals("CORAZONES") || palo.toString().equals("ROMBOS")) {
            return"ROJO";
        } else {
            return "NEGRO";
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }
}
package objetos;

public class Bote {

    private int cantidad;
    private static Bote instancia;

    private Bote() {
        this.cantidad = cantidad;
    }

    public static Bote getInstancia(){
        if(instancia == null){
            instancia = new Bote();
        }
        return instancia;
    }

    public int getCantidad() {return this.cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
}

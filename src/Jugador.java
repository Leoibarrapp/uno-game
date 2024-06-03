import java.util.LinkedList;

public class Jugador {
    private String nombre;
    private LinkedList<Carta> cartasMano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.cartasMano = new LinkedList<Carta>();
    }

    public LinkedList<Carta> getCartasMano() {
        return cartasMano;
    }

    public void setCartasMano(LinkedList<Carta> cartasMano) {
        this.cartasMano = cartasMano;
    }

    public void agregarCarta(Carta carta) {
      cartasMano.add(carta);
  }
  public void imprimirMano(){
        for (Carta carta : cartasMano) {
            System.out.println(carta);
        }
  }
}
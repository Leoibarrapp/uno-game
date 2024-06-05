public class CartaTope {
    Carta cartaTope;

    public CartaTope() {
    }
    public Carta getCartasTope() {
        return cartaTope;
    }
    public void setCartasTope(Carta cartaTope) {
        this.cartaTope = cartaTope;
    }
    public void agregarCarta(Carta carta) {
        cartaTope = carta;
    }
    public void eliminarCarta(Carta carta) {
        cartaTope = carta;
    }
    public void mostrarCarta() {
        System.out.println(cartaTope);
    }
}

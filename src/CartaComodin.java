public class CartaComodin extends Carta{

    public CartaComodin(char color, String tipo) {
        super(color, tipo);
    }

    public boolean esJugable(Juego juego) {
        return true;
    }

}
public class CartaColor extends Carta{

    public CartaColor(char color, String tipo) {
        super(color, tipo);
    }

    public boolean esJugable(Juego juego){

        Carta tope = juego.getMazoJuego().getTope();
        if( (this.getTipo().equals(tope.getTipo())) || (this.getColor() == tope.getColor()) ){
            return true;
        }
        return false;
    }
}
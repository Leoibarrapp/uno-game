public class CartaColor extends Carta{

    public CartaColor(char color, String tipo) {
        super(color, tipo);
    }

    public boolean esJugable(Juego juego){

        Carta tope = juego.getMazoJuego().getTope();
        if( (this.getTipo().equals(tope.getTipo())) || (this.getColor() == juego.getColorActual()) ){
            return true;
        }
        return false;
    }

    public void usar(Juego juego){
        switch(this.getTipo()){
            case "R","S":
                System.out.println("\tRepite el turno");
                break;
            case "CT2":
                juego.cambiarTurno();
                Jugador jugador = juego.getJugadores().get(juego.getTurno());

                jugador.getCartas().agregarCarta(juego.getMazoPila().getTope()); juego.getMazoPila().eliminarCarta(0);
                jugador.getCartas().agregarCarta(juego.getMazoPila().getTope()); juego.getMazoPila().eliminarCarta(0);

                System.out.println("\t"+ TextColor.YELLOW + jugador.getNombre() + TextColor.RESET +" robó DOS cartas de la pila");
                break;
            default:
                juego.cambiarTurno();
        }

    }
}
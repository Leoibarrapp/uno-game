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
                System.out.println("\tRepites el turno");
                break;
            case "CT2":
                juego.cambiarTurno();
                Jugador jugador = juego.getJugadores().get(juego.getTurno());
                if(jugador.tieneCT2() == false){
                    jugador.getCartas().agregarCarta(juego.getMazoPila().getTope());
                        juego.getMazoPila().eliminarCarta(0);
                    jugador.getCartas().agregarCarta(juego.getMazoPila().getTope());
                        juego.getMazoPila().eliminarCarta(0);
                    System.out.println("\t\u001B[33m"+ jugador.getNombre() + "\u001B[0m robó dos cartas");
                    juego.cambiarTurno();
                }
                break;
            default:
                juego.cambiarTurno();
        }

    }
}
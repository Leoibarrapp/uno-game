public class CartaComodin extends Carta{

    public CartaComodin(char color, String tipo) {
        super(color, tipo);
    }

    public boolean esJugable(Juego juego) {
        return true;
    }

    public void usar(Juego juego) {
        switch(this.getTipo()){
            case "CC":

                break;
            case "CT4":
                juego.cambiarTurno();
                Jugador jugador = juego.getJugadores().get(juego.getTurno());

                jugador.getCartas().agregarCarta(juego.getMazoPila().getTope()); juego.getMazoPila().eliminarCarta(0);
                jugador.getCartas().agregarCarta(juego.getMazoPila().getTope()); juego.getMazoPila().eliminarCarta(0);
                jugador.getCartas().agregarCarta(juego.getMazoPila().getTope()); juego.getMazoPila().eliminarCarta(0);
                jugador.getCartas().agregarCarta(juego.getMazoPila().getTope()); juego.getMazoPila().eliminarCarta(0);

                System.out.println("\t"+ TextColor.YELLOW + jugador.getNombre() + TextColor.RESET +" robó CUATRO cartas de la pila");
                break;
        }
        juego.cambiarTurno();
    }

}
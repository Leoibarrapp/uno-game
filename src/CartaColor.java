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
            case "T2":
                juego.cambiarTurno();
                int cant = 2;

                Jugador jugador = juego.getJugadores().get(juego.getTurno());
                Carta carta = jugador.buscarCartaTipo("T2");

                while(carta != null){
                    System.out.println( "\t" + TextColor.YELLOW + jugador.getNombre() + TextColor.RESET + " ha respondido con otra carta " + TextColor.GREEN + "T2!" + TextColor.RESET );

                    cant = cant + 2;
                    juego.cambiarTurno();
                    jugador.getCartas().eliminarCarta(carta);
                    juego.getMazoJuego().agregarCarta(carta);

                    jugador = juego.getJugadores().get(juego.getTurno());
                    carta = jugador.buscarCartaTipo("T2");
                }

                for(int i = 0; i < cant; i++){
                    jugador.agarrarCarta(juego);
                }

                System.out.println();
                System.out.println("\t"+ TextColor.YELLOW + jugador.getNombre() + TextColor.RESET +" robó " + TextColor.YELLOW + cant + " cartas" + TextColor.RESET + " de la pila" + TextColor.RESET);
            default:
                juego.cambiarTurno();
        }

    }
}
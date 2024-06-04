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
            case "T4":
                juego.cambiarTurno();
                int cant = 4;

                Jugador jugador = juego.getJugadores().get(juego.getTurno());
                Carta carta = jugador.buscarCartaTipo("T4");

                while(carta != null){
                    System.out.println( "\t" + TextColor.YELLOW + jugador.getNombre() + TextColor.RESET + " ha respondido con otra carta " + TextColor.GREEN + "T4!" + TextColor.RESET );
                    cant = cant + 4;
                    juego.cambiarTurno();
                    jugador = juego.getJugadores().get(juego.getTurno());
                    carta = jugador.buscarCartaTipo("T4");
                }

                for(int i = 0; i < cant; i++){
                    jugador.getCartas().agregarCarta(juego.getMazoPila().getTope());
                    juego.getMazoPila().eliminarCarta(0);
                }

                System.out.println();
                System.out.println("\t"+ TextColor.YELLOW + jugador.getNombre() + TextColor.RESET +" robó " + TextColor.YELLOW + cant + " cartas " + TextColor.RESET + "de la pila");
                break;
        }
        juego.cambiarTurno();
    }

}
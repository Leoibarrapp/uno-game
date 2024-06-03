public class CPU extends Jugador{

    public CPU() {
        super("CPU");
    }

    public void jugar(Juego juego, Carta x){
        System.out.println("jugada de cp");
        for(Carta carta : this.getCartas().getMazo()){
            if(carta.esJugable(juego)){
                super.jugar(juego, carta);
                break;
            }
        }

    }

}

public class CPU extends Jugador{

    public CPU() {
        super("CPU");
    }

    public Carta escogerCarta(Juego juego){
        Carta escogida = null;
        for(Carta carta : this.getCartas().getMazo()){
            if(carta.esJugable(juego)){
                escogida = carta;
                break;
            }
        }
        return escogida;
    }

    public void jugar(Juego juego, Carta c){
        c = this.escogerCarta(juego);
        super.jugar(juego, c);
    }

   /* public String toString(){
        String s = "CPU [...] \u001B[37m " + this.getCartas().getMazo().size() + " cartas restantes";

        if(this.getCartas().getMazo().size() == 1){
            s = s + "\u001B[33m UNO!";
        }

        return s + "\u001B[0m";
    }

    */

}

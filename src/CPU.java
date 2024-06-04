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

    public char escogerColor(){
        int numero = (int) (Math.random()*4);
        char color = ' ';
        switch(numero){
            case 0: color = 'R';
                break;
            case 1: color = 'G';
                break;
            case 2: color = 'B';
                break;
            case 3: color = 'Y';
                break;
        }
        return color;
    }

    public String toString(){
        String s = "CPU [...] \u001B[37m " + this.getCartas().getMazo().size() + " cartas restantes";

        if(this.getCartas().getMazo().size() == 1){
            s = s + "\u001B[33m UNO!";
        }

        return s + "\u001B[0m";
    }

}

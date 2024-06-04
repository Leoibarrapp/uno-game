import java.util.ArrayList;

public class Juego {
    private Mazo mazoJuego;
    private Mazo mazoPila;
    private ArrayList<Jugador> jugadores;
    private Jugador ganador = null;
    private int turno;
    private char colorActual;

    public Juego(Mazo mazoJuego, Mazo mazoPila, ArrayList<Jugador> jugadores) {
        this.mazoJuego = mazoJuego;
        this.mazoPila = mazoPila;
        this.jugadores = jugadores;
    }

    public Mazo getMazoJuego() {
        return mazoJuego;
    }

    public Mazo getMazoPila() {
        return mazoPila;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void cambiarTurno(){
        if(turno == 0){
            turno = 1;
        }
        else{
            turno = 0;
        }
    }

    public void iniciarJuego(){
        for(Jugador jugador : jugadores){
            Mazo mazo = new Mazo();
            for(int i = 0; i < 7; i++){
                mazo.agregarCarta(mazoPila.getTope());
                mazoPila.eliminarCarta(mazoPila.getTope());
            }
            jugador.setCartas(mazo);
        }
        Carta carta;
        int num;

        while(true){
            carta = mazoPila.getMazo().getFirst();
            try{
                num = Integer.parseInt(carta.getTipo());
                break;
            }
            catch(NumberFormatException e){
                mazoPila.barajear();
            }
        }

        mazoPila.eliminarCarta(carta);
        mazoJuego.agregarCarta(carta);

        colorActual = mazoJuego.getTope().getColor();
    }

    public Jugador getGanador() {
        return this.ganador;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void reBarajear(){
        Carta carta;
        int tamano = mazoJuego.getMazo().size();
        for(int i = 1; i < tamano; i++){
            carta = mazoJuego.getMazo().getLast();
            mazoPila.agregarCarta(carta);
            mazoJuego.getMazo().removeLast();
        }

        mazoPila.barajear();
    }

    public char getColorActual() {
        return colorActual;
    }

    public void setColorActual(char colorActual) {
        this.colorActual = colorActual;
    }
}

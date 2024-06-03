import java.util.ArrayList;

public class Juego {
    private Mazo mazoJuego;
    private Mazo mazoPila;
    private ArrayList<Jugador> jugadores;
    private Jugador ganador = null;
    private int turno;

    public Juego(Mazo mazoJuego, Mazo mazoPila, ArrayList<Jugador> jugadores) {
        this.mazoJuego = mazoJuego;
        this.mazoPila = mazoPila;
        this.jugadores = jugadores;
    }

    public Mazo getMazoJuego() {
        return mazoJuego;
    }

    public void setMazoJuego(Mazo mazoJuego) {
        this.mazoJuego = mazoJuego;
    }

    public Mazo getMazoPila() {
        return mazoPila;
    }

    public void setMazoPila(Mazo mazoPila) {
        this.mazoPila = mazoPila;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
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
    }
/*
    public void jugada(Jugador jugador, Carta carta){
        Carta tope = mazoJuego.getTope();
        System.out.println(carta.getTipo());
        System.out.println(tope.getTipo());
        if(carta.getTipo().equals(tope.getTipo())){

            mazoPila.agregarCarta(mazoPila.getTope());
            System.out.println("Agregada a mazo");
            jugador.getCartas().eliminarCarta(carta);
            System.out.println("Eliminada de jugador");
        }

        if(jugador.getCartas().getMazo().isEmpty()){
            this.ganador = jugador;
        }
    }
*/
    public Jugador getGanador() {
        return this.ganador;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
}

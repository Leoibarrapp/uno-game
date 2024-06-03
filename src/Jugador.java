import java.util.LinkedList;

public class Jugador{
    private String nombre;
    private Mazo cartas;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Mazo getCartas() {
        return cartas;
    }

    public void setCartas(Mazo cartas) {
        this.cartas = cartas;
    }

    public boolean puedeJugar(Juego juego){
        Carta tope = juego.getMazoJuego().getTope();
        for(Carta carta : cartas.getMazo()) {
            if(carta.esJugable(juego)){
                return true;
            }
        }
        return false;
    }

    public void agarrarCarta(Juego juego){
        Carta carta =  juego.getMazoPila().getTope();
        this.cartas.agregarCarta(carta);
        juego.getMazoPila().eliminarCarta(carta);
    }

    public Carta buscarCarta(String input){
        char color = input.charAt(0);
        //System.out.println(color);
        String tipo = input.substring(2);
        //System.out.println(tipo);

        for(Carta carta : cartas.getMazo()){
            if((color == carta.getColor()) && (tipo.equals(carta.getTipo()))){
                return carta;
            }
        }
        return null;
    }

    public void cantarUno(){
        System.out.println("UNO!");
    }

    public void jugar(Juego juego, Carta carta){
        juego.getMazoJuego().agregarCarta(carta);
        this.cartas.eliminarCarta(carta);
        if(cartas.getMazo().size() == 1){
            this.cantarUno();
        }
    }

    public String toString(){
        return nombre + " " + cartas + "\u001B[37m " + cartas.getMazo().size() + " cartas restantes" + "\u001B[0m";
    }

}
import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.Scanner;

public class Jugador{
    private String nombre;
    private Mazo cartas;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
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

        /*if(carta.esJugable(juego)){
            System.out.println("\tLa carta agarrada es jugable");
            new Scanner(System.in);

        }
        else{
            juego.cambiarTurno();
        }

         */
    }

    public Carta buscarCarta(String idCarta){
        if(!idCarta.isEmpty()){
            char color = idCarta.charAt(0);
            //System.out.println(color);
            if(idCarta.length() > 1){
                String tipo = idCarta.substring(2);
                //System.out.println(tipo);

                for(Carta carta : cartas.getMazo()){
                    if((color == carta.getColor()) && (tipo.equals(carta.getTipo()))){
                        return carta;
                    }
                }
            }

        }
        return null;
    }

    public Carta buscarCartaTipo(String tipoCarta){
        Carta c = null;

        for(Carta carta : cartas.getMazo()){
            if(carta.getTipo().equals(tipoCarta)){
                c = carta;
            }
        }

        return c;
    }

    public void cantarUno(){
        System.out.println("\t" + TextColor.GREEN + this.getNombre() + " ha cantado UNO!" + TextColor.RESET);
    }

    public void jugar(Juego juego, Carta carta){
        juego.getMazoJuego().agregarCarta(carta);
        this.cartas.eliminarCarta(carta);

        if(cartas.getMazo().size() == 1){
            this.cantarUno();
        }

        juego.setColorActual(carta.getColor());
        carta.usar(juego);

        if(cartas.getMazo().isEmpty()){
            juego.setGanador(this);
        }
    }

    public String toString(){
        String s = nombre + " " + cartas + "\u001B[37m " + cartas.getMazo().size() + " cartas restantes";

        if(cartas.getMazo().size() == 1){
            s = s + "\u001B[33m UNO!";
        }

        return s + "\u001B[0m";
    }

}
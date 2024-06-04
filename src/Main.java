import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = cin.nextLine();
        System.out.println();

        Jugador jugador = new Jugador(nombre);
        Jugador cpu = new CPU();
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador); jugadores.add(cpu);

        Mazo baraja = new Mazo();
        baraja.crear();
        baraja.barajear();

        Mazo pila = new Mazo();

        Juego juego = new Juego(pila, baraja, jugadores);
        juego.iniciarJuego();

        String input;

        int turno = 0;
        while(juego.getGanador() == null){
            switch(juego.getTurno()){
                case 0:
                    //System.out.println(baraja);

                    System.out.println(cpu);
                    System.out.println(jugador);
                    System.out.println();
                    System.out.println("Carta actual: " + juego.getMazoJuego().getTope());
                    System.out.println();
                    if (jugador.puedeJugar(juego)) {
                        System.out.print("Escoge una carta -> ");
                        input = cin.nextLine().trim();
                        Carta carta = jugador.buscarCarta(input);
                        if (carta != null) {
                            if (carta.esJugable(juego)) {
                                jugador.jugar(juego, carta);
                            } else {
                                System.out.println("La carta no es jugable");
                            }
                        } else {
                            System.out.println("Carta invalida");
                        }
                    } else {
                        System.out.println("No tienes cartas que puedas jugar. Agarra una carta.");
                        cin.nextLine();
                        System.out.println();
                        jugador.agarrarCarta(juego);
                    }

                    juego.setTurno(1);

                case 1:
                    if(cpu.puedeJugar(juego)){
                        cpu.jugar(juego, null);
                        System.out.println("El jugador 2 ha soltado la carta " + juego.getMazoJuego().getTope());
                        System.out.println();
                    }
                    else{
                        cpu.agarrarCarta(juego);
                        System.out.println("El jugador 2 ha agarrado un mazo de la pila");
                        System.out.println();
                    }

                    juego.setTurno(0);
                break;
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }

        System.out.println("\u001B[31m" + "El ganador es "+ juego.getGanador());

    }
}

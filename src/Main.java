import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws IOException {

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

        String idCarta;
        int turno = 0;
        Carta carta;

        while(juego.getGanador() == null){
            clearScreen();

            System.out.println("\u001B[33m TURNO DE " + jugadores.get(juego.getTurno()).getNombre() + "\u001B[0m");
            System.out.println(" Carta actual: " + pila.getTope());
            System.out.println();

            switch(juego.getTurno()){
                case 0:
                    System.out.println(cpu);
                    System.out.println(jugador);
                    System.out.println();

                    if (jugador.puedeJugar(juego)) {
                        System.out.print("Escoge una carta -> ");
                        idCarta = cin.nextLine();
                        carta = jugador.buscarCarta(idCarta);
                        if (carta != null) {
                            if (carta.esJugable(juego)) {
                                System.out.println("\t\u001B[33m" + jugador.getNombre() + "\u001B[0m" + " ha soltado la carta " + carta);
                                jugador.jugar(juego, carta);

                            } else {
                                System.out.println("La carta no es jugable");
                            }
                        } else {
                            System.out.println("Carta invalida");
                        }
                    } else {
                        System.out.println("No tienes cartas que puedas jugar. Debes agarrar una carta de la pila.");
                        cin.nextLine();
                        jugador.agarrarCarta(juego);
                        juego.setTurno(1);
                    }

                    break;
                case 1:

                    if(cpu.puedeJugar(juego)){
                        CPU aux = (CPU) cpu;
                        carta = aux.escogerCarta(juego);
                        System.out.println("\t\u001B[33mCPU\u001B[0m ha soltado la carta " + carta);
                        cpu.jugar(juego, carta);

                    }
                    else{
                        System.out.println("\t\u001B[33mCPU\u001B[0m ha agarrado un mazo de la pila");
                        System.out.println();
                        cpu.agarrarCarta(juego);
                        juego.setTurno(0);
                    }

                break;
            }
            if(baraja.getMazo().isEmpty()){
                juego.reBarajear();
            }
            System.out.println();
        }

    //    System.out.println("\u001B[31m" + "El ganador es "+ juego.getGanador());

    }
}

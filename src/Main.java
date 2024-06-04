import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.w3c.dom.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Scanner cin = new Scanner(System.in);
        System.out.println();
        System.out.println(TextColor.YELLOW + "BIENENIDO AL JUEGO UNO" + TextColor.RESET);
        System.out.println();
        System.out.println("1. Iniciar partida nueva");
        System.out.println("2. Jugar partida anterior");
        System.out.println("3. Salir");
        System.out.println();
        System.out.print("Opcion -> "); char menu = cin.nextLine().charAt(0);
        System.out.println();

        switch (menu) {
            case '1':
                break;
            case '2':
                break;
            case '3':
                break;
            default:
                System.out.println("Gracias por jugar!");
        }

        System.out.print("Nombre: ");
        String nombre = cin.nextLine();

        Jugador jugador = new Jugador(nombre);
        Jugador cpu = new CPU();
        CPU auxCPU = (CPU) cpu;
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        jugadores.add(cpu);

        Mazo baraja = new Mazo();
        baraja.crear();
        baraja.barajear();

        Mazo pila = new Mazo();

        Juego juego = new Juego(pila, baraja, jugadores);
        juego.iniciarJuego();

        String idCarta;
        int turno = 0;
        Carta carta;
        char colorEscogido = ' ';

        if(menu == '1'){
            juego.setTurno((int) (Math.random() * 2));
            System.out.println(TextColor.GREEN + "Escogiendo aleatoriamente los turnos..." + TextColor.RESET);
            System.out.println();

            while (juego.getGanador() == null) {

                System.out.println(TextColor.YELLOW + "TURNO DE " + jugadores.get(juego.getTurno()).getNombre() + TextColor.RESET);
                System.out.println("Carta actual: " + pila.getTope());
                System.out.println();

                switch (juego.getTurno()) {
                    case 0:
                        System.out.println(cpu);
                        System.out.println(jugador);
                        System.out.println();

                        if (jugador.puedeJugar(juego)) {
                            System.out.print("\tEscoge una carta -> ");
                            idCarta = cin.nextLine();
                            carta = jugador.buscarCarta(idCarta);
                            if (carta != null) {
                                if (carta.esJugable(juego)) {
                                    System.out.println("\t" + TextColor.YELLOW + jugador.getNombre() + TextColor.RESET + " ha soltado la carta " + carta);
                                    if (carta instanceof CartaComodin) {
                                        System.out.print("\tEscoge un color:  " + TextColor.RED + " [R] ROJO  " + TextColor.GREEN + " [G] VERDE  " + TextColor.BLUE + " [B] AZUL  " + TextColor.YELLOW + " [Y] AMARILLO  " + TextColor.RESET + " -> ");
                                        colorEscogido = cin.nextLine().charAt(0);
                                        if ((colorEscogido == 'R') || (colorEscogido == 'G') || (colorEscogido == 'B') || (colorEscogido == 'Y')) {
                                            System.out.println("\tSe ha cambiado el color a '" + colorEscogido + "'");
                                        } else {
                                            System.out.println("\tEl color escogido es invalido. Se ha cambiado el color por defecto a " + TextColor.RED + "ROJO" + TextColor.RESET);
                                            colorEscogido = 'R';
                                        }
                                        jugador.jugar(juego, carta);
                                        juego.setColorActual(colorEscogido);
                                    } else {
                                        jugador.jugar(juego, carta);
                                    }

                                } else {
                                    System.out.println("\tLa carta no es jugable");
                                }
                            } else {
                                System.out.println(TextColor.RED + "\tCarta invalida" + TextColor.RESET);
                            }
                        } else {
                            System.out.println("\tNo tienes cartas que puedas jugar. \n\tDebes " + TextColor.YELLOW + "agarrar una carta de la pila." + TextColor.RESET);
                            cin.nextLine();
                            jugador.agarrarCarta(juego);
                            carta = jugador.getCartas().getTope();
                            if (carta.esJugable(juego)) {
                                System.out.println("\tPuedes jugar la carta!");
                            } else {
                                juego.cambiarTurno();
                            }
                        }

                        break;
                    case 1:

                        if (cpu.puedeJugar(juego)) {
                            carta = auxCPU.escogerCarta(juego);
                            System.out.println("\t" + TextColor.YELLOW + "CPU" + TextColor.RESET + " ha soltado la carta " + carta);
                            cpu.jugar(juego, carta);
                            if (carta instanceof CartaComodin) {
                                colorEscogido = auxCPU.escogerColor();
                                System.out.println("\tSe ha cambiado el color a '" + colorEscogido + "'");
                                juego.setColorActual(colorEscogido);
                            }

                        } else {
                            System.out.println("\t" + TextColor.YELLOW + "CPU" + TextColor.RESET + " ha agarrado una carta de la pila");
                            cpu.agarrarCarta(juego);
                            if (cpu.puedeJugar(juego)) {
                                carta = auxCPU.escogerCarta(juego);
                            } else {
                                juego.cambiarTurno();
                            }
                        }

                        break;
                }
                if (baraja.getMazo().isEmpty()) {
                    juego.reBarajear();
                }
                System.out.println();

                try {
                    FileWriter writer = new FileWriter("partida.json");
                    gson.toJson(juego, writer);
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }

            System.out.println();
            System.out.println();
            System.out.println(TextColor.GREEN + "EL GANADOR ES " + TextColor.YELLOW + juego.getGanador().getNombre() + TextColor.RESET);
        }
    }
}

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Scanner cin = new Scanner(System.in);
        char menu = ' ';

        while(menu != '3') {
            System.out.println();
            System.out.print(TextColor.YELLOW+"1."+TextColor.RESET);
            System.out.println(" Iniciar partida nueva");
            System.out.print(TextColor.BLUE+" 2."+TextColor.RESET);
            System.out.println(" Jugar partida anterior");
            System.out.print(TextColor.GREEN+"  3."+TextColor.RESET);
            System.out.println(" Salir");
            System.out.print(TextColor.RED+"   4."+TextColor.RESET);
            System.out.println(" Ver tabla de Marcadores");
            System.out.print("Opcion -> ");
            menu = cin.nextLine().charAt(0);
            System.out.println();

            switch (menu) {
                case '1':
                    break;
                case '2':
                    break;
                case '3':
                    break;
                case '4':
                    break;
                default:
                    System.out.println("Gracias por jugar!");
            }
            Juego juego = new Juego();
            Scoreboard puntaje = new Scoreboard();

            FileReader readerScore = null;
            try {
                readerScore = new FileReader("puntajes.json");
                puntaje = gson.fromJson(readerScore, Scoreboard.class);
            } catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo, creando archivo");
                try {
                    FileWriter  writer2 = new FileWriter("puntajes.json");
                    writer2.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }


            Jugador cpu = new Jugador("CPU");
            Mazo pila = new Mazo();
            Mazo baraja = new Mazo();
            String idCarta = "";
            int turno = 0;
            Carta carta = null;
            char colorEscogido = ' ';
            Jugador jugador = new Jugador();
            ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
            if (menu == '1') {

                System.out.print("Nombre: ");
                String nombre = cin.nextLine();
                if (puntaje == null) {
                    puntaje.crear();
                }

                jugador = new Jugador(nombre);
                jugadores.add(jugador);
                jugador.setPuntaje((int) (Math.random() * 500));
                jugadores.add(cpu);
                if (puntaje.buscar(jugador) == false) {
                    puntaje.agregarJugador(jugador);
                }else if (puntaje.buscar(jugador) == true) {
                    System.out.println("Se encontró jugador existente");
                    puntaje.reemplazar(jugador);
                }

                baraja.crear();
                baraja.barajear();


                juego = new Juego(pila, baraja, jugadores);
                juego.iniciarJuego();

                System.out.println();

                juego.setTurno(0);
                System.out.println();
            }else if (menu == '2') {
                try {
                    FileReader reader = new FileReader("partida.json");
                    juego = gson.fromJson(reader, Juego.class);
                    jugadores = (ArrayList<Jugador>) juego.getJugadores();
                    baraja = (Mazo) juego.getMazoPila();
                    pila = (Mazo) juego.getMazoJuego();
                    cpu = jugadores.get(1);
                    jugador = jugadores.get(0);

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }else if (menu == '4') {
                System.out.println("  TABLA DE MARCADORES  ");
                puntaje.imprimir();
            }
if ((menu == '1') ||(menu == '2')) {
                    while (juego.getGanador() == null) {

                        System.out.println(TextColor.YELLOW + "TURNO DE " + jugadores.get(juego.getTurno()).getNombre() + TextColor.RESET);
                        Tiempo.delay(200);
                        System.out.println("Carta actual: " + pila.getTope());
                        Tiempo.delay(200);
                        System.out.println();
                        System.out.println();
                        puntaje.ordenar();
                        puntaje.imprimir();

                        switch (juego.getTurno()) {
                            case 0:
                                System.out.println(cpu);
                                System.out.println(jugador);
                                System.out.println();

                                if (jugador.puedeJugar(juego)) {
                                    Tiempo.delay(200);
                                    System.out.println("\tEscriba " + TextColor.RED + "0 " + TextColor.RESET + "para " + TextColor.RED + "salir " + TextColor.RESET);
                                    Tiempo.delay(200);
                                    System.out.print("\tEscoge una carta  -> ");
                                    idCarta = cin.nextLine();
                                    if (Objects.equals(idCarta, "0")) {
                                        break;
                                    }
                                    carta = jugador.buscarCarta(idCarta);
                                    if (carta != null) {
                                        if (carta.esJugable(juego)) {
                                            System.out.println("\t" + TextColor.YELLOW + jugador.getNombre() + TextColor.RESET + " ha soltado la carta " + carta);
                                            if ((carta.getTipo() == "T4" ) || (carta.getTipo() == "CC")){
                                                Tiempo.delay(200);
                                                System.out.print("\tEscoge un color:  "+TextColor.RED + " [R] ROJO  " + TextColor.GREEN + " [G] VERDE  " + TextColor.BLUE + " [B] AZUL  " + TextColor.YELLOW + " [Y] AMARILLO  " + TextColor.RESET + " -> ");
                                                colorEscogido = cin.nextLine().charAt(0);
                                                if ((colorEscogido == 'R') || (colorEscogido == 'G') || (colorEscogido == 'B') || (colorEscogido == 'Y')) {
                                                    Tiempo.delay(200);
                                                    System.out.println("\tSe ha cambiado el color a '" + colorEscogido + "'");
                                                } else {
                                                    System.out.println("\tEl color escogido es invalido. Se ha cambiado el color por defecto a " + TextColor.RED + "ROJO" + TextColor.RESET);
                                                    Tiempo.delay(200);
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
                                    Tiempo.delay(200);
                                    System.out.println("\tNo tienes cartas que puedas jugar. \n\tDebes " + TextColor.YELLOW + "agarrar una carta de la pila." + TextColor.RESET);
                                    cin.nextLine();
                                    jugador.agarrarCarta(juego);
                                    carta = jugador.getCartas().getTope();
                                    if (carta.esJugable(juego)) {
                                        Tiempo.delay(200);
                                        System.out.println("\tPuedes jugar la carta!");
                                    } else {
                                        juego.cambiarTurno();
                                    }
                                }

                                break;
                            case 1:

                                if (cpu.puedeJugar(juego)) {
                                    carta = cpu.escogerCarta(juego);
                                    Tiempo.delay(200);
                                    System.out.println("\t" + TextColor.YELLOW + "CPU" + TextColor.RESET + " ha soltado la carta " + carta);
                                    cpu.jugar(juego, carta);
                                    if ((carta.getTipo() == "CC" ) || (carta.getTipo() == "T4")) {
                                        colorEscogido = cpu.escogerColor();
                                        System.out.println("\tSe ha cambiado el color a '" + colorEscogido + "'");
                                        juego.setColorActual(colorEscogido);
                                    }

                                } else {
                                    System.out.println("\t" + TextColor.YELLOW + "CPU" + TextColor.RESET + " ha agarrado una carta de la pila");
                                    cpu.agarrarCarta(juego);
                                    if (cpu.puedeJugar(juego)) {
                                        carta = cpu.escogerCarta(juego);
                                    } else {
                                        juego.cambiarTurno();
                                    }
                                }

                                break;

                        }
                        if (idCarta.equals("0")) {
                            break;
                        }

                        if (baraja.getMazo().isEmpty()) {
                            juego.reBarajear();

                        }
                        System.out.println();

                        try {
                            FileWriter writer = new FileWriter("partida.json");
                            FileWriter  writer2 = new FileWriter("puntajes.json");
                            gson.toJson(puntaje,writer2);
                            writer2.close();

                            gson.toJson(juego, writer);
                            writer.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                System.out.println();
                System.out.println();
                  
                if(juego.getGanador() != null){
                    Tiempo.delay(200);
                    System.out.println(TextColor.GREEN + "EL GANADOR ES " + TextColor.YELLOW + juego.getGanador().getNombre() + TextColor.RESET);
                }

                System.out.println("Volver al menu principal");
            }
        }


        System.out.println();
        System.out.println( TextColor.GREEN + "Gracias por jugar con nosotros"+TextColor.RESET);
        System.out.println(" ██████╗ ██████╗  █████╗  ██████╗██╗ █████╗ ███████╗");
        System.out.println("██╔════╝ ██╔══██╗██╔══██╗██╔════╝██║██╔══██╗██╔════╝");
        System.out.println("██║  ███╗██████╔╝███████║██║     ██║███████║███████╗");
        System.out.println("██║   ██║██╔══██╗██╔══██║██║     ██║██╔══██║╚════██║");
        System.out.println("╚██████╔╝██║  ██║██║  ██║╚██████╗██║██║  ██║███████║");
        System.out.println(" ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝╚═╝  ╚═╝╚══════╝");
    }
}

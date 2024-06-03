import java.util.ArrayList;
import java.util.Collections;

public class Juego {
    private MazoInicial mazo;
    private ArrayList<Jugador> jugadores;
    private Carta cartaMesa;

    public Juego(MazoInicial mazoInicial, ArrayList<Jugador> jugadores) {
        this.mazo = mazoInicial;
        this.jugadores = jugadores;
    }

    void repartirCartas() {
        for (Jugador jugador : jugadores) {
            for (int i = 0; i < 7; i++) {
                Carta carta = mazo.remove(0);
                jugador.agregarCarta(carta);
            }
        }
    }

    void iniciarJuego() {
        cartaMesa = mazo.remove(0);
        System.out.println("La carta inicial en la mesa es: " + cartaMesa);
    }
}


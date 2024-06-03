import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        MazoInicial mazoInicial = new MazoInicial();
        CartaTope cartaTope = new CartaTope();

        mazoInicial.crear();
        mazoInicial.barajear();

        Carta carta = mazoInicial.remove(0);
        cartaTope.agregarCarta(carta);
        cartaTope.mostrarCarta();
    }
}


import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        new Mazo();
        Mazo mazoInicial1 = new Mazo();
        Mazo cartaTope1 = new Mazo();
        mazoInicial1.crear();
        mazoInicial1.barajear();
        mazoInicial1.imprimirMazo();
        mazoInicial1.soltarCartaTope(cartaTope1);
        cartaTope1.imprimirMazo();
    }
}

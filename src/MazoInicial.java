import java.util.LinkedList;
import java.util.*;

enum ColorCarta{ R, G, B ,Y };

public class MazoInicial {
    private LinkedList<Carta> mazoInicial;

    public MazoInicial() {
        this.mazoInicial = crear();
    }

    public LinkedList<Carta> getMazoInicial() {
        return mazoInicial;
    }

    public void setMazoInicial(LinkedList<Carta> mazoInicial) {
        this.mazoInicial = mazoInicial;
    }

    public LinkedList<Carta> crear(){
        LinkedList<Carta> mazo = new LinkedList<Carta>();

        for (ColorCarta color : ColorCarta.values()) {
            mazo.add(new Numero(color.name().charAt(0), "0"));
            for (int numero = 1; numero <= 9; numero++) {
                mazo.add(new Numero(color.name().charAt(0), String.valueOf(numero)));
                mazo.add(new Numero(color.name().charAt(0), String.valueOf(numero)));
            }

            mazo.add(new Numero(color.name().charAt(0), "Toma 2"));
            mazo.add(new Numero(color.name().charAt(0), "Toma 2"));
            mazo.add(new Numero(color.name().charAt(0), "Reversa"));
            mazo.add(new Numero(color.name().charAt(0), "Reversa"));
            mazo.add(new Numero(color.name().charAt(0), "Saltar"));
            mazo.add(new Numero(color.name().charAt(0), "Saltar"));
        }

        for(int i = 0; i < 4; i ++){
            mazo.add(new Comodin("TomaCuatro"));
            mazo.add(new Comodin("CambiaColor"));
        }

        return mazo;
    }

    public void barajear(){
        int rand;
        
        for (int i = 0; i < mazoInicial.size(); i++) {
            rand = (int) Math.floor(Math.random()*108);
            Collections.swap(mazoInicial, i, rand);
        }
        
    }


}

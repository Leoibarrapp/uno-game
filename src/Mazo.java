import java.util.Collections;
import java.util.LinkedList;

enum ColorCarta{ R, G, B ,Y };

public class Mazo extends LinkedList<Carta> {
    LinkedList<Carta> mazo;

    public Mazo() {
    this.mazo = new LinkedList<>();}

    public LinkedList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(LinkedList<Carta> mazo) {
        this.mazo = mazo;
    }
    public LinkedList<Carta> crear(){


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
    public void imprimirMazo() {
        System.out.println("Mazo:");
        for (Carta carta : mazo) {
            System.out.println("  " + carta);
        }
    }
    public void barajear(){
        Collections.shuffle(this.mazo);

    }
    public void soltarCartaTope(Mazo destino) {
        if (mazo.isEmpty()) {
            throw new RuntimeException("No hay cartas en el mazo");
        }else {
        Carta carta = mazo.remove(0);
        destino.mazo.add(carta);
    }
    }

}

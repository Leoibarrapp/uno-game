import java.util.Collections;
import java.util.LinkedList;

enum ColorCarta{ R, G, B, Y };

public class Mazo {
    private LinkedList<Carta> mazo;

    public Mazo() {
        this.mazo = new LinkedList<>();
    }

    public LinkedList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(LinkedList<Carta> mazo) {
        this.mazo = mazo;
    }

    public Carta getTope() {
        return mazo.getFirst();
    }

    public LinkedList<Carta> crear(){

        for (ColorCarta color : ColorCarta.values()) {
            mazo.add(new Carta(color.name().charAt(0), "0"));

            for (int numero = 1; numero <= 9; numero++) {
                mazo.add(new Carta(color.name().charAt(0), String.valueOf(numero)));
                mazo.add(new Carta(color.name().charAt(0), String.valueOf(numero)));
            }

            mazo.add(new Carta(color.name().charAt(0), "CT2")); mazo.add(new Carta(color.name().charAt(0), "CT2"));
            mazo.add(new Carta(color.name().charAt(0), "R")); mazo.add(new Carta(color.name().charAt(0), "R"));
            mazo.add(new Carta(color.name().charAt(0), "S")); mazo.add(new Carta(color.name().charAt(0), "S"));

        }

        for(int i = 0; i < 4; i ++){
            mazo.add(new Carta('C', "CT4"));
            mazo.add(new Carta('C', "CC"));
        }

        return mazo;
    }

    public void barajear(){
        Collections.shuffle(this.mazo);
    }

    public void agregarCarta(Carta carta) {
        mazo.addFirst(carta);
    }

    public void eliminarCarta(Carta carta) {
        if (mazo.isEmpty()) {
            System.out.println("SE ACABARON");
        }
        else {
            mazo.remove(carta);
        }
    }

    public String toString() {
        String s = "[ ";

        for(int i = 0; i < mazo.size()-1; i++){
            s = s + mazo.get(i) + ", ";
        }

        return s + mazo.getLast() + " ] " + mazo.size();
    }
}
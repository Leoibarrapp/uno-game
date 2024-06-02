public class Numero extends Color {

    public Numero(char color, String tipo) {
        super(color, tipo);
    }

    public String toString(){
        return getColor() + " " + getTipo();
    }
}

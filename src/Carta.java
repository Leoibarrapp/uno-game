import org.w3c.dom.Text;

public abstract class Carta {
    private char color;
    private String tipo;

    public Carta(char color, String tipo) {
        this.tipo = tipo;
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public String getTipo() {
        return tipo;
    }

    public abstract boolean esJugable(Juego juego);

    public abstract void usar(Juego juego);

    public String toString() {
        String c = "";
        switch(color){
            case 'R':
                c = TextColor.RED;
                break;
            case 'G':
                c = TextColor.GREEN;
                break;
            case 'B':
                c = TextColor.BLUE;
                break;
            case 'Y':
                c = TextColor.YELLOW;
                break;
            case 'W':
                c = TextColor.GRAY;
                break;
        }

        return c + color + "-" + tipo + TextColor.RESET;
    }
}
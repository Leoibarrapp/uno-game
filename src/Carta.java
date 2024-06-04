

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

    public String toString() {
        String c = "";
        switch(color){
            case 'R':
                c = "\u001B[31m";
                break;
            case 'G':
                c = "\u001B[32m";
                break;
            case 'B':
                c = "\u001B[34m";
                break;
            case 'Y':
                c = "\u001B[33m";
                break;
            case 'C':
                c = "\u001B[37m";
                break;
        }

        return c + color + "_" + tipo + "\u001B[0m";
    }
}
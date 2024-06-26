public abstract class Carta {
    private final char color;
    private final String tipo;

    /**
     * constructor de la carta, es abstracta, solo sirve para instanciar sus hijos
     * @param color el color de la carta
     * @param tipo el tipo de la carta
     */
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


    /**
     * Sobreescribe toString para imprimir una Carta
     * @return el identificador de la carta con los colores correspondientes
     */
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
public class Numero extends Color {

    public Numero(char color, String tipo) {
        super(color, tipo);
    }



    public void usar(){
    }

    public String toString() {
        String c = "";
        switch(this.getColor()){
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

        return c + this.getColor() + " " + this.getTipo() + "\u001B[0m";
    }
}

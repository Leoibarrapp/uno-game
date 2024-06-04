public class CartaComodin extends Carta{

    public CartaComodin(char color, String tipo) {
        super(color, tipo);
    }

    public boolean esJugable(Juego juego) {
        return true;
    }

    public void usar(Juego juego) {
        juego.setColorActual('R');

        switch(this.getTipo()){
            case "CC":

                break;
            case "CT4":
                break;
        }

        System.out.println("\tSe ha cambiado el color a\u001B[31m ROJO\u001B[0m");

        juego.cambiarTurno();
    }

}
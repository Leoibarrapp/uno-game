public class Main {

    public static void main(String[] args) {

        MazoInicial mazoInicial = new MazoInicial();

        for(Carta cartas : mazoInicial.getMazoInicial()){
            System.out.println(cartas);
        }
    }
}

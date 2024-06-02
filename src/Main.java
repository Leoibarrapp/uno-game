

public class Main {

    public static void main(String[] args) {

        MazoInicial mazoInicial1 = new MazoInicial();
        for(Carta cartas : mazoInicial1.getMazoInicial()){
            mazoInicial1.barajear();
            System.out.println(cartas);
        }
    }
}

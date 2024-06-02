import java.util.LinkedList;
import java.util.*;

public class MazoInicial {
    private LinkedList<Carta> mazoInicial;
    
    public void barajear(){
        int rand;
        
        for (int i = 0; i < mazoInicial.size(); i++) {
            rand = (int) Math.floor(Math.random()*108);
            Collections.swap(mazoInicial, i, rand);
        }
        
    }
}

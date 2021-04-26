package Players;
import java.util.Random;

public class IA extends Player {

    public IA(String name,char X){
        super(name,X);
    }

    public int play(int ColNumber,String name) {
        Random random = new Random();
        int column;
        column = 1+random.nextInt(ColNumber-1);
        return column;
    }
}

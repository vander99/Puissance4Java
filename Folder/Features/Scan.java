package Features;
import java.util.Scanner;

public class Scan {

    private Scanner scan = new Scanner(System.in);

    public String[] connection(int numPlayer){
        System.out.println("Joueur " + numPlayer + "?");
        String[] info = new String[2];
        info[0] = scan.next();
        info[1] = scan.next();
        return info;
    }
}

package Players;
import java.util.*;
import Features.*;

public class Human extends Player {

    private Errors errors = new Errors();
    private Scan scan = new Scan();
    private Scanner scanner = new Scanner(System.in);
    private int valide;
    private int column;

    public Human(String name,char X){
        super(name,X);
    }

    public int play(int colNumber) {
        valide = 0;                                         // Variable verification si le joueur a taper un numero correct
        while (valide == 0){
            try{
                column = scanner.nextInt();
                valide = errors.humanPlayerInvalide(column,colNumber);
            }
            catch(InputMismatchException e){
                System.out.println("Veuillez rentrer un nombre compris entre et ");
                scanner.nextLine();
            }
        }
        return column;
    }
}

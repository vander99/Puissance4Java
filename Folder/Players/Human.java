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

    public int play(int col_number,String name) {
        valide = 0;                                         // Variable verification si le joueur a taper un numero correct
        String colomnString;
        int column = 0;
        while (valide == 0){
            colomnString = scanner.next();
            if (colomnString.equals("sortir")){
                System.exit(0);
            }
            try{
                column = Integer.parseInt(colomnString);
                valide = errors.humanPlayerInvalide(column);
            }
            catch(NumberFormatException e){
                System.out.println("Erreur saisie colonne " + colomnString);
                scanner.nextLine();
            }
        }
        return column;
    }
}


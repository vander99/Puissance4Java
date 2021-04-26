package Features;
import Management.*;

public class Display {

    public Display(Grid grid) {
    }

    public void displayGrid(Grid grid) {
        // Parametre
        int lineNumber = grid.getLineNumber();
        int colNumber = grid.getColNumber();
        char[][] map = grid.getMap();

        //Boucle d'affichage
        System.out.println("1 " + "2 " + "3 " + "4 " + "5 " + "6 " + "7 ");
        for (int i = 0; i < lineNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void displayScore(int score1,int score2, int winner){
        System.out.println("Joueur " + winner + " gagne");
 //       System.out.println("Score : " + score1 + "- " + score2);
    }

    public void displayEquality(int score1,int score2){
        System.out.println("Egalite: "+score1+"- "+score2);
    }

}

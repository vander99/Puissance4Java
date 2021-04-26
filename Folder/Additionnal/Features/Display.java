package Features;
import Management.*;
import Players.*;

public class Display {

    public Display(Grid grid) {
    }

    public void displayGrid(Grid grid) {
        // Parametre
        int lineNumber = grid.getLineNumber();
        int colNumber = grid.getColNumber();
        char[][] map = grid.getMap();

        System.out.println();

        //Boucle d'affichage
        String numbers = "";
        for (int i=1;i<=grid.getColNumber();i++){
            numbers = numbers + i + " ";
        }
        System.out.println(numbers);
        for (int i = 0; i < lineNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println();
    }

    public void displayScore(Player [] players){
        String scoreMessage = "Score : ";
        for (int i=0; i<players.length;i++){
            scoreMessage = scoreMessage + players[i].getScore() + " - ";
        }
        StringBuffer remove = new StringBuffer(scoreMessage);
        remove.deleteCharAt(scoreMessage.length()-2);
        System.out.println(remove);
    }

    public void displayEquality(int score1,int score2){
        System.out.println("Egalite: "+score1+"- "+score2);
    }




}

package Management;
import java.io.*;
import Features.*;
import Players.*;

public class Round {
    private int Score1 = 0;
    private int Score2 = 0;
    private int column = 7;
    private int rows = 6;
    private char[][] matrix = new char[rows][column];
    private Grid grid = new Grid(rows, column,matrix);
    private Display display = new Display(grid);
    private int errorsCheck;
    private int endRound;
    private History histo = new History();


    public Round(Player [] players) {
    }

    public int beginRound(Player [] players,File history, int firstPlayer) {
        int playColumn;
        endRound = 0;
        while (endRound == 0) {
            for (int i = firstPlayer; i < players.length; i++) {
                firstPlayer = 0;
                errorsCheck = 0;
                int nbr = i + 1;
                display.displayGrid(grid);
                while (errorsCheck == 0){
                playColumn = players[i].play(column,players[i].getName());
                errorsCheck = grid.add(playColumn, nbr);
                histo.play(history,i+1,playColumn);}
                if (grid.equality()){
                    display.displayGrid(grid);
                    display.displayEquality(players[0].getScore(),players[1].getScore());
                    //i = players.length;
                    endRound++;
                    histo.equality(history);
                    histo.score(history,players[0].getScore(),players[1].getScore());
                    if (i == 0){
                        return 1;
                    }
                    else if (i == 1){
                        return 0;
                    }
                }
                else if (players[i].victory(grid,players[i].getX()) > 0){
                    players[i].winner();
                    display.displayGrid(grid);
                    display.displayScore(players[0].getScore(),players[1].getScore(),i+1);
                    histo.win(history,i+1);
                    histo.score(history,players[0].getScore(),players[1].getScore());
                    endRound++;
                    //i = players.length;
                    if (i == 0){
                        return 1;
                    }
                    else if (i == 1){
                        return 0;
                    }
                    return i+1;
                }
            }
        }
        return 0;
    }
}

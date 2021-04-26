package Management;
import java.io.*;
import Features.*;
import Players.*;

public class Round {
    private int score1 = 0;
    private int score2 = 0;
    private int colNumber = 9;
    private int lineNumber = 8;
    private char[][] matrix = new char[lineNumber][colNumber];
    private Grid grid = new Grid(lineNumber, colNumber,matrix);
    private Display display = new Display(grid);
    private int errorCheck;
    private int endRound;
    private History histo = new History();


    public Round(Player [] players) {
    }
    public void beginRound(Player [] players,File history) {
        int playColumn;
        endRound = 0;
        while (endRound == 0) {
            for (int i = 0; i < players.length; i++) {
                errorCheck = 0;
                int nbr = i + 1;
                display.displayGrid(grid);
                while (errorCheck == 0){
                playColumn = players[i].play(colNumber);
                errorCheck = grid.add(playColumn, players[i]);
                histo.play(history,i+1);}
                if (grid.equality()){
                    display.displayGrid(grid);
                    display.displayEquality(players[0].getScore(),players[1].getScore());
                    i = players.length;
                    endRound++;
                }
                else if (players[i].victory(grid,players[i].getX()) > 0){
                    players[i].winner();
                    display.displayGrid(grid);
                    display.displayScore(players);
                    histo.win(history,i+1);
                    histo.score(history,players);
                    endRound++;
                    i = players.length;
                }
            }
        }
    }
}

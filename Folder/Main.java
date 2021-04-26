import java.io.File;
import Players.*;
import Features.*;
import Management.*;


public class Main {

    public static void main(String[] args) {

        // Parametres

        int Score1 = 0;
        int Score2 = 0;
        int nbrPlayer = 2;
        int nbrVictory = 3;
        char[] chars = new char[nbrPlayer];
        Player[] players = new Player[2];
        chars[0]='x';
        chars[1]='o';
        int initialiser;
        Scan scan = new Scan();
        Errors errors = new Errors();
        History historyManagement = new History();
        File myhisto = historyManagement.create();
        historyManagement.fileNew(myhisto);

        // Initialisations des players

        for (int i=0;i<nbrPlayer;i++) {
            initialiser = 0;                                        // Variable de verification si le player a bien initialiser type et nom
            String[] info;

            while (initialiser == 0) {
                info = scan.connection(i+1);
                if (info[0].equals("humain")) {
                    Human player1 = new Human(info[1], chars[i]);
                    players[i] = player1;
                    historyManagement.players(myhisto,i+1,info[0],info[1]);
                    initialiser++;
                } else if (info[0].equals("ia")) {
                    IA player1 = new IA(info[1], chars[i]);
                    players[i] = player1;
                    historyManagement.players(myhisto,i+1,"ia",info[1]);
                    initialiser++;
                } else {
                    errors.connection(i+1);
                }
            }
        }

        // Gestion de la partie

        boolean endGame = true;
        int firstPlayer = 0;
        while (endGame) {
            historyManagement.startRound(myhisto);
            Round game = new Round(players);
            firstPlayer = game.beginRound(players,myhisto,firstPlayer);
            if (players[0].getScore() + players[1].getScore() >= 3){
                endGame = false;
            }
        }

        // Fin de la partie

        historyManagement.end(myhisto);
    }
}

import java.io.File;
import Players.*;
import Features.*;
import Management.*;


public class Main {

    public static void main(String[] args) {

        // Parametres

        int nbrPlayer = 3;
        int nbrVictory = 5;
        char[] chars = new char[nbrPlayer];
        Player[] players = new Player[nbrPlayer];
        chars[0]='X';
        chars[1]='O';
        int initialiser;
        Scan scan = new Scan();
        Errors errors = new Errors();
        History historyManagement = new History();
        File myHisto = historyManagement.create();
        historyManagement.fileNew(myHisto);


        // Initialisation des caracteres pour nbrplayer > 2

        if (nbrPlayer > 2){
            for (int i=2;i<nbrPlayer;i++){
                chars[i] = ((char) (chars[i-1] +1));
            }
        }

        // Initialisations des players

        for (int i=0;i<nbrPlayer;i++) {
            initialiser = 0;                                        // Variable de verification si le player a bien initialiser type et nom
            String[] info;

            while (initialiser == 0) {
                info = scan.connection(i+1);
                if (info[0].equals("humain")) {
                    Human player1 = new Human(info[1], chars[i]);
                    players[i] = player1;
                    historyManagement.players(myHisto,i+1,info[0],info[1]);
                    initialiser++;
                } else if (info[0].equals("ia")) {
                    IA player1 = new IA(info[1], chars[i]);
                    players[i] = player1;
                    historyManagement.players(myHisto,i+1,"IA",info[1]);
                    initialiser++; 
                } else if (info[0].equals("IntelligentIA")) {
                    IA player1 = new IA(info[1], chars[i]);
                    players[i] = player1;
                    historyManagement.players(myHisto,i+1,"IA",info[1]);
                    initialiser++;
                } else {
                    errors.connection();
                }
            }
        }

        // Gestion de la partie

        boolean endGame = true;
        while (endGame) {
            historyManagement.startRound(myHisto);
            Round game = new Round(players);
            game.beginRound(players,myHisto);
            for (int i=0;i<nbrPlayer;i++){
                if (players[i].getScore() >= nbrVictory){
                    endGame = false;
                }
            }
        }

        // Fin de la partie

        historyManagement.end(myHisto);
        System.out.println("Partie finie");
    }
}

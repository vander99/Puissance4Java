package Players;
import Management.*;

public abstract class Player {

    private String name;
    private char X;
    private int score;
    private int N=4;                        // namebre de points alignés pour avoir une victoire
    //constructeur
    public Player(String name, char X) {
        this.name = name;
        this.X = X;
        this.score = 0;
    }

    public String getName(){
        return this.name;
    }


    public char getX(){
        return this.X;
    }

    public int getScore(){
        return this.score;
    }
    public void winner(){
        this.score++;
    }

    public int victory(Grid grid,char sign){
        int nbr=0;
        int N = 4;                                       // namebre de points alignés
        int lineNumber = grid.getLineNumber();
        int colNumber = grid.getColNumber();
        nbr = nbr+grid.funcVictory(sign,0,0,N-1,0,grid,1);        // Verticale
        nbr = nbr+grid.funcVictory(sign,0,0,0,N-1,grid,1);      // Horizentale
        nbr = nbr+grid.funcVictory(sign,0,0,N-1,N-1,grid,1);   // 1ere diagonale
        nbr = nbr+grid.funcVictory(sign,N-1,0,N-1,N-1,grid,-1);    // 2eme diagonale
        return nbr;
    }

    public abstract int play(int colNumber,String name);

}

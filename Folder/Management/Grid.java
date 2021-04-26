package Management;
import Features.*;

public class Grid {

    //Atributs
    private int colNumber;
    private int lineNumber;
    private char[][] map;
    private Errors errors = new Errors();
    private int checkerrors;
    //Grille

    public Grid(int lineNumber, int colNumber, char[][] map) {
        this.colNumber = colNumber;
        this.lineNumber = lineNumber;
        this.map = map;

        //Initialisation de la grille
        for (int i = 0; i < lineNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                map[i][j] = '.';
            }
        }
    }

    // Recuperer des infos par rapport aux données de la grille
    public int getLineNumber() {
        return lineNumber;
    }

    public int getColNumber() {
        return colNumber;
    }

    public char[][] getMap() {
        return map;
    }

    // Ajout d'élement dans la grille

    public int add(int rawCol, int player) {
        checkerrors = errors.checkColumn(rawCol,map);                     // Variable verification erreur grille pleine
        if (checkerrors == 0){
            return checkerrors;
        }
        int i = 1;
        while (i < lineNumber+1) {
            if (player == 1 && map[lineNumber-i][rawCol-1] == '.') {
                map[lineNumber-i][rawCol-1] = 'x';
                break;
            }
            if (player == 2 && map[lineNumber-i][rawCol-1] == '.') {
                map[lineNumber-i][rawCol-1] = 'o';
                break;
            }
            i++;
        }
        return 1;

    }

    /* FuncVictoire a pour principe de prendre une partie de la grille, est comparé chaque point de cette partie avec N elements en dessous (verticale)
    à droite (horizentale) en dessous selon x et y (1ére diagonale) et en dessus selon x et y (2éme diagonale). Cette fonction prends 7 arguments:
    sign: qui est 'X' ou '0'
    beginx: Le begin de la partie de la grille ou l'on va commencer selon x
    beginy: le begin de la partie de la grille ou l'on va commencer selon y
    checkLine: avec combien d'element on va comparer chaque points selon x
    checkColumn: avec combien d'element on va comparer chaque points selon y
    grille: Notre grille
    incrementation: on monte ou dessends dans la grille (pour x), ou on pars vers la droite ou vers la gauche (pour y)
    Cette fonction retourne un int, ce choix est du au fait qu'on va l'appeler 4 fois, (on aurait aussi put utiliser un boolean avec des || )
     */
    public int funcVictory(char sign,int beginX,int beginY,int checkLine,int checkColumn,Grid grid,int incrementation){
        int N=4;
        int nbr=0;
        boolean v;
        for (int x=0;x<lineNumber-checkLine;x++){
            for (int y=0;y<colNumber-checkColumn;y++){
                int i=0;
                int j=0;
                v = true;
                while(Math.abs(i)<N && j<N){
                    if ((map[x+beginX][y+beginY] != map[x+i+beginX][y+j+beginY]) || (map[x+beginX][y+beginY]!=sign))
                        v = false;
                    if (checkLine != 0){
                        if (incrementation>0){ i++;}                                                 // Gerer le cas de la diagonale 2 il faut decrementer x
                        if (incrementation<0){i--;}
                    }
                    if (checkColumn != 0){
                        j++;
                    }
                }
                if (v){
                    nbr++;
                }
            }
        }
        return nbr;                             // Ce nombre est le nombre de fois ou 4 caractere sont alignés
    }

    public boolean equality(){
        boolean v = true;
        for(int i = 0;i<lineNumber;i++){
            for (int j = 0;j<colNumber;j++){
                if (map[i][j] == '.'){
                    v = false;
                }
            }
        }
        return v;
    }


}

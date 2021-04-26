package Players;
import Management.Grid;
import java.util.Random;

// Cette IA met une case dans l'endroit ou il y a le plus de nombre de cases consecutifs

public class IntelligentIA extends Players {

    public IntelligentIA(String name, char X) {
        super(name, X);
    }

    public int IACheckPossibility(Grid grid){
        // Parametre de la grille
        int colNumber = grid.getColNumber();
        int lineNumber = grid.getLineNumber();
        char[][] map = grid.getMap();

        // nbr est le nombre de case consecutif similaire
        int nbr = 0;
        int newL = 0;
        Random random = new Random();
        int newC = 1+random.nextInt(colNumber-1);
        int num;
        // Check Verticale
        for (int col = 0;col < colNumber;col++){
            num = 0;
            for (int line = lineNumber-1;line > 0; line--){
                 if ((map[line][col] == map[line-1][col]) && (map[line-1][col] != '.' )) {
                    num++;
                }
                else{
                    if (map[line-1][col] == '.'){
                        if (num > nbr){
                            nbr = num;
                            newL = line-1;
                            newC = col;
                        }
                    }
                    else{
                        num = 0;
                    }
                }
            }
        }
        // Check Horizentale à droite
        for (int line = lineNumber-1;line>0;line--){
            num = 0;
            for (int col = 0;col < colNumber-1;col++){
                if ((map[line][col] == map[line][col+1]) && (map[line][col+1] != '.')){
                    num++;
                }
                else{
                    if (map[line][col+1]=='.'){
                        if (num>nbr){
                            nbr = num;
                            newL = line;
                            newC = col+1;
                        }
                    }
                    else{num=0;}
                }
            }
        }
        // Check Horizentale à gauche
        for (int line = lineNumber-1;line>0;line--){
            num = 0;
            for (int col = 1;col < colNumber;col++){
                if ((map[line][col] == map[line][col-1]) && (map[line][col-1] != '.')){
                    num++;
                }
                else{
                    if (map[line][col-1]=='.'){
                        if (num>nbr){
                            nbr = num;
                            newL = line;
                            newC = col-1;
                        }
                    }
                    else{num=0;}
                }
            }
        }
        // Check diagonale 1
        int i=1;
        int N=4;            // Nombre de case similaire pour avoir une victoire
        for (int line = lineNumber;line > lineNumber-N+1;line--){
            for (int col=0;col<N;col++) {
                num = 0;
                while (i < 4) {
                    if ((map[line - i][col + i - 1] == map[line - i][col + i]) && (map[line-i][col+i]!='.')){
                        num++;
                    } else if (map[line - i][col + i] == '.') {
                        if (num > nbr) {
                            nbr = num;
                            newL = line;
                            newC = col + i;
                        }
                    }
                    i++;
                }
            }
        }


        // Check diagonale +1
        i = 1;
        for (int line=0;line<N;line++) {
            num = 0;
            for (int col = 0; col < N; col++) {
                while (i < 4) {
                    if (map[line + i - 1][col + i - 1] == map[line + i][col + i]) {
                        num++;
                    }
                    if (map[line + i][col + i] == '.') {
                        if (num > nbr) {
                            nbr = num;
                            newL = line;
                            newC = col + i;
                        }
                    }
                    i++;
                }
            }
        }

        System.out.println("Ligne : " + newL + "\n Colonne : " + newC);
        return newC+1;
    }

    public int jouer(int colNumber,Grid grid){
        int colomn = IACheckPossibilité(grid);
        return colomn;
    }
}
package Features;

public class Errors {


    public void connection(int playerNum){
        System.out.println("Erreur saisie Joueur " + playerNum);
    }

    public int humanPlayerInvalide(int column)
    {
        if (column>7 || column<1){
            System.out.println("Erreur colonne non valide " + column);
            return 0;}
        else {
            return 1;
        }
    }

    public int checkColumn(int rawCol,char[][] map){
        if (map[0][rawCol-1] != '.'){
            System.out.println("Erreur colonne pleine " + rawCol);
            return 0;
        }
        else{
            return 1;
        }
    }
}

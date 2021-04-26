package Features;

public class Errors {


    public void connection(){
        System.out.println("Joueur incorrect, veuillez choisir: humain Name ou IA Name!");
    }

    public int humanPlayerInvalide(int column,int colNumber)
    {
        if (column>colNumber){
            System.out.println("Colonne invalide vous pouvez rejouer!");
            return 0;
          }
        else {
            return 1;
        }
    }

    public int checkColumn(int rawCol,char[][] map){
        if (map[0][rawCol-1] != '.'){
            System.out.println("Grille pleine, veuillez rejouer!");
            return 0;
        }
        else{
            return 1;
        }
    }
}

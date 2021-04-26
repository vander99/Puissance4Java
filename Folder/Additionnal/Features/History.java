package Features;
import java.io.*;
import Players.*;

public class History{

    public File create(){
        File file = new File("log.txt");
            try{
                file.createNewFile();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        return file;
    }

    public void fileNew(File file){
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("Erreur!");
        }
    }

    public void play(File file, int i){
        try {
            FileWriter myWriter = new FileWriter(file,true);
            myWriter.write("Joueur " + i + " joue" + "\n");
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("Erreur!");
        }
    }

    public void players(File file, int i,String type,String name){
        try {
            FileWriter myWriter = new FileWriter(file,true);
            myWriter.write("Joueur " + i + " est " + type + " " + name + "\n");
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("Erreur!");
        }
    }

    public void startRound(File file){
        try {
            FileWriter myWriter = new FileWriter(file,true);
            myWriter.write("Manche commence" + "\n");
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("Erreur!");
        }
    }

    public void win(File file,int i){
        try {
            FileWriter myWriter = new FileWriter(file,true);
            myWriter.write("Joueur " + i + " gagne " + "\n");
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("Erreur!");
        }
    }

    public void score(File file,Player [] players){
        try {
            FileWriter myWriter = new FileWriter(file,true);
            // The message
            String scoreMessage = "Score : ";
            for (int i=0; i<players.length;i++){
                scoreMessage = scoreMessage + players[i].getScore() + " - ";
            }
            StringBuffer remove = new StringBuffer(scoreMessage);
            remove.deleteCharAt(scoreMessage.length()-2);
            myWriter.write(String.valueOf(remove) + "\n");
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("Erreur!");
        }
    }

    public void end(File file){
        try {
            FileWriter myWriter = new FileWriter(file,true);
            myWriter.write("Partie finie\n");
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("Erreur!");
        }
    }

    public void equality(File file){
        try {
            FileWriter myWriter = new FileWriter(file,true);
            myWriter.write("Egalite " + "\n");
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("Erreur!");
        }
    }


}

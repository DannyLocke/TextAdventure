import java.io.IOException;
import java.util.Scanner;

/**
 * Created by dlocke on 11/16/16.
 */
public class Game {

    public static Scanner scanner = new Scanner(System.in);
    public static Player player = new Player();

    public static void main(String[] args) throws Exception{
        System.out.println("Welcome, traveler.");

        //TRY CATCH TO START OR LOAD NEW GAME
        try{
            player = Player.loadGame();
            System.out.println("Loaded saved game");
        } catch (Exception e){
            System.out.println("Starting new game");
        }

        if(player.getName() == null){
            player.chooseName();
        }
        if(player.getWeapon() == null){
            player.chooseWeapon();
        }
        if(player.getLocation() == null){
            player.chooseLocation();
        }

        Enemy ogre = new Enemy("Ogre", 10, 10);
        player.battle(ogre);

        if(player.getItems().isEmpty()) {
            player.findItem("shield");
            player.findItem("boots");
            player.findItem("belt");
        }

        while(true){
            nextLine();
        }

    } //end main()


    public static String nextLine(){
        String line = scanner.nextLine();
        while (line.startsWith("/")) {
            switch(line){
                case "/inv":
                    for(String item : player.getItems()){
                        System.out.println(item);
                    }
                    break;
                case "/exit":
                    System.exit(0);
                    break;

                case "/weapon":
                    System.out.println(player.getWeapon());
                    break;

                case "/save":
                    try {
                        Player.saveGame(player);
                        System.out.println("Saved game.");
                    } catch (IOException e) {
                        e.printStackTrace(); //exception: tell us where the error is located, but not stop program
                    }
                    break;

                default:
                    System.out.println("Command not found");
                    break;
            }

            line = scanner.nextLine();
        }
        return line;
    }

}

/**
 * Created by dlocke on 11/22/16.
 */
public class Character {
    String name;
    int health;
    int damage;

    public void battle(Character opponent){
        System.out.printf("%s appears!\n", opponent.name);

        System.out.printf("%s's health: %d\n", name, health);
        System.out.printf("%s's health: %d\n", opponent.name, opponent.health);

        while(health > 0 && opponent.health > 0){
            health -= opponent.damage;
            opponent.health -= damage;

            System.out.printf("%s's health: %d\n", name, health);
            System.out.printf("%s's health: %d\n", opponent.name, opponent.health);


        } //end while loop

        String message = "%s has died. \n";
        if(health <= 0){
            System.out.printf(message, name);
        }

        if(opponent.health <= 0){
            System.out.printf(message, opponent.name);
        }

    } //end battle()

}

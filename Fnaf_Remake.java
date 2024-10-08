//Toolbox for functionality
import java.util.Random;
import java.util.Scanner;

public class Fnaf_Remake {
  
  //Main function for main menu
    public static void main(String[] args) {
      
      //Introduces scanner
      Scanner scanner = new Scanner(System.in);
      
      //Initialize player's choice
      int choice = 0;
      
      //Initialize game status to be over (since game hasn't started yet)
      boolean gameOver = true;
      
      
      // Display welcome screen
      System.out.println("Five Nights at Freddy's (simple java edition)");

      //Continuously running while loop for main menu
      while (true) {
        System.out.println("Press '1' for easy mode\nPress '2' for hard mode\nPress '3' to exit");
        choice = scanner.nextInt();

        //If player chooses to play easy mode
        if (choice == 1) {

          //Tell the player they have selected easy mode
          System.out.println("You have selected easy mode...\n");

          //Calls Easygame method and updates gameOver based on the result
          gameOver = Easygame(scanner); 
          
          // Display welcome screen once more (if the game has ended)
          if (gameOver) {
            System.out.println("Welcome to Five Nights at Freddy's (simple java edition)");
          }
              
        }

        //If player chooses to play hard mode
        else if (choice == 2) {
          
          //Tell the player they have selected hard mode
          System.out.println("You have selected hard mode...\n");

          //Calls Hardgame method and updates gameOver based on the result
          gameOver = Hardgame(scanner); 
          
          // Display welcome screen once more (if the game has ended)
          if (gameOver) {
            System.out.println("Welcome to Five Nights at Freddy's (simple java edition)");
          }
        }

        //If player chooses to exit
        else if (choice == 3){

          //Tell the player goodbye
          System.out.println("Goodbye...");

          //Terminate the program
          break;
        }

        //If the player doesn't enter a valid input
        else {
          System.out.println("Error... try again");
          System.out.println("Five Nights at Freddy's (simple java edition)");
        }
      }
    }
    
    //Easy mode game function
    private static boolean Easygame(Scanner scanner) {
      //Declares random number generator
      Random random = new Random();
      
      // Doors 1 through 5
      int animatronicDoor = random.nextInt(5) + 1; 
        
        // Night starts at 12:00 A.M.
        int hour = 12; 

        // Player starts with 100% power
        int power = 100;
        
        //Explain game
        System.out.println("There are 5 doors and Freddy is behind one of those doors... find him before 6AM or he will find you!");

        //While loop that runs until 6AM
        while (hour < 18) { 
          
            //Separate hour integer to account for 24 hour format
            int displayHour = hour % 12;
            
            //If the displayHour int is 0 it represents 12 AM
            if (displayHour == 0) {
                displayHour = 12;
            }
            
            //Displays player stats throughout each round
            System.out.println("\n" + displayHour + " A.M.");
            System.out.println("Power left: " + power);
            System.out.print("Enter a door number to check for Freddy (1-5): ");
            
            //Scaning player's guess
            int choice = scanner.nextInt();

            // If the user doesn't enter a valid number
            if (choice < 1 || choice > 5) {
              
              //Let player know they entered an invalid choice
              System.out.println("Error!! Choose a door number between 1 and 5.");
              
            } 
            // If the user picks the correct door (with Freddy in it)
            else if (choice == animatronicDoor) {
              
              //Tell the player what the correct guess and let them know they won
              System.out.println("You found Freddy!! He was behind door " + choice + ". You survived!\n" + "Entering main menu...\n");
                
              //The game ends
              return true; 
              
            } 
            // If the user doesn't pick the correct door
            else {
              
              //Tell player that their guess was incorrect
              System.out.println("Freddy was not behind door " + choice);
              
              // Move the animatronic to a different door by re-initializing animatronic position
              animatronicDoor = random.nextInt(5) + 1;

              // Another hour goes by
              hour++;
                 
              // Reduce power by a random amount (15 - 30)
              int powerReduction = random.nextInt(16) + 15; 
              power -= powerReduction;
                
              // If the power is less than or equal to 0 the game is over
              if (power <= 0) {
                
                //Let the player know that they have lost because they run out of power
                System.out.println("You've run out of power!! Freddy has come out door " + animatronicDoor + " and killed you. Better luck next time! :)\n" + "Entering main menu...\n");
                
                // Game ends
                return true; 
              }
            }
        }
        
        //Let the player know that they have lost
        System.out.println("\n6 A.M.\n" + "Freddy has come out door " + animatronicDoor + " and killed you. Better luck next time! :)\n" + "Entering main menu...\n");
        
        //Game ends
        return true;
    }
    
    //Hard mode game function
    private static boolean Hardgame(Scanner scanner) {
        //Declares random number generator
        Random random = new Random();
        
        // Doors 1 through 8
        int animatronicDoor = random.nextInt(8) + 1; 
        
        // Night starts at 12:00 A.M.
        int hour = 12; 

        // Player starts with 100% power
        int power = 100;
        
        //Explain game
        System.out.println("There are 6 doors and Freddy is behind one of those doors... find him before 6AM or he will find you!");

        //While loop that runs until 6AM
        while (hour < 18) { 
          
            //Separate hour integer to account for 24 hour format
            int displayHour = hour % 12;
            
            //If the displayHour int is 0 it represents 12 AM
            if (displayHour == 0) {
                displayHour = 12;
            }
            
            //Displays player stats throughout each round
            System.out.println("\n" + displayHour + " A.M.");
            System.out.println("Power left: " + power);
            System.out.print("Enter a door number to check for Freddy (1-8): ");
            
            //Scaning player's guess
            int choice = scanner.nextInt();

            // If the user doesn't enter a valid number
            if (choice < 1 || choice > 8) {
              
              //Let player know they entered an invalid choice
              System.out.println("Error!! Choose a door number between 1 and 8.");
              
            } 
            // If the user picks the correct door (with Freddy in it)
            else if (choice == animatronicDoor) {
              
              //Tell the player what the correct guess and let them know they won
              System.out.println("You found Freddy!! He was behind door " + choice + ". You survived!\n" + "Entering main menu...\n");
                
              //The game ends
              return true; 
              
            } 
            // If the user doesn't pick the correct door
            else {
              
              //Tell player that their guess was incorrect
              System.out.println("Freddy was not behind door " + choice);
              
              // Move the animatronic to a different door by re-initializing animatronic position
              animatronicDoor = random.nextInt(8) + 1;

              // Another hour goes by
              hour++;
                 
              // Reduce power by a random amount (20 - 35)
              int powerReduction = random.nextInt(16) + 20; 
              power -= powerReduction;
                
              // If the power is less than or equal to 0 the game is over
              if (power <= 0) {
                
                //Let the player know that they have lost because they run out of power
                System.out.println("You've run out of power!! Freddy has come out door " + animatronicDoor + " and killed you. Better luck next time! :)\n" + "Entering main menu...\n");
                
                // Game ends
                return true; 
              }
            }
        }
        
        //Let the player know that they have lost
        System.out.println("\n6 A.M.\n" + "Freddy has come out door " + animatronicDoor + " and killed you. Better luck next time! :)\n" + "Entering main menu...\n");
        
        //Game ends
        return true;
    }
}

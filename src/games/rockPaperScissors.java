package games;

// Import the necessary libraries, Scanner for user input and random to generate the computer moves
import java.util.Random;
import java.util.Scanner;

public class rockPaperScissors {

    // Declare some variables
    String playerName;
    String playerMove;
    String computerMove;
    int score;

    // set up an instance of the class Scanner into myScanner in order to get keyboard data
    Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args){

        // Set up instance of rockPaperScissors class
        rockPaperScissors rps = new rockPaperScissors();
        rps.initialiseGame();
    }


    // Get player details like their name and then run the game
    private void initialiseGame(){
        System.out.println("Enter your name: ");

        //Store it in variable playerName
        playerName = myScanner.nextLine();
        playGame();
    }

    private void playGame(){

        // Get move from player
        System.out.println("Enter your move: ");
        playerMove = myScanner.nextLine();

        // Display name and move
        System.out.println(playerName + " has selected " + playerMove + " as their move");

        // call method generateComputerMove and store result of this method in string variable computerMove
        computerMove = generateComputerMove();

        // Call method getWinner with playerMove and computer move and store result of game in string result
        String result = getWinner(playerMove, computerMove);

        // Now we have the result, time to report back to the user
        // Look and see what result is and print out a line to the user the relevant
        // message depending whether it was win, loose or draw.
        // We also have a score, so if user has won, this will be incremented or decremented if
        // they had lost.
        if(result.equalsIgnoreCase("Win")){
            System.out.println("Congratulations, you won this round!");
            score++;
        }
        else if(result.equalsIgnoreCase("Lose")){
            System.out.println("You lost this round!");
            score--;
        }
        else {
            System.out.println("This round was a draw!");
        }

        // Best of 3 winning games. If score is between -3 and +3, keep playing. -3 means computer has
        // won best of 3, +3 means user has won best of 3
        if(score < 3 && score > -3){
            playGame();
        }
        // Because score is incremented when user wins, a +3 indicates the user has won 3 games.
        // Display congratulations message, else check if score is -3 then display loser message.
        else if(score == 3){
            System.out.println("Winner Winner!!");
        }
        else if(score == -3){
            System.out.println("You Looooooosssseeeee!");
        }
// That's the end of that!
    }

    private String generateComputerMove() {
        // Produce random number...
        Random r = new Random();
        // Declare empty string move
        String move = "";

        // ...between 0 and 2 (3 includes 0, 1 and 2)
        int i = r.nextInt(3);

        // Switch case - computer has chosen it's move through random selection
        // now to assign random number to a random action.
        // If random number is 0, move will be Rock. If random number is 1,
        // move will be Paper and if random number is 2, move will be Scissors.
        switch(i){
            case 0:
                move = "Rock";
                break;

            case 1:
                move = "Paper";
                break;

            case 2:
                move = "Scissors";
                break;
        }
        // Return value from method
        return move;
    }

    private String getWinner(String playerMove, String computerMove){

        //Declare empty string
        String outcome = "";

        // Here comes nested if statements

        // If player has selected rock then see what computer has selected and outcome is assigned with
        // result of game. If computer has chosen rock its a draw, paper then player has lost,
        // or scissors then player has won. Thats only if player has chosen rock, if not we move on
        if(playerMove.equalsIgnoreCase("rock")){
            if(computerMove.equalsIgnoreCase("rock")){
                outcome = "Draw";
            }
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Lose";
            }
            else{
                outcome = "Win";
            }
        }

        // If player has chosen paper, again check what computer has chosen and assign outcome with
        // result of game
        if(playerMove.equalsIgnoreCase("paper")){
            if(computerMove.equalsIgnoreCase("rock")){
                outcome = "Win";
            }
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Draw";
            }
            else{
                outcome = "Lose";
            }
        }

        // Ditto with scissors
        // Ignore case means ignore whether the user has entered capital or LOWERCASE letters. Not relevant
        // and will cause problems without this
        if(playerMove.equalsIgnoreCase("scissors")){
            if(computerMove.equalsIgnoreCase("rock")){
                outcome = "Lose";
            }
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Win";
            }
            else{
                outcome = "Draw";
            }
        }


        // Finally return outcome from method
        return outcome;
    }
}

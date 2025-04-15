import java.util.Scanner;

public class HighScoreWins {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the name of The home team: ");
        String team1 = keyboard.nextLine();
        
        System.out.println("Enter the name of The away team: ");
        String team2 = keyboard.nextLine();

        System.out.println("What was the score of the home team:");
        int score1 = keyboard.nextInt();

        System.out.println("What was the score of the away team:");
        int score2 = keyboard.nextInt();

        if (score1 > score2) {
            System.out.println("The winner is: " + team1);
        } else if (score2 > score1) {
            System.out.println("The winner is: " + team2);
        } else {
            System.out.println("It's a tie between " + team1 + " and " + team2 + "!");
        }



    }

}
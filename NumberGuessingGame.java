import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Random random = new Random();

        int score = 0;
        String playAgain;

        System.out.println("\n------ Welcome to \"GUESS THE NUMBER\" Game -------");

        try (Scanner sc = new Scanner(System.in)) {

            do {
            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nI have chosen a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                System.out.print("\nAttempt " + attempt + ": Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;

                    // Higher score for fewer attempts
                    score += (maxAttempts - attempt + 1);
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Your Guess is Too Low!");
                } else {
                    System.out.println("Your Guess is Too High!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou've used all attempts!");
                System.out.println("The correct number was: " + numberToGuess);
            }

            System.out.println("Current Score: " + score);

                System.out.print("\nDo you want to play another round? (yes/no): ");
                playAgain = sc.next();

            } while (playAgain.equalsIgnoreCase("yes"));

            System.out.println("\n===== GAME OVER =====");
            System.out.println("Final Score: " + score);
            System.out.println("Thank you for playing!");
        }
    }
}

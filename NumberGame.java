import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int lower = 1;
        int upper = 100;
        int maxAttempts = 7;
        int score = 0;

        System.out.println("Welcome to the Number Game!");
        System.out.println("Guess the number between " + lower + " and " + upper);

        do {
            int target = random.nextInt(upper - lower + 1) + lower;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("New round! You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess;
                try {
                    userGuess = sc.nextInt();
                    sc.nextLine(); // Consume newline character
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    sc.nextLine(); // Clear input buffer
                    continue;
                }
                attempts++;

                if (userGuess == target) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < target) {
                    System.out.println("The number is greater than " + userGuess + ". Try again!");
                } else {
                    System.out.println("The number is less than " + userGuess + ". Try again!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! The correct number was: " + target);
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
        } while (sc.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your final score: " + score);
    }
}

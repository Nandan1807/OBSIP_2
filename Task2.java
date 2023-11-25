import java.util.Random;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberOfAttempts = 10; // You can adjust this as needed
        int score = 0;

        System.out.println("*****************************************");
        System.out.println("* Welcome to the Number Guessing Game!  *");
        System.out.println("*****************************************");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound);

        while (true) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("*****************************************");

            for (int attempts = 1; attempts <= numberOfAttempts; attempts++) {
                System.out.print("Enter your guess (Attempt " + attempts + "/" + numberOfAttempts + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += calculateScore(attempts, numberOfAttempts);
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try again! The number is higher.");
                } else {
                    System.out.println("Try again! The number is lower.");
                }

                if (attempts == numberOfAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
                }
            }

            System.out.println("*****************************************");
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your total score is: " + score);
                break;
            }
        }

        scanner.close();
    }

    private static int calculateScore(int attempts, int maxAttempts) {
        // Give more points for fewer attempts
        return (maxAttempts - attempts + 1) * 10;
    }
}

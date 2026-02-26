import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int number = random.nextInt(100)+1;
        int maxAttempts = 10;
        int attempt = 0;
        boolean guessedCorrectly = false;

        System.out.println ("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100");
        System.out.println("you have only "+ maxAttempts+" attempts.\n");
        while (attempt < maxAttempts){
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempt++;

            if(guess == number){
            System.out.println("Congrarulations! you guessed the correct number.");
            System.out.println("Attempts taken:" + attempt);
            guessedCorrectly = true;
            break;
            }
            else if (guess>number){
                System.out.println("Too High!");
            }
            else{
                System.out.println("Too Low!");
            }
            System.out.println("Remaining attempts:"+(maxAttempts - attempt));
            System.out.println();
            }
           
            if (!guessedCorrectly){
                System.out.println("you have easd all attempts.");
                System.out.println("Thecorrect number was:"+number);
             }

             scanner.close();
            }
        }

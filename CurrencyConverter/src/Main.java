import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Base Currency (USD): ");
        String base = scanner.nextLine();

        System.out.print("Enter Target Currency (INR): ");
        String target = scanner.nextLine();

        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();

        double  rate = 90.0;

        double result = amount * rate;

        System.out.println("Conversion Amount: " + result + "" + target);
    }
}
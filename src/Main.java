import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static int max = 2;
    public static int min = 0;
    public static int score = 0;
    public static int tries = 0;

    public static Random random = new Random();
    public static int randomNum = random.nextInt((max - min + 1) - min);

    public static void main(String[] args) {
        System.out.println("Holla!");

        guess();
    }

    public static void guess() {
        if (tries > 0) {
            clear();
        }
        System.out.print("Guess a number: ");
        Scanner scanGuess = new Scanner(System.in);
        int guessNum = scanGuess.nextInt();
        tries++;

        if (guessNum == randomNum) {
            System.out.println("Correct!");
            score++;
            System.out.println("Your score is: " + score);

            System.out.println("\nDo you want to try again? (Y/N)");
            Scanner scanOpp = new Scanner(System.in);
            String tryOpp = scanOpp.nextLine();
            if (tryOpp.equals("Y") || tryOpp.equals("y")) {
                /*String[] call = {"call"};
                Main.main(call);*/
                System.out.println("\n\n");
                guess();
            } else if (tryOpp.equals("N") || tryOpp.equals("n")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid input! Better luck next time.");
            }

        } else {
            System.out.println("Wrong! The answer is: " + randomNum);
            System.out.println("Your score is: " + score);

            System.out.println("\n\nDo you want to try again (Y/N): ");
            Scanner scanOpp = new Scanner(System.in);
            String tryOpp = scanOpp.nextLine();
            if (tryOpp.equals("Y") || tryOpp.equals("y")) {
                String[] call = {"call"};
                guess();
            } else if (tryOpp.equals("N") || tryOpp.equals("n")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid input! Better luck next time.");
            }
        }
    }

    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
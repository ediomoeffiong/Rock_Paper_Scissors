import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static int yourScore = 0;
    public static int compScore = 0;
    public static int r;
    public static String[] list = {"rock", "paper", "scissors"};

    public static void main(String[] args) {
        Random random = new Random();
        r = random.nextInt(3);

        System.out.print("Rock, Paper or Scissors: ");
        Scanner scanChoice = new Scanner(System.in);
        String choice = scanChoice.nextLine();

        System.out.println("\n");

        String lower = choice.toLowerCase();

        for (int i = 0; i < 3; i++) {
            switch (lower) {
                case "rock":
                    if (list[r].equals("rock")) {
                        playAgain("draw");

                    } else if (list[r].equals("scissors")) {
                        playAgain("won");
                    } else {
                        playAgain("lost");
                    }
                    break;
                case "paper":
                    if (list[r].equals("rock")) {
                        playAgain("won");

                    } else if (list[r].equals("scissors")) {
                        playAgain("lost");
                    } else {
                        playAgain("draw");
                    }
                    break;
                case "scissors":
                    if (list[r].equals("rock")) {
                        playAgain("lost");

                    } else if (list[r].equals("scissors")) {
                        playAgain("draw");
                    } else {
                        playAgain("won");
                    }
                    break;
                default:
                    playAgain("draw");
                    break;
            }
        }
    }

    public static void playAgain(String status) {
        if (status.equals("won")) {
            yourScore++;
            System.out.println("I chose " + list[r] + ", you won");
        } else if (status.equals("draw")) {
            System.out.println("I chose " + list[r] + ", it's a draw");
        } else if (status.equals("lost")) {
            compScore++;
            System.out.println("I chose " + list[r] + ", you lost");
        } else if (status.equals("end")) {
            System.exit(0);
        } else {
            System.out.println("\n");
        }

        System.out.println("Your score is " + yourScore);
        System.out.println("My score is " + compScore);
        System.out.println("\n");
        System.out.print("Do you want to play again (Y/N): ");
        Scanner scanPlay = new Scanner(System.in);
        String play = scanPlay.nextLine();

        if (play.equals("Y") || play.equals("y")) {
            System.out.println("\n");
            String[] call = {"call"};
            Main.main(call);
        } else if (play.equals("N") || play.equals("n")) {
            if (yourScore > compScore) {
                System.out.println("You are the final winner. Good job!");
            } else if (compScore > yourScore) {
                System.out.println("Oops! I'm the final winner. Hurray!");
            } else {
                System.out.println("Oops! It's a draw and none of us wins. Sighs!");
                playAgain("end");
            }
        } else {
            System.out.println("Wrong input!");
            playAgain("blank");
        }

    }

}
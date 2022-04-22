package bullscows;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Grader grader = null;
        while (grader == null) {
            try {
                grader = generateGrader();
            } catch (WrongSizeException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(grader.getInitialMsg());
        System.out.println("Okay, let's start a game!");
        int counter = 1;
        while (true) {
            System.out.println("Turn " + counter + ":");
            String guess = scanner.nextLine();
            counter++;
            if (grader.grade(guess)) {
                System.out.println("Congratulations! You guessed the secret code.");
                return;
            }
        }
    }

    static RandomGenerator getRandomNumber() throws WrongSizeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.println("Input the number of possible symbols in the code:");
        int numSymbols = Integer.parseInt(scanner.nextLine());
        return new RandomGenerator(size, numSymbols);
    }


    private static Grader generateGrader() throws WrongSizeException {
        RandomGenerator randomGenerator = getRandomNumber();
        Grader grader = new Grader(randomGenerator.generate(), randomGenerator.getRange());
        return grader;
    }
}

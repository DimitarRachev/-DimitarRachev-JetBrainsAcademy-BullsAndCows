package bullscows;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Grader grader = getGrader();
        System.out.println(grader.getInitialMsg());
        System.out.println("Okay, let's start a game!");
        int counter = 1;
        while (true) {
            System.out.println("Turn " + counter + ":");
            String guess = scanner.nextLine();
            counter++;
            try {
                if (grader.grade(guess)) {
                    System.out.println("Congratulations! You guessed the secret code.");
                    return;
                }
            } catch (WrongSizeException | InvalidCharactersExeption e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Grader getGrader() {
        Grader grader = null;
        while (grader == null) {
            try {
                grader = generateGrader();
            } catch (WrongSizeException | NotANumberException e) {
                System.out.println(e.getMessage());
                //TODO remove this unnecessary exit after completion of the game
                System.exit(0);
            }
        }
        return grader;
    }

    private static Grader generateGrader() throws WrongSizeException, NotANumberException {
        RandomGenerator randomGenerator = getRandomNumber();
        return new Grader(randomGenerator.generate(), randomGenerator.getRange(), randomGenerator.getValidSymbols());
    }

    static RandomGenerator getRandomNumber() throws WrongSizeException, NotANumberException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        String s = scanner.nextLine();
        int size;
        try {
            size = Integer.parseInt(s);
        } catch (Exception e) {
            throw new NotANumberException("Error: \"" + s + "\" isn't a valid number.");
        }
        System.out.println("Input the number of possible symbols in the code:");
        s = scanner.nextLine();
        int numSymbols;
        try {
            numSymbols = Integer.parseInt(s);
        } catch (Exception e) {
            throw new NotANumberException("Error: \"" + s + "\" isn't a valid number.");
        }
        return new RandomGenerator(size, numSymbols);
    }
}

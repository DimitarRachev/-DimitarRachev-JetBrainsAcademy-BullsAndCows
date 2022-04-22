package bullscows;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Grader grader = null;
        while (grader == null) {
            try {
                grader = generateGrader();
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Okay, let's start a game!");
        int counter = 1;
        while (true) {
            System.out.println("Turn "+counter+":");
            String guess = scanner.nextLine();
            counter++;
            if (grader.grade(guess)) {
                System.out.println("Congratulations! You guessed the secret code.");
                return;
            }
        }
    }
      static int getRandomNumber () {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please, enter the secret code's length:");
                RandomGenerator generator = new RandomGenerator(Integer.parseInt(scanner.nextLine()));
                return generator.generate();
            } catch (IllegalArgumentException e) {
               throw new IllegalArgumentException (e.getMessage());
            }
        }


    private static Grader generateGrader() {
        try {
            return new Grader(getRandomNumber());
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}

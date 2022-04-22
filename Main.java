package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Grader grader = generateGrader();
//        while (true) {
            int guess = Integer.parseInt(scanner.nextLine());
            if (grader.grade(guess)) {
//                return;
            }
//        }
    }

    private static Grader generateGrader() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(9000) + 1000;
        return new Grader(number);
    }
}

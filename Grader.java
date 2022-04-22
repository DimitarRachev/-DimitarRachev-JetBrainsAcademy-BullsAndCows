package bullscows;

public class Grader {
    int goal;
    String goalToString;

    public Grader(int goal) {
        this.goal = goal;
        goalToString = String.valueOf(goal);

    }

    public boolean grade(int guess) {
        if (guess == goal) {
            System.out.println("Grade: 4 bull(s) and 1 cow(s). The secret code is " + guess + ".");
            return true;
        }
        int bulls = 0;
        int cows = 0;
        String guessToString = String.valueOf(guess);
        for (int i = 0; i < guessToString.length(); i++) {
            if (guessToString.charAt(i) == goalToString.charAt(i)) {
                bulls++;
            } else if (goalToString.contains(String.valueOf(guessToString.charAt(i)))) {
                cows++;
            }
        }
        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None. The secret code is " + goal + ".");
        } else if (bulls == 0) {
            System.out.println("Grade:" + cows + " cow(s). The secret code is " + goal + ".");

        } else if (cows == 0) {
            System.out.println("Grade: " + bulls + " bull(s). The secret code is " + goal + ".");
        } else {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is " + goal + ".");
        }
        return false;
    }
}

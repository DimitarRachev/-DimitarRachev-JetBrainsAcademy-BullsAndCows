package bullscows;

public class Grader {
    int goal;
    String goalToString;

    public Grader(int goal) {
        this.goal = goal;
        goalToString = String.valueOf(goal);

    }

    public boolean grade(String guess) {
        getGrades(guess);
        return Integer.parseInt(guess) == goal;
    }

    private void getGrades(String guess) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == goalToString.charAt(i)) {
                bulls++;
            } else if (goalToString.contains(String.valueOf(guess.charAt(i)))) {
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
    }
}

package bullscows;

public class Grader {
    String goal;
    String range;


    public Grader(String goal, String range) {
        this.goal = goal;
        this.range = range;
    }

    public boolean grade(String guess) {
//        if (guess.length() != goal.length()) {
//            throw new WrongSizeException("You must enter" + goal.length() + "characters");
//        }
        getGrades(guess);
        return goal.equals(guess);
    }

    String getInitialMsg() {
        StringBuilder sb = new StringBuilder();
        sb.append("The secret is prepared: ");
        for (int i = 0; i < goal.length(); i++) {
            sb.append("*");
        }
        sb.append(" ").append(range).append(".");
        return sb.toString();
    }

    private void getGrades(String guess) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == goal.charAt(i)) {
                bulls++;
            } else if (goal.contains(String.valueOf(guess.charAt(i)))) {
                cows++;
            }
        }
        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.");
            // Uncomment for cheat
            // System.out.println(" The secret code is " + goal + ".");
        } else if (bulls == 0) {
            System.out.println("Grade:" + cows + " cow(s).");
            // Uncomment for cheat
            // System.out.println(" The secret code is " + goal + ".");
        } else if (cows == 0) {
            System.out.println("Grade: " + bulls + " bull(s).");
            // Uncomment for cheat
            // System.out.println(" The secret code is " + goal + ".");
        } else {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
            // Uncomment for cheat
            // System.out.println(" The secret code is " + goal + ".");
        }
    }
}

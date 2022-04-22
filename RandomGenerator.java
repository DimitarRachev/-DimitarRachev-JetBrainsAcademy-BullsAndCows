package bullscows;

public class RandomGenerator {
    long pseudoRandomNumber;
    int size;

    public RandomGenerator(int size) throws IllegalArgumentException {
        this.pseudoRandomNumber = System.nanoTime();
        try {
            this.size = checkSize(size);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private int checkSize(int size) throws IllegalArgumentException {
        if (size > 10) {
            throw new IllegalArgumentException("Error: can't generate a secret number with a length of " + size + " because there aren't enough unique digits.");
        }
        return size;
    }

    int generate() {
        StringBuilder result = new StringBuilder();
        String generated = String.valueOf(pseudoRandomNumber);
        for (int i = generated.length() - 1; i >= 0; i--) {
            if (result.indexOf(String.valueOf(generated.charAt(i))) == -1) {
                if (result.length() == 0 && generated.charAt(i) == '0') {
                    continue;
                }
                result.append(generated.charAt(i));
                if (result.length() == size) {
                    return Integer.parseInt(result.toString());
                }
            }
        }
        pseudoRandomNumber = System.nanoTime();
        return generate();
    }
}

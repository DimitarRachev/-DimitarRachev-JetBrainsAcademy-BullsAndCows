package bullscows;

import java.util.*;

public class RandomGenerator {
    private int size;
    private int numSymbols;
    private Map<Integer, String> symbols;

    public RandomGenerator(int size, int numSymbols) throws WrongSizeException {
        setNumSymbols(numSymbols);
        setSize(size);
        setSymbols();
    }

    private void setSymbols() {
        symbols = new HashMap<>();
        int index = 0;
        for (int i = '0'; i <= '9'; i++) {
            symbols.put(index++, String.valueOf((char) i));
        }
        for (int i = 'a'; i <= 'z'; i++) {
            symbols.put(index++, String.valueOf((char) i));
        }
    }

    private void setNumSymbols(int numSymbols) throws WrongSizeException {
        if (numSymbols > 36) {
            throw new WrongSizeException("Error: can't generate a secret number with a length of " + size + " because there aren't enough unique digits.");
        }
        this.numSymbols = numSymbols;
    }

    public void setSize(int size) throws WrongSizeException {
        if (size > 36) {
            throw new WrongSizeException("Error: can't generate a secret number with a length of " + size + " because there aren't enough unique digits.");
        }
        this.size = size;
    }

    String generate() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            String next = symbols.get(random.nextInt(numSymbols + 1));
            if (sb.indexOf(next) == -1) {
                sb.append(next);
            } else {
                i--;
            }
        }
        return sb.toString();
    }

    public String getRange() {
        if (numSymbols <= 10) {
            return "(0-9)";
        } else {
            return "(0-9, a-" + symbols.get(numSymbols - 1) + ")";
        }
    }
}

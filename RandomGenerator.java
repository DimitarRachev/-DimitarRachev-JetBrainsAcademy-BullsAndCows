package bullscows;

import java.util.*;

public class RandomGenerator {
    private int size;
    private int numSymbols;
    private Map<Integer, String> symbols;

    public RandomGenerator(int size, int numSymbols) throws WrongSizeException {
        setSize(size);
        setNumSymbols(numSymbols);
        setSymbols();
    }

    private void setSymbols() {
        symbols = new LinkedHashMap<>();
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
            throw new WrongSizeException("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
        }
        if (size > numSymbols) {
            throw new WrongSizeException("Error: it's not possible to generate a code with a length of " + size + " with " + numSymbols + " unique symbols.");
        }
        this.numSymbols = numSymbols;
    }

    public void setSize(int size) throws WrongSizeException {
        if (size > 36 || size <= 0) {
            throw new WrongSizeException("Error: can't generate a secret number with a length of " + size + " because there aren't enough unique symbols.");
        }
        this.size = size;
    }

    String generate() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            String next = symbols.get(random.nextInt(numSymbols));
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

    public String getValidSymbols() {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (String s : symbols.values()) {
            if (index++ == numSymbols) {
                break;
            }
            sb.append(s);
        }
        return sb.toString();
    }
}

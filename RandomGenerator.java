package bullscows;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class RandomGenerator {
    int size;

    public RandomGenerator(int size) throws WrongSizeException {
        setSize(size);
    }

    public void setSize(int size) throws WrongSizeException {
        if (size > 10) {
            throw new WrongSizeException("Error: can't generate a secret number with a length of " + size + " because there aren't enough unique digits.");
        }
        this.size = size;
    }

    int generate() {
        Random random = new Random();
        Set<Integer> num = new LinkedHashSet<>();
        int counter = 0;
        while (num.size() < size) {
            int i = random.nextInt(10);
            while (counter == 0 && i == 0) {
                i = random.nextInt(10);
            }
            num.add(i);
            counter++;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : num) {
            sb.append(integer);
        }
        return Integer.parseInt(sb.toString());
    }
}

package app.lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class RandomNumbersGenerator {

    private final Random randomGenerator = new Random();

    public Set<Integer> generateRandomNumbers(int minValue, int maxValue, int how_many) {
        Set<Integer> randomNumbers = new HashSet<Integer>();
        while (randomNumbers.size() < how_many) {
            Integer temp = randomGenerator.nextInt(maxValue + minValue);
            if (!isNotInRange(temp, minValue, maxValue)) {
                randomNumbers.add(temp);
            }
        }
        return randomNumbers;
    }

    private static boolean isNotInRange(Integer numberAdding, int minvalue, int maxValue) {
        return numberAdding < minvalue || numberAdding > maxValue;
    }
}

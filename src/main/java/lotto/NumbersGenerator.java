package lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static lotto.Lotto.isNotInRange;

public class NumbersGenerator {

    private final Random randomGenerator = new Random();

     Set<Integer> generateRandomNumbers(int minValue, int maxValue, int how_many) {
        Set<Integer> randomNumbers = new HashSet<Integer>();
        while (randomNumbers.size() < how_many) {
            Integer temp = randomGenerator.nextInt(maxValue + minValue);
            if (!isNotInRange(temp)) {
                randomNumbers.add(temp);
            }
        }
        return randomNumbers;
    }
}

package lotto;

import java.util.HashSet;
import java.util.Set;

import static lotto.IntegerSetter.CompareSets;
import static lotto.IntegerSetter.loopFromSet;

public class Lotto {

    private static final String LOOSE = "You loose, numbers matched: ";
    private static final String WIN = "You win, numbers matched: ";
    private static final String CHOOSEN = "Choosen: ";
    private static final String RANDOMS = "Randoms: ";
    private static final int HOW_MANY_NUMBERS = 6;
    private static final int MIN = 1;
    private static final int MAX = 10;
    private final RandomNumbersGenerator generator = new RandomNumbersGenerator();
    private final UserNumbers generateUserNumbers = new UserNumbers();
    private Set<Integer> userNumbers = new HashSet<Integer>();
    private Set<Integer> randomNumbers = new HashSet<Integer>();

    public void play() {
        userNumbers = generateUserNumbers.getNumberFromUser(MIN, MAX, HOW_MANY_NUMBERS);
        randomNumbers = generator.generateRandomNumbers(MIN, MAX, HOW_MANY_NUMBERS);
        showNumbers();
        winnOrLoose();
    }

    private void winnOrLoose() {
        int match = CompareSets(randomNumbers, userNumbers);
        if (match > 3) {
            System.out.println(WIN + match);
        } else {
            System.out.println(LOOSE + match);
        }
    }

    private void showNumbers() {
        System.out.println(CHOOSEN);
        loopFromSet(userNumbers);

        System.out.println(RANDOMS);
        loopFromSet(randomNumbers);
    }
}

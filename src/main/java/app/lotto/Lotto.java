package app.lotto;

import app.Game;

import java.util.HashSet;
import java.util.Set;

import static app.lotto.IntegerSetter.CompareSets;
import static app.lotto.IntegerSetter.loopFromSet;
import static app.lotto.LottoConfig.*;
import static app.lotto.LottoMessageProvider.*;

public class Lotto implements Game {

    private final RandomNumbersGenerator generator = new RandomNumbersGenerator();
    private final UserNumbersRetriever generateUserNumbers = new UserNumbersRetriever();
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

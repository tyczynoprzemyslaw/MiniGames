package lotto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static lotto.IntegerSetter.CompareSets;
import static lotto.IntegerSetter.loopFromSet;

public class Lotto {

    private static final String IT_IS_NOT_NUMBER = "Type real number!";
    private static final String START_MESSAGE = "Give 6 different numbers from range 1-99, to play lotto";
    private static final String NUMBER_CONTAINED = "You already gave this number";
    private static final String NUMBER_OUT_OF_RANGE = "Type number from 1 to 99";
    private static final String LOOSE = "You loose, numbers matched: ";
    private static final String WIN = "You win, numbers matched: ";
    private static final String CHOOSEN = "Choosen: ";
    private static final String RANDOMS = "Randoms: ";
    private static final int HOW_MANY_NUMBERS = 6;
    private static final int MIN = 1;
    private static final int MAX = 99;

    private final Set<Integer> userNumbers = new HashSet<Integer>();
    private final NumbersGenerator generator = new NumbersGenerator();
    private final Scanner scan = new Scanner(System.in);
    private Set<Integer> randomNumbers = new HashSet<Integer>();


    public static boolean isNotInRange(Integer numberAdding) {
        return numberAdding < MIN || numberAdding > MAX;
    }

    public void play() {
        getNumberFromUser();
        randomNumbers = generator.generateRandomNumbers(MIN, MAX, HOW_MANY_NUMBERS);
        showNumbers();
        winnOrLoose();
    }

    private void getNumberFromUser() {
        System.out.println(START_MESSAGE);

        while (userNumbers.size() < HOW_MANY_NUMBERS) {
            Integer numberAdding = getNumber(scan);
            isNumberCorrect(numberAdding);
        }
        scan.close();
    }

    private void isNumberCorrect(Integer numberAdding) {
        if (userNumbers.contains(numberAdding)) {
            System.out.println(NUMBER_CONTAINED);
            return;
        }

        if (isNotInRange(numberAdding)) {
            System.out.println(NUMBER_OUT_OF_RANGE);
            return;
        }
        userNumbers.add(numberAdding);
    }

    private Integer getNumber(Scanner scan) {
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println(IT_IS_NOT_NUMBER);
        }
        return scan.nextInt();
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

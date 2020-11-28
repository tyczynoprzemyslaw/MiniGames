package app.lotto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static app.lotto.LottoMessageProvider.*;

public class UserNumbersRetriever {



    private final Scanner scan = new Scanner(System.in);
    private final Set<Integer> userNumbers = new HashSet<Integer>();



    public Set<Integer> getNumberFromUser(int minValue, int maxValue, int howManyNumbers) {

        System.out.println(START_MESSAGE);
        while (userNumbers.size() < howManyNumbers) {
            Integer numberAdding = getNumber(scan);
            isNumberCorrect(numberAdding, minValue, maxValue);
        }
        scan.close();
        return userNumbers;
    }

    private Integer getNumber(Scanner scan) {
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println(IT_IS_NOT_NUMBER);
        }
        return scan.nextInt();
    }

    private void isNumberCorrect(Integer numberAdding, int minValue, int maxValue) {
        if (userNumbers.contains(numberAdding)) {
            System.out.println(NUMBER_CONTAINED);
            return;
        }
        if (isNotInRange(numberAdding, minValue, maxValue)) {
            System.out.println("Type number from " + minValue + " to " + maxValue);
            return;
        }
        userNumbers.add(numberAdding);
    }

    private static boolean isNotInRange(Integer numberAdding, int minValue, int maxValue) {
        return numberAdding < minValue || numberAdding > maxValue;
    }
}

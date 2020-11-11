package lotto;

import java.util.*;

public class Lotto {
    final static String IT_IS_NOT_NUMBER="Type real number!";
    final static String START_MESSAGE= "Give 6 different numbers from range 1-99, to play lotto";
    final static String NUMBER_CONTAINED= "You already gave this number";
    final static String NUMBER_OUT_OF_RANGE= "Type number from 1 to 99";
    final static String LOOSE="You loose, numbers matched: ";
    final static String WIN="You win, numbers matched: ";

    final static int HOW_MANY_NUMBERS = 6;
    final static int MIN = 1;
    final static int MAX = 99;

    int match = 0;

    public Set<Integer> userNumbers = new HashSet<Integer>();
    public Set<Integer> randomNumbers = new HashSet<Integer>();

     Random randomGenerator = new Random();
     Scanner scan = new Scanner(System.in);

    public void play() {
        getNumberFromUser();
        randomNumbers();
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

    private void randomNumbers() {
        while (randomNumbers.size() < HOW_MANY_NUMBERS) {
            Integer temp =randomGenerator.nextInt(MAX + 1);
            if (!isNotInRange(temp)){
                randomNumbers.add(temp);
            }

        }
    }

    private void winnOrLoose() {
        if (howManyMatches() > 3) {
            System.out.println(WIN + match);
        } else {
            System.out.println(LOOSE + match);
        }
    }

    private void showNumbers() {
        System.out.println("Choosen: ");
        loopFromList(userNumbers);

        System.out.println("Randoms: ");
        loopFromList(randomNumbers);
    }

    private void loopFromList(Set<Integer> set) {
        for (Integer i : set) {
            System.out.println((i));
        }
    }

    private boolean isNotInRange(Integer numberAdding) {
        return numberAdding < MIN || numberAdding > MAX;
    }

    private int howManyMatches() {

        for (Integer temp : randomNumbers) {
            if (userNumbers.contains(temp)){
                match++;
            }
        }
        return match;
    }
}

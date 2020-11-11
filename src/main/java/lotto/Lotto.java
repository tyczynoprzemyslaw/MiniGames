package lotto;

import java.util.*;

public class Lotto {
    final static int HOW_MANY_NUMBERS = 6;
    final static int MIN = 1;
    final static int MAX = 99;

    final static String IT_IS_NOT_NUMBER="Type real number!";
    final static String START_MESSAGE= "Give 6 different numbers from range 1-99, to play lotto";
    final static String NUMBER_REPEAT= "You already gave this number";
    final static String NUMBER_OUT_OF_RANGE= "Type number from 1 to 99";
    int match = 0;
    Integer numberAdding = 0;

    public Set<Integer> userNumbers = new HashSet<Integer>();
    public Set<Integer> randomNumbers = new HashSet<Integer>();

    Random randomGenerator = new Random();
    private boolean isNumberAccepteable;

    public void play() {
        getNumberFromUser();
       randomNumbers();
        showNumbers();
        //winnOrLoose();
    }

    private void getNumberFromUser() {
        System.out.println(START_MESSAGE);
        Scanner scan = new Scanner(System.in);
        while (userNumbers.size() < HOW_MANY_NUMBERS) {

            while (!scan.hasNextInt()) {
                scan.next();
                System.out.println(IT_IS_NOT_NUMBER);
            }
            Integer numberAdding = scan.nextInt();

            if (userNumbers.contains(numberAdding)) {
                System.out.println(NUMBER_REPEAT);
                continue;
            }

            if (isNotInRange(numberAdding)) {
                System.out.println(NUMBER_OUT_OF_RANGE);
                continue;
            }

            userNumbers.add(numberAdding);
            System.out.println("Added: " + numberAdding);

        }
        scan.close();
    }

    public void randomNumbers() {
        while (randomNumbers.size() < HOW_MANY_NUMBERS) {
          randomNumbers.add(randomGenerator.nextInt(MAX + 1));
        }
    }


    public void winnOrLoose() {
        if (howManyMatches() > 3) {
            System.out.println("You won, there was : " + match + " matches");
        } else {
            System.out.println("You loose, there was: " + match + " matches");
        }

    }

    public void showNumbers() {
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
        for (int i = 0; i < HOW_MANY_NUMBERS; i++) {
            for (int j = 0; j < HOW_MANY_NUMBERS; j++)
                if (isNumberFromUsesExistInRandomNumbers(i, j)) {
                    match++;
                }
        }
        return match;
    }

    private boolean isNumberFromUsesExistInRandomNumbers(int i, int j) {
        return true; //(randomNumbers(i)).equals(userNumbers(j));
    }


}

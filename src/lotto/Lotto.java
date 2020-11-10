package lotto;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	final int HOW_MANY_NUMBERS = 6;
	final int MIN = 1;
	final int MAX = 99;

	public ArrayList<Integer> userNumbers = new ArrayList<Integer>();
	public ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
	Random randomGenerator = new Random();

	int match = 0;
	Integer numberAddingToList = 0;
	boolean isNumberAccepteable = true;


	public Lotto() {
		super();
	}

	public Lotto(ArrayList<Integer> userNumbers, ArrayList<Integer> randomNumbers, Random randomGenerator, int match, Integer numberAddingToList,  boolean isNumberAccepteable) {
		super();
		this.userNumbers = userNumbers;
		this.randomNumbers = randomNumbers;
		this.randomGenerator = randomGenerator;
		this.match = match;
		this.isNumberAccepteable = isNumberAccepteable;
		this.numberAddingToList = numberAddingToList;
	}

	public void giveNumbers() {
		System.out.println("Podaj 6 roznych liczb z przedzia³u 1-99, aby zagrac w lotto");
		Scanner scan = new Scanner(System.in);


		for (int i = 0; i < HOW_MANY_NUMBERS; i++) {
			//System.out.println("Kó³ko" + i);
			while (!scan.hasNextInt()) {
				scan.next();
				System.out.println("Type real number!");
			}
			Integer numberAddingToList = scan.nextInt();

			if (userNumbers.contains(numberAddingToList)) {
				System.out.println("You already gave this number");
                /* Próbowa³em zast¹piæ te dwie linie metod¹ (tym bardziej, ¿e redundancja mocno,
                 ale wszystko siê sypie
                 doubledOrIncorrectValue(i);
                */
				i--;
				isNumberAccepteable = false;

			}

			if (isNotBeetwenMinAndMax(numberAddingToList)) {
				System.out.println("Type number from 1 to 99");
				i--;
				isNumberAccepteable = false;

			}


			if (isNumberAccepteable) {
				userNumbers.add(numberAddingToList);
				System.out.println("Dodano: " + numberAddingToList);
			}
			isNumberAccepteable = true;

		}
		scan.close();
	}



	public void randomNumbers() {

		for (int i = 0; i < HOW_MANY_NUMBERS; i++) {
			isNumberAccepteable = true;
			numberAddingToList=randomGenerator.nextInt(MAX + 1);
			System.out.println("Checking 1");
			if (randomNumbers.contains(numberAddingToList)) {
				i--;
				isNumberAccepteable = false;
			}

			if (isNotBeetwenMinAndMax(numberAddingToList)) {
				System.out.println("Checking 2");
				System.out.println("Type number from 1 to 99");
				i--;
				isNumberAccepteable = false;
			}
			System.out.println("Checking 3");


			if (isNumberAccepteable){
				System.out.println("Checking 4");
				//tutaj Intellij sugeruje wywalenie klamr i
				// zrobienie tego w jednej linii, robi siê tak?
				randomNumbers.add(numberAddingToList);
			}
			System.out.println("Checking 5");
		}
	}



	public void winnOrLoose() {
		if (howManyMatches() > 3){
			System.out.println("You won, there was : " + match + " matches");
		}
		else {
			System.out.println("You loose, there was: " + match + " matches");
		}

	}

	public void showNumbers() {
		System.out.println("Wybrane: ");
		loopFromList(userNumbers);

		System.out.println("Wylosowane");
		loopFromList(randomNumbers);
	}

	private void loopFromList(ArrayList<Integer> list) {
		for (int i = 0; i < HOW_MANY_NUMBERS; i++) {
			System.out.println(list.get(i));
		}
	}

	private void doubledOrIncorrectValue(int i){
		i = i-1;
		isNumberAccepteable = false;
	}

	private boolean isNotBeetwenMinAndMax(Integer numberAddingToList) {
		return numberAddingToList < MIN || numberAddingToList > MAX;
	}

	private int howManyMatches() {
		for (int i = 0; i < HOW_MANY_NUMBERS; i++) {
			for (int j = 0; j < HOW_MANY_NUMBERS; j++)
				if ((randomNumbers.get(i)).equals(userNumbers.get(j))){
					match++;
				}
		}
		return match;
	}


}

package lotto;

public class Main {
	public static void main(String[] args) {
		
		Lotto lotto = new Lotto();
		lotto.giveNumbers();
		lotto.randomNumbers();
		lotto.showNumbers(lotto.givenNumbers, lotto.randomNumbers);
		lotto.winnOrLoose(lotto.givenNumbers, lotto.randomNumbers);
		
		
		
	}
}

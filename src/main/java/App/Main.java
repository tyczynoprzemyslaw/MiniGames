package App;

import lotto.Lotto;

public class Main {
	public static void main(String[] args) {
		
		Lotto lotto = new Lotto();
		lotto.giveNumbers();
		lotto.randomNumbers();
		lotto.showNumbers();
		lotto.winnOrLoose();
		
		
		
	}
}

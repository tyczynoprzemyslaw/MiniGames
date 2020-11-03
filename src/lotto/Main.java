package lotto;

public class Main {
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		int[] givenNumbers = lotto.giveNumbers();
		int[] lottoNumbers = lotto.randomNumbers();
		lotto.showNumbers(givenNumbers, lottoNumbers);
		lotto.winnOrLoose(givenNumbers, lottoNumbers);
		
		
		
	}
}

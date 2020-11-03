package lotto;

import java.util.Random;
import java.util.Scanner;

public class Lotto {
				
	int[] givenNumbers = new int[6];
	int[] randomNumbers = new int[6];
	Random generator = new Random();
	int howManyNumbers=6;
	int match=0;
			
	public Lotto() {
		super();
	}

	public Lotto(int[] givenNumbers, int[] randomNumbers, Random generator, int howManyNumbers, int match) {
		super();
		this.givenNumbers = givenNumbers;
		this.randomNumbers = randomNumbers;
		this.generator = generator;
		this.howManyNumbers = howManyNumbers;
		this.match = match;
	}
		
	public void giveNumbers() {
		System.out.println("Podaj 6 roznych liczb z przedzia³u 1-99, aby zagrac w lotto");
		Scanner scan = new Scanner(System.in);
		
		
		for (int i=0; i< howManyNumbers; i++) {
			
			while(!scan.hasNextInt()){
	            scan.next();
	            System.out.println("Podaj liczbe!");
	        }
	        givenNumbers[i]=scan.nextInt();
			
			//Check if given number already exist in array
			for (int j=0; j< howManyNumbers; j++) {
				if (numberExistinArray(i, j)) {
					i--;
					System.out.println("T¹ liczbê ju¿ poda³eœ! Jeszcze raz: ");		
				}				
			}
			
			if (this.givenNumbers[i]<1 || this.givenNumbers[i]>99) {
				System.out.println("Liczba powinna byc z zakresu 1-99, Podaj poprawn¹!");
				i--;
			}		
			else  System.out.println("Ok");						
		}
		scan.close();
	}
	
	public void randomNumbers() {
		
		for (int i=0;i<howManyNumbers;i++) {				
			this.randomNumbers[i]=generator.nextInt(100);								
			for (int j=0;j<howManyNumbers;j++) {
				if (numberExistinArray(i, j)) i--;
					
			}										
		}
		
	}
	
	public void showNumbers(int[] givenNumbers,int[] lottoNumbers) {
			System.out.println("Wybrane: ");
			loopFromArray(givenNumbers);
			
			System.out.println("Wylosowane");
			loopFromArray(lottoNumbers);
	}
	
	private void loopFromArray(int[] array) {		
		for (int i=0;i<howManyNumbers;i++) {			
			System.out.println(array[i]);
		}
	}
			
	public void winnOrLoose (int[] givenNumbers,int[] lottoNumbers) {	
		for (int i=0;i<howManyNumbers;i++) {							
							
			for (int j=0;j<howManyNumbers;j++) { 				
				if (givenNumbers[i]==lottoNumbers[j] ) {
					match++;			
				}
			}
		}
		
		if (match<3) System.out.println("Przegra³eœ! " + match + " liczb pasowa³o do siebie");
		else if(match>=3) System.out.println("Wygra³eœ! " + match + " liczb pasowa³o do siebie!");
	
    }
	
	private boolean isNumberExist (int[] firsArray, int[] secoundArray ){
		for (int i=0;i<howManyNumbers;i++) {							
			
			for (int j=0;j<howManyNumbers;j++) { 				
				if (firsArray[i]==secoundArray[j] ) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	private boolean numberExistinArray (int i, int j){
		if (this.givenNumbers[i]==this.givenNumbers[j] && i != j) {
			return true;
		}
		return false;
		}
			
}

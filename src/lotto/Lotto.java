package lotto;

import java.util.Random;
import java.util.Scanner;

public class Lotto {
	
	
	
		
	int[] givenNumbers = new int[7];
	int[] lottoNumbers = new int[7];
	Random generator = new Random();

	int match=0;
		
	public int[] giveNumbers() {
		System.out.println("Podaj 6 roznych liczb z przedzia³u 1-99, aby zagrac w lotto");
		Scanner scan = new Scanner(System.in);
		int[] numbers = new int[7];
		
		for (int i=1;i<7;i++) {
			
			numbers[i]=scan.nextInt();		
			
			//Check if given number already exist in array
			for (int j=1;j<7;j++) {
				if (numbers[i]==numbers[j] && i != j) {
					i--;
					System.out.println("T¹ liczbê ju¿ poda³eœ! Jeszcze raz: ");				
					break;
				}				
			}
			
			if (numbers[i]<1 || numbers[i]>99) {
				System.out.println("Liczba powinna byc z zakresu 1-99, Podaj poprawn¹!");
				i--;
			}			
			
			else  System.out.println(i + ": " + numbers[i]+ " Podaj nastêpn¹ :)");									
			
		}
		return numbers;
	}
	
	public int[] randomNumbers() {
		int[] randomNumbers = new int[7];
		for (int i=1;i<7;i++) {
				
				randomNumbers[i]=generator.nextInt(100);	
							
				for (int j=1;j<7;j++) {
					if (randomNumbers[i]==randomNumbers[j] && i != j) i--;
					
				}										
			}
		return randomNumbers;
	}
	
	public void showNumbers(int[] givenNumbers,int[] lottoNumbers) {
			System.out.println("Wybrane: ");
			for (int i=1;i<7;i++)			
				System.out.println(givenNumbers[i]);
			
			System.out.println("Wylosowane");
			for (int i=1;i<7;i++)			
				System.out.println(lottoNumbers[i]);
	}
		
	
	public void winnOrLoose (int[] givenNumbers,int[] lottoNumbers) {	
		for (int i=1;i<7;i++) {							
							
			for (int j=1;j<7;j++) 				
				if (givenNumbers[i]==lottoNumbers[j] ) match++;			
		}
		
		if (match<3) System.out.println("Przegra³eœ!" + match + " liczb pasowa³o do siebie");
		else if(match>=3) System.out.println("Wygra³eœ! " + match + " liczb pasowa³o do siebie!");
	
    }
	
}

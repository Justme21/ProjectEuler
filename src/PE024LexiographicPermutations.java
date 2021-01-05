import java.util.ArrayList;
import java.util.Scanner;

/*Written as challenge for Project Euler (#024)
 * This program gets the n'th lexiogaphic permutation of a series of numbers
 * (where the number of numbers to be checked and the value of n can be entered by the user)
 * ("Lexiographic" means in numerical or alphabetical order)
 * This program iterates through the positions in the solution, determining the value at each.
 * At the i'th position in the answer, if that number is fixed then */
public class PE024LexiographicPermutations{
	
	/*Just gets the factortial of a given number. There might already be a function for it in java
	 * but I wasn't sure*/
	public static long factorial(int number){
		long value=1;
		for(int i=2;i<=number;i++){
			value*=i;
		}
		return value;
	}
	
	/*Recursive program that takes in the number of permutations left to cover, the number of free integers left, a list of 
	 * unused numbers in order, and the list that will contain the answer
	 * Gets n! (which is the number of permutation of the free integers when the leftmost integer is fixed)
	 * The fixed integer can be determined by getting the multiple of n! which is less than permutationPosit
	 * If there is a remainder then the number we are looking for occurs in the next block of permutations, so we fix the integer as the
	 * value gotten after counter+1 permutations (so position counter in the array).
	 * If remainder is zero then the value occurs after counter permutations (counter-1 in the array) */
	public static void computeValue(long permutationPosit, int numPosit, ArrayList <Integer> list,ArrayList<Integer>answerList){
		long facValue=factorial(numPosit),remainder=(permutationPosit%facValue);
		int counter=(int) (permutationPosit/facValue);
		if(remainder==0){
			answerList.add(list.get(counter-1)); //if the remainder is 0 then the answer comes in that permutation 
			list.remove(counter-1);//removes value from list
			for(int i=list.size()-1;i>=0;i--){ //the remainder being zero means the permutation is the largest possible permutation of the remaining numbers
				answerList.add(list.get(i));}
		}
		else{
			answerList.add(list.get(counter));//since iteration starts at 0 this is the "counter+1" iteration integer
			list.remove(counter);//removes the taken number from the list
			computeValue(permutationPosit-(counter*facValue),numPosit-1,list,answerList);//recursively calls the function with reduced value
		}
	}
	
	public static void main(String args[]){
		int numNumbers;
		long numPermutation; //using long to allow for large permutations (ie the 1,000,000th permutation)
		ArrayList <Integer> numberList=new ArrayList <Integer>(),answerList=new ArrayList<Integer>();
		Scanner keyboard=new Scanner(System.in);
		System.out.print("How many digits are there? ");
		numNumbers=keyboard.nextInt();
		System.out.print("What number permutation are you looking for? ");
		numPermutation=keyboard.nextLong();
		if(factorial(numNumbers)<numPermutation){//if n! is less than the permutation we want, then there aren't enough numbers to reach it
			System.out.println("These numbers will not have this many permutations");
			System.exit(0); //if there aren't enough numbers the program terminates
		}
		for(int i=0;i<numNumbers;i++){
			numberList.add(i); // puts the numbers 0-n-1 into the arrayList
		}
		computeValue(numPermutation,numNumbers-1,numberList,answerList);
		System.out.println(answerList);
		
	}
}
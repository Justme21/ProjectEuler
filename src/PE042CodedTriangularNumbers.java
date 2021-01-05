/**Written as problem for Project Euler
 * This program reads in a list of numbers as a string, breaks it down
 *  into single words. The program then changes these words into sums based
 *  on their position in the alphabet. The program then checks if this sum is 
 *  in a list of triangular numbers.
 * */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PE042CodedTriangularNumbers{
	
	/*Gets the value of the sum of the numerical value of the letters in a given word*/
	public static int getValue(String Word){
		int value=0;
		for(int i=0;i<Word.length();i++){
			char letter=Word.charAt(i);
			int charValue=letter-'A'+1;
			value+=charValue;
		}
		return value;
	}
	
	/*Generates the list of triangular numbers by the formula that if a number is triangular
	 * it will be=n(n+1)/2 for some n*/
	public static void getTriangularNumbers(ArrayList <Integer> Array,int maxValue){
		int start=0;
		while(start<=maxValue){
			int combo=start*(start+1);
			combo/=2;
			Array.add(combo);
			start++;
		}
	}
	
	/*Compares the array of numerical values of words with the list of triangular numbers */
	public static int compareArrays(ArrayList <Integer>numberArray,ArrayList<Integer> triangleArray,int numTriangle,int Count){
		int numMatch=0;
		for(int i=0;i<Count;i++){
			int check1=numberArray.get(i);
			for(int j=0;j<numTriangle;j++){
				if(check1==triangleArray.get(j)){
					numMatch++;
					break;
				}
			}
		}
		return numMatch;
	}
	
	public static void main(String args[]) throws IOException{
		Scanner keyboard=new Scanner(System.in);
		String word;
		int numCode=0,limit=0,count=0,numTriangles;
		ArrayList <Integer> numberList=new ArrayList<Integer>();
		ArrayList <Integer> triangularList=new ArrayList<Integer>();
		System.out.print("Ready to go\n");
		String thisLine=keyboard.nextLine();
		thisLine=thisLine.replace('\"',' '); //These are just here due to the formatting of the input
		thisLine=thisLine.replace(',', '\n');
		Scanner reader=new Scanner(thisLine);
		while(reader.hasNext()){
			word=reader.next();
			numCode=getValue(word);
			if(numCode>limit){limit=numCode;}
			numberList.add(numCode);
			count++;
		}
		getTriangularNumbers(triangularList,limit);
		numTriangles=compareArrays(numberList,triangularList,limit,count);
		System.out.print(numTriangles+" of these words are coded triangular numbers\n");
	}
}
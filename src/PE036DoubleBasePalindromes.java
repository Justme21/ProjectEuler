import java.util.ArrayList;

/*Written as challenge for Project Euler (#036)
 * This program gets the sum of all of the numbers <UPPER_BOUND which are palindromes
 * both in base 10 and in base 2*/
public class PE036DoubleBasePalindromes{
	
	public static int UPPER_BOUND=1000000;
	
	/*Breaks the number up into it's base representation, and returns the arraylist with the entries in 
	 *order from left to right (as reading in base 10) */
	public static ArrayList <Integer> getNumberArray(double Number,int base){
		ArrayList <Integer> array=new ArrayList <Integer>();
		int number= (int) Number;
		while(number>0){
			array.add(0,(int) (number%base));
			number/=base;
		}
		return array;
	}
	
	/*Checks each entry in the arraylist against the corresponding entry at the other end of the array*/
	public static boolean isPalindrome(ArrayList <Integer> baseArray){
		int count=0;
		while(count<(baseArray.size()/2)+1){
			if(baseArray.get(count)!=baseArray.get(baseArray.size()-1-count)){
				return false;
			}
			count+=1;
		}
		return true;
	}
	
	
	public static void main (String args[]){
		long n=1,sum=0;
		ArrayList <Integer> numBTen,numBTwo=new ArrayList<Integer>();
		while(n<UPPER_BOUND){
			numBTen=getNumberArray(n,10);
			if(isPalindrome(numBTen)){
				numBTwo=getNumberArray(n,2);
			}
			if(isPalindrome(numBTen)&&isPalindrome(numBTwo)){
				sum+=n;
			}
			n+=1;
		}
		System.out.print("The sum of the Double Base Palindromes less than "+UPPER_BOUND+" is "+sum+"\n");
	}
}
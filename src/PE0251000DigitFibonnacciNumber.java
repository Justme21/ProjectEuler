import java.util.ArrayList;

/**Written as challenge for Project Euler
 * This programme finds the first fibonnacci number with 1000 digits or more*/
public class PE0251000DigitFibonnacciNumber{
	
	/*Returns an arraylist that is the sum of the entries of 2 other arrayLists*/
	public static ArrayList<Integer> getSum(ArrayList <Integer> Array1,ArrayList <Integer> Array2){
		ArrayList <Integer> sumArray=new ArrayList<Integer>();
		int temp=0;
		if(Array2.size()>Array1.size())Array1.add(0,0);
		for(int i=Array2.size()-1;i>=0;i--){
			int sum=Array1.get(i)+Array2.get(i)+temp;
			temp=0;
			if(sum>=10){
				temp=sum/10;
				sum=sum%10;
			}
			sumArray.add(0,sum);
		}
		if(temp!=0){
			sumArray.add(0,temp);
		}
		return sumArray;
	}
	
	/*This performs the switch necessary to calculate fibonacci numbers
	 *Takes in 2 ArrayLists, uses them to generate an ArrayList containing the next fibonacci number 
	 *and this process is repeated while the length of the newly generated array is less than 1000*/
	public static void getFibonnacciNumber(ArrayList <Integer> Fib1,ArrayList <Integer> Fib2){
		int count=2; 
		ArrayList <Integer> Fib3=new ArrayList <Integer>();
		while(Fib2.size()<1000){
			Fib3=getSum(Fib1,Fib2);
			Fib1=Fib2;
			Fib2=Fib3;
			count++;
		}
		System.out.print("And the count is: "+count);
	}
	
	/*Kind of a messy way of approaching the problem, probably easier to do this using just integers
	 * but this way works and is fast*/
	public static void main(String[] args){
		ArrayList <Integer> F1=new ArrayList <Integer>();
		ArrayList <Integer> F2=new ArrayList <Integer>();
		F1.add(1);
		F2.add(1);
		getFibonnacciNumber(F1,F2);
	}
}
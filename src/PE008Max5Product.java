/*Written as challenge for Project Euler (#008)
 * This programme takes in any number of values, and returns the largest product of 5 consecutive
 * numbers from this list */
import java.util.ArrayList;
import java.util.Scanner;


public class PE008Max5Product{
	
	public static void main(String args[]){
		String numberWordString;
		int entry=1,max=0,test=1;
		Scanner keyboard=new Scanner(System.in);
		ArrayList<Integer>numberList=new ArrayList<Integer>();
		System.out.print("This programme finds the maximum value of the product of 5 consecutive numbers from the list of 1000\n");
		while(entry!=0){
			numberWordString=keyboard.nextLine();
			for(int i=0;i<numberWordString.length();i++){
				entry=numberWordString.charAt(i);
				entry-=48; /**/
				System.out.println(entry);
				numberList.add(entry);
			}
		}
		for(int i=0;i<numberList.size()-4;i++){
			test=1;
			for(int j=0;j<5;j++){
				test*=numberList.get(i+j);
			}
			System.out.println("Test: "+test+" NumberList: "+numberList.get(i));
			if(test>=max)max=test;
		}
		System.out.print("Max equals: "+max);
	}
}

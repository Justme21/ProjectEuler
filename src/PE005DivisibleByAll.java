import java.util.ArrayList;
import java.util.Scanner;

/* Written as challenge for Project Euler (#005)
 * This program prints out a number that is divisible by every number between 1 and some limit defined by the user*/
public class PE005DivisibleByAll{
	
	public static void main(String args[]){
		int limit,divisor,checker,result=1;
		ArrayList<Integer> multiplierList=new ArrayList<Integer>();
		Scanner keyboard=new Scanner(System.in);
		System.out.print("This programme prints out a number that is divisible by every number up to a limit.\n");
		System.out.print("What limit do you want to use: ");
		limit=keyboard.nextInt();
		multiplierList.add(1);
		for(int i=1;i<limit+1;i++){
			checker=i;
			for(int j=0;j<multiplierList.size();j++){
				divisor=multiplierList.get(j);
				if(checker%divisor==0)checker/=divisor;
			}
			multiplierList.add(checker);
		}
		for(int i=0;i<multiplierList.size();i++){
			result*=multiplierList.get(i);
		}
		System.out.print("The first number that has all of the numbers less than your limit as a divisor is: "+result);
	}
}
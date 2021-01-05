import java.util.ArrayList;
import java.util.Scanner;

/*Written as a challenge for Project Euler (#001). 
 * Had to write a code that would add together all of the multiples of 3 or 5 that were less than 1000*/
public class PE001SumMultiples{
	
	public static void main(String args[]){
		int multiple,range,divide,total=0;
		Scanner keyboard=new Scanner(System.in);
		ArrayList <Integer> Range=new ArrayList<Integer>();
		System.out.print("What range do you want to test for ");
		range=keyboard.nextInt();
		for(int i=0;i<range;i++){
			Range.add(i);
		}
		while(true){
			System.out.print("For what multiples? ");
			multiple=keyboard.nextInt();
			if(multiple==0)break;
			for(int i=0;i<Range.size();i++){
				divide=Range.get(i);
				if(divide%multiple==0){
					Range.remove(i);
					total+=divide;
				}
			}
		}
		System.out.print("And the answer is "+total);
	}
}
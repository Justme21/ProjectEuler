/* Written as programming assignment for Project Euler (#16)
 * The programme gets the sum of the numbers in the number 2^n where the value
 * of n is input by the user*/
import java.util.ArrayList;
import java.util.Scanner;

public class PE016PowerNumberSum{
	
	public static void main(String args[]){
		ArrayList <Integer> numSet=new ArrayList<Integer>();
		Scanner keyboard=new Scanner(System.in);
		System.out.print("To what power of 2 do you want to check? ");
		int numTimes=keyboard.nextInt(),rollover=0,sum=0;
		numSet.add(0,1);
		for(int i=0;i<numTimes;i++){
			int size=numSet.size();
			numSet.add(0);
			for(int j=0;j<size;j++){
				if(numSet.get(j+1)>9){numSet.set(j+1,0);}
				numSet.set(j,(numSet.get(j)*2)+rollover);
				rollover=0;
				if(numSet.get(j)>9){
					rollover=numSet.get(j)/10;
					numSet.set(j,numSet.get(j)%10);
				}
			}
		}
		for(int i=0;i<numSet.size();i++){
			System.out.print(numSet.get(i)+", ");
			sum+=numSet.get(i);
		}
		System.out.print("\nThe sum of the numbers in 2^"+numTimes+" is "+sum+"\n");
	}
}
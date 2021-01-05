import java.util.Scanner;

/*Written as challenge for Project Euler (#010)
 * Adds up all of the prime numbers less than a given maxValue
 * Adds up the first 20000000 in less than a minute.
 * Brute force method, very inefficient. Needs more thought at some point
 * ?Only need to check up to the square root of the number to see if it is prime?
 * Starts at 2, increments once, then adds 2 to every value after that, hence halving the number of 
 * numbers to check. Gets a bit messy at the end, due to 2 being divisible by 2 and prime.
 * Requires optimisation in the future so it can be potentially repurposed*/

public class PE010ListOfPrimes2{
	
	public static void main(String args[]){
		long total=(long) 0;
		int counter=2,limit;
		Scanner keyboard=new Scanner(System.in);
		System.out.print("The primes up to what value do you want the sum of: ");
		long maxValue=keyboard.nextLong();
		while(counter<maxValue){
			limit=(int) Math.sqrt(counter);
			if(counter==2||counter==3){
				total+=counter;
				System.out.print(counter+" is prime\n");
			}
			for(int i=2;i<=limit;i++){
				if(counter%i==0&&i!=counter)break;
				if(i==limit&&counter%i!=0){
					total+=counter;
					System.out.print(counter+" is prime\n");
				}
			}
			System.out.print(counter+": and total="+total+"\n");
			if(counter%2==1)counter+=2;
			else{counter++;}
		}
		System.out.print("The total is "+total);
	}
}
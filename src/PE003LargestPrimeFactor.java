import java.util.Scanner;

/* Written as challenge for Project Euler (#003)
 * This programme gets the largest prime factor of a number
 * The programme divides the given number by small numbers, and if it goes in evenly checks to see if the 
 * result of the division is a prime number
 * The first result that is a prime number must by definition be the largest prime number*/
public class PE003LargestPrimeFactor{
	
	public static void main(String args[]){
		long start,tester=0;
		Boolean largestPrime=false;
		Scanner keyboard=new Scanner(System.in);
		System.out.print("What number do you want to get the highest prime factor of?:\n");
		start=keyboard.nextLong();
		for(int i=1;i<start/2;i++){
			if(start%i==0){
				tester=start/i;
				for(int j=2;j<(tester/2)+1;j++){
					if(tester%j==0){
						break;
					}
					else if((j+1)>=(tester/2)+1&&tester%j!=0){
						largestPrime=true;
					}
				}
				if(largestPrime==true){
					break;
				}
			}
		}
		System.out.print(tester+" is the highest prime factor");
	}
}
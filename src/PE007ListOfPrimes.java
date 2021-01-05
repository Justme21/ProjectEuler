/* Written as challenge for Project Euler (#007)
 * This programe prints the value of the 10001st prime number.
 * It takes 4 seconds. Easily modified to find any prime number, or to list the prime numbers*/
public class PE007ListOfPrimes{
	
	public static void main(String args[]){
		int counter=6,number=13;
		while(counter!=10001){
			number++;
			for(int i=2;i<number;i++){
				if(number%i==0)break;
				if(i==number-1&&number%i!=0){
					counter++;
				}
			}
		}
		System.out.print("Counter: "+counter+" Number: "+number+" \n");
	}
}
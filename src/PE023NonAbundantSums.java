import java.util.ArrayList;

/*Written as challenge for Project Euler (#023)
 * This program gets the sum of all numbers that cannot be expressed as the sum of two 
 * abundant numbers (where an abundant number is a number whose divisors sum to be greater
 * than the number itself).
 * THIS PROGRAM TAKES TOO LONG, BUT I CANNOT SEE HOW TO RESOLVE IT
 * THIS PROGRAM TAKES 61 SECONDS TO COMPLETE, MOST OF THE PROGRAMS ON THE FORUM TAKE <15 SECONDS TO RUN
 * MOST TIME IS CONSUMED WHEN CHECKING IF THE DIFFERENCE IN THE NUMBERS IS AN ABUNDANT NUMBER */
public class PE023NonAbundantSums{
	
	/*Returns true if the number is abundant and false otherwise*/
	public static boolean getFactorSum(int number){
		int factorSum=1;
		for(int i=2;i<(number/2)+1;i++){
			if(number%i==0){factorSum+=i;}
			if(factorSum>number){return true;}
		}
		return false;
	}
	
	public static void main(String args[]){
		int sumValue=0;
		long t1=System.nanoTime();// used to calculate how long it takes the program to run
		ArrayList<Integer>abundantNumberList=new ArrayList<Integer>();//stores all the abundant numbers
		for(int i=0;i<=28123;i++){//given that all numbers>28123 are the sum of abundant numbers
			boolean isSum=false;
			if(getFactorSum(i)&&i!=0){
				abundantNumberList.add(i);
			}
			/*This is where the problem arises, as the number of abundant numbers grows
			 * the number of iterations of the for loop becomes large and takes longer and longer to cycle
			 * Individually gets the difference between the number and each abundantNumber that is already 
			 * on the list. If their difference is on the list then the number is the sum of abundant numbers */
			for(int j=0;j<abundantNumberList.size()&&abundantNumberList.get(j)<=i-12;j++){
				if(abundantNumberList.indexOf(i-abundantNumberList.get(j))!=-1){
					isSum=true;
					break;
				}
			}
			if(!isSum){sumValue+=i;}
		}
		System.out.println(sumValue+"   "+(double)(System.nanoTime()-t1)/1000000000);
	}
}
/*Written as challenge for project Euler (#002), returns the sum of all the even Fibonacci Numbers
 * Number exceeds maximum value of java, so it returns minus number*/
public class PE002FibonacciSolver{
	
	public static final int MAXLIMIT=4000000;
	public static void main(String args[]){
		long x1=0,x2=1,total=0,x3=0;
		while(x3<MAXLIMIT){
			x3=x1+x2;
			x1=x2;
			x2=x3;
			if(x2%2==0){
				System.out.print(x2+" is being added\n");
				total+=x2;
			}
		}
		total-=x2;
		System.out.print("The sum of all the even Fibonacci Numbers is: "+total);
		System.out.print(total/10000);
	}
}
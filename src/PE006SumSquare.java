
/*Written as challenge for Project Euler (#006)
 * Had to get the difference between the sum of the squares and the square of the sums*/
public class PE006SumSquare{
	
	public static void main(String args[]){
		
		int sum=0,square=0,difference=0;
		for(int i=1;i<101;i++){
			sum+=i;
			square+=(i*i);
		}
		sum*=sum;
		if(sum>square)difference=sum-square;
		else{difference=square-sum;}
		System.out.print(difference);
	}
}
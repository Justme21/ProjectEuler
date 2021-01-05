/**Written as challenge for Project Euler
 * This problem originated from being given a number list that spiralled outwards, and you had to find the sum
 * of the entries at each corner in a 1001*1001 square list*/
public class PE028SumOdds{
	
	public static void main(String[] args){
		int maximum,dimension=1001,sum=0,odd=1,difference=2,count=0;
		maximum=dimension*dimension;
		while(odd<=maximum){
			sum+=odd;
			odd+=difference;
			count++;
			if(count==4){
				count=0;
				difference+=2;
			}
		}
		System.out.print(maximum+" "+odd+" "+sum);
	}
}
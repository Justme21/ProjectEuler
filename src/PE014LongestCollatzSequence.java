/*Written as Challenge for Project Euler (#014)
 * This program gets the longest Collatz Sequence of all of the numbers between 1 and 1000000
 * Does this by brute force method, only realistic option, very quick*/

public class PE014LongestCollatzSequence{
	
	public static void main(String args[]){
		int num=1,maxNum=0,len=1,maxLen=0;
		long tempNum=1; 
		while(num<1000000){
			if(tempNum==1){
				num++;
				tempNum=num;
				if(len>maxLen){
					maxLen=len;
					maxNum=num-1;
				}
				len=0;
			}
			else if(tempNum%2==0)tempNum=collatzEven(tempNum);
			else{tempNum=collatzOdd(tempNum);
			}
			len++;
		}
		System.out.print("The length of the longest collatz sequence starting less than 1,000,000 is "+maxLen+" from the number "+maxNum);
	}
	
	public static long collatzEven(long tempNum){
		tempNum=tempNum/2;
		return tempNum;
	}
	
	public static long collatzOdd(long tempNum){
		tempNum=3*tempNum;
		tempNum++;
		return tempNum;
	}
}
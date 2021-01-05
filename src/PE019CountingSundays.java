import java.util.Scanner;

/*Written as challenge for Project Euler (#019)
 * This program counts how many times a particular day occurred on the first of any century
 * It works based on the formula dayNum=date+month code+year+floor(year/4)+leap year
 * where date is the date of the day in question, month code depends on: 622503514624,
 * year is the last 2 digits of the year (mod 28) and leap year=-1 if the year is a leap year
 * and the month is January or February*/
public class PE019CountingSundays{
	
	/*Allows for quick modification of the program by adjusting parameters*/
	public static int DAY=0;
	public static int DATE=1;
	
	public static void main(String args[]){
		int monthList[]={6,2,2,5,0,3,5,1,4,6,2,4},centuryList[]={7,5,3,1,0,-2,-4,-6};//correspond to month codes and century codes
		int numSundays=0,century,defaultSum;
		Scanner keyboard=new Scanner(System.in);
		System.out.print("Which century do you want to check? :");
		century=keyboard.nextInt()-1; // the 20th century has the year prefix "19"
		for(int i=1;i<=12;i++){// iterate through the months
			for(int j=(century*100)+1;j<=(century+1)*100;j++){// for each month check the 1 for every year in the century
				int leap=0;
				if((j-century*100)%4==0&&j%100!=0||(j)%400==0){// condition for year to be a leap year
					if(i==1||i==2){leap=-1;}// corresponds to rule in the formula
				}
				defaultSum=DATE+monthList[i-1]+((j%100)%28)+(((j%100)%28)/4)+centuryList[(j-1600)/100]+leap;
				if(defaultSum%7==DAY){
					numSundays+=1;
				}
			}
		}
		System.out.print("There were "+numSundays+" Sundays in that century");
	}
}
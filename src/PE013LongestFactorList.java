/*Written as challenge for Project Euler(#013)
 * Takes in 100 50-digit numbers and gets the first ten digits of the sum of the numbers
 * I separated the 50 digit numbers into single integers, stored them in an array, and then
 * starting at the end, added up all of the final digits, and added the tens value of that sum onto the next sum
 * and repeated. Had to adjust as the end output has 12 integer values, so only 10 are displayed.*/
import java.util.Scanner;

public class PE013LongestFactorList{
	
	public static void  main(String args[]){
		Scanner keyboard=new Scanner(System.in);
		Integer singleList[][] = new Integer[100][50];
		Integer answer[]=new Integer[10];
		String lineTaker,finalAns ="";
		char num;
		int lineNum=-1,numM=0,total,rollover=0,columnNum=49;
		System.out.print("\n");
		while(true){
			lineNum++;
			if(lineNum==100)break;
			lineTaker=keyboard.nextLine();
			for(int i=0;i<lineTaker.length();i++){
				num=lineTaker.charAt(i);
				numM=Character.getNumericValue(num);
				singleList[lineNum][i]=numM;
			}
		}
		while(columnNum>=0){
			total=0;
			total+=rollover;
			for(int i=0;i<100;i++){
				total+=singleList[i][columnNum];
			}
			if(columnNum==0)answer[columnNum]=total;
			else if(columnNum<=9)answer[columnNum]=total%10;
			rollover=total/10;
			columnNum--;
		}
		for(int i=0;i<answer.length-2;i++){
			finalAns+=answer[i];
		}
		System.out.print(finalAns);
	}
}
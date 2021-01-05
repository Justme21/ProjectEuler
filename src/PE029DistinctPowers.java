import java.util.ArrayList;

/*Written as challenge for Project Euler (#029)
 * This program calculates a^b for 2<=a<=100, 2<=b<=100, and stores each distinct entry in an 
 * arrayList. 
 * The program then prints out the number of entries in the array
 * Used "System.nanoTime()" to calculate how long it was taking for the program to run*/
public class PE029DistinctPowers{
	
	/*Gets a string representation of the ArrayList for easy storage in the ArrayList "powerList"*/
	public static String getString(ArrayList <Integer> number){
		String num="";
		for(int i=number.size()-1;i>=0;i--){
			num+=number.get(i);
		}
		return num;
	}
	
	/*Harvested from PE020FactorialDigitSum and edited/repurposed
	 *Takes in an integer, and the number which is the power to which it is to be raised
	 *Uses a for loop to multiply the number by itself as many times as specifified
	 *For this challenge the numbers become too large to be stored in any single data type, so this 
	 *subroutine breaks the number up into an arrayList and handles it from there.
	 *Minimises memory space required by only adding 0's when necessary to extend the length of the array */
	public static void power(int input,int index,ArrayList <Integer> FactorialArray){
		int temp=0,posit;
		FactorialArray.add(1);//the array needs to start with value 1 to facilitate multiplication
		for(int i=0;i<index;i++){
			posit=0;
			while(posit<FactorialArray.size()){
				FactorialArray.set(posit,FactorialArray.get(posit)*input);
				FactorialArray.set(posit,FactorialArray.get(posit)+temp);
				temp=0;
				if(FactorialArray.get(posit)>=10){
					if(posit==FactorialArray.size()-1){FactorialArray.add(0);}
					temp=FactorialArray.get(posit)/10;
					FactorialArray.set(posit,FactorialArray.get(posit)%10);
				}
				posit++;
			}
		}
	}
	
	public static void main(String args[]){
		long t1=System.nanoTime();
		System.out.println("Start");
		ArrayList <String> powerList=new ArrayList <String>();
		String numString;
		for(int i=2;i<=100;i++){
			for(int j=2;j<=100;j++){
				ArrayList <Integer> number=new ArrayList <Integer>();
				power(i,j,number);//sets number=i^j
				numString=getString(number);// gets a string representation of number
				if(powerList.indexOf(numString)==-1){//returning -1 means that number isn't already in the arrayList
					powerList.add(numString);
				}
			}
		}
		System.out.println(powerList.size()+"    "+((double)(System.nanoTime()-t1)/1000000000));
	}
}
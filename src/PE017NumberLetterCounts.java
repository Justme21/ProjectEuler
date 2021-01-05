import java.util.ArrayList;


/*Written as Challenge for Project Euler (#017)
 * This program gets the number of letters required to write the numbers from "number" to "LIMIT" (inclusive)
 * in words.*/
public class PE017NumberLetterCounts{
	
	/*This is mainly just to make it easier to follow what is going on later on*/
	public static int LIMIT=1000;
	public static int THOUSAND=8;
	public static int HUNDRED=7;
	public static int AND=3;
	public static int TEEN=4;
	public static int saver; //this is necessary for the value of saver to be carried over when working with teens
	
	/*Harvested from PE036 DoubleBasePalindrome. Breaks number up into representation in base "base"*/
	public static ArrayList <Integer> getNumberArray(double Number,int base){
		ArrayList <Integer> array=new ArrayList <Integer>();
		int number= (int) Number;
		while(number>0){
			array.add(0,(int) (number%base));
			number/=base;
		}
		return array;
	}
	
	/*The basic switch used to convert the numbers 0-9 into the number of letters in their words.*/
	public static int basicSwitch(int testNum){
		switch(testNum){
		case 1:case 2:case 6:return 3;
		case 3:case 7:case 8:return 5;
		case 4:case 5:case 9:return 4;
		}
		return 0;
	}
	
	/*Special switch used for 10 ("eleven", "twelve" make this necessary)
	 * cases 3, 5,8 are excluded as they correspond to setting value=-1, which is its default value*/
	public static int tensSwitch(){
		int value=(-1);
		switch(saver){
		case 1: case 2: return 6-basicSwitch(saver);
		case 4:case 6:case 7:case 9: value=0;
		}
		return (value+TEEN);
	}
	
	/*Treats the variety of cases met in treating numbers from 1-1000.
	 * Can easily be adjusted to work for larger numbers */
	public static int getNumberWord(int testNum,int tensValue,boolean otherNum){
		int extra=HUNDRED;
		switch(tensValue){
		case 1: saver=testNum;return basicSwitch(testNum); //treating units, assigns saver to be the unit value in case necessary
		case 2:
			switch(testNum){
			case 1:return tensSwitch(); //if we are addressing numbers 10-19 this is necessary
			case 2:case 3:case 8:case 9:return 6;
			case 4:case 5: case 6:return 5;
			case 7:return 7;
			}
		case 3:
			if(testNum==0){return 0;}//we don't write "zero hundreds"
			if(otherNum){extra+=AND;}// if there have been previous digits in the number we need to include "and"
			return basicSwitch(testNum)+extra;
		case 4:
			if(testNum==0){return 0;}// we don't say "zero thousands", this doesn't really do much unless handling larger numbers
			extra=THOUSAND;
			return basicSwitch(testNum)+extra;
		}
		return 0;
	}
	
	public static void main(String args[]){
		int number=1,wordLength,stringLength=0;
		boolean otherNum; //
		ArrayList <Integer> numList=new ArrayList <Integer>();
		while(number<=LIMIT){
			otherNum=false;// at the start of each number there have been no prior digits
			numList=getNumberArray(number,10); // break number up into base 10 representation
			for(int i=numList.size()-1;i>=0;i--){
				wordLength=getNumberWord(numList.get(i),numList.size()-i,otherNum);
				if (wordLength!=0){otherNum=true;}// if there were letters in the word, then there have been other digits in it
				stringLength+=wordLength;
			}
			number++;
		}
		System.out.println("These numbers use "+stringLength+" letters");
	}
}
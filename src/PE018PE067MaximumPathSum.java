import java.util.ArrayList;
import java.util.Scanner;

/*Written as challenge for Project Euler (#018)
 * This program also works to get solution for challenge #067, which is basically the same problem 
 * on a larger scale
 * This program reads in a list of integers from a triangle (1 number first row, 2 second, and so on
 * The program then calculates the largest possible sum that can be gotten from adding the entries in any 
 * "path"
 * Conor McMeel conceived of the solution which involves starting with the bottom row, adding the largest
 * of each pair of entries to the appropriate entry above it
 * This is repeated until the entry left at the point of the triangle is the largest possible sum of the paths*/
public class PE018PE067MaximumPathSum{
	
	/*Adds the largest entry from each row to the suitable entry above it*/
	public static ArrayList <Integer> reduceRows(ArrayList <Integer>bRow,ArrayList <Integer>tRow){
		for(int i=0;i<tRow.size();i++){
			int adder=bRow.get(i+1);//if the entry at (i) is greater then this value changes in the if statement
			if(bRow.get(i)>=bRow.get(i+1)){
				adder=bRow.get(i);
			}
			tRow.set(i,tRow.get(i)+adder);//add the greatest value to the suitable entry on the row above
		}
		return tRow;//returns the adjusted upper row
	}
	
	public static void main(String args[]){
		Scanner keyboard=new Scanner(System.in);
		int counter=0;//forms the integers into a triangle.
		ArrayList <ArrayList<Integer>> fullTriangle=new ArrayList<ArrayList<Integer>>();//an arrayList to store the rows that are also arrayLists
		while(keyboard.hasNextInt()){// in principle this could lead to errors if there weren't enough numbers.
			ArrayList <Integer> tempRowArray=new ArrayList <Integer>();//stores each row
			for(int i=0;i<=counter;i++){
				tempRowArray.add(keyboard.nextInt());
			}
			fullTriangle.add(tempRowArray);// build the triangle row by row
			counter++;
		}
		for(int i=fullTriangle.size()-1;i>0;i--){// start at the bottom row
			ArrayList<Integer>bottomRow=fullTriangle.get(i),nextUp=fullTriangle.get(i-1);
			fullTriangle.set(i-1,reduceRows(bottomRow,nextUp));//adjust the second to bottom row with each iteration
		}
		System.out.print("The Maximum total of any path is "+fullTriangle.get(0).get(0));//print out the point of the triangle
	}
}
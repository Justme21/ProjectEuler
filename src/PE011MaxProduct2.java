/* Written as challenge for Project Euler (#11)
 * Allows entry of a grid of numbers of an entered height and width
 * The programme then gets the greatest product of four numbers in 
 * any one row or column or diagonal in the list.*/
import java.util.Scanner;

public class PE011MaxProduct2{
	
	static int  result,maxResult=0;
	public static void  main(String args[]){
		Scanner keyboard=new Scanner(System.in);
		int height,width;
		System.out.print("What is the size of the list of numbers (h/w):\n");
		height=keyboard.nextInt();
		width=keyboard.nextInt();
		int numList[][]=new int[height][width];
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				numList[i][j]=keyboard.nextInt();
			}
		}
		System.out.print("Complete. Final entry is: "+numList[height-1][width-1]+"\n");
		for(int j=0;j<height;j++){
			for(int i=0;i<width;i++){
				if(i<width-3)getProduct(numList,i,j,1,0);
				if(j<height-3)getProduct(numList,i,j,0,1);
				if(i<width-3&&j<height-3)getProduct(numList,i,j,1,1);
				if(i>3&&j<height-3)getProduct(numList,i,j,-1,1);
			}
		}
		System.out.print("The final result is: "+maxResult);
	}
	
	public static void getProduct(int numList[][],int posX, int posY, int xMove, int yMove){
		result=1;
		for(int i=0;i<4;i++){
			result*=numList[posY+(yMove*i)][posX+(xMove*i)];
		}
		if(result>maxResult)maxResult=result;
	}
	
}
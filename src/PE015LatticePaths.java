import java.util.Scanner;


public class PE015LatticePaths{
	
	public static void main(String args[]){
		long height, width,total;
		long answer;
		System.out.print("What is the height and width of the matrix?\n");
		Scanner keyboard=new Scanner(System.in);
		height=keyboard.nextInt();
		width=keyboard.nextInt();
		total=height+width;
		for(long i=total-1;i>0;i--){
			total*=i;
		}
		for(long i=height-1;i>0;i--){
			height*=i;
		}
		for(long i=width-1;i>0;i--){
			width*=i;
		}
		answer=total/(height*width); // answer becomes too big to be handled very quickly
		System.out.print("The number of different paths are: "+answer+"\n");
	}
}
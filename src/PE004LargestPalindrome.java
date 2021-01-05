import java.util.ArrayList;

/*Written as challenge for Project Euler
 * Uses brute force to get the largest palindrome that is the product of 2 3-digit numbers
 * More elegant would have been to start at the largest values for i and j, and have worked back
 * Programme isn't very strenuous on computer anyway, not worth changing. */
public class PE004LargestPalindrome{
	
	public static void main(String args[]){
		long product,p1=0,f1=0,f2=0;
		char c1,c2;
		String checker;
		ArrayList<String>numberList=new ArrayList<String>();
		for(int i=100;i<1000;i++){
			for(int j=100;j<1000;j++){
				product=i*j;
				checker=""+product;
				for(int k=0;k<checker.length()/2;k++){
					c1=checker.charAt(k);
					c2=checker.charAt(checker.length()-(1+k));
					if(c1!=c2){break;}
					if(k==(checker.length()/2)-1&&c1==c2){
						if(product>p1){
							p1=product;
							f1=i;
							f2=j;
						}
						System.out.print("Adding "+checker+"\n");
						numberList.add(checker);
					}
				}
			}
		}
		System.out.print("\nThe largest palindrome in this list is "+p1+" whose factors are "+f1+"*"+f2);
	}
}
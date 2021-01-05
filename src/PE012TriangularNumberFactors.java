/*Written as challenge for Project Euler (#012)
 * finds the first triangular number with more than 500 divisors*/

public class PE012TriangularNumberFactors{
	
	public static void main(String args[]){
		int triNum=0,numDivisors=0,adder=1;
		while(numDivisors<500){
			triNum+=adder;
			numDivisors=0;
			for(int i=1;i<triNum;i++){
				if(triNum%i==0)numDivisors++;
			}
			if(numDivisors>500)break;
			else{adder++;}
		}
		System.out.print(triNum+" is the first triangular number with more than 500 divisors.");
	}
}
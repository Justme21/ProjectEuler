
/*This was written as a challenge for Project Euler (#020)
 * Program gets the sum of the digits in n! for some n (in this case n=100) */
public class PE020FactorialDigitSum{

	//these are required for use in multiple routines, so are left global to the program
	int size,N;
	static int MATRIXSIZE=10000;
	static int posJ=MATRIXSIZE-1;

	//Will print a number by reading in a single line from an array, and printing out the integers in reverse order (hence leaving the number the right way round)
	static void printNumber(int[] Array){
		boolean print=false;
		for(int i=1;i<MATRIXSIZE;i++){
			if(Array[i]!=0){print=true;}
			if(print){
				System.out.print(Array[i]);
			}
		}
		System.out.println("");
	}

	/*reads in a number and a 2 dimensional matrix. Then gets that number's factorial by splitting
	 * it into individual integer components and fitting it into an array integer by integer
	 * This function is currently faulty as it reduces divides the numbers by 10 until they all=0*/
	static void factorialise(int input,int[] FactorialArray){
		int temp=0,posit,numZeroes;
		FactorialArray[0]=1;
		while(input>0){
			posit=0;
			numZeroes=0;
			while(true){
				FactorialArray[posit]*=input;
				FactorialArray[posit]+=temp;
				temp=0;
				if(FactorialArray[posit]>=10){
					temp=FactorialArray[posit]/10;
					FactorialArray[posit]=FactorialArray[posit]%10;
				}
				if(FactorialArray[posit]==0){numZeroes++;}
				if(numZeroes>=50||posit==MATRIXSIZE-1){break;}
				else{
					numZeroes=0; // why is this line here?
					posit++;
				}
			}
			input--;
		}
	}

	/* Assigns values from the array to the factorial array. In the array they have been entered in reverse order, so they are transferred
	 * into the factorial array in reverse order so that the numbers are supposed to come out right.
	 * As a result of this process of assignment if the number has more than 1000 digits then the start of it will be cut off**/
	static void assignValues(int[] factorialArray,int arrayPoint){
		factorialArray[posJ]=arrayPoint;
		posJ--;
	}

	/* This creates an array, starts it off with all 0's, then factorialises the number given and puts it into the array, then transfers the values
	 * from array to the factorial array*/
	static void factorialise2(int[] takeArray, int[] takeFactorialArray){
		int[] array=new int[MATRIXSIZE];
		factorialise(takeArray[0],array);
		for(int j=0;j<MATRIXSIZE;j++){
			assignValues(takeFactorialArray,array[j]);
		}
	}

	/*Gets the sum of the entries in the array*/
	static void getSum(int[] FactorialArray){
		int sum=0;
		for(int i=0;i<MATRIXSIZE;i++){
			sum+=FactorialArray[i];
		}
		System.out.println("And the sum is "+sum);
	}

	public static void main(String args[]){
		int[] numeratorArray=new int[1],numeratorFactorialArray=new int[MATRIXSIZE];
		numeratorArray[0]=100; //Only getting the sum of 100!
		factorialise2(numeratorArray,numeratorFactorialArray);
		System.out.print(numeratorArray[0]+"! is: ");
		printNumber(numeratorFactorialArray);
		getSum(numeratorFactorialArray);
		System.out.println("");
	}
}

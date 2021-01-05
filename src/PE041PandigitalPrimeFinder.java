
/*Written as challenge for Project Euler (#041)
 * Task was to find largest n-digit "Pandigital" prime 
 * (where a pandigital prime is a prime which uses the numbers from 1-n exactly once)
 * This program technically stores all of the pandigital primes found in an array, which is unneccessary
 * for this project, but may be useful for something else later.
 * Note: Adam mathematically determined the criteria which stated the prime would need to be >2000 and 
 * less than 80000*/
public class PE041PandigitalPrimeFinder{
	
	/*Breaks the prime up into it's individual digits and stores them in order in an array*/
	static int checkList(int Prime,int[] numberArray){
		int count=0;
		int[] numList=new int[10];
		while(Prime>0){
			numList[count]=Prime%10;
			Prime=(int)(Prime/10);
			count++;
		}
		for(int i=0;i<count;i++){
			numberArray[i]=numList[count-1-i];
		}
		return count;
	}

	/*Checks if the number is Pandigital.
	 * The function checks if each number<=NumNumbers is in the prime.
	 * If they are all there then the number is Pandigital and therefore usable*/
	static boolean numberChecker(int[] PrimeNumber,int NumNumbers){
		boolean usable=true;
		for(int j=1;j<=NumNumbers;j++){
			for(int l=0;l<NumNumbers;l++){
				if(PrimeNumber[l]==j){
					PrimeNumber[l]=0;
					break;
				}
				else if(l==NumNumbers-1){
					usable=false;
				}
			}
		}
		return usable;
	}

	/*Prints out all the entries in the array that aren't =0*/
	static void printOut(int[] Array,int size){
		for(int i=0;i<size;i++){
			if(Array[i]!=0){
				System.out.print(Array[i]);
				if(i!=size-1){
					System.out.print(", ");
				}	
			}
		}
	}

	/*Finds all the primes between MinNum and MaxNum that are pandigital and then stores them in an
	 * an array.*/
	public static int getPrimes(int MinNum,int MaxNum,int PrimeArray[]){
		int posit=0,numNumbers;
		int[] numberHolder=new int[10];
		boolean isPrime;
		for(int num=MinNum;num<=MaxNum;num++){
			isPrime=false;
			numNumbers=checkList(num,numberHolder); //takes each number breaks it up into digits
			if(numberChecker(numberHolder,numNumbers)){ //if it passes this then the number is pandigital
				isPrime=true;
				for(int i=2;i<=(num/2);i++){// brute force method of checking if prime.
					if(num%i==0){
						isPrime=false;
						break;
					}
				}
			}
			if(isPrime){
				PrimeArray[posit]=num; //if isPrime is still through after the for loop then the number has to be prime
				posit++;// This allows for an array made up of primes to be formed
			}
		}
		System.out.println("Complete");
		return posit; //returns the number of primes in the array 
	}

	/*Minimum and Maximum adjustable for versatility purposes.*/
	public static void main(String args[]){
		int maximum,minimum,numPrimes;
		int[] primeArray= new int[1000000];
		maximum=8000000;
		minimum=2000;
		numPrimes=getPrimes(minimum,maximum,primeArray);
		System.out.print("The number you are looking for is: "+primeArray[numPrimes-1]);
	}
}
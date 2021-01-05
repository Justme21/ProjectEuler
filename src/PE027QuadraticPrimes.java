import java.util.ArrayList;

/*INCOMPLETE!!!*/
public class PE027QuadraticPrimes{
	
	public static boolean consequtivePrimes=true;
	//Gets a list of prime numbers less than some given number, and stores them in an array
	// Could put primes into a vector, and it might be worth consideration later, but for the time being
	// it might be useful to know how many primes there are
	public static void getPrimes(int MinNum, int MaxNum, ArrayList <Double> PrimeArray){
		int posit=0;
		boolean isPrime;
		for(int num=MinNum;num<=MaxNum;num++){
			isPrime=true;
			for(int i=2;i<num/2;i++){
				if(num%i==0){
					isPrime=false;
					break;
				}
			}
			if(isPrime){
				double Num=num;
				PrimeArray.add(Num); //if isPrime is still through after the for loop then the number has to be prime
				posit++;// This allows for an array made up of primes to be formed
			}
		}
	}

	
	public static void main(String args[]){
		int startPrime=79,endPrime=100000;
		ArrayList <Double> primeList=new ArrayList <Double>();
		getPrimes(startPrime,endPrime,primeList);
		for(int a=-81;a<999;a+=2){
			for(int i=0;i<primeList.size();i++){
				double b=primeList.get(i);
				if(b<1000.0&&(b%3==1&&a%3==0||b%3==2&&a%3!=0)){
					double factor=(80.0*80.0)+80*a+b;
					if(primeList.indexOf(factor)!=-1){
						consequtivePrimes = true;
						for(int n=0;n<80;n++){
							double factor2=(double)n*(double)n+(double)n*a+b;
							if(primeList.indexOf(factor2)==-1){
								consequtivePrimes=false;
								System.out.println("n= "+n+" a= "+a+" b= "+b);
								break;
							}
						}
						if(consequtivePrimes){
							System.out.println("a= "+a+"  b= "+b+" gives primes for 0-80");
						}
						
					}
				}
			}
			
		}
		
	}
}
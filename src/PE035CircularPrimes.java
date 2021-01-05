import java.util.ArrayList;


public class PE035CircularPrimes{
	
	public static void getPrimes(ArrayList <Integer> PrimeList,int Limit){
		PrimeList.add(2);//2 is the only even prime
		for(int i=3;i<Limit;i+=2){//only checking odd numbers
			boolean prime=true;
			for(int j=2;j<=Math.sqrt(i);j++){
				if(i%j==0){
					prime=false;
					break;}
			}
			if(prime){PrimeList.add(i);}
		}
	}
	
	/*Breaks down the integer prime into an ArrayList*/
	public static void primeBreakdown(int Prime,ArrayList <Integer> PrimeBreakdownList){
		while(Prime>0){
			PrimeBreakdownList.add(0,Prime%10);
			Prime/=10;
		}
	}
	
	/*Reconstructs array of primes as integers*/
	public static int primeRemake(ArrayList <Integer>PrimeRemakeList){
		int prime=0;
		for(int i=0;i<PrimeRemakeList.size();i++){
			prime=prime*10+PrimeRemakeList.get(i);
		}
		return prime;
	}
	
	public static ArrayList <Integer> listShift(ArrayList <Integer>primeList){
		ArrayList <Integer> shiftedPrimeList=new ArrayList <Integer>();
		shiftedPrimeList.add(primeList.get(primeList.size()-1));
		for(int i=0;i<primeList.size()-1;i++){
			shiftedPrimeList.add(primeList.get(i));
		}
		return shiftedPrimeList;
	}
	
	public static int circularTest(ArrayList <Integer>PrimeList,int prime,int maxPrime){
		int Count=0;
		boolean isPrime=true;
		ArrayList <Integer>primeBreakdownList=new ArrayList <Integer>();
		primeBreakdown(prime,primeBreakdownList);
		for(int i=0;i<primeBreakdownList.size();i++){
			if((primeBreakdownList.get(i)%2==0&&prime!=2)||(primeBreakdownList.get(i)%5==0&&prime!=5)){return 0;}
		}
		do{
			primeBreakdownList=listShift(primeBreakdownList);
			int tempPrime=primeRemake(primeBreakdownList);
			if(PrimeList.indexOf(tempPrime)!=-1){
				PrimeList.remove(PrimeList.indexOf(tempPrime));
				if(tempPrime<maxPrime){Count++;}
			}
			else{isPrime=false;}
		}while(primeRemake(primeBreakdownList)!=prime);
		if(isPrime){return Count;}
		else{return 0;}
	}
	
	
	public static void main(String args[]){
		double t1=System.nanoTime();
		int limit=1000000,count=0;
		ArrayList <Integer> primeList=new ArrayList <Integer>();
		getPrimes(primeList,10*limit);
		System.out.println("Got primes "+primeList.size());
		for(int i=0;primeList.get(i)<limit;i++){
			int count1=circularTest(primeList,primeList.get(i),limit);
			if(count1>0){i-=1;}
			count+=count1;
		}
		System.out.println("There are "+count+" circular primes less than "+limit);
		System.out.println("The time is "+((System.nanoTime()-t1)/1000000000));
	}
}
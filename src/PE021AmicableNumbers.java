import java.util.ArrayList;


public class PE021AmicableNumbers{
	
	public static int LIMIT=10000;
	
	public static int getFactorSum(int number){
		if(number==1){return 0;}
		ArrayList <Integer> factors=new ArrayList <Integer>();
		factors.add(1);
		int factorSum=0;
		for(int i=2;i<(number/2)+1;i++){if(number%i==0){factors.add(i);}}
		for(int i=0;i<factors.size();i++){factorSum+=factors.get(i);}
		return factorSum;
	}
	
	public static void main(String args[]){
		ArrayList <Integer> numberList = new ArrayList <Integer>(),factorSumList=new ArrayList <Integer>();
		int factor1,number1,factor2,number2,amicableSum=0;
		for(int i=1;i<LIMIT;i++){
			numberList.add(i);
			factorSumList.add(getFactorSum(i));
		}
		for(int i=1;i<LIMIT;i++){
			number1=numberList.get(i-1);
			factor1=factorSumList.get(i-1);
			if(factor1>0&&number1!=0&&factor1<LIMIT-1){
				number2=numberList.get(factor1-1);
				factor2=factorSumList.get(factor1-1);
				if(factor1==number2&&number1==factor2&&number1!=factor1){
					amicableSum+=number1+number2;
					factorSumList.set(number1-1,0);
					numberList.set(number1-1,0);
					numberList.set(number2-1,0);
					factorSumList.set(number2-1,0);
				}
			}
			
		}
		System.out.println("The sum of all the amicable numbers less than "+LIMIT+" is "+amicableSum);
	}
}
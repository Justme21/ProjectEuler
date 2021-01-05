import java.util.ArrayList;


public class PE463WeirdRecurrenceRelation{
		
	/*Gets a string representation of the ArrayList for easy storage in the ArrayList "powerList"*/
	public static long getInt(ArrayList <Integer> number){
		long num=0,positMultiplier=(long) Math.pow(10,number.size()-1);
		for(int i=0;i<=11&&i<number.size();i++){//only addresses at most last 10 digits
			num+=number.get(i)*positMultiplier;
			positMultiplier/=10;
		}
		return num;
	}
	
	/*Gets a string representation of the ArrayList for easy storage in the ArrayList "powerList"*/
	public static String getString(ArrayList <Integer> number){
		String num="";
		for(int i=0;i<number.size();i++){
			num+=number.get(i);
		}
		return num;
	}
	
	public static ArrayList <Integer> rearrange(ArrayList<Integer> number){
		ArrayList <Integer> replaceNumber=new ArrayList <Integer>();
		for(int i=number.size()-1;i>=0;i--){
			replaceNumber.add(number.get(i));
		}
		return replaceNumber;
	}
	
	/*Harvested from PE020FactorialDigitSum and edited/repurposed
	 *Takes in an integer, and the number which is the power to which it is to be raised
	 *Uses a for loop to multiply the number by itself as many times as specifified
	 *For this challenge the numbers become too large to be stored in any single data type, so this 
	 *subroutine breaks the number up into an arrayList and handles it from there.
	 *Minimises memory space required by only adding 0's when necessary to extend the length of the array */
	public static void power(int input,int index,ArrayList <Integer> FactorialArray){
		int temp=0,posit;
		FactorialArray.add(1);//the array needs to start with value 1 to facilitate multiplication
		for(int i=0;i<index;i++){
			posit=0;
			while(posit<FactorialArray.size()){
				FactorialArray.set(posit,FactorialArray.get(posit)*input);
				FactorialArray.set(posit,FactorialArray.get(posit)+temp);
				temp=0;
				if(FactorialArray.get(posit)>=10){
					if(posit==FactorialArray.size()-1){FactorialArray.add(0);}
					temp=FactorialArray.get(posit)/10;
					FactorialArray.set(posit,FactorialArray.get(posit)%10);
				}
				posit++;
			}
		}
		while(FactorialArray.size()>12){
			FactorialArray.remove(FactorialArray.size()-1);//reduces the length of the number to something manageable
		}
		FactorialArray=rearrange(FactorialArray);
	}
	
	public static ArrayList <Integer> divide(ArrayList <Integer>number,int factor){
		int remainder=0;
		for(int i=0;i<number.size();i++){
			remainder=number.get(i)%factor;
			number.set(i,number.get(i)/factor);
			if(i!=number.size()-1){number.set(i+1,number.get(i+1)+(remainder*10));}
		}
		return number;
	}
	
	public static ArrayList <Integer> multiply(ArrayList <Integer>number,int factor){
		int remainder=0;
		for(int i=number.size()-1;i>=0;i--){
			number.set(i,(number.get(i)*factor)+remainder);
			remainder=number.get(i)/10;
			number.set(i,number.get(i)%10);
		}
		return number;
	}
	
	public static ArrayList <Integer> add(ArrayList <Integer> number,ArrayList <Integer> adder,int plusMinus){
		int remainder=0;
		for(int i=0;i<number.size();i++){
			if(adder.size()>i){number.set(number.size()-1-i, number.get(number.size()-1-i)+(plusMinus*adder.get(i)));}
			if(number.get(i)<0&&i!=0){
				number.set(i, number.get(i)+10);
				number.set(i-1,number.get(i-1)-1);
			}
			remainder=number.get(i)/10;
			number.set(i,number.get(i)%10);
			if(i!=0){number.set(i-1,number.get(i-1)+remainder);}
		}
		return number;
	}
	
	public static int f(ArrayList <Integer>n){
		ArrayList <Integer> one=new ArrayList <Integer>(),three=new ArrayList <Integer>();
		ArrayList <Integer> N1=(ArrayList<Integer>) n.clone(),N2=(ArrayList<Integer>) n.clone();
		one.add(1);
		three.add(3);
		long tempNum=getInt(n);
		if(tempNum==0){System.exit(0);}
		if(tempNum==1){System.out.println("1");return 1;}
		if(tempNum==3){System.out.println("3");return 3;}
		if(tempNum%2==0){System.out.println("%2==0");return f(divide(n,2));}
		if(tempNum%4==1){System.out.println("%4==1");
			ArrayList <Integer> A=add(N1,one,-1);
			ArrayList <Integer> B=divide(A,2);
			ArrayList <Integer> C=add(B,one,1);
			int a=f(C);
			ArrayList <Integer> E=add(N2,one,-1);
			ArrayList <Integer> F=divide(E,4);
			int b=f(F);
			return (2*a)-b;//2f(2n+1)-f(n)*/
		}
		if(tempNum%4==3){System.out.println("%4==3");return 3*(f(add(divide(add(N1,three,-1),2),one,1)))-2*(f(divide(add(N2,three,-1),4)));}//3f(2n+1)-2f(n)
		else{System.out.println("Error");return 0;}
	}
	
	public static void numberBreakup(ArrayList <Integer> number){
		int remainder=0;
		for(int i=0;i<number.size();i++){
			number.set(i,number.get(i)+remainder);
			remainder=0;
			if(number.get(i)>=10){
				remainder=number.get(i)/10;
				number.set(i,number.get(i)%10);
			}
		}
		if(remainder!=0){number.add(remainder);}
	}
	public static void main(String args[]){
		int s=0;
		ArrayList <Integer>numExponent=new ArrayList <Integer>();
		ArrayList <Integer> one=new ArrayList <Integer>(),numberPower=new ArrayList <Integer>();
		one.add(1);
		power(3,37,numberPower);
		for(int i=1;i<=100;i++){
			numExponent.add(i);
			numberBreakup(numExponent);
			numExponent=rearrange(numExponent);
			s+=f(numExponent);
			numExponent.clear();
		}
		System.out.println(s);
	}
}
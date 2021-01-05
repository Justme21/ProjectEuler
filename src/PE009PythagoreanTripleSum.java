
/*Written as challenge for Project Euler (#009)
 * . Find the pythagorean triple whose sum is 1000
 * Returns the product of these numbers also.*/
public class PE009PythagoreanTripleSum{
	
	public static void main(String args[]){
		int a=0,b=0,A,B;
		double c=0,abc;
		for(a=1;a<1000;a++){
			for(b=1;b<1000;b++){
				A=a*a;
				B=b*b;
				c=A+B;
				c=Math.sqrt(c);
				if(a+b+c==1000)break;
			}
			if(a+b+c==1000)break;
		}
		abc=a*b*c;
		System.out.print("a="+a+", b="+b+", c="+c+", the product of abc="+abc);
	}
}
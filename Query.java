package FactorialSolver;

public class Query {
	public static void main(String[] args) {
		
		//Sample usage.
		LugendresFactorizer sample = new LugendresFactorizer(6);
		
		System.out.println(sample.factorial);
		//It returns "720"
		System.out.println(java.util.Arrays.deepToString(sample.factorsAndExps));
		//It returns[[2, 4], [3, 2], [5, 1]]
		System.out.println(sample);	
		//It returns "6! = 720 = 2^4 * 3^2 * 5"
		
		//Sample question.
		//Find the smallest n such that n! ends in 290 zeros.
		//The answer is 1170.
		int answer=0;
		for(int n=1;n<1200;n++) 
		{
			LugendresFactorizer l = new LugendresFactorizer(n);
			String str = l.factorial.toString();
			int zeroCount = 0;
			for(int i=1; i<str.length(); i++) {
				if(str.charAt(str.length()-(i))=='0') zeroCount++;
				else break;
			}
			if (zeroCount >= 290) {
				answer = n;
				break;
			}
		}
		System.out.println(answer);
		
		//You can find the number of zeros by how many times it can be divided by 5.
		//If we start the loop at 5, the sequence of prime numbers is 2,3,5, 
		//so factors[2][1] is the desired number.
		//This answer is also 1170.
		int anotherAnswer=0;
		for(int n=5;n<1200;n++) 
		{
			LugendresFactorizer l = new LugendresFactorizer(n);
			if (l.factorsAndExps[2][1] >= 290) {
				anotherAnswer = n;
				break;
			}
		}
		System.out.println(anotherAnswer);
		
	}
}

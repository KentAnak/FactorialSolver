package FactorialSolver;

public class Query {
	public static void main(String[] args) {
		
		//Sample usage.
		LugendresFactorizer sample = new LugendresFactorizer(6);
		
		System.out.println(sample.factorial);
		//It returns "720"
		System.out.println(java.util.Arrays.deepToString(sample.factors));
		//It returns[[2, 4], [3, 2], [5, 1]]
		System.out.println(sample);	
		//It returns "6! = 720 = 2^4 * 3^2 * 5"
		
		//Sample question.
		//Find the smallest n such that n! ends in 290 zeros.
		//The answer is 1170.
		int answer=0;
		for(int i=1;i<1200;i++) 
		{
			LugendresFactorizer l = new LugendresFactorizer(i);
			String str = l.factorial.toString();
			int zeroCount = 0;
			for(int j=1; j<str.length(); j++) {
				if(str.charAt(str.length()-(j))=='0') zeroCount++;
				else break;
			}
			if (zeroCount >= 290) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
		
		//You can find the number of zeros by how many times it can be divided by 5.
		//If we start the loop at 5, the sequence of prime numbers is 2,3,5, 
		//so factors[2][1] is the desired number.
		//This answer is also 1170.
		int anotherAnswer=0;
		for(int i=5;i<1200;i++) 
		{
			LugendresFactorizer l = new LugendresFactorizer(i);
			if (l.factors[2][1] >= 290) {
				anotherAnswer = i;
				break;
			}
		}
		System.out.println(anotherAnswer);
		
	}
}

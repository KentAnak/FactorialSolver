package FactorialSolver;

public class Query {
	public static void main(String[] args) {
		
		//Sample usage.
		LugendresFactorizer sample = new LugendresFactorizer(6);
		//It returns "720"
		System.out.println(sample.factorial);
		//It returns[[2, 4], [3, 2], [5, 1]]
		System.out.println(java.util.Arrays.deepToString(sample.factors));
		//It returns "6! = 720 = 2^4 * 3^2 * 5"
		System.out.println(sample);	
		
		//Sample question.
		//Find the smallest positive integer n such that n! has 290 zeros at the end of the number.
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
	}
}

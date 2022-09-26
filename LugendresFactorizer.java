package FactorialSolver;

import java.lang.Math;
import java.math.BigInteger;

public class LugendresFactorizer {
	int n;
	BigInteger factorial = BigInteger.ONE;	
	int[][] factors;
	LugendresFactorizer(int inputnum){
		n = inputnum;
		int primeCount=0;
		for(int i=1; i<=n; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));		
			if (isPrimeNumber(i))
			{
				primeCount++;
			}
		}
		factors = new int[primeCount][2];
		int p=0;
		for(int i=1; i<=n; i++) {
			if (isPrimeNumber(i))
			{
				factors[p][0] = i;
				factors[p][1] = 1;
				p++;
			}
		}
		if(p>1) {
			int fp;	
			for(int v=0; v<p; v++) {
				fp=0;
				for(int i=1; i<=n; i++){
					fp += (int)n/(Math.pow(factors[v][0], i));
				}
				factors[v][1]=fp;
			}
		}
	}
	
	private boolean isPrimeNumber( int target )
	{
		if ( 1 >= target ) return false;
		if ( 2 == target ) return true;
		int n = (int)Math.sqrt( target );
		for ( int i = 2; i <= n; ++ i ) {
			if ( 0 == ( target % i ) ) return false;
		}
		return true;
	}
	public String toString() {
		String s = n+"! = "+factorial+" = ";
		for (int i = 0; i< factors.length; i++) {
			if(factors[i][1]==1) s += factors[i][0];
			else s += factors[i][0]+"^"+factors[i][1];
			if(i != factors.length-1) s += " * ";
		}
		return s;
	}
}

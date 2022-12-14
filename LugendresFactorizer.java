package FactorialSolver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;
import java.math.BigInteger;

public class LugendresFactorizer {
	int n;
	BigInteger factorial = BigInteger.ONE;	
	int[][] factorsAndExps;
	LugendresFactorizer(int inputnum){
		n = inputnum;
		if(n < 1) throw new ArithmeticException("Input value must be greater than 0.");

		for(int i=1; i<=n; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));		
		}

		int factors[] = eratosthenesSeive(inputnum);
		int primesCount = factors.length;
		factorsAndExps = new int[primesCount][2];
		for(int i=0; i<primesCount; i++) {
			factorsAndExps[i][0]=factors[i];
			factorsAndExps[i][1] = 1;
		}	
		
		if(primesCount>1) {
			int powerCount;	
			for(int p=0; p<primesCount; p++) {
				powerCount=0;
				for(int i=1; Math.pow(factorsAndExps[p][0], i)<=n; i++){
					powerCount += (int)n/(Math.pow(factorsAndExps[p][0], i));
				}
				factorsAndExps[p][1]=powerCount;
			}
		}
	}
	
	private int[] eratosthenesSeive(int x) {
		List<Integer> primes = new ArrayList<Integer>();
	    boolean isPrime[] = new boolean[x+1];
	    Arrays.fill(isPrime, true);
	    isPrime[0] = false;
	    isPrime[1] = false;
	    
	    int sqrtX = (int) Math.sqrt(x);

	    for(int q=2; q<=sqrtX; q++) {
	        if (isPrime[q]) {
	            for (int powerQ =q*q; powerQ<isPrime.length; powerQ += q) {
	            	isPrime[powerQ] = false;
	            }
	        }
	    }
	    for (int i=2; i<isPrime.length; i++) {
	        if (isPrime[i]) {
	        	primes.add(i);
	        }
	    }
	    return primes.stream().mapToInt(i->i).toArray();
	}
	
	public String toString() {
		String s = n+"! = "+factorial;
		if(n>=3) {
			s+=" = ";
			for (int i = 0; i< factorsAndExps.length; i++) {
				if(factorsAndExps[i][1]==1) s += factorsAndExps[i][0];
				else s += factorsAndExps[i][0]+"^"+factorsAndExps[i][1];
				if(i != factorsAndExps.length-1) s += " * ";
			}
		}
		return s;
	}
}

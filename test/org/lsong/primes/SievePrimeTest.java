package org.lsong.primes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SievePrimeTest {
	
	private ArrayPrime[] arrayPrimes = new ArrayPrime[] {
			new ArrayPrime(2, 1),
			new ArrayPrime(3, 2),
			new ArrayPrime(4, 2),
			new ArrayPrime(5, 3),
			new ArrayPrime(10, 4),
			new ArrayPrime(11, 5),
			new ArrayPrime(84, 23),
			new ArrayPrime(1070, 180),
	// end
	};

	@Test
	public void testArrayPrimes() {
		for (ArrayPrime arrayPrime : arrayPrimes) {
			testArrayPrime(arrayPrime);
		}
	}

	/**
	 * Test Illegal Argument (less than 2 in constructor)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgument() {
		new SievePrime(0);
		new SievePrime(-1);
		new SievePrime(1);
	}

	private void testArrayPrime(ArrayPrime arrayPrime) {
		SievePrime sieve = new SievePrime(arrayPrime.max);
		assertEquals(arrayPrime.primeArray, sieve.getArrayOfPrimes());//(expected correct, actual reality)
	}

	private static class ArrayPrime {
		
		int max;
		int numOfPrimes;
		List<Integer> primeArray = new ArrayList<Integer>();
		Integer[] listPrimes = new Integer[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
				31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
				103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167,
				173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239,
				241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313,
				317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397,
				401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467,
				479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569,
				571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643,
				647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
				739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823,
				827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911,
				919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009,
				1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069,
				};

		public ArrayPrime(int max, int numOfPrimes) {
			this.max = max;
			this.numOfPrimes = numOfPrimes;
			
			Integer[] subset = Arrays.copyOfRange(listPrimes, 0, numOfPrimes);
			primeArray.addAll(Arrays.asList(subset));
			this.primeArray = primeArray;
		}
		
	}

}

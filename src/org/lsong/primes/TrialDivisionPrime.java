package org.lsong.primes;

import java.util.ArrayList;
import java.util.List;

/**
 * Find prime numbers within a range by examining each number using trial
 * division within the specified range. Trial division: test each number by
 * modulo-ing by numbers from the range 2 to the square root (number). If a
 * modulo = 0, then number is not prime - it was divided evenly. If we reach
 * square root (number), then number is prime - no number can divide the number
 * evenly
 * 
 * E.G. User enters 25. Look for primes in range 2 to 25. Check each number 2-25
 * inclusive whether it is a prime number.
 * 
 * Assumes range is no negative (all negative numbers are not prime). Returns
 * list of prime numbers.
 * 
 * @author lsong
 */
public class TrialDivisionPrime {

	/**
	 * Requires that max is not less than two - throws an Illegal Argument
	 * Exception - since there are no prime numbers smaller than 2.
	 * 
	 * Based on the assumption that max is two or greater, prime array will
	 * include prime number 2 and other prime numbers up to and including the
	 * max. E.G. max = 5. primeArray = [2, 3, 5]
	 */
	public static List<Integer> getPrimeArray(int max) {

		// Check that max is not less than two
		if (max < 2) {
			throw new IllegalArgumentException(
					"Number must be greater than or equal to 2. There are no prime numbers smaller than 2.");
		}

		// Declare prime array and add 2 as a prime number.
		List<Integer> primeArray = new ArrayList<Integer>();
		primeArray.add(2);

		checkAllNumbersInRange(max, primeArray);

		return primeArray;
	}

	/**
	 * Calculates the stopping point using squareroot to check if a number is
	 * prime.
	 * 
	 * E.G. if n = 19 then squareroot = 4.35... stopping point = 5. Therefore 5
	 * is the last number needed to be checked a prime before stopping. Check:
	 * 4^2 is still smaller than n, but 5^2 is greater than n.
	 */
	private static int calculateStopPoint(int n) {
		return (int) Math.sqrt(n) + 1;
	}

	/**
	 * Assumes int n is >= 2. Returns a boolean whether n is prime or not. Check
	 * if prime by dividing by all numbers up to stopping point of
	 * squareroot(n).
	 */
	private static boolean isPrimeNumber(int n) {
		int stopPoint = calculateStopPoint(n);

		for (int i = 2; i <= stopPoint; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Loops through all numbers from 2 to maximum (inclusive) to check if
	 * numbers are prime. If numbers are prime, they are added to the prime
	 * array.
	 */
	private static void checkAllNumbersInRange(int max, List<Integer> primeArray) {
		for (int i = 2; i <= max; i++) {
			if (isPrimeNumber(i)) {
				primeArray.add(i);
			}
		}
	}
}

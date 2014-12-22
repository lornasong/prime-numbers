package org.lsong.primes;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Find all prime numbers within a range using the algorithm from the Sieve of
 * Eratosthenes. Sieve: marks all multiples of a prime as non-prime beginning
 * with prime number 2. The numbers not marked as multiples of a prime are then
 * prime numbers.
 * 
 * E.G. User enters 25. Look for primes in range 2 to 25. Check each number 2-25
 * inclusive whether it is a prime number.
 * 
 * Assumes range is not negative (all negative numbers are not prime). Assumes
 * user entered a number greater than 1 or else throws an Exception. Returns
 * list of prime numbers.
 * 
 * @author lsong
 */
public class SievePrime {

	private final int max;
	private int stopNum;// Stopping point

	private BitSet primeBit = new BitSet();// Bitset of index 0 to max-2
	//List of prime numbers
	private final List<Integer> primeArray = new ArrayList<Integer>();
	
	public SievePrime(int max) {

		if (max < 2) {
			throw new IllegalArgumentException(
					"Number must be 2 or greater. There are no prime numbers smaller than 2.");
		}

		this.max = max;
		this.stopNum = calculateStopNum(max);
		createBitSet();

		int prime = findNextPrimeIndex();//could just set 0, 1 bit and sit there.
		//could have set 2 as first prime
		recursiveSieve(prime);
		findRemainingPrimes(0);
	}

	public List<Integer> getArrayOfPrimes() {
		return primeArray;
	}

	/**
	 * Calculates and returns the stopping point: squareroot(max) + 1 inclusive.
	 * Beyond this point it is no longer necessary to check for primes because
	 * (stoping point)^2 is greater than the max.
	 * 
	 * E.G. if max = 19 then squareroot = 4.35... stopping point = 5. Therefore
	 * 5 is the last number needed to be checked a prime before stopping. Check:
	 * 4^2 is still smaller than max, but 5^2 is greater than max.
	 */
	private int calculateStopNum(int max) {
		return (int) Math.sqrt(max) + 1;
	}

	/**
	 * Sets primeBit from range 0 to max - 2 where index 0 corresponds with
	 * number 2 and index max -2 corresponds with number max. This is because 0
	 * and 1 are not prime numbers, so we begin with 2.
	 *///doc private methods are for self. can create in line if only called once.
	//or if you want to isolate to comment
	private void createBitSet() {
		primeBit.set(0, max - 1);
	}

	/**
	 * Returns the index of the next prime number by identifying the first
	 * 'true' in the bitset. Also adds this number (index + 2) to the ArrayList
	 * of prime numbers. Then sets the index to false in bitset.
	 */
	private int findNextPrimeIndex() {
		int primeIndex = primeBit.nextSetBit(0);//protect this in case returns -1
		//b.c no more prime numbers. e.g. if statement.

		primeArray.add(primeIndex + 2);//kernel method a method that people call. a tiny method.
		primeBit.set(primeIndex, false);

		return primeIndex;
	}

	/**
	 * Loops through indexes of multiples of a prime number (not including
	 * itself) and sets the multiple indexes to false.
	 * 
	 * E.G. primeIndex = 5, then prime number is actually 7. so multiple = 7.
	 * The multiples that need canceling are 14, 21, 28... Therefore the indexes
	 * that are canceled are 12, 19, 26...
	 */
	private void flipPrimeMultiples(int primeIndex) {

		int multiple = primeIndex + 2;

		for (int i = (primeIndex + multiple); i < (max - 1); i += multiple) {
			primeBit.set(i, false);
		}
	}

	/**
	 * Recursively takes a primeIndex, sets all indexes of multiples of prime to
	 * be false. Find next primeIndex and continues. Stops once prime number
	 * (primeIndex + 2) is greater than or equal to the stopping point stopNum.
	 */
	private boolean recursiveSieve(int primeIndex) {

		if ((primeIndex + 2) >= stopNum) { // base case
			return false;
		} else {
			flipPrimeMultiples(primeIndex);
			int nextPrimeIndex = findNextPrimeIndex();

			return recursiveSieve(nextPrimeIndex);
		}
	}

	/**
	 * Assumes all remaining true bits in bitset are prime numbers. Finds next
	 * bit, flips to false, adds the prime number to array... Continues until
	 * the bitset is empty.
	 */
	private boolean findRemainingPrimes(int nextIndex) {

		if (primeBit.isEmpty()) {
			return false;
		} else {
			nextIndex = primeBit.nextSetBit(nextIndex);
			primeBit.set(nextIndex, false);
			primeArray.add(nextIndex + 2);
			return findRemainingPrimes(nextIndex);
		}
	}

}

package org.lsong.primes;

import java.util.ArrayList;
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
	
	private final List<Integer> primeArray = new ArrayList<Integer>();
	public final int max;
	private int stop;
	
	public SievePrime(int max){
		//try catch max < 2
		this.max = max;
		//this.stop = calculateStop(max);
		//recursiveSieve(2);
		//addRemainingPrimes();
	}
	
	/*
	 * calculateStop(max)
	 * returns the squareroot of the user's int (max) (ceiling). calculation for prime stops
	 * once exceed the squareroot of user int
	 *	call this in constructor
	 * 
	 * private createBitSet()
	 * fill an 'array' from 0 to max-2. False default. (True means it is a multiple of a prime.)
	 * 
	 * 
	 * findNextPrimeIndex(bitset)
	 * scans bitset starting from index 0 (int 2) and identifies the first 'false' which is
	 * the next prime number. adds prime number to ArrayList. returns index of the next prime number
	 * 
	 * 
	 * fillInPrimeMultiples(array, primeIndex)
	 * set primeIndex to be true
	 * loops through the multiples of prime and sets those indexes to also be true
	 * 
	 * private boolean recursiveSieve(array, primeIndex)
	 * (call this in constructor as recursive(findNextPrimeIndex())) start at two
	 * if (primeIndex + 2 > stop)
	 *  return false;
	 * else
	 * 	fillInPrimeMultiples(primeIndex);
	 *  nextPrimeIndex = findNextPrimeIndex();
	 *  return recursiveSieve(nextPrimeIndex);
	 *  
	 * addRemainingPrimes(bitset)
	 * scan through remaining bitset and any Falses can be assumed to be primes. add them to the array
	 * for loop
	 */

}

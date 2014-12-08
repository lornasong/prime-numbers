package org.lsong.primes;

/**
 * Find all prime numbers within a range using the algorithm from the Sieve of
 * Eratosthenes. Sieve: marks all multiples of a prime as non-prime beginning
 * with prime number 2. The numbers not marked as multiples of a prime are then
 * prime numbers.
 * 
 * E.G. User enters 25. Look for primes in range 2 to 25. Check each number 2-25
 * inclusive whether it is a prime number.
 * 
 * Assumes range is no negative (all negative numbers are not prime). Returns
 * list of prime numbers.
 * 
 * @author lornasong
 */
public class SievePrime {
	
	public final int max;
	
	public SievePrime(int max){
		this.max = max;
	}

}

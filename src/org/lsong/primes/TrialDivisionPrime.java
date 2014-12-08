package org.lsong.primes;

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

}

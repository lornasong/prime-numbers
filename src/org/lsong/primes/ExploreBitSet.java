package org.lsong.primes;

import java.util.BitSet;

public class ExploreBitSet {

	public static void main(String[] args) {
		//Test/Play with bitset
		BitSet test = new BitSet(10);//size of bitset is 10 bits
		for(int i = 0; i <10; i++){
			test.set(i); //sets indexes of bits. all with value of true
		}
		System.out.println(test);
		test.flip(2); //sets bitset index 2 equal to false
		System.out.println(test);//returns indexes of true bits in an array
		System.out.println(test.get(0));//returns boolean of index 0
		
		System.out.println("--------------");
		//test multiples of two
		BitSet two = new BitSet(10);
		//fill bitset with trues
		two.set(0, 10);
		System.out.println(two);
		//get first prime number (2). index 0
		int primeIndex = two.nextSetBit(0);
		System.out.println(primeIndex);
		//flip prime number and multiples of two
		int multiple = 2;
		for (int i = primeIndex; i <10; i += multiple){
			two.set(i, false);
		}
		System.out.println(two);
		
		System.out.println("--------------");
		BitSet empty = new BitSet(2);
		empty.set(0, 1);
		System.out.println(empty);
		empty.flip(0, 1);
		System.out.println(empty);
		System.out.println(empty.nextSetBit(0)); //when no more nextSetBit, then returns -1
		System.out.println(empty.isEmpty());

	}

}

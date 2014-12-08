package org.lsong.primes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author lsong
 *
 */
public class Controller {

	public static void main(String[] args) {

		Controller controller = new Controller();

		controller.doMain();
	}

	private void doMain() {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out
				.println("Please enter a number greater than or equal to 2:");
		int input = getInt(reader);
		
		SievePrime test = new SievePrime(input);
		
		for (int i: test.getArrayOfPrimes()){
			System.out.print(i + ", ");
		}

	}
	
	private int getInt(BufferedReader reader) {
		try {
			int input = Integer.parseInt(reader.readLine());
			
			if (input >= 2){
				return input;
			}
			else{
				System.out.println("Error: input must be an integer 2 or greater.");
				System.out.println("Please try again:");
				return getInt(reader);
			}
			
		} catch (NumberFormatException e) {
			System.out.println("Error: input must be an integer 2 or greater");
			System.out
					.println("Please re-enter a number:");
			return getInt(reader);
		} catch (IOException e) {
			System.out.println("Error occurred");
			e.printStackTrace();
		}
		return 0;
	}

}

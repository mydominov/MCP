/**
 * 
 */
package com.calango.MCP.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author calango
 *
 */
public class TransferNumberTests {

	@Test
	public void testFromOctoToBinary1() {
		//List<Integer> answer = Arrays.asList(0,0,0,0,0,0,0,0,1,0,1,1,1,0,1,1,1,1,0,1);
		String answer = "101110111101";

		final String number = "5675";
		String a = TransferNumber.fromOctoToBinary(number);
		System.out.println(a);
		//a.forEach(i->{System.out.print(i + " ");});
		Assert.assertEquals(answer, TransferNumber.fromOctoToBinary(number));
	}
	
	@Test
	public void testFromOctoToBinary2() {
		String answer = "1011";

		final String number = "13";
		String a = TransferNumber.fromOctoToBinary(number);
		System.out.println(a);
		Assert.assertEquals(answer, TransferNumber.fromOctoToBinary(number));
	}

}

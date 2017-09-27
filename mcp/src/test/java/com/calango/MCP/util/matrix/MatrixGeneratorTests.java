/**
 * 
 */
package com.calango.MCP.util.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author calango
 *
 */
public class MatrixGeneratorTests {

	/**
	 * Test method for {@link com.calango.SelfMatrixLinearSequentialMachines.util.matrix.MatrixGenerator#createFromPolynomialA(long, int)}.
	 */
	@Test
	public void testCreateFromPolynomialA() {
		/*List<List<Integer>> answer = new ArrayList<>();
		List<Integer> temp = Arrays.asList(1,1,1,0,1);
		answer.add(temp);
		temp = Arrays.asList(1,0,0,0,0);
		answer.add(temp);
		temp = Arrays.asList(0,1,0,0,0);
		answer.add(temp);
		temp = Arrays.asList(0,0,1,0,0);
		answer.add(temp);
		temp = Arrays.asList(0,0,0,1,0);
		answer.add(temp);
		
		String polynomial = "5675";
		int length = 5;
		List<List<Integer>> res = MatrixGenerator.createFromPolynomialA(polynomial, length);
		Assert.assertEquals(answer, res);*/
	}

	@Test
	public void testcreateFromPolynomialB() {
		/*List<List<Integer>> answer = new ArrayList<>();
		
		List<Integer> tempLine = new ArrayList<>(Arrays.asList(1,1,0,0,0));
		answer.add(tempLine);
		tempLine = Arrays.asList(1,0,1,0,0);
		answer.add(tempLine);
		tempLine = Arrays.asList(1,0,0,1,0);
		answer.add(tempLine);
		tempLine = Arrays.asList(0,0,0,0,1);
		answer.add(tempLine);
		tempLine = Arrays.asList(1,0,0,0,0);
		answer.add(tempLine);
		
		String polynomial = "5675";
		int length = 5;
		List<List<Integer>> result = MatrixGenerator.createFromPolynomialB(polynomial, length);
		Assert.assertEquals(answer, result);*/
	}
}

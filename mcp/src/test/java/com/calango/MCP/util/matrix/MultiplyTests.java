/**
 * 
 */
package com.calango.MCP.util.matrix;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.calango.MCP.util.matrix.Multiply;

/**
 * @author calango
 *
 */
public class MultiplyTests {

	/**
	 * Test method for {@link com.calango.SelfMatrixLinearSequentialMachines.util.matrix.Multiply#multiply(java.util.List, java.util.List)}.
	 */
	@Test
	public void testMultiply1() {
		List<List<Integer>> mx1 = new ArrayList<>();
		List<List<Integer>> mx2 = new ArrayList<>();
		
		List<Integer> str = new ArrayList<>();
		str.add(1);
		str.add(1);
		str.add(1);
		
		mx1.add(str);
		
		str = new ArrayList<>();
		str.add(1);
		str.add(1);
		mx2.add(str);
		
		str = new ArrayList<>();
		str.add(1);
		str.add(0);
		mx2.add(str);
		
		List<List<Integer>> res = Multiply.multiplyMatrix(mx1, mx2);
		Assert.assertNull(res);
	}

	@Test
	public void testMultiply2() {
		List<List<Integer>> result = new ArrayList<>();
		result.add(Arrays.asList(2,1));
		List<List<Integer>> mx1 = new ArrayList<>();
		List<List<Integer>> mx2 = new ArrayList<>();
		
		List<Integer> str = new ArrayList<>();
		str.add(1);
		str.add(1);
		
		mx1.add(str);
		
		str = new ArrayList<>();
		str.add(1);
		str.add(1);
		mx2.add(str);
		
		str = new ArrayList<>();
		str.add(1);
		str.add(0);
		mx2.add(str);
		
		List<List<Integer>> res = Multiply.multiplyMatrix(mx1, mx2);
		Assert.assertEquals(result, res);
		
	}
	
}

/**
 * 
 */
package com.calango.MCP.util;

import java.util.List;

import org.junit.Test;

import com.calango.MCP.util.matrix.MatrixGenerator;

/**
 * @author calango
 *
 */
public class MatrixGeneratorTests {

	/**
	 * Test method for {@link com.calango.MCP.util.MatrixGenerator#generateAutoMatrix(int, int)}.
	 */
	@Test
	public void testGenerateAutoMatrix() {
		List<List<Integer>> res = MatrixGenerator.generateAutoMatrix(3, 4);
		System.out.println("AUTO:");
		/*res.forEach(sub -> {
			System.out.println();
			sub.forEach(el -> {
				System.out.print(el + " ");
			});
		});*/
	}

	/**
	 * Test method for {@link com.calango.MCP.util.MatrixGenerator#generateDiagMatrix(int, int)}.
	 */
	@Test
	public void testGenerateDiagMatrix() {
		List<List<Integer>> res = MatrixGenerator.generateDiagMatrix(3, 4);
		System.out.println("Diag:");
		/*res.forEach(sub -> {
			System.out.println();
			sub.forEach(el -> {
				System.out.print(el + " ");
			});
		});*/
	}

}

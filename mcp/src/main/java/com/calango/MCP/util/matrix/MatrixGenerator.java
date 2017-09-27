/**
 * 
 */
package com.calango.MCP.util.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author calango
 *
 */
public class MatrixGenerator {

	/**
	 * 
	 */
	private final static int ZERO = 0;
	
	private final static int IDENTITY = 1;
	
	public static List<List<Integer>> createFromPolynomialA(
			String polynomial) {
		int length = polynomial.length() - 1;
		List<List<Integer>> matrix = new ArrayList<>(length);
		List<Integer> primaryLine = new ArrayList<>(length);
		for (int i = 1; i < polynomial.length(); ++i) {
			primaryLine.add(Character.getNumericValue(polynomial.charAt(i)));
		}
		matrix.add(primaryLine);
		
		for (int i = 1; i < length; ++i) {
			primaryLine = new ArrayList<>(length);
			for (int j = 0; j < length; ++j) {
				if (j == (i - 1)) {
					primaryLine.add(IDENTITY);
				} else {
					primaryLine.add(ZERO);
				}
			}
			matrix.add(primaryLine);
		}
		
		return matrix;
	}
	
	public static List<List<Integer>> createFromPolynomialB(
			String polynomial) {
		int length = polynomial.length() - 1;
		List<List<Integer>> matrix = new ArrayList<>(length);
		List<Integer> primaryLine = new ArrayList<>(length);
		for (int i = 1; i < polynomial.length(); ++i) {
			primaryLine.add(Character.getNumericValue(polynomial.charAt(i)));
		}
		List<Integer> tempLine;
		for (int i = 0; i < length; ++i) {
			tempLine = new ArrayList<>(length);
			for (int j = 0; j < length; ++j) {
				if (j == 0) {
					tempLine.add(primaryLine.get(i));
				} else {
					if ((i+1) == j) {
						tempLine.add(IDENTITY);
					} else {
						tempLine.add(ZERO);
					}
				}
			}
			matrix.add(tempLine);
		}
		
		return matrix;
	}
	
	public static List<List<Integer>> generateAutoMatrix(int it, int jt) {
		List<List<Integer>> result = new ArrayList<>(it);
		Random ran = new Random();
		List<Integer> line;
		for (int i = 0; i < it; ++i) {
			line = new ArrayList<>(jt);
			for (int j = 0; j < jt; ++j) {
				line.add(ran.nextInt(2));
			}
			result.add(line);
		}
		return result;
	}
	
	public static List<List<Integer>> generateDiagMatrix(int it, int jt) {
		List<List<Integer>> result = new ArrayList<>(it);
		List<Integer> line;
		for (int i = 0; i < it; ++i) {
			line = new ArrayList<>(jt);
			for (int j = 0; j < jt; ++j) {
				line.add((i == j)? (1) : (0));
			}
			result.add(line);
		}
		return result;
	}
	
	public static List<List<Integer>> generateSmithMatrix(int it, int jt, int r) {
		List<List<Integer>> result = new ArrayList<>(it);
		List<Integer> line;
		for (int i = 0; i < it; ++i) {
			line = new ArrayList<>(jt);
			for (int j = 0; j < jt; ++j) {
				line.add(((i == j) && (i < r))? (1) : (0));
			}
			result.add(line);
		}
		return result;
	}
}

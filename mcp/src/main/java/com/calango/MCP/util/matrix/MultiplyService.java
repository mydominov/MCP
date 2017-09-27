/**
 * 
 */
package com.calango.MCP.util.matrix;

import java.util.List;

import com.calango.MCP.exception.IncompatibleMatricies;


/**
 * @author calango
 *
 */
public class MultiplyService {

	public static boolean isOK(List<List<Integer>> arr1, List<List<Integer>> arr2) {
		return (arr1.get(0).size() == arr2.size()) ? (true) : (false);
	}
	
	public static boolean areSimilar(List<List<Integer>> a, List<List<Integer>> b) {
		int i,j;
		for (i = 0; i < a.size(); ++i) {
			for (j = 0; j < a.get(0).size(); ++j) {
				if (!a.get(i).get(j).equals(b.get(i).get(j))) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static List<List<Integer>> serve(List<List<Integer>> s, List<List<Integer>> a,
			List<List<Integer>> b, int num) throws IncompatibleMatricies {

		if (isOK(a, s) && isOK(s, b)) {
			// S(i+1) = A * S(i) * B
			for (int i = 0; i < num; ++i) {
				s = Multiply.multiplyMatrix(Multiply.multiplyMatrix(a, s), b);
			}
			return s;
		} else {
			throw new IncompatibleMatricies();
		}
		
	}
	
	public static Integer checkPeriod(List<List<Integer>> a, List<List<Integer>> b, 
			List<List<Integer>> s, List<List<Integer>> s0) throws IncompatibleMatricies {
		if (isOK(a, s) && isOK(s, b)) {
			Integer result = 0;
			do {
				s = Multiply.multiplyMatrix(Multiply.multiplyMatrix(a, s), b);
				++result;
			} while (!areSimilar(s, s0));
			return result;
		} else {
			throw new IncompatibleMatricies();
		}
	}
}

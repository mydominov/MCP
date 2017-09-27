package com.calango.MCP.util.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author calango
 *
 */
public class Multiply {
	
	public static List<List<Integer>> multiplyMatrix(List<List<Integer>> arr1, List<List<Integer>> arr2) {
		List<List<Integer>> answer = new ArrayList<>(arr1.size());
		int temp;
		for (int i = 0 ; i < arr1.size(); ++i) {
			answer.add(i, new ArrayList<Integer>(arr2.get(0).size()));
			for (int j = 0; j < arr2.get(0).size(); ++j) {
				temp = 0;
				for (int k = 0; k < arr2.size(); ++k) {
					temp ^= arr1.get(i).get(k)
							& arr2.get(k).get(j);
				}
				answer.get(i).add(j, temp % 2);
			}
		}
		/*IntStream.range(0, arr1.size()).forEach(globalI -> {
			answer.add(globalI, new ArrayList<>(arr2.get(0).size()));
			IntStream.range(0, arr2.get(0).size()).forEach(globalJ -> {
				TempValue temp = new TempValue();
				IntStream.range(0, arr2.size()).forEach(element -> {
					temp.inc(
						arr1.get(globalI).get(element)
							* arr2.get(element).get(globalJ));
				});
				answer.get(globalI).add(globalJ, temp.getTempValue());
			});
		});*/

		return answer;
	}
}

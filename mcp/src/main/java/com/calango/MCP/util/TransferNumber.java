/**
 * 
 */
package com.calango.MCP.util;

/**
 * @author calango
 *
 */
public class TransferNumber {

	public static String fromOctoToBinary(String value) {
		int tempValue, secondVal, thirdVal;
		int counter = value.length() - 1;
		StringBuffer binary = new StringBuffer();

		while (counter >= 0) {
			tempValue = Character.getNumericValue(value.charAt(counter));
			thirdVal = tempValue / 4;
			tempValue -= thirdVal * 4;
			secondVal = tempValue / 2;
			tempValue -= secondVal * 2;
			binary.append(tempValue);

			if ((counter != 0) || ((counter == 0) && (thirdVal != 0))) {
				binary.append(secondVal);
				binary.append(thirdVal);
			} else {
				if (secondVal != 0) {
					binary.append(secondVal);
				}
			}
			
			--counter;
		}
		binary = binary.reverse();
		return binary.toString();
	}

	private static int nod(int a, int b) {
		while ((a != 0) && (b != 0)) {
			if (a > b) {
				a = a % b;
			} else {
				b = b % a;
			}
		}
		return (a + b);
	}

	public static int countT(int length, short j) {
		int temp = (int) (Math.pow(2, length) - 1);
		return (int) (temp / (nod(temp, j)));
	}
}
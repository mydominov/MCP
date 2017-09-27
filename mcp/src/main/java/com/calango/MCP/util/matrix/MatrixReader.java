package com.calango.MCP.util.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calango
 */
public class MatrixReader {
    
    public static final List<List<Integer>> readMatrix(String matrix) 
    		throws IllegalArgumentException {
    	List<List<Integer>> readyMatrix = new ArrayList<>();
    	try (BufferedReader reader = new BufferedReader(
        		new StringReader(matrix))) {
    		String[] spiltLine;
    		List<Integer> mxLines;
    		for (String line; (line = reader.readLine()) != null;) {
    			mxLines = new ArrayList<>();
    			spiltLine = line.split(" ");
    			for (String number : spiltLine) {
    				if (!number.equals("")) {
    					mxLines.add(Integer.parseInt(number));
    				}
    			}
    			readyMatrix.add(mxLines);
    		}
    	} catch (IOException e) {
    		//TODO: LOG4J2
			e.printStackTrace();
		} catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid input of data.");
        }
    	
    	return readyMatrix;
    }
    
}

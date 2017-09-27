/**
 * 
 */
package com.calango.MCP.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.calango.MCP.exception.IncompatibleMatricies;
import com.calango.MCP.util.matrix.MatrixGenerator;
import com.calango.MCP.util.matrix.MatrixReader;
import com.calango.MCP.util.matrix.MultiplyService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author calango
 *
 */
@RestController
public class MatrixController {

	@RequestMapping(value="generateSmithMatrix")
	public ResponseEntity<List<List<Integer>>> generateSmithMatrix(@RequestBody String obj) {
		List<List<Integer>> result = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(obj);
			//System.out.println(root.path("i").asInt() + " " + root.path("j").asInt() + " " + root.path("mode").asText());
			
			int i = root.path("i").asInt();
			int j = root.path("j").asInt();
			int r = root.path("r").asInt();
			result = MatrixGenerator.generateSmithMatrix(i, j, r);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="generateMatrix")
	public ResponseEntity<List<List<Integer>>> generateMatrix(@RequestBody String obj) {
		List<List<Integer>> result = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(obj);
			//System.out.println(root.path("i").asInt() + " " + root.path("j").asInt() + " " + root.path("mode").asText());
			
			int i = root.path("i").asInt();
			int j = root.path("j").asInt();
			switch (root.path("mode").asText()) {
				case "auto": {
					result = MatrixGenerator.generateAutoMatrix(i, j);
					break;
				}
				case "diag": {
					result = MatrixGenerator.generateDiagMatrix(i, j);
					break;
				}
				case "block": {
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="getMatrixAFromNumber", method = RequestMethod.POST)
	public ResponseEntity<List<List<Integer>>> generateMatrixAFromNumber(@RequestBody String obj) {
		List<List<Integer>> result = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(obj);
			
			String number = root.path("number").asText();
			result = MatrixGenerator.createFromPolynomialA(number);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="getMatrixBFromNumber")
	public ResponseEntity<List<List<Integer>>> generateMatrixBFromNumber(@RequestBody String obj) {
		List<List<Integer>> result = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(obj);
			
			String number = root.path("number").asText();
			result = MatrixGenerator.createFromPolynomialB(number);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/multiply")
	public ResponseEntity<List<List<Integer>>> multiplyMatrices(
			@RequestBody String obj) throws IncompatibleMatricies {
		List<List<Integer>> result =  new ArrayList<>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(obj);
			String a = root.path("A").asText();
			String b = root.path("B").asText();
			String s = root.path("S").asText();
			int iteration = root.path("iteration").asInt();
			
			List<List<Integer>> mxA = MatrixReader.readMatrix(a);
			List<List<Integer>> mxB = MatrixReader.readMatrix(b);
			List<List<Integer>> mxS = MatrixReader.readMatrix(s);
			
			result = MultiplyService.serve(mxS, mxA, mxB, iteration);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(result);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/checkPeriod", method = RequestMethod.POST)
	public ResponseEntity<Integer> checkPeriod(@RequestBody String obj) throws IncompatibleMatricies {
		Integer result = 0;
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(obj);
			String a = root.path("A").asText();
			String b = root.path("B").asText();
			String s = root.path("S").asText();
			String s0 = root.path("S0").asText();
			
			List<List<Integer>> mxA = MatrixReader.readMatrix(a);
			List<List<Integer>> mxB = MatrixReader.readMatrix(b);
			List<List<Integer>> mxS = MatrixReader.readMatrix(s);
			List<List<Integer>> mxS0 = MatrixReader.readMatrix(s0);
			
			result = MultiplyService.checkPeriod(mxA, mxB, mxS, mxS0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}

@ControllerAdvice
class MainExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(IncompatibleMatricies.class)
    public void handleConflict() {
        // Nothing to do
    }
}
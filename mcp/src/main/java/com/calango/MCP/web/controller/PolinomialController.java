/**
 * 
 */
package com.calango.MCP.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calango.MCP.db.dao.impl.PolynomialDAOImpl;
import com.calango.MCP.db.model.Polynomial;
import com.calango.MCP.util.TransferNumber;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PolinomialController {

	@RequestMapping(value="getPolinomials")
	public Resources<Polynomial> getPolinomials(@RequestBody String obj) {
		List<Polynomial> result =  new ArrayList<>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(obj);
			//String property = root.path("property").asText();
			int length = root.path("length").asInt();
			
			PolynomialDAOImpl polyDao = new PolynomialDAOImpl();
			
			result = polyDao.getPolynominals(length);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Resources<>(result);
	}
	
	@RequestMapping(value="addPolinomial")
	public ResponseEntity<Void> addPolinomial(@RequestBody String obj) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
		
			final Polynomial pol = objectMapper.readValue(obj, Polynomial.class);
			pol.setT(TransferNumber.countT(pol.getLength(), pol.getJ()));
			pol.setNumber(TransferNumber.fromOctoToBinary(pol.getFunction()));
			PolynomialDAOImpl dao = new PolynomialDAOImpl();
			dao.addPolynominal(pol);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

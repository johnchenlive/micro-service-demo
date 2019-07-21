package com.abc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.demo.Constant;
import com.abc.demo.NumberOutOfRangeException;
import com.abc.demo.service.RomanNumeralService;


/**
 * This is the entry point of the Roman Numeral Service
 */
@RestController
@RequestMapping(value = "/romannumeral")
public class RomanNumeralController {

	@Autowired
	private RomanNumeralService romanNumeralService;

	/**
	 * This is the entry point of the HTTP Endpoint - http://HOST_NAME:8080/romannumeral?query={integer}
	 * @param value The value of the request parameter "query"
	 * @return response
	 */
	@RequestMapping
	public ResponseEntity<String> getRomanNumeral(@RequestParam(Constant.REQUEST_PARAM_QUERY) String value) {	
		int num = 0;
		String result = "";
		
		try {
			num = Integer.parseInt(value);
		}catch(NumberFormatException e){
			return ResponseEntity.badRequest().body(Constant.MESSAGE_ERROR_NOT_NUMBER);
		}
		
		try{
			result = romanNumeralService.intToRoman(num);
		}catch(NumberOutOfRangeException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		if (result == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(result);
	}
}

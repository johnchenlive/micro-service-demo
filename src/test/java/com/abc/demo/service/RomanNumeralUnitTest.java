package com.abc.demo.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.abc.demo.Application;
import com.abc.demo.Constant;
import com.abc.demo.NumberOutOfRangeException;
import com.abc.demo.service.impl.RomanNumeralServiceImpl;

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.NONE,
		classes = {
			Application.class
			}
		)
@RunWith(SpringRunner.class)
@Import(value = {RomanNumeralServiceImpl.class})
public class RomanNumeralUnitTest {
	
	@Autowired
	private RomanNumeralService romanNumeralService;

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * The other below ten cases are covered by the other test cases in this class.
	 * @throws NumberOutOfRangeException
	 */
	@Test
	public void testBelowTen() throws NumberOutOfRangeException {
		int num = 8;
		String result = romanNumeralService.intToRoman(num);
		Assert.assertEquals("VIII", result);
	}
	
	@Test
	public void testLowerTens() throws NumberOutOfRangeException {
		int num = 24;
		String result = romanNumeralService.intToRoman(num);
		Assert.assertEquals("XXIV", result);
	}
	
	@Test
	public void testFourty() throws NumberOutOfRangeException {
		int num = 49;
		String result = romanNumeralService.intToRoman(num);
		Assert.assertEquals("XLIX", result);
	}
	
	@Test
	public void testUpperTens() throws NumberOutOfRangeException {
		int num = 66;
		String result = romanNumeralService.intToRoman(num);
		Assert.assertEquals("LXVI", result);
	}
	
	
	@Test
	public void testLowerHundreds() throws NumberOutOfRangeException {
		int num = 280;
		String result = romanNumeralService.intToRoman(num);
		Assert.assertEquals("CCLXXX", result);
	}
	
	@Test
	public void testFourHundreds() throws NumberOutOfRangeException {
		int num = 492;
		String result = romanNumeralService.intToRoman(num);
		Assert.assertEquals("CDXCII", result);
	}
	
	@Test
	public void testUpperHundreds() throws NumberOutOfRangeException {
		int num = 777;
		String result = romanNumeralService.intToRoman(num);
		Assert.assertEquals("DCCLXXVII", result);
	}
	
	@Test
	public void testThousandAndNineDigit() throws NumberOutOfRangeException {
		int num = 3999;
		String result = romanNumeralService.intToRoman(num);
		Assert.assertEquals("MMMCMXCIX", result);
	}
	

	@Test
	public void testOutOfRange() {
		int num = 0;
		
		try{
			String result = romanNumeralService.intToRoman(num);
		}catch(NumberOutOfRangeException e){
			Assert.assertEquals(Constant.MESSAGE_ERROR_NUMBER_OUTOFRANGE, e.getMessage());
		}
	}

}

package com.abc.demo.service;

import com.abc.demo.NumberOutOfRangeException;

/**
 * The Roman Numeral Service
 *
 */
public interface RomanNumeralService {

	/**
	 * Convert an integer to its Roman numeral representation
	 * @param num An integer. The valid range is 1-3999.
	 * @return Roman numeral representation of the input number
	 * @throws NumberOutOfRangeException the exception is thrown when the input number is not an integer in the range 1-3999.
	 */
	public String intToRoman(int num) throws NumberOutOfRangeException;
}

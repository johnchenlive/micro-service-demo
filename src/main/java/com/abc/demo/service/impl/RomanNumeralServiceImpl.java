package com.abc.demo.service.impl;

import org.springframework.stereotype.Service;

import com.abc.demo.Constant;
import com.abc.demo.NumberOutOfRangeException;
import com.abc.demo.service.RomanNumeralService;

/**
 * This is the implementation class of the interface RomanNumeralService
 *
 */
@Service
public class RomanNumeralServiceImpl implements RomanNumeralService {
	
	@Override
	public String intToRoman (int num) throws NumberOutOfRangeException{
		
		if(num < 1 || num > 3999){
			throw new NumberOutOfRangeException(Constant.MESSAGE_ERROR_NUMBER_OUTOFRANGE);
		}
		
		StringBuffer sb = new StringBuffer();
		return intToRoman2(num, sb);
	}
	
	
	private String intToRoman2(int num, StringBuffer builder) {
		
		if (num >= 1000) {
            builder.append(Constant.ROMAN_1000);
            return intToRoman2(num - 1000, builder);
        }

        if (num >= 900) {
            builder.append(Constant.ROMAN_900);
            return intToRoman2(num - 900, builder);
        }

        if (num >= 500) {
            builder.append(Constant.ROMAN_500);
            return intToRoman2(num - 500, builder);
        }

        if (num >= 400) {
            builder.append(Constant.ROMAN_400);
            return intToRoman2(num - 400, builder);
        }

        if (num >= 100) {
            builder.append(Constant.ROMAN_100);
            return intToRoman2(num - 100, builder);
        }

        if (num >= 90) {
            builder.append(Constant.ROMAN_90);
            return intToRoman2(num - 90, builder);
        }

        if (num >= 50) {
            builder.append(Constant.ROMAN_50);
            return intToRoman2(num - 50, builder);
        }

        if (num >= 40) {
            builder.append(Constant.ROMAN_40);
            return intToRoman2(num - 40, builder);
        }

        if (num >= 10) {
            builder.append(Constant.ROMAN_10);
            return  intToRoman2(num - 10, builder);
        }

        if (num >= 9) {
            builder.append(Constant.ROMAN_9);
            return intToRoman2(num - 9, builder);
        }

        if (num >= 5) {
            builder.append(Constant.ROMAN_5);
            return  intToRoman2(num - 5, builder);
        }

        if (num >= 4) {
            builder.append(Constant.ROMAN_4);
            return  intToRoman2(num - 4, builder);
        }
        if (num != 0) {
            builder.append(Constant.ROMAN_1);
            return intToRoman2(num - 1, builder);
        }


        return builder.toString();
	}

}

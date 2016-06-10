package com.muru.problems.general;

import javax.xml.bind.ValidationException;

/**
 * Created by msivagna on 6/10/16.
 */
public class ConvertDecimalToAnyBase {
    /**
     * PROBLEM: 3
     * Convert decimal to a base between 2 and 16
     * @return
     */
    public String convertDecimalToABaseBetween2And16(int number, int base) throws ValidationException {
        if(number < 0) {
            throw new ValidationException("input cannot be negative");
        }

        if (base < 2 || base > 16) {
            throw new ValidationException("Base cannot be less than 2 or greater than 16");
        }

        if (number == 0) {
            return "0";
        }

        String baseMap = "0123456789ABCDEF";
        StringBuilder stringBuilder = new StringBuilder();
        while (number > 0) {
            int remainder = number % base;
            stringBuilder.append(baseMap.charAt(remainder));
            number = number / base;
        }
        return stringBuilder.reverse().toString();
    }
}

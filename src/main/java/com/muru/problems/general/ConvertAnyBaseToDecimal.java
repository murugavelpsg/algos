package com.muru.problems.general;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.ValidationException;

/**
 * Created by msivagna on 6/10/16.
 */
public class ConvertAnyBaseToDecimal {
    /**
     * PROBLEM: 4
     * Convert a base between 2 and 16 to decimal
     * @param input
     * @param base
     * @return
     */
    public int convertBaseBetween2And16ToDecimal(String input, int base) throws ValidationException {
        if (base < 2 || base > 16) {
            throw new ValidationException("Invaid base");
        }

        if (StringUtils.isEmpty(input)) {
            throw new ValidationException("Input cannot be null or empty");
        }

        String baseMap = "0123456789ABCDEF";
        input = input.toUpperCase();
        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            int digit = baseMap.indexOf(input.charAt(i));
            num = num * base + digit;
        }
        return num;
    }
}

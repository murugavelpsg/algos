package com.muru.problems.general;

import javax.xml.bind.ValidationException;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 * Created by msivagna on 12/22/16.
 */
public class SumOfDigits {
    public int calculateSumOfDigits(int input) throws ValidationException {
        if (input < 0) {
            throw new ValidationException("Input Is Less than zero. ");
        }
        int sum = input;
        while (sum > 10) {
            sum = getSumOfDigits(sum);
        }
        return sum;
    }

    private int getSumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum = sum + (number % 10);
            number = number / 10;
        }
        return sum;
    }
}

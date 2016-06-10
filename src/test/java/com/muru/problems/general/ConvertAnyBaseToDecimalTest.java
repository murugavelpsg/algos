package com.muru.problems.general;

import org.testng.annotations.Test;

import javax.xml.bind.ValidationException;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 6/10/16.
 */
public class ConvertAnyBaseToDecimalTest {
    ConvertAnyBaseToDecimal convertAnyBaseToDecimal = new ConvertAnyBaseToDecimal();

    @Test
    public void mustGetDecimalFromBase2() throws ValidationException {
        assertEquals(convertAnyBaseToDecimal.convertBaseBetween2And16ToDecimal("1100100", 2), 100);
    }

    @Test
    public void mustGetDecimalFromBase16() throws ValidationException {
        assertEquals(convertAnyBaseToDecimal.convertBaseBetween2And16ToDecimal("64", 16), 100);
    }

    @Test
    public void mustGetDecimalFromBase16ForInput0() throws ValidationException {
        assertEquals(convertAnyBaseToDecimal.convertBaseBetween2And16ToDecimal("0", 16), 0);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustGetExceptionForNullInput() throws ValidationException {
        assertEquals(convertAnyBaseToDecimal.convertBaseBetween2And16ToDecimal(null, 16), 0);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustGetExceptionForEmptyInput() throws ValidationException {
        assertEquals(convertAnyBaseToDecimal.convertBaseBetween2And16ToDecimal("", 16), 0);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustGetExceptionForInvalidBaseForDecimalConversion() throws ValidationException {
        assertEquals(convertAnyBaseToDecimal.convertBaseBetween2And16ToDecimal("1234", 200), 0);
    }
}
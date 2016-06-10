package com.muru.problems.general;

import org.testng.annotations.Test;

import javax.xml.bind.ValidationException;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 6/10/16.
 */
public class ConvertDecimalToAnyBaseTest {
    ConvertDecimalToAnyBase  convertDecimalToAnyBase = new ConvertDecimalToAnyBase();
    @Test
    public void mustGetABase2Number() throws ValidationException {
        assertEquals(convertDecimalToAnyBase.convertDecimalToABaseBetween2And16(100, 2), "1100100");
    }

    @Test
    public void mustGetABase16Number() throws ValidationException {
        assertEquals(convertDecimalToAnyBase.convertDecimalToABaseBetween2And16(100, 16), "64");
    }

    @Test
    public void mustGetABase16NumberForInput0() throws ValidationException {
        assertEquals(convertDecimalToAnyBase.convertDecimalToABaseBetween2And16(0, 16), "0");
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustGetExceptionForInvalidBase() throws ValidationException {
        assertEquals(convertDecimalToAnyBase.convertDecimalToABaseBetween2And16(100, 18), "64");
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustGetExceptionForNegativeInput() throws ValidationException {
        assertEquals(convertDecimalToAnyBase.convertDecimalToABaseBetween2And16(-100, 16), "64");
    }
}
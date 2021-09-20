package com.virtualpairprogrammers.isbntools;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest  {
    @Test
    public void checkAValid10DigitISBN(){
       ValidateISBN validator = new ValidateISBN();
//        1. make the test fail
//        2.use mini function(maybe not correct function) to pass the test
       boolean result = validator.checkISBN("0140449116");
        Assert.assertTrue(result);
    }

    @Test
    public void checkAValid13DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
//        fail();
        boolean result = validator.checkISBN("9781853260087");
        assertTrue("first result",result);
        result = validator.checkISBN("9781853267338");
        assertTrue("second result",result);

    }

    @Test
    public void checkAnInvalid10DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test
    public void checkAnInvalid13DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781853267336");
        assertFalse(result);
    }

    @Test
    public void TenDigitISBNNumbersEndingInAnXareValid(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue("value ends with X", result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNAreNotAllowed(){
//        fail();
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("123456789");

    }

    @Test(expected = NumberFormatException.class)
    public void nonNumericISBNAreNotAllowed(){
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("HelloWorld");
    }


}
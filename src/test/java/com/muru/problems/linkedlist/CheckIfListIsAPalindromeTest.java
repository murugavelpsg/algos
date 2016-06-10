package com.muru.problems.linkedlist;

import com.muru.datastructures.linkedlist.LinkedList;
import com.muru.datastructures.linkedlist.List;
import org.testng.annotations.Test;

import javax.xml.bind.ValidationException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 6/10/16.
 */
public class CheckIfListIsAPalindromeTest {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void mustGetExceptionWhenInstantiatingObjectWithNullList() throws ValidationException {
        CheckIfListIsAPalindrome checkIfListIsAPalindrome = new CheckIfListIsAPalindrome(null);
    }

    @Test
    public void mustGetFalseForEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        CheckIfListIsAPalindrome checkIfListIsAPalindrome = new CheckIfListIsAPalindrome(list);
        assertFalse(checkIfListIsAPalindrome.checkIfListIsAPalindrome());
    }

    @Test
    public void mustGetTrueForOneElementList() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(30);
        CheckIfListIsAPalindrome checkIfListIsAPalindrome = new CheckIfListIsAPalindrome(list);
        assertTrue(checkIfListIsAPalindrome.checkIfListIsAPalindrome());
    }

    @Test
    public void mustGetFalseIfListIsNotPalindrome() {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }
        CheckIfListIsAPalindrome checkIfListIsAPalindrome = new CheckIfListIsAPalindrome(list);
        assertFalse(checkIfListIsAPalindrome.checkIfListIsAPalindrome());
    }

    @Test
    public void mustGetTrueIfListIsPalindromeAndOddSized() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);
        list.add(10);
        CheckIfListIsAPalindrome checkIfListIsAPalindrome = new CheckIfListIsAPalindrome(list);
        assertTrue(checkIfListIsAPalindrome.checkIfListIsAPalindrome());
    }

    @Test
    public void mustGetTrueIfListIsPalindromeAndEvenSized() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(30);
        list.add(20);
        list.add(10);
        CheckIfListIsAPalindrome checkIfListIsAPalindrome = new CheckIfListIsAPalindrome(list);
        assertTrue(checkIfListIsAPalindrome.checkIfListIsAPalindrome());
    }
}
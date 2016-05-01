package com.muru.datastructures.problems;

import com.muru.datastructures.linkedlist.LinkedList;
import com.muru.datastructures.linkedlist.List;
import org.testng.annotations.Test;

import javax.xml.bind.ValidationException;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 4/30/16.
 */
public class LinkedListProblemsTest {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void mustGetExceptionWhenInstantiatingObjectWithNullList() throws ValidationException {
        LinkedListProblems linkedListProblems = new LinkedListProblems(null);
    }

    /*
        START: PROBLEM 1
     */
    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustGetExceptionForKthToLastElementInEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        LinkedListProblems linkedListProblems = new LinkedListProblems(list);
        Integer actualKthToLastElement = linkedListProblems.findKthToLastElement(4);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustGetExceptionFor4thToLastElementInSingleElementList() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(30);
        LinkedListProblems linkedListProblems = new LinkedListProblems(list);
        Integer actualKthToLastElement = linkedListProblems.findKthToLastElement(4);
    }

    @Test
    public void mustGetExceptionFor1stToLastElementInSingleElementList() {
        List<Integer> list = new LinkedList<Integer>();
        Integer elemAdded = new Integer(30);
        list.add(elemAdded);
        LinkedListProblems linkedListProblems = new LinkedListProblems(list);
        assertEquals(linkedListProblems.findKthToLastElement(1), elemAdded);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustGet100thToLastElementInMultiElementList() {
        List<Integer> list = new LinkedList<Integer>();
        //List that contains element from 0 to 19
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        LinkedListProblems linkedListProblems = new LinkedListProblems(list);
        assertEquals(linkedListProblems.findKthToLastElement(100), new Integer(16));
    }

    @Test
    public void mustGetKthToLastElementInMultiElementList() {
        List<Integer> list = new LinkedList<Integer>();
        //List that contains element from 0 to 19
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        LinkedListProblems linkedListProblems = new LinkedListProblems(list);
        assertEquals(linkedListProblems.findKthToLastElement(4), new Integer(16));
    }
    /*
        END: PROBLEM 1
     */

    /*
        START: PROBLEM 2
     */
    @Test
    public void mustGetFalseForEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        LinkedListProblems linkedListProblems = new LinkedListProblems(list);
        assertFalse(linkedListProblems.checkIfListIsAPalindrome());
    }

    @Test
    public void mustGetTrueForOneElementList() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(30);
        LinkedListProblems linkedListProblems = new LinkedListProblems(list);
        assertTrue(linkedListProblems.checkIfListIsAPalindrome());
    }

    @Test
    public void mustGetFalseIfListIsNotPalindrome() {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }
        LinkedListProblems linkedListProblems = new LinkedListProblems(list);
        assertFalse(linkedListProblems.checkIfListIsAPalindrome());
    }

    @Test
    public void mustGetTrueIfListIsPalindromeAndOddSized() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);
        list.add(10);
        LinkedListProblems linkedListProblems = new LinkedListProblems(list);
        assertTrue(linkedListProblems.checkIfListIsAPalindrome());
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
        LinkedListProblems linkedListProblems = new LinkedListProblems(list);
        assertTrue(linkedListProblems.checkIfListIsAPalindrome());
    }
    /*
        END: PROBLEM 2
     */
}
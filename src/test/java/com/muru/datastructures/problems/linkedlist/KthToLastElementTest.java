package com.muru.datastructures.problems.linkedlist;

import com.muru.datastructures.linkedlist.LinkedList;
import com.muru.datastructures.linkedlist.List;
import org.testng.annotations.Test;

import javax.xml.bind.ValidationException;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 6/10/16.
 */
public class KthToLastElementTest {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void mustGetExceptionWhenInstantiatingObjectWithNullList() throws ValidationException {
        KthToLastElement kthToLastElement = new KthToLastElement(null);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustGetExceptionForKthToLastElementInEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        KthToLastElement kthToLastElement = new KthToLastElement(list);
        Integer actualKthToLastElement = kthToLastElement.findKthToLastElement(4);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustGetExceptionFor4thToLastElementInSingleElementList() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(30);
        KthToLastElement kthToLastElement = new KthToLastElement(list);
        Integer actualKthToLastElement = kthToLastElement.findKthToLastElement(4);
    }

    @Test
    public void mustGetExceptionFor1stToLastElementInSingleElementList() {
        List<Integer> list = new LinkedList<Integer>();
        Integer elemAdded = new Integer(30);
        list.add(elemAdded);
        KthToLastElement kthToLastElement = new KthToLastElement(list);
        assertEquals(kthToLastElement.findKthToLastElement(1), elemAdded);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustGet100thToLastElementInMultiElementList() {
        List<Integer> list = new LinkedList<Integer>();
        //List that contains element from 0 to 19
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        KthToLastElement kthToLastElement = new KthToLastElement(list);
        assertEquals(kthToLastElement.findKthToLastElement(100), new Integer(16));
    }

    @Test
    public void mustGetKthToLastElementInMultiElementList() {
        List<Integer> list = new LinkedList<Integer>();
        //List that contains element from 0 to 19
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        KthToLastElement kthToLastElement = new KthToLastElement(list);
        assertEquals(kthToLastElement.findKthToLastElement(4), new Integer(16));
    }
}
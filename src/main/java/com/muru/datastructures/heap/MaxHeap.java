package com.muru.datastructures.heap;

/**
 * Created by msivagna on 8/26/16.
 */
public class MaxHeap<T extends Comparable<T>> implements Heap {
    private static final int ROOT_INDEX = 0;
    private Comparable[] heapArray;
    private int maxCapacity = 25;
    private int currentHeapSize = 0;

    public MaxHeap(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.heapArray = new Comparable[maxCapacity];
    }

    public boolean add(Comparable element) {
        if (currentHeapSize == maxCapacity) {
            //Re-allocate a new array double the capacity
            //Copy all the elements from the old array to the new array
            //Initialize the old array to null
            maxCapacity = maxCapacity * 2;
            Comparable[] newHeapArray = new Comparable[maxCapacity];
            System.arraycopy(heapArray, 0, newHeapArray, 0, heapArray.length);
            heapArray = newHeapArray;
        }
        //Add the element to the end
        //Max Heapify
        // - Add the element to the end of the array
        // - Swap with its parent until the parent is greater than current or we reach the root
        currentHeapSize++;
        heapArray[currentHeapSize - 1] = element;
        int currentIndex = currentHeapSize - 1;
        int parentIndex = getParentIndex(currentIndex);
        while (currentIndex > ROOT_INDEX) {
            if (heapArray[currentIndex].compareTo(heapArray[parentIndex]) <= 0) {
                break;
            }
            Comparable temp = heapArray[currentIndex];
            heapArray[currentIndex] = heapArray[parentIndex];
            heapArray[parentIndex] = temp;
            currentIndex = parentIndex;
            parentIndex = getParentIndex(currentIndex);
        }
        return true;
    }

    private int getParentIndex(int index) {
        return (int) Math.floor((index - 1) / 2.0);
    }

    public Comparable remove() {
        if (currentHeapSize == 0) {
            return null;
        }
        //Remove the top most element
        //Copy the last element at the root
        //Find the greatest of the two children and swap with the greatest
        //End when current element is greater than both the children or there are no more children
        Comparable elemRemoved = heapArray[ROOT_INDEX];
        heapArray[ROOT_INDEX] = heapArray[currentHeapSize - 1];
        currentHeapSize--;
        int currentIndex = ROOT_INDEX;
        while (currentIndex <= currentHeapSize - 1) {
            int greatestOfTwoChildrenIndex = findIndexOfGreatestOfTwoChildren(currentIndex);
            if (greatestOfTwoChildrenIndex == -1 ||
                    heapArray[currentIndex].compareTo(heapArray[greatestOfTwoChildrenIndex]) >= 0) {
                break;
            }
            Comparable temp = heapArray[currentIndex];
            heapArray[currentIndex] = heapArray[greatestOfTwoChildrenIndex];
            heapArray[greatestOfTwoChildrenIndex] = temp;
            currentIndex = greatestOfTwoChildrenIndex;
        }
        return elemRemoved;
    }

    private int findIndexOfGreatestOfTwoChildren(int index) {
        int childIndex1 = (2 * index + 1) > currentHeapSize - 1 ? -1 : (2 * index + 1);
        int childIndex2 = (2 * index + 2) > currentHeapSize - 1 ? -1 : (2 * index + 2);

        if (childIndex1 != -1 && childIndex2 != -1) {
            if (heapArray[childIndex1].compareTo(heapArray[childIndex2]) >= 0) {
                return childIndex1;
            } else {
                return childIndex2;
            }
        } else if (childIndex1 == -1 && childIndex2 > 0) {
            return childIndex2;
        } else {
            return childIndex1;
        }

    }

    public Comparable peek() {
        return heapArray[ROOT_INDEX];
    }

    public boolean contains(Comparable element) {
        for (int i = 0; i < currentHeapSize; i++) {
            if (heapArray[i].compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return currentHeapSize;
    }
}

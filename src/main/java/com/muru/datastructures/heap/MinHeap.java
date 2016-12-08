package com.muru.datastructures.heap;

/**
 * Created by msivagna on 12/8/16.
 */
public class MinHeap<T extends Comparable<T>> implements Heap {
    private Comparable[] heapArray;
    private int maxCapacity;
    private int currentHeapSize = 0;

    public MinHeap(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.heapArray = new Comparable[maxCapacity];
    }

    public boolean add(Comparable element) {
        if (element == null) {
            throw new UnsupportedOperationException("Cannot insert null to the heap");
        }

        if (currentHeapSize == maxCapacity) {
            //Array already full. Double the array size and copy the elements to the new array
            maxCapacity = maxCapacity * 2;
            Comparable[] newHeapArray = new Comparable[maxCapacity];
            System.arraycopy(heapArray, 0, newHeapArray, 0, heapArray.length);
            heapArray = newHeapArray;
        }

        //Add the element to the last index in the array
        currentHeapSize++;
        heapArray[currentHeapSize - 1] = element;
        int currentIndex = currentHeapSize - 1;
        int parentIndex = getParentIndex(currentIndex);
        //Swap the current element with its parent until the parent is less than current element
        while (currentIndex > 0) {
            if (heapArray[parentIndex].compareTo(heapArray[currentIndex]) <= 0) {
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

    private int getParentIndex(int currentIndex) {
        return (int) Math.floor((currentIndex - 1) / 2.0);
    }

    public Comparable remove() {
        if (currentHeapSize == 0) {
            return null;
        }

        //Remove root
        //Move the last element of the array to index 0
        //Swap the current element with the lowest of the two.
        //Break if the current element is the lowest
        //Break if there are no more children

        Comparable elemRemoved = heapArray[0];
        heapArray[0] = heapArray[currentHeapSize - 1];
        int currentIndex = 0;
        currentHeapSize--;
        while (currentIndex < currentHeapSize) {
            int leastChildIndex = findLeastOfTwoChildren(currentIndex);
            if (leastChildIndex == -1) {
                break;
            } else {
                if (heapArray[currentIndex].compareTo(heapArray[leastChildIndex]) < 0) {
                    break;
                }

                Comparable temp = heapArray[currentIndex];
                heapArray[currentIndex] = heapArray[leastChildIndex];
                heapArray[leastChildIndex] = temp;
                currentIndex = leastChildIndex;
            }
        }
        return elemRemoved;
    }

    /**
     * Return -1 if no more children
     * Else return the index of the least of the two children
     * @param parentIndex
     * @return
     */
    private int findLeastOfTwoChildren(int parentIndex) {
        int child1Index = 2 * parentIndex + 1;
        int child2Index = 2 * parentIndex + 2;
        if (child1Index > currentHeapSize-1) {
            return -1;
        } else if (child2Index > currentHeapSize-1) {
            return child1Index;
        } else {
            if (heapArray[child1Index].compareTo(heapArray[child2Index]) < 0) {
                return child1Index;
            } else {
                return child2Index;
            }
        }
    }

    public Comparable peek() {
        if (currentHeapSize == 0) {
            return null;
        }
        return heapArray[0];
    }

    public boolean contains(Comparable element) {
        if (element == null) {
            return false;
        }

        for (int i = 0; i < currentHeapSize; i++) {
            if (heapArray[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.currentHeapSize;
    }
}

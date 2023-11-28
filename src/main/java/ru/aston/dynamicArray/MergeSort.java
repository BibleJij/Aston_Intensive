package ru.aston.dynamicArray;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort<E> {
    public void sort(E[] array, Comparator<? super E> c) {
        int sizeArray = array.length;
        if(sizeArray == 1) return;
        int mid = sizeArray / 2;
        E[] leftArray = Arrays.copyOfRange(array, 0, mid);
        E[] rightArray = Arrays.copyOfRange(array, mid, sizeArray);
        sort(leftArray, c);
        sort(rightArray, c);
        merge(leftArray, rightArray, array, c);
    }

    private void merge(E[] left, E[] right, E[] array, Comparator<? super E> comparator) {
        int leftSize = left.length;
        int rightSize = right.length;
        int l = 0;
        int r = 0;
        int i = 0;
        while (l < leftSize && r < rightSize) {
            if (left[l] != null && right[r] != null) {
                if (comparator.compare(left[l], right[r]) <= 0) {
                    array[i++] = left[l++];
                } else {
                    array[i++] = right[r++];
                }
            } else if (left[l] != null) {
                array[i++] = left[l++];
            } else {
                array[i++] = right[r++];
            }
        }
        while (l < leftSize) {
            array[i++] = left[l++];
        }
        while (r < rightSize) {
            array[i++] = right[r++];
        }
    }
}

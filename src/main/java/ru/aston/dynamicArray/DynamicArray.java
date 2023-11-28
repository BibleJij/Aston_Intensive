package ru.aston.dynamicArray;

import java.util.*;

public class DynamicArray<E> implements Array<E> {

    private int size;

    private Object[] array;

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ARRAY = {};

    private MergeSort<E> mergeSort = new MergeSort<>();


    public DynamicArray() {
        this.size = 0;
        this.array = new Object[DEFAULT_CAPACITY];
    }

    public DynamicArray(int size) {
        if (size > 0) {
            this.size = size;
            this.array = new Object[size];
        } else if (size == 0) {
            this.size = 0;
            this.array = EMPTY_ARRAY;
        } else
            throw new IllegalArgumentException("Ошибка в инициализации обьекта. \n "
                    + size + " - размер массива невозможен");
    }

    @Override
    public void add(int index, E element) {
        indexOutOfArray(index);
        if (array[index] == null) {
            array[index] = element;
            size++;
        } else
            array[index] = element;
    }

    @Override
    public void add(E element) {
        if (array.length == size) {
            array = Arrays.copyOf(array, size() + DEFAULT_CAPACITY);
        }
        array[size] = element;
        size++;
    }

    @Override
    public void addAll(Collection<? extends E> c) {
        ensureCapacity(size + c.size());
        System.arraycopy(c.toArray(), 0, array, size, c.size());
        size += c.size();
    }

    @Override
    public void clear() {
        array = EMPTY_ARRAY;
        size = 0;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        mergeSort.sort((E[]) array, c);
    }

    @Override
    public E get(int index) {
        indexOutOfArray(index);
        return (E) array[index];

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int index) {
        indexOutOfArray(index);
        return (E) removeFromList(index);
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i <= size - 1; i++) {
            if (array[i].equals(o)) {
                removeFromList(i);
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(array).filter(Objects::nonNull).toArray());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    private boolean indexOutOfArray(int index) {
        if (index <= size - 1 || index >= 0)
            return true;
        else
            throw new IllegalArgumentException("Выход за рамки листа. \n"
                    + index + " - за рамками листа");
    }

    public int size() {
        return size;
    }

    private Object removeFromList(int index) {
        array[index] = null;
        for (int i = index; i <= size; i++) {
            if (i == size - 1) {
                array[i] = null;
                break;
            } else
                array[i] = array[i + 1];
        }
        array = Arrays.copyOf(array, size() - 1);
        size--;
        return array;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = Math.max(array.length * 2, minCapacity);
            array = Arrays.copyOf(array, newCapacity);
        }
    }
}

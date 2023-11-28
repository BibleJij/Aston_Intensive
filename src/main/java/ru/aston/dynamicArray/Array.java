package ru.aston.dynamicArray;

import java.util.*;

public interface Array<E> {

    void add(int index, E element);

    void add(E element);

    void addAll(Collection<? extends E> c);

    void clear();

    void sort(Comparator<? super E> c);

    E get(int index);

    boolean isEmpty();

    E remove(int index);

    boolean remove(Object o);
}

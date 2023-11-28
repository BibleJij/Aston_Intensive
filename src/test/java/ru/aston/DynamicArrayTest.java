package ru.aston;


import org.junit.*;
import ru.aston.dynamicArray.DynamicArray;

import java.util.List;

public class DynamicArrayTest {
    private DynamicArray<String> stringArrayList;
    private DynamicArray<Integer> arrayList;

    @Before
    public void setUpValues(){
        arrayList = new DynamicArray<>();
        arrayList.addAll(List.of(5, 10, 15, 20, 25));

        stringArrayList = new DynamicArray<>();
        stringArrayList.addAll(List.of("Hello", "world", "how", "are", "you"));
    }

    @Test
    public void getCheck() {
        Assert.assertEquals("you", stringArrayList.get(4));
    }

    @Test
    public void sizeCheck() {
        Assert.assertEquals(5, arrayList.size());
    }

    @Test
    public void addObject() {
        arrayList.add(30);
        Assert.assertEquals(30, (int) arrayList.get(arrayList.size() - 1));

    }

    @Test
    public void addByIndex(){
        arrayList.add(0, 0);
        Assert.assertEquals((Integer) 0, arrayList.get(0));
    }

    @Test
    public void addAll(){
        arrayList.clear();
        arrayList.addAll(List.of(1, 2, 3, 4, 5));
        for (int i = 0; i <= arrayList.size() - 1; i++)
            Assert.assertEquals((Integer) (i + 1), arrayList.get(i));
    }

    @Test
    public void clear(){
        Assert.assertNotNull(arrayList);
        arrayList.clear();
        Assert.assertEquals(0, arrayList.size());
    }

    @Test
    public void removeByIndex(){
        stringArrayList.remove(0);
        Assert.assertEquals("world", stringArrayList.get(0));
    }

    @Test
    public void removeByObject(){
        stringArrayList.remove("you");
        Assert.assertEquals("are", stringArrayList.get(stringArrayList.size()-1));
    }
}


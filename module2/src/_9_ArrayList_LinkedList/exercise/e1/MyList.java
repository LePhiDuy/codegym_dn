package _9_ArrayList_LinkedList.exercise.e1;

import java.util.Arrays;

public class MyList<E>{
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    Object[] elements;
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity " + capacity);
        }
    }
    public int size() {
        return this.size;
    }
    public void add(int index, E element) {
        if (index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException("index: " + index);
        } else if (elements.length == size){
            ensureCapacity(1);
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }
    public boolean add(E obj) {
        if (elements.length == size) {
            ensureCapacity(1);
        }
        elements[size] = obj;
        size++;
        return true;
    }
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize =  size + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity: " + minCapacity);
        }
    }
    public E remove(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("index: " + index);
        } else {
            E element = (E) elements[index];
            for (int i = index; i < elements.length - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[elements.length - 1] = null;
            size--;
            return element;
        }
    }
    public MyList<E> clone() {
        MyList<E> v = new MyList<>();
        v.elements = Arrays.copyOf(this.elements, size);
        v.size = this.size;
        return v;
    }
    public E get(int i) {
        if (i < 0 || i >= elements.length) {
            throw new IndexOutOfBoundsException("index: " + i);
        } else {
            return (E)(elements[i]);
        }
    }
    public int indexOf(E o) {
        int index = -1;
        for (int i = 0; i < elements.length; i++) {
            if (o.equals(elements[i])) {
                index = i;
                break;
            }
        }
        return index;
    }
    public boolean contains(E o) {
        return this.indexOf(o) > 0;
    }
}

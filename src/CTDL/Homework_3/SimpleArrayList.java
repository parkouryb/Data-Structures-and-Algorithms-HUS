package CTDL.Homework_3;

import java.util.*;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public int indexOf(T data) {
        for (int i = 0;i < n;++ i) {
            if (this.array[i].equals(data)) return i;
        }
        return -1;
    }

    public void add(T data) {
        ++ n;
        this.array[n - 1] = data;
    }

    public T get(int i) {
        return (i < n) ? this.array[i] : null;
    }

    public void set(int i, T data) {
        if (i < 0 || i >= n)
            System.out.println("Warning: nothing to set!");
        this.array[i] = data;

    }

    public void remove(T data) {
        for (int i = 0; i < n; ++i) {
            if (this.array[i].equals(data)) {
                for (int j = i + 1; j < n; ++j) {
                    this.array[j - 1] = this.array[j];
                    // ??? really? O(n)
                }
                --n;
            }
        }
    }

    public boolean isContain(T data) {
        boolean flag = false;
        for (int i = 0; i < n; ++i) {
            if (data.equals(this.array[i]))
                flag = true;
        }
        return flag;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < n && array[currentIndex] != null;
            }

            @Override
            public T next() {
                return array[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}

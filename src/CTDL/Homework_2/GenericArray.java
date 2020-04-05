package CTDL.Homework_2;

import java.lang.reflect.Array;

public class GenericArray<T>{
    private int size = 10; // defaut size = 10
    private Class<T> aClass;

    private T[] myArray;

    public GenericArray(Class<T> aClass) {
        this.aClass = aClass;
        myArray = (T[]) Array.newInstance(aClass, size);
    }
    public GenericArray(Class<T> aClass,  int size) {
        this.aClass = aClass;
        this.size = size;
        myArray = (T[]) Array.newInstance(aClass, size);
    }

    public T[] getMyArray() {
        return this.myArray;
    }

    public <T extends Comparable<? super T>> void insertionSort(T[] a) {
        for(int i = 0; i < a.length; ++i) {
            T key = a[i];
            int position = i;
            while(position > 0 && a[position-1].compareTo(key) > 0)
            {
                a[position] = a[position-1];
                position--;
            }
            a[position] = key;
        }
    }

    public <T extends Comparable<? super T>> void bubbleSort(T[] a) {
        for (int i = 0;i < a.length;++ i) {
            for (int j = 0;j < a.length - 1;++ j) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    T tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public <T extends Comparable<? super T>> void selectionSort(T[] a) {
        for (int i = 0;i < a.length - 1;++ i) {
            int index = i;
            boolean flag = false;
            for (int j = i + 1;j < a.length;++ j) {
                if (a[index].compareTo(a[j]) > 0) {
                    index = j;
                    flag = true;
                }
            }

            if (flag) {
                T tmp = a[index];
                a[index] = a[i];
                a[i] = tmp;
            }
        }
    }

    public void printArray(T[] a) {
        for (int i = 0;i < a.length;++ i) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");
    }

    



}
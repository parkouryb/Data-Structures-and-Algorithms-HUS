package CTDL.Homework_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
 
public class Exc2<E>{
    static Scanner input = new Scanner(System.in);
        
    private E[] array;
 
    // Contructor.
    public Exc2(E[] array) {
        this.array = array;
    }

    public Exc2() {
    
    }
 
    public E[] getArray() {
        return array;
    }

    public <E extends Comparable<? super E>> void bubbleSort(E[] a) {
        for (int i = 0;i < a.length;++ i) {
            for (int j = 0;j < a.length - 1;++ j) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    E tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public void printArray(E[] a) {
        for (int i = 0;i < a.length;++ i) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");
    }
    /**
     * 
     * @param a
     * @param value
     * @return index of Value, if not found return -1
     */
    public int findElement(E[] a, E value) {
        int index = -1;
        for (int i = 0;i < a.length;++ i) {
            if (a[i] == value) index = i;
        }
        return index;
    }

    public void readArray(Integer[] a, int n) {
        
        for (int i = 0;i < n;++ i) {
            a[i] = Integer.parseInt(input.next());
        }

    }

    public static void main(String[] agrs) throws Exception {
        
        Integer a[] = new Integer[10];
        Exc2<Integer> gArray = new Exc2<Integer>(a);
        int n = Integer.parseInt(input.next());
        Integer[] b = new Integer[n];
        gArray.readArray(b, n);
        gArray.printArray(b);
        gArray.bubbleSort(b);
        gArray.printArray(b);
        System.out.println("index 2:" + gArray.findElement(a, 2));

    }
}
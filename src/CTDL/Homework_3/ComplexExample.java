package CTDL.Homework_3;

import java.util.*;
import java.io.*;

public class ComplexExample{
    static Scanner sc = new Scanner(System.in);

    public static Complex sumComplexs(Complex[] cp) {
        Complex res = new Complex(0.0f, 0.0f);
        for (int i = 0;i < cp.length;++ i) {
            res = res.add(cp[i]);
        }
        return res;
    }

    public static void main(String[] agrs) {
        System.out.print("Enter n: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Enter complex numbers: \n");
        Complex[] cpNums = new Complex[n];
        for (int i = 0;i < n;++ i) {
            float x = sc.nextFloat();
            float y = sc.nextFloat();
            cpNums[i] = new Complex(x, y);
        }
        

        System.out.println("Get 'sum' get 'sum': " + sumComplexs(cpNums).toString());

        
        System.out.print("Enter v: \n");
        int v = Integer.parseInt(sc.next());
        if (v > 0 && v < n) System.out.println("Complex " + v + ": " + cpNums[v]);
        else System.out.println("V not found!");
    }
}
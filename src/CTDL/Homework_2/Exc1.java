package CTDL.Homework_2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Exc1{
    int count_swap = 0;
    int count_compare = 0; // ???

    public void printArray(int[] a, int n) {
        for (int i = 0;i < n;++ i) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public void printArray(int[] a, int n, int idx, int idx1) {
        for (int i = 0;i < n;++ i) {
            if (i == idx || i == idx1) System.out.print("[" + a[i] + "] ");
            else System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public void BubbleSort(int[] a, int n) {
        for (int i = 0;i < n - 1;++ i) {
            for (int j = 0;j < n - 1;++ j) {
                ++ count_compare;
                if (a[j] > a[j + 1]) {
                    ++ count_swap;
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    printArray(a, n, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] agrs) throws Exception {
        FileReader fr = new FileReader("test.txt");
        BufferedReader br = new BufferedReader(fr);

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String Str = br.readLine();
        System.out.println(Str);
        String[] arrOfStr = Str.split(" ", 0);
        for (int i = 0;i < n;++ i) {
            a[i] = Integer.parseInt(arrOfStr[i]);
        }
        Exc1 bbs = new Exc1();
        
        bbs.BubbleSort(a, n);
        System.out.println("\n");
        bbs.printArray(a, n);
        System.out.println(bbs.count_swap);
        br.close();
        fr.close();
    }
}
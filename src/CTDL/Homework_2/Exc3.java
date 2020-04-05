package CTDL.Homework_2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Exc3{
    int count_swap = 0; // ???
    int count_compare = 0; 

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

    public static void swap(int[] a, int index, int index1) {
        int tmp = a[index];
        a[index] = a[index1];
        a[index1] = tmp;
    }

    public void InsertionSort(int[] a, int n) {
        boolean flag = true;
        if (n >= 2) {
            if (a[0] > a[1]) {
                swap(a, 0, 1);
                ++ count_swap;
                printArray(a, n, 0, 1);
            }
        }
        for (int i = 0;i < n - 1;++ i) {
            if (a[i] > a[i + 1]) {
                flag = false;
                int index = n - 1;
                boolean flag2 = false;

                for (int j = 0;j < i;++ j) {
                    ++ count_compare;
                    if (a[i + 1] < a[0]) {
                        flag2 = true;
                        index = 0;
                        break;
                    }
                    if (a[j] <= a[i + 1] && a[i + 1] <= a[j + 1]) {
                        index = j + 1;
                        flag2 = true;
                        break;
                    }
                }

                if (flag2) {
                    for (int j = i;j >= index;-- j){
                        swap(a, j, j + 1);
                        ++count_swap;
                    }
                    printArray(a, n, index, i + 1);
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
        Exc3 bbs = new Exc3();
        
        bbs.InsertionSort(a, n);
        System.out.println("\n");
        bbs.printArray(a, n);
        System.out.println(bbs.count_swap + " " + bbs.count_compare);
        br.close();
        fr.close();
    }
}
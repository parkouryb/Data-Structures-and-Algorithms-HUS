package CTDL.Homework_2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Exc2{
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

    public void SelectionSort(int[] a, int n) {
        int maxx = 0;
        for (int i = 0;i < n;++ i) {
            maxx = Math.min(maxx, a[i]);
        }
        for (int i = 0;i < n - 1;++ i) {
            int tmp_min = maxx;
            int index = n - 1;
            boolean flag = false;
            for (int j = i + 1;j < n;++ j) {
                ++ count_compare;
                if (a[j] < tmp_min) {
                    tmp_min = a[j];
                    index = j;
                    flag = true;
                }
            }
            
            if (flag) {
                int tmp = a[i];
                a[i] = a[index];
                a[index] = tmp;
                ++count_swap;
    
                printArray(a, n, i, index);    
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
        Exc2 bbs = new Exc2();
        
        bbs.SelectionSort(a, n);
        System.out.println("\n");
        bbs.printArray(a, n);
        System.out.println(bbs.count_swap + " " + bbs.count_compare);
        br.close();
        fr.close();
    }
}
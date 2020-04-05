package CTDL.Homework_2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Exc4 {
    public static void main(String[] agrs) throws Exception {
        Exc1 s1 = new Exc1();
        Exc2 s2 = new Exc2();
        Exc3 s3 = new Exc3();
        
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
        s1.BubbleSort(a, n);
        s2.SelectionSort(a, n);
        s3.InsertionSort(a, n);
        System.out.println("count_compare - count_swap");
        System.out.println(s1.count_compare + " - " + s1.count_swap);
        System.out.println(s2.count_compare + " - " + s2.count_swap);
        System.out.println(s3.count_compare + " - " + s3.count_swap);

        br.close();
        fr.close();
    }
}
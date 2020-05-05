package CTDL.Homework_5;

import java.util.Scanner;
import java.util.function.Function;

public class domdom{
    public static int ucln (int Nume, int Denom) {

        int a = Math.abs(Nume);
        int b = Math.abs(Denom);
        while ( a != b) {

            if(a>b)
                a=a-b;
            else b=b-a;
        }
        return a;
    }

    public static int USCLN(int a, int b) {
        if (b == 0) return a;
        return USCLN(b, a % b);
    }

    // tử số là Nume, mẫu số là Denom, tính và in ra dạng tối giản của Nume/Denom
    public static void  printSimplest(int Nume, int Denom){

        int uc= USCLN(Nume,Denom);
        Nume = Nume / uc;
        Denom = Denom / uc;
        if(Denom < 0) {
            Nume = 0 -Nume ;
            Denom =0-Denom;
        }
        System.out.println(Nume + "/" + Denom);

    }
    public static void main(String args[]){
        int num = 872;
        int numtmp = num;
        int sum = 0;
        int count = 0;
        while (numtmp != 0) {
            System.out.println("num: " + numtmp);
            sum = sum + numtmp % 10;
            numtmp = numtmp / 10; // 87 -> 8
        }

        int numtmp1 = num;
        while (numtmp1 != 0) {
            numtmp1 = numtmp1 / 10;
            count = count + 1;
        }
        System.out.println(sum + " " + count);
//        int Nume=Integer.parseInt("-44");
//        int Denom=Integer.parseInt("20");
//        printSimplest(Nume, Denom);
    }
}
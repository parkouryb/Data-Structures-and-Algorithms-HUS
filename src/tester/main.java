/* NomNom created on 5/1/2020 inside the package - tester */

package tester;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int [n][n];
        for ( int i=0; i<a.length;i++){
            for( int j=0; j<a[0].length;j++){
                a[i][j]= sc.nextInt();
            }
        }
        giatri(a);
        maxcot(a);
        if(cau5(a,3)== true) {
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

    }
    public static  void giatri(int a[][]){


        for(int i=0; i<a.length; i++){
            int max= Integer.MIN_VALUE;

            for( int j=0; j<a[0].length;j++){
                if(max < a[i][j]){
                    max= a[i][j];
                }


            }
            System.out.print( max + " ");
        }
    }
    public static void maxcot (int a[][]){
        for(int j=0; j<a[0].length; j++){
            int max= Integer.MIN_VALUE;
            for( int i=0; i<a.length; i++){
                if( max< a[i][j]){
                    max= a[i][j];
                }
            }
            System.out.print(max + " ");
        }

    }
    public static boolean cau5( int a[][], int k) {
        k = k - 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i][k] > 0) {
                return false;
            }
        }
        return true;

    }
}
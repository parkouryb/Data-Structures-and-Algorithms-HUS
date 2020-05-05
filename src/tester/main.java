/* NomNom created on 5/1/2020 inside the package - tester */

package tester;

public class main {

    private static int n = 4;
    static int[] a = new int[11];
    static boolean[] b = new boolean[11];
    private static int k = 3;

    public static void sinh(int x) {
        if (x > k) {
            print();
            return;
        }
        else {
            for (int i = 1; i <= n;++ i) {
                if (b[i]) {
                    a[x] = i;
                    b[i] = false;
                    sinh(x + 1);
                    b[i] = true;
                }
            }
        }
    }

    private static void print() {
        for (int i = 1;i <= k;++ i) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        for (int i = 0;i < 11;++ i)
            b[i] = true;
        sinh(1);
    }
}

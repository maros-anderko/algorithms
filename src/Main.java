import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        arrayLeftRotation();
    }

    public static void arrayLeftRotation() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i<n;i++){
            a[i] = scan.nextInt();
        }
        int[] res = new int[n];
        for (int i = 0; i<n-d; i++) {
            res[i] = a[i+d];
        }
        for (int i = 0; i<d;i++) {
            res[n-d+i] = a[i];
        }
        System.out.println(Arrays.toString(res));
        scan.close();
    }
}
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        anagrams();
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

    public static Map<Character, Integer> resolveString(String a){
        Map<Character, Integer> mapA = new HashMap<>();
        StringBuilder sa = new StringBuilder(a);
        for (int i = 0; i< a.length();i++) {
            char c = sa.charAt(i);
            if (mapA.get(c) != null) {
                int count = mapA.get(c);
                count++;
                mapA.put(c, count);
            }
            else {
                mapA.put(c, 1);
            }
        }
        return mapA;
    }

    public static void anagrams(){
        Scanner scan = new Scanner(System.in);
        Map<Character, Integer> mapA = resolveString(scan.nextLine());
        Map<Character, Integer> mapB = resolveString(scan.nextLine());

        int changes = 0;
        for (char c : mapA.keySet()){
            if (mapB.get(c) != null) {
                changes += Math.abs(mapA.get(c) - mapB.get(c));
                mapB.remove(c);
            } else {
                changes += mapA.get(c);
            }
        }

        for (char c : mapB.keySet()){
            changes += mapB.get(c);
        }
        System.out.println(changes);
        scan.close();
    }
}
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ransomNote();
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

    public static void ransomNote() {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        Map<String,Integer> magazine = new HashMap<>();
        for (int i = 0; i<m; i++){
            String s = scan.next();
            if (magazine.get(s) != null){
                int count = magazine.get(s);
                count++;
                magazine.put(s,count);
            } else {
                magazine.put(s, 1);
            }
        }

        Map<String,Integer> notes = new HashMap<>();
        for (int i = 0; i<n; i++){
            String s = scan.next();
            if (notes.get(s) != null){
                int count = notes.get(s);
                count++;
                notes.put(s,count);
            } else {
                notes.put(s, 1);
            }
        }
        boolean able = true;
        for (String s: notes.keySet()) {
            if (magazine.get(s) == null){
                able = false;
                break;
            } else {
                int notesC = notes.get(s);
                int magC = magazine.get(s);
                if (notesC > magC) {
                    able = false;
                    break;
                }
            }
        }
        if (able)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
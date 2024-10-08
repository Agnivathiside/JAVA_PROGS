// public class zig_zag_array_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

public class zig_zag_array_shit {

    public static boolean isZigzag(int n, int[] arr) {
        int f = 1;

        for (int i = 1; i < n; i++) {
            if (f == 1) {
                if (arr[i - 1] > arr[i]) return false;
            } else {
                if (arr[i - 1] < arr[i]) return false;
            }
            f ^= 1;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            obj.zigZag(n, arr);

            boolean check = isZigzag(n, arr);
            if (check) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}

// } Driver Code Ends



class Solution {
    public static void zigZag(int n, int[] arr) {
        // code here
        Arrays.sort(arr);
        int l = 0;
        int r = n-1;
        int mid = (r+l)/2;

        ArrayList<Integer> firstHalf = new ArrayList<>();
        ArrayList<Integer> secondHalf =  new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<=mid; i++){
            firstHalf.add(arr[i]);
        }
        for(int i= mid+1; i<n; i++){
            secondHalf.add(arr[i]);
        }

        int x = 0;
        int y = 0;
        int z = 0;
        while(x<firstHalf.size() || y < secondHalf.size()){
            ans.add(firstHalf.get(x));
            ans.add(secondHalf.get(y));
            x++;
            y++;
        }

        while(x<firstHalf.size()){
            ans.add(firstHalf.get(x));
            x++;
        }

        while(y<secondHalf.size()){
            ans.add(secondHalf.get(y));
            y++;
        }

        while(z<ans.size()){
            arr[z] = ans.get(z);
            z++;
        }

    }
}


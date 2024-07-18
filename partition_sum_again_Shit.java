// public class partition_sum_again_Shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

public class partition_sum_again_Shit{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int d;
            d = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends

class Solution {
    static int count = 0;
    public static void solve(int n, int d, int arr[], int target, int count, int sum, int index){
        if ((index>n) || sum>target){
            return;
        }
        if (sum == target){
            count++;
            return;
        }

        solve(n, d, arr, target, count, sum+arr[index], index+1);
        solve(n, d, arr, target, count, sum, index+1);
    }
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int total = 0;
        for(int i=0; i<n; i++){
            total += arr[i];
        }
        int target = (total+d)/2;
        solve(n-1, d, arr, target, count, 0, 0);
        return count;
    }
}

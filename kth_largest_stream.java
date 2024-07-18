// public class kth_largest_stream

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class kth_largest_stream {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int k = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);

            String S1[] = read.readLine().split(" ");

            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            int[] ptr = ob.kthLargest(k, arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends
// 1, 2, 3, 4, 5, 6    k=4
class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<k; i++){
            pq.add(arr[i]);
        }
         
    }
}
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class maximum_diamond_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            
            int[] A = new int[N];
            
            String S1[] = read.readLine().split(" ");
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxDiamonds(A,N,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
// 2, 1, 7, 4, 2 
class Solution {
    static long maxDiamonds(int[] A, int N, int K) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        // int arr_len=A.length;
        for(int i=0;i<N;i++){
            pq.add(A[i]);
        }

        long sum=0;
        for(int i=0;i<K;i++){
            int top=pq.peek();
            sum+=top;
            pq.poll();
            pq.add(top/2);
        }

        return sum;

    }
}
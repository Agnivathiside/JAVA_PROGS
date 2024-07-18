//{ Driver Code Starts
import java.io.*;
import java.util.*;

class kth_large_elem_stream_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int k = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            
            int[] arr = new int[n];
            
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            int[] ptr = ob.kthLargest(k,arr,n);
            for(int i=0; i<n; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        // code here
        int[] ans=new int[n];
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<=k-2;i++){
            pq.add(arr[i]);
            ans[i]=-1;
        }
        // for(int i=k-1;i<n;i++){
        //     pq.add(arr[i]);
        //     ans[i]=pq.poll();
        // }
        for(int i=k-1; i<n; i++){
            pq.add(arr[i]);
            if(pq.size()>k)
                pq.poll();
            ans[i] = pq.peek();
        }
        return ans;
    }
};
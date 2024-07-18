//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    long minimizeSum(int N, int arr[]) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.add(arr[i]);
        }

        int sum=0;
        while(pq.size()>1){
            System.out.println("Queue is now: "+pq);
            int first=pq.poll();
            int second=pq.poll();
            sum+=first+second;
            pq.add(sum);
        }

        return Long.valueOf(sum);
    }
}

//{ Driver Code Starts.

public class minimize_sum_shit{

    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0; i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            long ans = obj.minimizeSum(n, A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends
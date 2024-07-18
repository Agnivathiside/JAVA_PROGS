//{ Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

public class adding_array_min_pq_shit {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().minOperations(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




// {1, 10, 12, 9, 2, 3}
class Solution {
    int minOperations(int[] arr, int n, int k) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        // 1 16 10 5 6 
        int count=0;
        while(k>pq.peek()){
            if(pq.size()==1) return -1; 
            // System.out.println("i was here");
            int sum=0;
            int first=pq.poll();
            int second=pq.poll();
            sum+=first+second;
            pq.add(sum);
            count++;
        }

        // if(count==0) return -1;

        return count;
    }
}

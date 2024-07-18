// public class kwy_pair_shit

//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class kwy_pair_shit{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().hasArrayTwoCandidates(arr, n, x);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        Arrays.sort(arr);
        // 1 4 6 8 10 45
        // System.out.println("Sorte array is "+arr);

        int start=0;
        int end = n-1;

        while (end>start){
            if (arr[start]+arr[end]==x){
                return true;
            }
            else if(arr[start]+arr[end]>x){
                end=end-1;
            }else{
                start=start+1;
            }
        }
        return false;
    }
}

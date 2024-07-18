// public class longest_sub_arr_k_shit

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class longest_sub_arr_k_shit {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr[] = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution obj = new Solution();
            int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int arr[], int N, int K) {
        // Complete the function
        int start=0;
        int end = -1;
        int curSum=0;
        int max=Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            curSum+=arr[i];

            if(curSum==K){
                start=0;
                end=i;
                max=Math.max(max, (end-start+1));
            }

            else if(map.containsKey(curSum-K)){
                start=map.get(curSum-K)+1;
                end=i;
                max=Math.max(max, (end-start+1));
            }
            map.put(curSum, i);
        }
        return (max==Integer.MIN_VALUE)?0:max;
    }
}

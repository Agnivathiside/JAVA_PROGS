// public class pythagorean_triplet_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class pythagorean_triplet_shit {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().checkTriplet(arr, n);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    boolean solve(int arr[], int sum){
        Arrays.sort(arr);
        int left=0, right=arr.length-1;

        while(left<right){
            if (arr[left]+arr[right]==sum){
                return true;
            }else if(arr[left]+arr[right]>sum){
                right-=1;
            }else{
                left+=1;
            }
        }
        return false;
    }
    public int[] twoSum(int[] nums, int target) {
        System.out.println("Finding value "+target);
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }
    boolean checkTriplet(int[] arr, int n) {
        // code here
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * arr[i];
        }

        int found[]=new int[2];
        for (int i=0; i<n; i++){
            // System.out.println("passing value "+arr[i]);
            found= twoSum(arr, arr[i]);
            
        }
        if (found.length==0) return false;
        return true;

    }
}

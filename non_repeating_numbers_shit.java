// public class non_repeating_numbers_shit

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for (int i = 0; i < 2 * n + 2; i++) {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for (int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public int[] singleNumber(int[] nums) {
        // Code here
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num:nums){
            map.put(num, 1+map.getOrDefault(num, 0));
        }
        int ans[] = new int[nums.length]; 
        ArrayList<Integer> arl = new ArrayList<>();
        for (int keys:map.keySet()){
            if (map.get(keys)==1){
                arl.add(keys);
            }
        }
        
        ans[0]=arl.get(0);
        ans[1]=arl.get(1);

        Arrays.sort(ans);

        return ans;

    }
}
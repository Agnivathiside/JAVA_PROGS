// public class unique_permutations_shit

//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");

            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr, n);
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> arr, int index, int n, ArrayList<ArrayList<Integer>> ans){
        if (arr.size()==1){
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<Integer> subres = new ArrayList<>();
            subres.add(arr.get(0));
            res.add(subres);
            return res;
        }

        for(int i=0; i<arr.size(); i++){
            int first = arr.remove(0);

            ArrayList<ArrayList<Integer>> ans1 = new ArrayList<>();
            ans1=solve(arr, index, n, ans);
            
            for(ArrayList<Integer> arl:ans1){
                arl.add(first);
            }
            for(ArrayList<Integer> arl: ans1){
                ans.add(arl);
            }
            arr.add(first);
        }
        return ans;


    }
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans_final = new ArrayList<>();

        ans_final=solve(arr, 0, n, ans);
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (ArrayList<Integer> arl :ans_final){
            set.add(arl);
        }

        ans_final.clear();
        for(ArrayList<Integer> final1:set){
            ans_final.add(final1);
        }
        return ans_final;
    }
}

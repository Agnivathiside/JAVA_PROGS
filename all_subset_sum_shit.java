// public class all_subset_sum_shit

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

public class all_subset_sum_shit {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

// User function Template for Java//User function Template for Java
class Solution {
    int sum(ArrayList<Integer> arl){
        int sum=0;
        for (int i=0; i<arl.size(); i++){
            sum+=arl.get(i);
        }
        return sum;
    }
    void solve(ArrayList<Integer> arr, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> subsets,int index, int n){
        if (index==n){
            subsets.add(new ArrayList<>(temp));
            return;
        }

        temp.add(arr.get(index));
        solve(arr, temp, subsets, index+1, n);

        temp.remove(temp.size()-1);
        solve(arr, temp, subsets, index+1, n);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        // code here
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();

        solve(arr, temp, subsets, 0, N);

        ArrayList<Integer> ans = new ArrayList<>();
        for (ArrayList<Integer> arl: subsets){
            ans.add(sum(arl));
        }
        return ans;
    }
}
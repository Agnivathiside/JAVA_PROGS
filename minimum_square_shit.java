//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int solve(int n){
        //base case
        if (n==0) return 0;
        
        int ans=n;
        //loop
        for (int i=1; i*i<=n; i++){
            ans=Math.min(ans, 1+ solve(n-i*i));
        }
        return ans;
    }
    public static int solveMem(int n,ArrayList<Integer> lis){
        //base case
        if (n==0) return 0;
        
        if (lis.get(n)!=-1){
            return lis.get(n);
        }
        int ans=n;
        //loop
        for (int i=1; i*i<=n; i++){
            ans=Math.min(ans, 1+ solve(n-i*i));
        }
        lis.add(n, ans);
        return lis.get(n);
    }
    public int MinSquares(int n)
    {
        //return solve(n);
        ArrayList<Integer> lis=new ArrayList<>();
        for (int i=0;i<n;i++){
            lis.add(-1);
        }
        return solveMem(n, lis);
    }
}
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            String a1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(a1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int solve(int mat[][], int i, int j, int max){
        if (i>mat.length || j>mat[0].length) return 0;

        int right=solve(mat, i, j+1, max);
        int bottom=solve(mat, i+1, j, max);
        int corner=solve(mat, i+1, j+1, max);

        if (mat[i][j]==1){
            int ans1=1+Math.min(right ,Math.min(bottom, corner));
            max=Math.max(ans1, max);
            return ans1;
        }else{
            return 0;
        }
    }
    static int maxSquare(int n, int m, int mat[][]){
        // code here
        int max=0;
        solve(mat, 0,0,max);
        return max;
    }
}
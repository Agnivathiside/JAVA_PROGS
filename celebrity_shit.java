//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

import javax.management.monitor.CounterMonitor; 

class celebrity_shit{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    boolean knows(int M[][], int a, int b, int n){
        if (M[a][b]==1){
            return true;
        }
        return false;
    }
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// put all candidate in stack 
        Stack<Integer> st= new Stack<>();
        for (int i=0;i<n;i++){
            st.push(i);
        }

        // take out 2 candidates and check for celebrity
        // wait for a single person to be in the stack
        while (st.size()>1){
            int a=st.peek();
            st.pop();

            int b=st.peek();
            st.pop();

            if (knows(M,a,b,n)){
                st.push(b);
            }else{
                st.push(a);
            }

        }
        int potential_ans=st.peek();
        // Now we are left with only one element 
        boolean row_check=false;
        boolean col_check=false;

        int count_zero=0;
        int count_one=0;

        for (int i=0;i<n;i++){
            if(M[potential_ans][i]==0){
                count_zero++;
            }
        }
        for (int i=0;i<n;i++){
            if(M[i][potential_ans]==1){
                count_one++;
            }
        }
        if (count_zero==n) row_check=true;
        if (count_one==n-1) col_check=true;

        if(row_check && col_check){
            return potential_ans;
        }
        return -1;
        
    }
}
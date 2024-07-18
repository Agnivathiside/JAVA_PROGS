//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static boolean isMerged(int[] a, int[] b, int[] merged){
        if(a.length + b.length != merged.length)
            return false;
        
        int[] m = new int[merged.length];
        int i = 0;
        for(int e : a)
            m[i++] = e;
        for(int e : b)
            m[i++] = e;
        Arrays.sort(m);
        int[] mergedCopy = Arrays.copyOf(merged, merged.length);
        Arrays.sort(mergedCopy);
        if(!Arrays.equals(m, mergedCopy))
            return false;
        
        for(i = 1; i < merged.length; i++){
            if(merged[i] > merged[(i-1)/2])
                return false;
        }
        
        return true;
    }
    
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int a[] = new int[n];
            int b[] = new int[m];
            int merged[];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            int[] copyA = Arrays.copyOf(a, a.length), copyB = Arrays.copyOf(b, b.length);
            merged = obj.mergeHeaps(a, b, n, m);
            
            boolean flag = isMerged(copyA, copyB, merged);
            System.out.println(flag ? 1 : 0);
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    void heapify(int[] arr, int n, int i){

    }
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        //PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int[] arr= new int[n+m];
        int[] ans=new int[n+m];
        int i=0,j=0,c=0;
        while (i<n && j<m){
            if (a[i]>b[j]) arr[c]=a[i];
            else arr[c]=b[j]; 
            c++;
            i++;
            j++;
        }
        while (i<n){
            arr[c]=a[i];
            c++;
            i++;
        }
        while (j<m){
            arr[c]=b[j];
            c++;
            j++;
        }
        int size=arr.length;
        for (int i=size/2;i<)
        return ans;
    }
}
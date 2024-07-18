// public class preorder_toBST_shit

//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

class Node { 
	int data; 
	Node left, right; 
	Node(int d) { 
		data = d; 
		left = right = null; 
	} 
} 


public class preorder_toBST_shit {
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputline[i]);
            }
            
            Node res = post_order(arr, n);
            printPostorder(res);
            System.out.println();
        }
    }
    
    
    
    
// } Driver Code Ends
//User function Template for Java


//Function that constructs BST from its preorder traversal.
public static Node makeBST(int pre[], int start, int end){
    if (start>end) return null;
    
    int mid=start+(end-start)/2;
    
    Node root = new Node(pre[mid]);
    
    root.left=makeBST(pre, start, mid-1);
    root.right=makeBST(pre, mid+1, end);
    
    return root;
}
public static Node solve(int pre[], int mini, int max, int i){
    if (i>=pre.length) return null;

    if (pre[i]<mini || pre[i]>max){
        return null;
    }

    Node root = new Node(pre[i++]);
    root.left=solve(pre, mini, root.data, i);
    root.right=solve(pre, root.data, max, i);
    return root;
}
public static Node post_order(int pre[], int size) 
{
    //Your code here
    // Arrays.sort(pre);
    // return makeBST(pre, 0, pre.length-1);

    int mini=Integer.MIN_VALUE;
    int max= Integer.MAX_VALUE;
    int i=0;
    return solve(pre, mini, max, i);
} 

//{ Driver Code Starts.


public static 	void printInorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printInorder(node.left); 
		System.out.print(node.data + " "); 
		printInorder(node.right); 
	} 
	
public static 	void printPostorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printPostorder(node.left); 
		printPostorder(node.right);
		System.out.print(node.data + " "); 
	} 
	
public static 	void printPreorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		System.out.print(node.data + " "); 
		printPreorder(node.left); 
		printPreorder(node.right);
	} 

}
// } Driver Code Ends
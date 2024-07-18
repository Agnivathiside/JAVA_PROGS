//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class k_sum_path_shit
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<>();

        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            
            System.out.println(ob.sumK(root,k));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    void findPath(Node root, int count, int sum, ArrayList<Integer> lis, int k){
        if (root==null){
            return;
        }
        lis.add(root.data);
        findPath(root.left, count, sum, lis, k);
        findPath(root.right, count, sum, lis, k);
        int size=lis.size();
        for (int i=lis.size()-1;i>=0;i--){
            sum+=lis.get(i);
            if (sum==k) count++;
        } 
        lis.remove(size-1);
    }
    public int sumK(Node root,int k)
    {
        // code here
        ArrayList<Integer> lis=new ArrayList<>();
        int count=0;
        int sum=0;
        findPath(root, count, sum, lis, k);
        return count;
    }
}
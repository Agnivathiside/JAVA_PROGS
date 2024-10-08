//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

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

class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void postOrder(Node root)
    {
        if(root == null)
            return;
            
        postOrder(root.left);
         postOrder(root.right);
        System.out.print(root.data+" ");
    
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution g = new Solution();
                g.convertToMaxHeapUtil(root);
                postOrder(root);
                
                System.out.println();
                    
                t--;
            
        }
    }
}



// } Driver Code Ends


//User function Template for Java

/*class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/

class Solution
{
    static void inorderation(Node root, ArrayList<Integer> lis){
        if (root==null) return;
        inorderation(root.left,lis);
        lis.add(root.data);
        inorderation(root.right,lis);
        
    }
    static void heapify(ArrayList<Integer> hT, int i) {
        int size = hT.size();
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && hT.get(l) > hT.get(largest))
          largest = l;
        if (r < size && hT.get(r) > hT.get(largest))
          largest = r;
    
        if (largest != i) {
          int temp = hT.get(largest);
          hT.set(largest, hT.get(i));
          hT.set(i, temp);
    
          heapify(hT, largest);
        }
    }
    public static void convertToMaxHeapUtil(Node root)
    {
        //code here
        ArrayList<Integer> lis=new ArrayList<>();
        inorderation(root, lis);
        int size=lis.size();
        for (int i=size/2;i<0;i--){
            heapify(lis,i);
        } 
        return;
    }
}
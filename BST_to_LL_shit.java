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

class GfG {
    
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution ob=new Solution();
                ob.flatten(root);
                printInorder(root);
                System.out.println();
                    t--;
            
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static void inorderation(Node root, ArrayList<Integer> lis){
        if (root==null) return;

        inorderation(root.left, lis);
        lis.add(root.data);
        inorderation(root.right, lis);

    }
    public static void flatten(Node root)
    {
        //code here
        ArrayList<Integer> lis=new ArrayList<>();
        inorderation(root, lis);
        Node head= new Node(lis.get(0));
        Node curr=head;
        
        //curr.right=null;
        return;
        //Node head=new Node(lis.get(0));
        // Node curr=head;
        // for (int i=1;i<lis.size()-1;i++){
        //     Node temp=new Node(lis.get(i));
        //     curr.next=temp;
        // }
    }
    // class LinkedList {
    //     Node head; // head of list
    
    //     /* Linked list Node*/
    //     class Node {
    //         int data;
    //         Node next;
    
    //         // Constructor to create a new node
    //         // Next is by default initialized
    //         // as null
    //         Node(int d) { data = d; }
    //     }
    // }
    
}
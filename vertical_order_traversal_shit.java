// public class vertical_order_traversal_shit

//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
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

public class vertical_order_traversal_shit{
    
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
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java

class pair {
        Node first;
        int second;
        pair(Node first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // Base case
        if (root == null){
            ArrayList<Integer> ans= new ArrayList<>();
            return ans;
        }
 
        // Create a map and store vertical
        // order in map using
        // function getVerticalOrder()
        HashMap<Integer, ArrayList<Integer> > m
            = new HashMap<>();
        int hd = 0;
 
        // Create queue to do level order
        // traversal Every item of queue contains
        // node and horizontal distance
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(root, hd));
 
        // mn and mx contain the minimum and
        // maximum horizontal distance from root
        int mn = 0, mx = 0;
        while (q.size() > 0) {
 
            // pop from queue front
            pair temp = q.remove();
 
            hd = temp.second;
            Node node = temp.first;
 
            // insert this node's data
            // in vector of hash
            if (!m.containsKey(hd))
                m.put(hd, new ArrayList<>());
            m.get(hd).add(node.data);
 
            if (node.left != null)
                q.add(new pair(node.left, hd - 1));
            if (node.right != null)
                q.add(new pair(node.right, hd + 1));
 
            // Update mn and mx
            if (mn > hd)
                mn = hd;
            else if (mx < hd)
                mx = hd;
        }
        
        // run the loop from minimum to maximum
        // every horizontal distance hd
        ArrayList<Integer> tmp= new ArrayList<>();
        // for (int i = mn; i <= mx; i++) {
        //     tmp.add(m.get(i));
        // }
        System.out.println(m);
        return tmp;
    }
}

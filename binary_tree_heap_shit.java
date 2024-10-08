//{ Driver Code Starts
    import java.util.LinkedList;
    import java.util.Queue;
    import java.io.*;
    import java.util.*;
    
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
      public class GfG {
    
        static Node buildTree(String str) {
    
            if (str.length() == 0 || str.charAt(0) == 'N') {
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
            while (queue.size() > 0 && i < ip.length) {
    
                // Get and remove the front of the queue
                Node currNode = queue.peek();
                queue.remove();
    
                // Get the current node's value from the string
                String currVal = ip[i];
    
                // If the left child is not null
                if (!currVal.equals("N")) {
    
                    // Create the left child for the current node
                    currNode.left = new Node(Integer.parseInt(currVal));
                    // Push it to the queue
                    queue.add(currNode.left);
                }
    
                // For the right child
                i++;
                if (i >= ip.length) break;
    
                currVal = ip[i];
    
                // If the right child is not null
                if (!currVal.equals("N")) {
    
                    // Create the right child for the current node
                    currNode.right = new Node(Integer.parseInt(currVal));
    
                    // Push it to the queue
                    queue.add(currNode.right);
                }
                i++;
            }
    
            return root;
        }
        static void printInorder(Node root) {
            if (root == null) return;
    
            printInorder(root.left);
            System.out.print(root.data + " ");
    
            printInorder(root.right);
        }
    
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
    
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String s = br.readLine();
                Node root = buildTree(s);
    
                Solution ob = new Solution();
                if (ob.isHeap(root))
                    System.out.println(1);
                else
                    System.out.println(0);
            }
        }
    }
    // } Driver Code Ends
    
    
    // User Function template for JAVA
    
    /*
    Node defined as
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    */
    
    class Solution {
        boolean isMaxOrder(Node root){
            if (root ==null) return true;
            if (root.left==null && root.right==null) return true;
            if (root.right==null) return root.data>root.left.data;
            boolean left=isMaxOrder(root.left);
            boolean right =isMaxOrder(root.right);
            return ((left && right) && root.data>root.left.data && root.data>root.right.data);
        }
        boolean isCBT(Node root, int nodeCount, int index){
            if (root==null) return true;
            if (index>=nodeCount) return false;
            boolean left =isCBT(root.left, nodeCount, 2*index+1);
            boolean right =isCBT(root.right, nodeCount, 2*index+2);
            return (left && right);
        }
        int countNodes(Node root){
            if (root==null) return 0;
            return 1+ countNodes(root.left)+ countNodes(root.right);
        }
        boolean isHeap(Node root) {
            // code here
            int index=0;
            int nodeCount=countNodes(root);
            boolean CBT=isCBT(root, nodeCount, index);
            boolean maxorder=isMaxOrder(root);
            return (CBT && maxorder);
        }
    }
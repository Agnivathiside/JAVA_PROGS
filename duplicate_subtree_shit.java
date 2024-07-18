// public class duplicate_subtree_shit

//{ Driver Code Starts
//Initial Template for Java

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

class GFG {

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
            if (i >= ip.length)
                break;

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
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();
            System.out.println(ob.dupSub(root));
            t--;
        }
    }
}
// } Driver Code Ends

// User function Template for Java

/*
 * A Binary Tree node
 * 
 * class Node
 * {
 * int data;
 * Node left, right;
 * 
 * Node(int item)
 * {
 * data = item;
 * left = right = null;
 * }
 * }
 */

// class Solution {
//     boolean solve(Node left, Node right){
//         if (left==null && right==null) return false;
//         if (left==null && right!=null) return false;
//         if (left!=null && right==null) return false;

//         boolean checkleft=false;
//         boolean checkright=false;
//         if (left.data==right.data){
//             checkleft = solve(left.left, right.left);
//             checkright = solve(left.right, right.right);

//         }else{
//             boolean first = solve(left, right.left) || solve(left, right.right);
//             boolean second = solve(left.left, right) || solve(left.right, right);
//             return first || second;
//         }

//         return (checkleft||checkright);
//     }
//     int dupSub(Node root) {
//         // code here
//         boolean flag= solve(root.left, root.right);
//         return (flag==false)?0:1;
//     }
// }

class Solution {
    boolean isDuplicateSubtree(Node left, Node right) {
        // Base case: Both left and right are null, so no duplicate subtree
        if (left == null && right == null) return false;
        
        // If only one of left or right is null, then no duplicate subtree
        if (left == null || right == null) return false;
        
        // If the data of current nodes match, check their subtrees
        if (left.data == right.data) {
            boolean checkLeft = isDuplicateSubtree(left.left, right.left);
            boolean checkRight = isDuplicateSubtree(left.right, right.right);
            return checkLeft || checkRight;
        } else {
            // Check both possibilities for duplicates (left of left with right, and vice versa)
            boolean first = isDuplicateSubtree(left, right.left) || isDuplicateSubtree(left, right.right);
            boolean second = isDuplicateSubtree(left.left, right) || isDuplicateSubtree(left.right, right);
            return first || second;
        }
    }
    
    int dupSub(Node root) {
        if (root == null) return 0; // Null tree, no duplicate subtree
        return isDuplicateSubtree(root.left, root.right) ? 1 : 0;
    }
}

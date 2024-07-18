// public class count_no_subtree_sum__BT_shit

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

public class count_no_subtree_sum__BT_shit {

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
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            int x = Integer.parseInt(br.readLine());
            Tree tr = new Tree();
            System.out.println(tr.countSubtreesWithSumX(root, x));

        }

    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * class Node
 * {
 * int data;
 * Node left,right;
 * Node(int d)
 * {
 * data=d;
 * left=right=null;
 * }
 * }
 */

// class Tree {
//     int count = 0;
//     int countSubtreesWithSumX(Node root, int X) {
//         // Add your code here.
//         if (root == null) return count;
//         if (root.left==null && root.right==null && root.data == X) return count++;

//         int left =0, right =0;

//         if (root.left!=null) left = root.left.data;
//         if (root.right!=null) right = root.right.data;

//         boolean sum = (root.data + left + right) == X;
//         if (sum) count++;

//         countSubtreesWithSumX(root.left, X);
//         countSubtreesWithSumX(root.right, X);

//         return count;

//     }
// }
class Tree{
    int c;
    int sum(Node root,int X){
        if(root==null){
            return 0;
        }
        int l=sum(root.left,X);
        int r=sum(root.right,X);
        int s=l+r+root.data;
        if(s==X){
            c++;
        }
        return s;
    }
    int countSubtreesWithSumX(Node root, int X){
        c=0;
        sum(root,X);
        return c;
    }
}
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.util.LinkedList;

import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class zig_zag_traversal_shit {
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

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    /* Drier program to test above functions */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            GFG g = new GFG();

            List<List<Integer>> res = g.zigZagTraversal(root);
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();

            t--;

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

class GFG {
    // // Function to store the zig zag order traversal of tree in a list.
    // ArrayList<Integer> zigZagTraversal(Node root) {
    //     // Add your code here.
    //     // Stack<Node> st=new Stack<>();
    //     Queue<Node> qu = new LinkedList<>();
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     if (root == null) {
    //         return null;
    //     }
    //     int level = 1;
    //     qu.add(root);
    //     while (!qu.isEmpty()) {
    //         // ans.add(st.pop().data);
    //         int no_of_elements = qu.size();
    //         // ArrayList<Node> al=new ArrayList<>();
    //         for (int i = 0; i < no_of_elements; i++) {
    //             // ans.add(st.pop().data);
    //             Node curr = qu.poll();
    //             ans.add(curr.data);
    //             if (level % 2 == 0) {
    //                 // if(curr.right!=null) al.add(curr.right);
    //                 if (curr.left != null)
    //                     qu.add(curr.left);
    //                 if (curr.right != null)
    //                     qu.add(curr.right);
    //                 // if(curr.left!=null) al.add(curr.left);
    //             } else {
    //                 if (curr.right != null)
    //                     qu.add(curr.right);
    //                 if (curr.left != null)
    //                     qu.add(curr.left);
    //             }
    //         }
    //         // while (al.size()!=0){
    //         // st.push(al.get(0));
    //         // al.remove(0);
    //         // }
    //         level++;
    //     }
    //     return ans;
    // }


    List<List<Integer>> zigZagTraversal(Node root){
	    Queue<Node> q= new LinkedList<>();
        q.add(root);
        List<List<Integer>> result=new ArrayList<>();
        boolean leftToRight=true;

        while (!q.isEmpty()){
            int size= q.size();
            int[] ans= new int[size];

            for (int i=0;i<size;i++){
                Node frontNode=q.poll();

                int index= leftToRight?i :size-i-1;
                ans[index]=frontNode.data;

                if (frontNode.left!=null) q.add(frontNode.left);
                if (frontNode.right!=null) q.add(frontNode.right);
            }
            leftToRight=!leftToRight;
            List<Integer> lis= new ArrayList<>();
            for (int i:ans){
                lis.add(i);
            }
            result.add(lis);
        }
        return result;
	}
}
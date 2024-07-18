// public class search_in_BST_shit

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class search_in_BST_shit {
    void insert(Node root, int key) {

        if (key < root.data) {
            if (root.left != null)
                insert(root.left, key);
            else
                root.left = new Node(key);
        } else if (key > root.data) {
            if (root.right != null)
                insert(root.right, key);
            else
                root.right = new Node(key);
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            search_in_BST_shit obj = new search_in_BST_shit();
            int a1 = sc.nextInt();
            Node root = new Node(a1);

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                obj.insert(root, a);
            }

            int s = sc.nextInt();
            BST g = new BST();
            if (g.search(root, s) == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    }
}
// } Driver Code Ends

class BST {
    // Function to search a node in BST.
    void inorder(Node root, ArrayList<Integer> arl){
        if (root ==null) return;

        inorder(root.left, arl);
        arl.add(root.data);
        inorder(root.right, arl);
    }
    boolean search(Node root, int x) {
        // Your code here
        if (root == null) return false;
        ArrayList<Integer> arl = new ArrayList<>();
        inorder(root, arl);
        
        int start=0;
        int end=arl.size()-1;

        int mid=start+(end-start)/2;

        while(end>start){
            if (arl.get(mid)==x){
                return true;
            }else if (x>arl.get(mid)){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }
}

// public class binary_tree_to_LL_shit

//{ Driver Code Starts
//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.util.LinkedList;

class Tree {
    int data;
    Tree left;
    Tree right;

    Tree(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}


// } Driver Code Ends


/*class Tree{
int data;
    Tree left;
    Tree right;
    Tree(int d){
        data=d;
        left=null;
        right=null;
    }
}

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/


class GfG {
    // Function to make binary tree from linked list.
    public static Tree convert(Node head, Tree node) {
        Node curr = head;
        ArrayList<Tree> arl = new ArrayList<>();
        while(curr!=null){
            Tree treenode = new Tree(curr.data);
            arl.add(treenode);
            curr = curr.next;
        }
        int n = arl.size();
        for(int i=0; i<n/2; i++){
            if (2*i + 1 < n){
                arl.get(i).left = arl.get(2*i + 1);
            }
            if (2*i + 2 < n){
                arl.get(i).right = arl.get(2*i + 2);
            }
        }
        return arl.get(0);
    }
}

//{ Driver Code Starts.
public class binary_tree_to_LL_shit {
    static Node lhead;
    static Queue<Tree> queue = new LinkedList<Tree>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Tree node = null;
            lhead = null;
            Node head = null;
            while (!queue.isEmpty()) {
                queue.poll();
            }
            int n = sc.nextInt();
            if (n != 0) {
                binary_tree_to_LL_shit llist = new binary_tree_to_LL_shit();
                int a1 = sc.nextInt();
                head = new Node(a1);
                llist.addToTheLast(head);
                lhead = head;
                for (int i = 1; i < n; i++) {
                    int a = sc.nextInt();
                    llist.addToTheLast(new Node(a));
                }
            }
            Solution g = new Solution();
            Tree root = g.convert(lhead, node);
            try {
                levelOrder(root, n);
            } catch (NullPointerException ex) {
                System.out.println(-1);
            }
            System.out.println();
        }
    }

    public static void levelOrder(Tree root, int n) {
        queue.add(root);
        while (!queue.isEmpty() && n-- > 0) {
            Tree proot = queue.remove();
            try {
                queue.add(proot.left);
                queue.add(proot.right);
                System.out.print(proot.data + " ");
            } catch (NullPointerException ex) {
            }
        }
    }

    public void addToTheLast(Node head) {
        if (lhead == null)
            lhead = head;
        else {
            Node temp = lhead;
            while (temp.next != null) temp = temp.next;
            temp.next = head;
        }
    }
}
// } Driver Code Ends
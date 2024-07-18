// public class union_two_LL_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
    }
}

public class union_two_LL_shit{
    static Scanner sc = new Scanner(System.in);

    public static Node inputList(int size) {
        Node head, tail;
        int val;

        val = sc.nextInt();

        head = tail = new Node(val);

        size--;

        while (size-- > 0) {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }

        return head;
    }

    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String args[]) {
        int t = sc.nextInt();
        while (t-- > 0) {
            int n, m;

            n = sc.nextInt();
            Node head1 = inputList(n);

            m = sc.nextInt();
            Node head2 = inputList(m);

            Sol obj = new Sol();

            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}
// } Driver Code Ends

/*
 * class Node
 * {
 * int data;
 * Node next;
 * Node(int d) {data = d; next = null; }
 * }
 */

class Sol {
    public static Node findUnion(Node head1, Node head2) {
        // Add your code here.
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> arl = new ArrayList<>();

        Node cur1=head1;
        Node cur2=head2;

        while (cur1!=null){
            set.add(cur1.data);
            cur1=cur1.next;
        }
        while (cur2!=null){
            set.add(cur2.data);
            cur2=cur2.next;
        }
        for (int elements : set){
            arl.add(elements);
        }
        Collections.sort(arl);
        Node dummy = new Node(-1);
        Node head = dummy;
        for (int i=0; i<arl.size(); i++){
            Node temp = new Node(arl.get(i));
            head.next = temp;
            head = head.next;
        }
        return dummy.next;
    }
}
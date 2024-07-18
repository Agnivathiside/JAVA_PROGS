
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

class intersection_sorted_LL_shit {
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
            m = sc.nextInt();

            Node head1 = inputList(n);
            Node head2 = inputList(m);

            Sol obj = new Sol();

            Node result = obj.findIntersection(head1, head2);

            printList(result);
            System.out.println();
        }
    }
}
// } Driver Code Ends

/*
 * Node of a linked list
 * class Node {
 * int data;
 * Node next;
 * Node(int d) { data = d; next = null; }
 * }
 */

class Sol {
    public static Node findIntersection(Node head1, Node head2) {
        int len1 = 1;
        int len2 = 1;

        Node h1 = head1;
        Node h2 = head2;

        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();

        Node dummy = new Node(-1);
        Node head = dummy;

        while (h1 != null) {
            len1++;
            s1.add(h1.data);
            h1 = h1.next;
        }
        h1 = head1;

        while (h2 != null) {
            len2++;
            s2.add(h2.data);
            h2 = h2.next;
        }
        h2 = head2;

        if (len1 <= len2) {
            while (h2 != null) {
                if (s1.contains(h2.data)) {
                    Node first = new Node(h2.data);
                    dummy.next = first;
                    dummy = dummy.next;
                    s1.remove(h2.data);
                }
            }
        } else if (len1 < len2) {
            while (h1 != null) {
                if (s2.contains(h1.data)) {
                    Node first = new Node(h1.data);
                    dummy.next = first;
                    dummy = dummy.next;
                    s2.remove(h1.data);
                }
            }
        }
        return head;

    }
}

//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

}

class inseet_at_middle_shit {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;

            for (int i = 0; i < n - 1; i++) {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            int k = sc.nextInt();

            Solution g = new Solution();
            head = g.sortedInsert(head, k);

            printList(head);
            t--;
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

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head1, int key) {
        // Add your code here.
        Node present = head1;
        Node future = head1.next;
        boolean flag = false;

        if (key < head1.data) {
            Node new_head = new Node(key);
            new_head.next = head1;
            return new_head;
        }
        if (key > head1.data && key < head1.next.data) {
            Node new_head = new Node(key);
            Node pre = head1;
            Node post = head1.next;
            new_head.next = post;
            pre.next = new_head;
            return head1;
        }

        while (future != null) {
            if ((key >= present.data) && (key <= future.data)) {
                Node node = new Node(key);
                node.next = future;
                present.next = node;
                flag = true;
                break;
            }
            future = future.next;
            present = present.next;
        }
        if (flag == false) {
            Node pre = head1;
            while (pre.next != null) {
                pre = pre.next;
            }
            Node node = new Node(key);
            pre.next = node;
        }
        return head1;
    }
}
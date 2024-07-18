// public class rearrange_LL_shit

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

public class rearrange_LL_shit {
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
            new Solution().rearrangeEvenOdd(head);
            printList(head);
            t--;
        }
    }
}

// } Driver Code Ends

/*
 * 
 * class Node {
 * 
 * int data;
 * Node next;
 * 
 * Node(int d) {
 * data = d;
 * next = null;
 * }
 * }
 * This is method only submission.
 * You only need to complete the below method.
 */
class Solution {
    // Should rearrange given linked list such that all even
    // positioned Nodes are before odd positioned.
    // Returns nothing
    void rearrangeEvenOdd(Node head) {
        Node even = new Node(0);
        Node odd = new Node(0);
        Node evenstart = even;
        Node oddstart = odd;
        Node temp = head;
        int i = 1;
        while (temp != null) {
            if (i % 2 != 0) {
                oddstart.next = temp;
                oddstart = temp;
                i++;
            } else {
                evenstart.next = temp;
                evenstart = temp;
                i++;
            }
            temp = temp.next;
        }
        oddstart.next = even.next;
        evenstart.next = null;
    }
}

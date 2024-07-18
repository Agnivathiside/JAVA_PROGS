// public class merge_sort_doubly_LL_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

public class merge_sort_doubly_LL_shit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * class Node
 * {
 * int data;
 * Node next, prev;
 * Node(int data)
 * {
 * this.data = data;
 * next = prev = null;
 * }
 * }
 */
class Solution {
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head) {
        // Base case: if list is empty or has only one element
        if (head == null || head.next == null)
            return head;

        // Convert the doubly linked list to an array list
        ArrayList<Integer> arl = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            arl.add(curr.data);
            curr = curr.next;
        }

        // Sort the array list
        Collections.sort(arl);

        // Reconstruct the sorted doubly linked list
        Node dummy = new Node(-1);
        Node current = dummy;
        for (int num : arl) {
            Node temp = new Node(num);
            current.next = temp;
            temp.prev = current;
            current = current.next;
        }

        Node newHead = dummy.next;
        dummy.next.prev=null;
        return newHead;

    }
}


//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList_Intersection {
    Node head = null;
    Node tail = null;

    public void Intersection_Y_LL_shit(Node node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            // Node temp = head;
            // while (temp.next != null)
            // temp = temp.next;

            // temp.next = node;
            tail.next = node;
            tail = node;
        }
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {

        /*
         * Constructed Linked List is 1->2->3->4->5->6->
         * 7->8->8->9->null
         */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            LinkedList_Intersection llist1 = new LinkedList_Intersection();
            LinkedList_Intersection llist2 = new LinkedList_Intersection();
            LinkedList_Intersection llist3 = new LinkedList_Intersection();

            int a1 = sc.nextInt();
            Node head1 = new Node(a1);
            Node tail1 = head1;

            for (int i = 1; i < n1; i++) {
                int a = sc.nextInt();
                tail1.next = (new Node(a));
                tail1 = tail1.next;
            }

            int b1 = sc.nextInt();
            Node head2 = new Node(b1);
            Node tail2 = head2;
            for (int i = 1; i < n2; i++) {
                int b = sc.nextInt();
                tail2.next = (new Node(b));
                tail2 = tail2.next;
            }
            if (n3 > 0) {
                int c1 = sc.nextInt();
                Node head3 = new Node(c1);
                tail1.next = head3;
                tail2.next = head3;
                Node tail3 = head3;
                for (int i = 1; i < n3; i++) {
                    int c = sc.nextInt();
                    tail3.next = (new Node(c));
                    tail3 = tail3.next;
                }
            }
            Intersect obj = new Intersect();
            System.out.println(obj.intersectPoint(head1, head2));
            t--;
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
 * Linked List class
 * class LinkedList
 * {
 * Node head; // head of list
 * }
 */

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2) {
        // code here
        int LL_1_len=0;
        int LL_2_len=0;

        Node curr1=head1;
        Node curr2=head2;

        while (curr1!=null){
            LL_1_len++;
            curr1=curr1.next;
        }
        curr1=head1;

        while (curr2!=null){
            LL_2_len++;
            curr2=curr2.next;
        }
        curr2=head2;

        if (LL_1_len>LL_2_len){
            int pointer_location=LL_1_len-LL_2_len;

            while (pointer_location>0){
                curr1=curr1.next;
                pointer_location--;
            }
            while (curr1.data!=curr2.data) {
                curr1=curr1.next;
                curr2=curr2.next;
            }

            return curr1.data;
        }else if (LL_2_len>LL_1_len) {
            int pointer_location=LL_2_len-LL_1_len;
            while (pointer_location>0){
                curr2=curr2.next;
                pointer_location--;
            }

            while (curr1.data!=curr2.data) {
                curr1=curr1.next;
                curr2=curr2.next;
            }

            return curr1.data;
        }else{
            while (curr1.data!=curr2.data) {
                curr1=curr1.next;
                curr2=curr2.next;
            }

            return curr1.data;

        }
    }
}

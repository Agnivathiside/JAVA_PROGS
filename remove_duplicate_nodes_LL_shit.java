// public class remove_duplicate_nodes_LL_shit

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

public class remove_duplicate_nodes_LL_shit {
    Node head;
    Node tail;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            remove_duplicate_nodes_LL_shit llist = new remove_duplicate_nodes_LL_shit();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            Solution ob = new Solution();
            head = ob.removeAllDuplicates(llist.head);
            llist.printList(head);

            t--;
        }
    }
}
// } Driver Code Ends

class Solution {
    public Node removeAllDuplicates(Node head) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            if (map.containsKey(curr.data)) {
                map.put(curr.data, map.get(curr.data) + 1);
            } else {
                map.put(curr.data, 1);
            }
            curr = curr.next;
        }
        // System.out.println(map);
        Node dummy = new Node(-1);
        Node curr1 = dummy;
        ArrayList<Integer> finalNode = new ArrayList<>();
        for (int keys : map.keySet()) {
            if (map.get(keys) == 1) {
                finalNode.add(keys);
            }
        }
        Collections.sort(finalNode);
        for(int nodes:finalNode){
            Node temp = new Node(nodes);
            curr1.next = temp;
            curr1 = curr1.next;
        }
        return dummy.next;
    }
}

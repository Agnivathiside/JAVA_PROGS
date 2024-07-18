// public class vowel_consonent_LL_shit

//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        next = null;
    }
}
public class vowel_consonent_LL_shit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node head = null, tail = null;

            char head_c = sc.next().charAt(0);
            head = new Node(head_c);
            tail = head;

            while (n-- > 1) {
                tail.next = new Node(sc.next().charAt(0));
                tail = tail.next;
            }

            Solution obj = new Solution();
            // show(head);
            show(obj.arrangeCV(head));

        }
    }

    public static void po(Object o) {
        System.out.println(o);
    }

    public static void show(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends

/*
 * Structure of node class is:
 * class Node {
 * char data;
 * Node next;
 * 
 * public Node(char data){
 * this.data = data;
 * next = null;
 * }
 * }
 */
class Solution {

    public Node arrangeCV(Node head) {
        // write code here and return the head of changed linked list
        ArrayList<Character> vowel = new ArrayList<>();
        ArrayList<Character> consonent = new ArrayList<>();

        Node curr = head;
        while (curr!=null){
            if (curr.data=='a' || curr.data=='e' || curr.data=='i' || curr.data=='o' || curr.data=='u'){
                vowel.add(curr.data);
            }else{
                consonent.add(curr.data);
            }
            curr = curr.next;
        }
        Node dummyVowelHead = new Node('1');
        Node VowelHead = dummyVowelHead;

        for (int i = 0 ; i< vowel.size(); i++){
            Node temp = new Node(vowel.get(i));
            VowelHead.next = temp;
            VowelHead = VowelHead.next;
        }
        Node dummyConsonentHead = new Node('1');
        Node ConsonentHead = dummyConsonentHead; 
        for (int i=0; i<consonent.size(); i++){
            Node temp = new Node(consonent.get(i));
            ConsonentHead.next = temp;
            ConsonentHead = ConsonentHead.next;
        }
        VowelHead.next = dummyConsonentHead.next;
        return dummyVowelHead.next;
    }
}

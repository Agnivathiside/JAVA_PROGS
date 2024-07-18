//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

public class reverse_in_group_LL_shit
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution{
    
    static Node reverseLL(Node head){
        if(head==null||head.next==null)
        return head;
        Node rev=reverseLL(head.next);
        head.next.next=head;
        head.next=null;
        return rev;
    }
    
    public static Node reverse(Node head, int k)
    {
        //Your code here
        if (head==null) return null;
        Node curr=head;
        
        while (k-1>0 && curr.next!=null){
            curr=curr.next;
            k--;
        }
        Node nextNode=curr.next;
        curr.next=null;
        
        Node newHead=reverseLL(head);
        Node newCurr=newHead;
        while(newCurr.next!=null){
            newCurr=newCurr.next;
        }
        
        newCurr.next=reverse(nextNode, k);
        System.out.println("New head data is "+newHead.data);

        return newHead;
    }
}
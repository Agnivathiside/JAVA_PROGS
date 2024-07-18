import java.util.*;
//import java.lang.*;
//import java.io.*;
class Node{
    int data;
    Node next;
}
public class remove_loop_shit {
    public static Node newNode(int data){
        Node temp=new Node();
        temp.data=data;
        temp.next=null;
        return temp;
    }
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node fast=head;
        Node slow=head;
        Node curr=head;
        System.out.println(fast.data);
        System.out.println(slow.data);
        System.out.println(curr.data);
        while (fast!=null && fast.next!=null){
            System.out.println("now fast is: "+fast.data);
            fast=fast.next.next;
            System.out.println("now slow is: "+slow.data);
            slow=slow.next;
            
            if (slow.next==head){
                slow.next=null;
                return;
            }else if (fast==slow){
                break;
            }
        }
        if (fast==null || fast.next==null){
            return;
        }else{
            while (slow.next!=curr.next){
                slow=slow.next;
                curr=curr.next;
            }
            slow.next=null;
            return;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the first number: ");
        int num =sc.nextInt();
        Node head=newNode(num);
        Node tail=head;
        System.out.println("Here loop begins");
        for (int i=0;i<n-1;i++){
            num=sc.nextInt();
            tail.next=newNode(num);
            tail=tail.next;
        }
        removeLoop(head);
        sc.close();
    }
}

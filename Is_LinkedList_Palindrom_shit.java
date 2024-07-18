//{ Driver Code Starts
    import java.util.*;

    class Node
    {
        int data;
        Node next;
        
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    
    class Is_LinkedList_Palindrom_shit
    {
         Node head;  
         Node tail;
        
        /* Function to print linked list */
        void printList(Node head)
        {
            Node temp = head;
            while (temp != null)
            {
               System.out.print(temp.data+" ");
               temp = temp.next;
            }  
            System.out.println();
        }
        
     
        /* Inserts a new Node at front of the list. */
        public void addToTheLast(Node node) 
        {
    
            if (head == null) 
            {
                head = node;
                tail = node;
            } else 
            {
                tail.next = node;
                tail = node;
            }
        }
        
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
             
            while(t>0)
            {
                int n = sc.nextInt();
                //int k = sc.nextInt();
                Is_LinkedList_Palindrom_shit llist = new Is_LinkedList_Palindrom_shit();
                //int n=Integer.parseInt(br.readLine());
                int a1=sc.nextInt();
                Node head= new Node(a1);
                Node tail = head;
                for (int i = 1; i < n; i++) 
                {
                    int a = sc.nextInt(); 
                    tail.next = new Node(a);
                    tail = tail.next;
                }
                
                Solution g = new Solution();
                if(g.isPalindrome(head) == true)
                    System.out.println(1);
                else
                    System.out.println(0);
                t--;
            }
            
        }
    }
    
    
    
    
    // } Driver Code Ends
    
    
    /* Structure of class Node is
    class Node
    {
        int data;
        Node next;
        
        Node(int d)
        {
            data = d;
            next = null;
        }
    }*/
    
    class Solution
    {
        Node middle(Node head){
            Node fast=head;
            Node slow=head;
            while (fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            System.out.println("middle value is "+ slow.data);
            return slow;//1
        }
        Node reverse(Node head){
            if (head==null || head.next==null){
                System.out.println("head of rev LL is "+head.data);
                return head;
            }
            Node r=reverse(head.next);
            head.next.next=head;
            head.next=head;
            System.out.println("head of rev LL is "+r.data);
            return r;
        }
        //Function to check whether the list is palindrome.
        boolean isPalindrome(Node head) 
        {
            // Step1- Find the middle Node
            // Step2- Reverse hald of the LL
            // Step3- Use 2 pointer
            if (head==null){
                return true;
            }
            Node curr=head;//2
            Node mid=middle(head);//1
            Node half_LL=reverse(mid);
            while (half_LL!=null){
                if (curr.data!=half_LL.data){
                    System.out.println("not a palindrom");
                    return false;
                }
                System.out.println("Move forward with pointers");
                curr=curr.next;
                half_LL=half_LL.next;
            }
            System.out.println("yes!, palindrom");
            return true;
        }    
    }
    
    
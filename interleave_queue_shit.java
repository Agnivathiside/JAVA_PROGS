import java.util.* ;
import java.util.LinkedList;
import java.io.*;

public class interleave_queue_shit {
    public static Queue<Integer> interLeaveQueue(Queue < Integer > q) {
        // Write your code here.
        //Queue<Integer> q1;
        System.out.println("Actual Queue size is "+q.size());
        Queue<Integer> q1= new LinkedList<>();
        for (int i=0;i<5;i++){
            int poll=q.poll();
            q1.offer(poll);
            System.out.println(i);
            System.out.println("Polled element is "+poll);
        }
        System.out.println(q1);
        while (!q1.isEmpty()){
            q.offer(q1.poll());
            int val=q.poll();
            q.offer(val);
        }
        return q;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<10;i++){
            //System.out.println("Enter the number: ");
            q.offer(sc.nextInt());
        }
        System.out.println(interLeaveQueue(q));
        sc.close();
    }
}
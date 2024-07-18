import java.util.*;
public class temp_shit {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int arr[]={10,21,34,100,90,51,1,45};
        for (int i=0;i<arr.length;i++){
          pq.add(arr[i]);
        }
        System.out.print(pq);
      }
}

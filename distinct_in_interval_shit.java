import java.util.*;
// import java.util.Set;
public class distinct_in_interval_shit {
    public static void main(String[] args){
        Scanner SC= new Scanner(System.in);
        System.out.print("Enter the interval: ");
        int a =SC.nextInt();
        int low=0,count=0;
        int high=a-1;
        int[] arr={1,2,2,1,3,1,1,3};
        HashSet<Integer> s = new HashSet<>();
        for(int i=low;i<=high;i++){
            s.add(arr[i]);
            count++;
            if (count==a){
                low++;
                high++;
                System.out.print(s.size());
                s.clear();
            }
        }
        SC.close();
    }
}

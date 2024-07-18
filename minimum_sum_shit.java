import java.util.Arrays;

public class minimum_sum_shit {
    public static long minSum(int arr[], int n)
    {
        // Your code goes here
        Arrays.sort(arr);
        long a=0;
        long b=0;
        int i=0;
        System.out.println(arr);
        for (int x=0;x<arr.length;x++){
            System.out.print(arr[x]+" ");
        }
        while(i<n){
            a=a*10+arr[i++]; // apending digit 
            System.out.println("\n");
            System.out.println("Value of a is "+a);
            if (i<n){
                b=b*10+arr[i++];
                System.out.println("Value of b is "+b);
            }

        }
        return a+b;
    }
    public static void main(String[] args){
        int[] arr={9,8,1,5,6};
        int n=arr.length;
        minSum(arr, n);
    }
}

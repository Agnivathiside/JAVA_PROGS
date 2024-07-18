public class count_2_sum_pair_shit {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7};
        int sum=8;
        int start=0;
        int end=arr.length-1;
        int count=0;

        while (end>start){
            if(arr[start]+arr[end]==sum){
                System.out.println("count increased");
                count+=1;
                start++;
                end--;
            }else if (arr[start]+arr[end]>sum){
                System.out.println("end is 1 less");
                end--;
            }else {
                System.out.println("start is 1 more");
                start++;
            }
        }
        System.out.println("count is "+count);
    }
}

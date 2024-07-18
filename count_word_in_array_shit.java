import java.util.Arrays;
import java.util.*;
public class count_word_in_array_shit {
    public static int count_word_in_array( String arr[] ,String word){
        //System.out.println(arr.length);
        if (arr.length==0){
            return 0;
        }
        if (arr[0].equals(word)){//arr[0]==word--> this thing didn't work. WHY?
            return 1+count_word_in_array(Arrays.copyOfRange(arr, 1, arr.length), word);
        }else{
            return count_word_in_array(Arrays.copyOfRange(arr, 1, arr.length), word);
        }

    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("how many words?: ");
        int a =SC.nextInt();
        String[] arr=new String[a];
        for (int i=0;i<a;i++){
            arr[i]=SC.next();
        }
        System.out.println("Word you want to count: ");
        String word= SC.next();
        System.out.println(count_word_in_array(arr, word));

        SC.close();
    }
    
}

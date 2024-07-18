import java.util.*;
import java.util.Arrays;
public class print_sorted_string_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str=SC.nextLine();
        char charArray[]=str.toLowerCase().toCharArray();
        Arrays.sort(charArray);
        System.out.println(new String(charArray));
        SC.close();
    }
}

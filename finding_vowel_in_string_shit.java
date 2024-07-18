import java.util.*;
import java.util.Arrays;
public class finding_vowel_in_string_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        String arr[]={"a","e","i","o","u"};
        System.out.println("Enter the string idiot: ");
        String str=SC.next();
        List<String> l1 = new ArrayList<String>();
        for (int i=0;i<str.toLowerCase().length();i++){//BUT STILL .toLowerCase() isn't working
            String s=Character.toString(str.charAt(i));
            if(Arrays.asList(arr).contains(s)==true){
                l1.add(s);
            } 
        }
        System.out.println(l1);
        SC.close();


    }
}

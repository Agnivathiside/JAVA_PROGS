//SOMETHING IS WRONG ! , DOESN'T WORK FOR "AAGGAA" !! 
import java.util.*;
public class palindrome_string_shit_rec {
    public static String check_palindrome(String str){
        if (str.length()==1){
            return "Palindrome";
        }else if (str.charAt(0)==str.charAt(str.length()-1)){
            str=(String) str.subSequence(1, str.length()-1);
            return check_palindrome(str);
        }
        return "Not palindromic";
    }
    public static void main(String[] args){
        Scanner SC= new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str= SC.nextLine();
        System.out.println(check_palindrome(str));
        SC.close();
    }
}

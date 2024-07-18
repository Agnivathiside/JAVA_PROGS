import java.util.*;
public class check_palindrom_rec_shit {
    public static boolean check_palindrom(String word){
        if (word.length()<=1){
            return true;
        }
        if (word.charAt(0)==word.charAt(word.length()-1)){//tried to write this with substring first but :((
            return check_palindrom(word.substring(1,word.length()-1));
        }else{
            return false;
        }
        
    }
    public static void main(String[] args){
        Scanner SC= new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str=SC.next();
        System.out.println(check_palindrom(str));
        SC.close();

    }
    
}

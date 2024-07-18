// (1) It should have at least 8 and at most 32 characters

// (2) It should start with an uppercase or lowercase letter

// (3) It should not have any of these characters: / \ = ' "

// (4) It should not have spaces
import java.util.*;
public class password_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the PASSWORD: ");
        String password=SC.next();
        if (8<=password.length() && password.length()<=32){
            if (('a'<=password.charAt(0) && password.charAt(0)<='z') &&('A'<=password.charAt(0) && password.charAt(0)<='Z') ){
                if ((password.contains("/")==false && password.contains("\\")==false && password.contains("=")==false && password.contains("''")==false && password.contains(" ") && password.contains("s")) ){
                    System.out.println("karde bhencho approve karde !!, agar double quote bhi hai to bhi karde ");
                }
            }
        }
        SC.close();
    }
}

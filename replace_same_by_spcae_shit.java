import java.util.*;
public class replace_same_by_spcae_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter First String: ");
        String str1=SC.nextLine();
        System.out.println("Enter Second String: ");
        String str2=SC.nextLine();
        for (int i=0;i<str1.length();i++){
            Character cha=str1.charAt(i);
            String str3=Character.toString(cha);
            str2=str2.replace(str3, "");
        }
        System.out.println(str2);
        SC.close();
    }
    
}

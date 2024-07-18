import java.util.*;
public class string_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        // System.out.println("Enter a sentence");
        // String sen=SC.nextLine();
        // System.out.println("here is what you have written-->"+sen);
        // System.out.println("here is the length of your string-->"+sen.length());
        // System.out.println("here are the characters in the sentence-->");
        // for(int i=0;i<sen.length();i++){
        //     System.out.println(sen.charAt(i));
        // }
        // String name1="sgniva";
        // String name2="agniva";
        // if (name1.compareTo(name2)<0){
        //     System.out.println(true);
        // }else{
        //     System.out.println(false);
        // }
        //System.out.println(name2.compareTo(name1));
        //System.out.println("Enter a shitty string: ");
        String my_str="abcdefghijklmnopqrstuvwxyz";
        // System.out.println("FULL SENTENCE IN STYLE-->");
        // System.out.println(my_str.substring(0,my_str.length()));
        // System.out.println("10TH CHAR IN STYLE-->");
        // System.out.println(my_str.charAt(10));
        // System.out.println("LAST CHAR IN STYLE-->");
        // System.out.println(my_str.charAt(my_str.length()-1));
        //  String str = "123";
        //  int number = Integer.parseInt(str);
        //  System.out.println(number);
        // int number = 123;
        // String str = Integer.toString(number);
        // System.out.println(str+str.length());
        System.out.println(my_str.substring(0,1));
        System.out.println(my_str.substring(my_str.length()-1, my_str.length()));


        SC.close();
    }
}

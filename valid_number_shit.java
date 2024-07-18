// Accept a phone number as input. A valid phone number should satisfy the following constraints.

// (1) The number should start with one of these digits: 6, 7, 8, 9

// (2) The number should be exactly 10 digits long.

// (3) No digit should appear more than 7 times in the number.

// (4) No digit should appear more than 5 times in a row in the number.

// If the fourth condition is not very clear, then consider this example: 

// the number 9888888765 is invalid because the digit 8 appears more than 5 times in a row.

// Print the string valid if the phone number is valid. If not, print the string invalid.
import java.util.*;
public class valid_number_shit {
    public static int count_char_in_string(String num ,Character ch){
        int count=0;
        for (int i=0;i<num.length();i++){
            if(ch==num.charAt(i)){
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the damn phone number: ");
        String num=SC.next();
        Boolean flag =true;
        if (num.length()==10 && (num.charAt(0)==6 || num.charAt(0)==7 || num.charAt(0)==8 || num.charAt(0)==9 )){
            //Boolean flag =true;
            for (int i=0;i<num.length();i++){
                int counter=count_char_in_string(num, num.charAt(i));
                if (counter<7){
                    continue;
                }else{
                    flag =false;
                    break;
                }
            }
            //string shouldn't contain 00000 || 11111*(1,2,3,4,5,6,7,8,9)
            if(num.contains("00000")==false){
                for (int x=0;x<10;x++){
                    int a=11111*x;
                    String s=Integer.toString(a);
                    if (num.contains(s)==false){
                        continue;
                    }else{
                        flag=false;
                        break;
                    }
                }
            }else{
                flag=false;
            }
        }else{
            flag=false;
        }
        if (flag == true){
            System.out.println("Vlid bhencho");
        }else{
            System.out.println("chal bhencho nikal, invalid");
        }
        SC.close();

    }
}

//Accept a sequence of words as input. 
//Create a dictionary named freq whose keys are the distinct words in the sequence. 
//The value corresponding to a key (word) should be the 
//frequency of occurrence of the key (word) in the sequence.
import java.util.*;
public class in_dic_or_not_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the words with comma in between: ");
        String str=SC.next();
        String[] str_arr=new String[10];
        str_arr=str.split(",");
        Map<String,Integer> dic=new HashMap<>();
        for (String word:str_arr){
            if (dic.containsKey(word)==false){
                dic.put(word, 1);
            }else if (dic.containsKey(word)==true){
                int a=dic.get(word);
                a++;
                dic.put(word, a);
            }
        }
        System.out.println(dic);
        SC.close();
    }
}

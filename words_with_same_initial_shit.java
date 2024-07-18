//Accept a sequence of words as input. 
//Create a dictionary named real_dict whose keys are the letters of the English alphabet. 
//For each key (letter), the corresponding value should be a list of words 
//that begin with this key (letter). 
//For any given key, the words should be appended to the 
//corresponding list in the order in which they appear in the sequence. 
//You can assume that all words of the sequence will be in lower case.
import java.util.*;
public class words_with_same_initial_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the words with comma in between: ");
        String str=SC.nextLine();
        String[] str_arr=new String[10];
        str_arr=str.split(",");
        Map<Character,Set<String>> real_dict=new HashMap<>();
        for (int i=0;i<str_arr.length;i++){
            if (real_dict.containsKey(str_arr[i].charAt(0))==false){
                Set<String> str_set =new HashSet<>();
                str_set.add(str_arr[i]);
                real_dict.put(str_arr[i].charAt(0), str_set);
            }else if(real_dict.containsKey(str_arr[i].charAt(0))==true){
                real_dict.get(str_arr[i].charAt(0)).add(str_arr[i]);
            }
        }
        System.out.println(real_dict);
        SC.close();
    }
}

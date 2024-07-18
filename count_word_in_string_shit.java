import java.util.HashMap;
//import java.util.Map;
import java.util.*;
public class count_word_in_string_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("DAO BARA STRING DAO... COMMA DIYE LIKHBE: ");
        String str =SC.next();
        String[] str_split=str.split(",");
        HashMap<String, Integer> M=new HashMap<String, Integer>();
        for (int i=0;i<str_split.length;i++){
            Boolean flag=M.containsKey(str_split[i]);
            if (flag==false){
                M.put(str_split[i], 1);

            }else{
                int a=M.get(str_split[i]);
                a=a+1;
                M.put(str_split[i], a);  
            }
        }
        System.out.println(M);
        SC.close();
    }
    
}

import java.util.*;
public class biggest_word_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        List<String> l_word=new ArrayList<String>();
        System.out.println("Start entering wrods, When you are done hit -->('.') : ");
        String word=SC.next();
        while(word!="."){//WHY THE FUCK WHILE LOOP CONDITION ISN'T WORKING!!!!!
             if(word.equals(".")){
                 break;
             }
            l_word.add(word);
            word=SC.next();
        }
        String big_word=l_word.get(0);
        for (int i=0;i<l_word.size();i++){
            if(l_word.get(i).length()>=big_word.length()){
                big_word=l_word.get(i);
            }
        }
        System.out.println("Here is our big boy: "+big_word);
        SC.close();

    }
}

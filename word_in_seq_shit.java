//In the first line of input, accept a sequence of space-separated words. 
//In the second line of input, accept a single word. 
//If this word is not present in the sequence, print NO. 
//If this word is present in the sequence, 
//then print YES and in the next line of the output, 
//print the number of times the word appears in the sequence.
import java.util.*;
public class word_in_seq_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the words with comman in between");
        //i'm JUST NOT USING SPACE FOR SOME WIERD PROB FACED BY JAVA
        String words=SC.nextLine();
        System.out.println("Enter the word");
        String word=SC.next();
        String[] words_arr = new String[10];
        words_arr=words.split(",");
        List<String> word_list=new ArrayList<>(Arrays.asList(words_arr));
        if (word_list.contains(word)==true){
            System.out.println("YES");
            int count =0;
            for (int i=0;i<word_list.size();i++){
                if (words_arr[i].equals(word)==true){
                    count = count +1;
                }else{
                    continue;
                }
            }
            System.out.println(count);
            
        }else if(word_list.contains(word)==false){
            System.out.println("NO");
        }
        SC.close();

    }
    
}

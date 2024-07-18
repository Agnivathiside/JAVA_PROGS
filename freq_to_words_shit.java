//Write a function named freq_to_words that accepts a list of words as argument. 
//It should return a dictionary which has the following structure:
//['a', 'random', 'collection', 'a', 'another', 'a', 'random']-->{1: ['another', 'collection'], 2: ['random'], 3: ['a']}
//['one', 'two', 'three', 'one']-->{1: ['three', 'two'], 2: ['one']}
import java.util.*;
public class freq_to_words_shit {
    public static Integer count(String[] arr, String word){
        int count=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i].equals(word)){
                count+=1;
            }
        }
        return count;
    }
    public static Map<Integer,Set<String>> freq_to_word(String[] arr){
        Map<Integer,Set<String>> dic = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if (dic.containsKey(count(arr, arr[i]))==false){
                Set<String> word_set=new HashSet<>();
                word_set.add(arr[i]);
                dic.put(count(arr, arr[i]), word_set);
            }else if(dic.containsKey(count(arr, arr[i]))==true){
                if(dic.get(count(arr, arr[i])).contains(arr[i])==false){
                    dic.get(count(arr, arr[i])).add(arr[i]);
                }else{
                    continue;
                }
            }
        }
        return dic;
    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.print("How many words: ");
        int a=SC.nextInt();
        String[] word_list=new String[a];
        System.out.println("Enter the words with comma in between: ");
        String str=SC.next();
        word_list=str.split(",");
        System.out.println(word_list);
        System.out.println(freq_to_word(word_list));
        SC.close();        
    }
}

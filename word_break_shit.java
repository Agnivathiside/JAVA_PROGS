import java.util.*;

public class word_break_shit {
    public static boolean solve(String word, List<String> dict, String str){
        System.out.println("Now string is "+str);
        if (str.contains(word)) return true;
        if (str.length()>word.length()) return false;

        for (int i=0; i<dict.size();i++){
            str=str+dict.get(i);
            boolean found = solve(word, dict, str);

            if (found) return true;
            else if(i==dict.size()-1){
                str=str.replace(dict.get(i), "");
                System.out.println("after replacing string is "+str);
            }
        }
        return false;
    }
    public static boolean wordBreak(String word, List<String> dict){
        String str = "";
        boolean ans = solve(word, dict, str);
        return ans;
    }
    public static void main(String[] args){
        List<String> dict = new ArrayList<>();
        // dict.add("apple");
        // dict.add("bal");

        // dict.add("cats");
        // dict.add("dog");
        // dict.add("sand");
        // dict.add("and");
        // dict.add("cat");

        // dict.add("a");
        // dict.add("abc");
        // dict.add("b");
        // dict.add("cd");

        dict.add("a");
        dict.add("b");
        dict.add("c");

        // ["a", "abc", "b", "cd"]

        // String s = "applepenapple";
        // String s = "catsandog";
        // String s= "abcd";
        String s = "ac";

        boolean ans = wordBreak(s, dict);
        System.out.println(ans);
    }
    
}

import java.util.ArrayList;
import java.util.List;

public class palindrome_partioning_shit {
    public boolean isPalin(String s, int i, int j){
        while(j>i){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void solve(String s, int index, List<String> temp, List<List<String>> res){
        if (index>=s.length()){
            res.add(temp);
        }

        for (int i=index; i<s.length(); i++){
            if (isPalin(s, index, i)){
                temp.add(s.substring(index, i+1));
                solve(s, index+1, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    } 
    public List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();
        List<List<String>>res = new ArrayList<>();
        solve(s, 0, temp, res);
        return res;
    }
}

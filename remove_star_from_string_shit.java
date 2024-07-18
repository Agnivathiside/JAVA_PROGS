import java.util.Stack;
// leet**cod*e ==> lecoe
public class remove_star_from_string_shit {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        String output="";
        st.add(s.charAt(0));

        for (int i=1; i<s.length(); i++){
            if (s.charAt(i)=='*'){
                st.pop();
            }else{
                st.add(s.charAt(i));
            }
        }

        while (!st.isEmpty()){
            output = st.pop() + output;
        }
        return output;
    }
}

import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class redundent_bracket_shit {
    public static int count_pair_bracket(String str) {
        // the raw string of brackets is taken as argument
        return str.length() / 2;
    }

    public static int count_expression(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                count++;
            }
        }
        return count;
    }

    public static boolean is_matching(Character a, Character b) {
        if (a == '(' && b == ')') {
            return true;
        } else if (a == '{' && b == '}') {
            return true;
        } else if (a == '[' && b == ']') {
            return true;
        }
        return false;
    }

    public static boolean valid_brackets(String str) {
        Stack<Character> st = new Stack<>();
        int str_len = str.length();
        if (str_len % 2 != 0)
            return false;
        for (int i = 0; i < str_len; i++) {
            if (st.empty()) {
                st.push(str.charAt(i));
            } else if (!st.empty() && is_matching(st.peek(), str.charAt(i))) {
                st.pop();
            } else {
                st.push(str.charAt(i));
            }
        }
        if (!st.empty())
            return false;
        return true;
    }

    public static String extract_bracket_sequence(String str) {
        String output = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '{' || str.charAt(i) == '}'
                    || str.charAt(i) == '[' || str.charAt(i) == ']') {
                output = output + String.valueOf(str.charAt(i));
            }
        }
        return output;
    }

    public static boolean findRedundantBrackets(String s) {
        String s_brackets = extract_bracket_sequence(s);
        // System.out.println(s_brackets);
        // return true;

        /* NOW WE'LL HAVE TO CHECK FOR VALID PAIR OF BRACKETS */
        boolean valid_brac = valid_brackets(s_brackets);
        if (!valid_brac)
            return false;

        /* NOW IF THE BRACKET SEQUENCE IS VALID */
        // count for expression and
        // count for bracket pairs (as the sequence is valid)
        int count_exp = count_expression(s);
        int count_pair_brac = count_pair_bracket(s_brackets);

        if (count_pair_brac > count_exp)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string of Expression: ");
        String exp = sc.next();

        // Steps - First make a string with only brackets only
        // check if brackets are valid
        // if check_bracket is valid then count the pair of brackets
        // of pair_count is >= expression_count then redundent bracket is present

        boolean is_alright = findRedundantBrackets(exp);
        if (is_alright) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
        sc.close();
    }
}

class Solution {

    public static int checkRedundancy(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ')')
            {
                if (st.peek() == '('){
                    return 1;
                }else{
                    int k = 0;
                    while (st.peek() != '('){

                        k++;

                        st.pop();

                    }

                    if (k == 1)

                    {

                        return 1;

                    }

                    st.pop();

                }

            }

            else

            {

                st.push(s.charAt(i));

            }

        }

        return 0;

    }

}
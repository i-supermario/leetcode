import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i<s.length()){
            char curr = s.charAt(i);
            if(curr=='('){
                st.push(')');
            }
            else if(curr=='['){
                st.push(']');
            }
            else if(curr=='{'){
                st.push('}');
            }
            else if(!st.isEmpty()){
                if(curr!=st.pop()) return false;
            }
            else return false;
            i++;
        }

        return st.isEmpty();
    }
}
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st =new Stack<>();
        for(char c : s.toCharArray()){
            if((st.size() != 0)&&((c == '}' && st.peek() == '{')||(c == ']' && st.peek() == '[')||(c == ')' && st.peek() == '('))){
                st.pop();
            }else{
                st.push(c);
            }
        }
        if(st.size()==0){
            return true ;
        }else{
            return false;
        }
    }
}

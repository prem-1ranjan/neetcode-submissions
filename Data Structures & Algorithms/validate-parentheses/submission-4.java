// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> st =new Stack<>();
//         for(char c : s.toCharArray()){
//             if((st.size() != 0)&&((c == '}' && st.peek() == '{')||(c == ']' && st.peek() == '[')||(c == ')' && st.peek() == '('))){
//                 st.pop();
//             }else{
//                 st.push(c);
//             }
//         }
//         if(st.size()==0){
//             return true ;
//         }else{
//             return false;
//         }
//     }
// }


class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(')');
            } else if (c == '{') {
                st.push('}');
            } else if (c == '[') {
                st.push(']');
            } 
            // Agar koi closing bracket aaya, toh stack khali nahi hona chahiye 
            // aur stack ka top element current character se match hona chahiye
            else if (st.isEmpty() || st.pop() != c) {
                return false;
            }
        }
        
        return st.isEmpty();
    }
}
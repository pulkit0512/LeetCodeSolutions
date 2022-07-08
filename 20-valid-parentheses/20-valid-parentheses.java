class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(st.isEmpty()){
                if(ch=='(' || ch=='{' || ch=='['){
                    st.push(ch);
                }else{
                    return false;
                }
            }else if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else if(ch==')'){
                if(st.peek()=='('){
                    st.pop();
                }else{
                    return false;
                }
            }else if(ch=='}'){
                if(st.peek()=='{'){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                if(st.peek()=='['){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
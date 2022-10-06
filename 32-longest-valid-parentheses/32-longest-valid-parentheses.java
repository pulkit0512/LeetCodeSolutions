class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int len = s.length();
        
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else{
                if(st.peek()==-1 || s.charAt(st.peek())==')'){
                    st.push(i);
                }else{
                    st.pop();
                    ans = Math.max(ans, i-st.peek());
                }
            }
        }
        
        return ans;
    }
}
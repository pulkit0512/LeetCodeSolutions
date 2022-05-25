class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int len = s.length();
        st.push(-1);
        int ans = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch=='('){
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
class Solution {
    public int calculate(String s) {
        return calculateUsing1Stack(s);
    }
    
    private int calculateUsing1Stack(String s) {
        s = "(" + s + ")";
        Stack<Integer> st = new Stack<>();
        int len = s.length();
        int val = 0;
        int sign = 1;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch=='('){
                if(sign==-1){
                    st.push(Integer.MIN_VALUE);
                }else{
                    st.push(Integer.MAX_VALUE);
                }
                sign = 1;
            }else if(ch==' '){
                continue;
            }else if(ch=='+' || ch=='-'){
                if(val!=0){
                    st.push(val*sign);
                }
                sign = (ch=='+')?1:-1;
                val = 0;
            }else if(ch==')'){
                val = val*sign;
                while(st.peek()!=Integer.MIN_VALUE && st.peek()!=Integer.MAX_VALUE) {
                    val += st.pop();
                }
                int top = st.pop();
                if(top==Integer.MIN_VALUE){
                    st.push(-val);
                }else{
                    st.push(val);
                }
                val = 0;
                sign = 1;
            }else{
                val = val*10 + (ch-'0');
            }
        }
        return st.pop();
    }
}
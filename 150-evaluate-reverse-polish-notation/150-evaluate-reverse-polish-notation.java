class Solution {
    final String plus = "+";
    final String minus = "-";
    final String mul = "*";
    final String div = "/";
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            int tokenType = getTokenType(tokens[i]);
            if(tokenType==0){
                st.push(Integer.valueOf(tokens[i]));
            }else{
                int b = st.pop();
                int a = st.pop();
                if(tokenType==1){
                    a += b;
                }else if(tokenType==2){
                    a -= b;
                }else if(tokenType==3){
                    a *= b;
                }else{
                    a /= b;
                }
                st.push(a);
            }
        }
        return st.pop();
    }
    
    private int getTokenType(String s){
        if(s.equals(plus)){
            return 1;
        }else if(s.equals(minus)){
            return 2;
        }else if(s.equals(mul)){
            return 3;
        }else if(s.equals(div)){
            return 4;
        }else{
            return 0;
        }
    }
}
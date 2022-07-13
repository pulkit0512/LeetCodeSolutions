class Solution {
    final String plus = "+";
    final String minus = "-";
    final String mul = "*";
    final String div = "/";
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<String> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty() || isOperation(tokens[i])){
                st.push(tokens[i]);
            }else if(isOperation(st.peek())){
                st.push(tokens[i]);
            }else{
                int a = Integer.valueOf(tokens[i]);
                while(!st.isEmpty() && !isOperation(st.peek())){
                    int b = Integer.valueOf(st.pop());
                    String opr = st.pop();
                    if(opr.equals(plus)){
                        a += b;
                    }else if(opr.equals(minus)){
                        a -= b;
                    }else if(opr.equals(mul)){
                        a *= b;
                    }else{
                        a /= b;
                    }
                }
                st.push(String.valueOf(a));
            }
        }
        return Integer.valueOf(st.pop());
    }
    
    private boolean isOperation(String s){
        return s.equals(plus) || s.equals(minus) || s.equals(mul) || s.equals(div);
    }
}
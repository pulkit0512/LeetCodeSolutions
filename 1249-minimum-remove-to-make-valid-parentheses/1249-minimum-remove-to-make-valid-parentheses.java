class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<len;i++){
            if(s.charAt(i)==')'){
                if(st.isEmpty()){
                    continue;
                }else{
                    st.pop();
                    sb.append(s.charAt(i));
                }
            }else if(s.charAt(i)=='('){
                st.push('(');
                sb.append(s.charAt(i));
            }else{
                sb.append(s.charAt(i));
            }
        }
        st = new Stack<>();
        len = sb.length();
        StringBuilder sb1 = new StringBuilder();
        for(int i=len-1;i>=0;i--){
            if(sb.charAt(i)=='('){
                if(st.isEmpty()){
                    continue;
                }else{
                    st.pop();
                    sb1.append('(');
                }
            }else if(sb.charAt(i)==')'){
                st.push(')');
                sb1.append(')');
            }else{
                sb1.append(sb.charAt(i));
            }
        }
        return sb1.reverse().toString();
    }
}
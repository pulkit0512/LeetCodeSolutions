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
        if(st.isEmpty()){
            return sb.toString();
        }
        StringBuilder ans = new StringBuilder();
        int open = st.size();
        len = sb.length();
        for(int i=len-1;i>=0;i--){
            if(sb.charAt(i)=='(' && open>0){
                open--;
            }else{
                ans.append(sb.charAt(i));
            }
        }
        return ans.reverse().toString();
    }
}
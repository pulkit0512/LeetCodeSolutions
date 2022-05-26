class Solution {
    public String decodeString(String s) {
        s = s+"]";
        Stack<Object> st = new Stack<>();
        char open = '[';
        st.push(1);
        st.push(open);
        int len = s.length();
        int val = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            //System.out.println(st);
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                val = val*10 + (ch-'0');
                if(!sb.isEmpty()){
                    st.push(sb.toString());
                    sb = new StringBuilder();
                }
            }else if(ch=='['){
                st.push(val);
                st.push(open);
                val = 0;
            }else if(ch==']'){
                String temp = sb.toString();
                if(!sb.isEmpty()){
                    sb = new StringBuilder();
                }
                if(!(st.peek() instanceof Character)){
                    temp = st.pop() + temp;
                }
                st.pop();
                int times = (int)st.pop();
                for(int j=0;j<times;j++){
                    sb.append(temp);
                }
                temp = sb.toString();
                while(!st.isEmpty() && !(st.peek() instanceof Character)){
                    temp = st.pop()+temp;
                }
                st.push(temp);
                sb = new StringBuilder();
            }else{
                sb.append(ch);
            }
        }
        return (String)st.pop();
    }
}
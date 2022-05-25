class Solution {
    public int calculate(String s) {
        //return calculateUsingTwoStacks(s);
        return calculateUsingOneStack(s);
    }
    private int calculateUsingOneStack(String s) {
        s = "("+s+")";
        int len = s.length();
        int result = 0, sign = 1;
        int current = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
            }else if(ch=='+'){
                result += current*sign;
                sign = 1;
                current = 0;
            }else if(ch=='-'){
                result += current*sign;
                sign = -1;
                current = 0;
            }else if(ch ==' '){
                continue;
            }else if(Character.isDigit(ch)){
                current = current*10 + (ch-'0');
            }else{
                result += current*sign;
                result *= st.pop();
                result += st.pop();
                current = 0;
            }
        }
        return result;
    }
    
    private int calculateUsingTwoStacks(String s) {
        s = "("+s+")";
        int len = s.length();
        Stack<Integer> values = new Stack<>();
        Stack<Character> opr = new Stack<>();
        int val = 0;
        for(int i=0;i<len;i++){
            //System.out.println(values+" "+opr);
            char ch = s.charAt(i);
            if(ch=='('){
                opr.push(ch);
            }else if(Character.isDigit(ch)){
                val = val*10 + (ch-'0');
            }else if(ch==' '){
                continue;
            }else if(ch=='+' || ch=='-'){
                if(opr.peek()=='-'){
                    values.push(-val);
                }else{
                    values.push(val);
                }
                opr.push(ch);
                val = 0;
            }else{
                val = (opr.peek()=='-')?-val:val;
                while(opr.peek()!='('){
                    val += values.pop();
                    opr.pop();
                }
                opr.pop();
            }
        }
        
        return val;
    }
}
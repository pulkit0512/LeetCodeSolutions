class Solution {
    public int calculate(String s) {
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
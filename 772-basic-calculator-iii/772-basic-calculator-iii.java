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
            }else if(ch==')'){
                val = performOperation(values, opr, val);
                while(opr.peek()!='('){
                    val += values.pop();
                    opr.pop();
                }
                opr.pop();
            }else{
                val = performOperation(values, opr, val);
                values.push(val);
                val = 0;
                opr.push(ch);
            }
        }
        return val;
    }
    private int performOperation(Stack<Integer> values, Stack<Character> opr, int val) {
        if(opr.peek()=='-'){
            val = -val;
        }else if(opr.peek()=='*'){
            val = values.pop()*val;
            opr.pop();
        }else if(opr.peek()=='/'){
            val = values.pop()/val;
            opr.pop();
        }
        return val;
    }
}
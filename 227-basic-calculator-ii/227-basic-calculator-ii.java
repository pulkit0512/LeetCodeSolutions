class Solution {
    public int calculate(String s) {
        //return calculateUsingStack(s);
        return calculateUsingConstantSpace(s);
    }
    private int calculateUsingConstantSpace(String s) {
        int len = s.length();
        int current = 0, last = 0;
        int result = 0;
        char lastOpr = '+';
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                current = current*10 + (ch-'0');
            }
            if((!Character.isDigit(ch) && ch!=' ') || i==len-1){
                //System.out.println(last+" "+current+" "+lastOpr+" "+ch);
                if(lastOpr == '+' || lastOpr== '-'){
                    result += last;
                    last = (lastOpr=='+'?current:-current);
                }else if(lastOpr == '*'){
                    last = last*current;
                }else{
                    last = last/current;
                }
                current = 0;
                lastOpr = ch;
            }
        }
        result += last;
        return result;
    }
    private int calculateUsingStack(String s) {
        int len = s.length();
        Stack<Integer> values = new Stack<>();
        char opr = '+';
        int val = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch==' '){
                continue;
            }
            if(Character.isDigit(ch)){
                while(i<len && Character.isDigit(s.charAt(i))){
                    val = val*10 + s.charAt(i)-'0';
                    i++;
                }
                i--;
            }else{
                performOperation(values, opr, val);
                opr = ch;
                val = 0;
            }
        }
        if(val!=0){
            performOperation(values, opr, val);
        }
        int result = 0;
        while(!values.isEmpty()){
            result += values.pop();
        }
        return result;
    }
    private void performOperation(Stack<Integer> values, char opr, int val) {
        if(opr == '+'){
            values.push(val);
        }else if(opr == '-'){
            values.push(-val);
        }else if(opr == '*'){
            values.push(values.pop()*val);
        }else{
            values.push(values.pop()/val);
        }
    }
}
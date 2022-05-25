class Solution {
    public int calculate(String s) {
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
                if(opr == '+'){
                    values.push(val);
                }else if(opr == '-'){
                    values.push(-val);
                }else if(opr == '*'){
                    values.push(values.pop()*val);
                }else{
                    values.push(values.pop()/val);
                }
                opr = ch;
                val = 0;
            }
        }
        if(val!=0){
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
        int result = 0;
        while(!values.isEmpty()){
            result += values.pop();
        }
        return result;
    }
}
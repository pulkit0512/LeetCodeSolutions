class Solution {
    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> values = new Stack<>();
        char opr = ' ';
        for(int i=0;i<len;){
            char ch = s.charAt(i);
            if(ch==' '){
                i++;
                continue;
            }
            if(Character.isDigit(ch)){
                int val = 0;
                while(i<len && Character.isDigit(s.charAt(i))){
                    val = val*10 + s.charAt(i)-'0';
                    i++;
                }
                values.push(val);
            }else{
                if(ch=='*' || ch=='/'){
                    int val1 = values.pop();
                    i++;
                    while(s.charAt(i)==' '){
                        i++;
                    }
                    int val2 = 0;
                    while(i<len && Character.isDigit(s.charAt(i))){
                        val2 = val2*10 + s.charAt(i)-'0';
                        i++;
                    }
                    if(ch=='*'){
                        values.push(val1*val2);
                    }else{
                        values.push(val1/val2);
                    }
                }else if(ch=='+' || ch=='-'){
                    if(opr==' '){
                        opr = ch;
                    }else{
                        int val2 = values.pop();
                        int val1 = values.pop();
                        if(opr=='+'){
                            values.push(val1+val2);
                        }else{
                            values.push(val1-val2);
                        }
                        opr = ch;
                    }
                    i++;
                }
            }
        }
        if(opr!=' '){
            int val2 = values.pop();
            int val1 = values.pop();
            if(opr=='+'){
                values.push(val1+val2);
            }else{
                values.push(val1-val2);
            }
        }
        return values.pop();
    }
}
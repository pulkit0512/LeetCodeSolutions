class Solution {
    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> values = new Stack<>();
        Stack<Character> opr = new Stack<>();
        for(int i=0;i<len;){
            char ch = s.charAt(i);
            if(ch==' '){
                i++;
                continue;
            }
            if(Character.isDigit(ch)){
                int val = 0;
                while(i<len && Character.isDigit(s.charAt(i))){
                    val = val*10 + (int)(s.charAt(i)-'0');
                    i++;
                }
                values.push(val);
            }else{
                //System.out.println(values);
                if(ch=='*' || ch=='/'){
                    int val1 = values.pop();
                    i++;
                    while(s.charAt(i)==' '){
                        i++;
                    }
                    int val2 = 0;
                    while(i<len && Character.isDigit(s.charAt(i))){
                        val2 = val2*10 + (int)(s.charAt(i)-'0');
                        i++;
                    }
                    if(ch=='*'){
                        values.push(val1*val2);
                    }else{
                        values.push(val1/val2);
                    }
                }else if(ch=='+' || ch=='-'){
                    //System.out.println(i+" "+ch);
                    if(opr.isEmpty()){
                        opr.push(ch);
                    }else{
                        int val2 = values.pop();
                        int val1 = values.pop();
                        char curOpr = opr.pop();
                        if(curOpr=='+'){
                            values.push(val1+val2);
                        }else{
                            values.push(val1-val2);
                        }
                        opr.push(ch);
                    }
                    i++;
                }
            }
        }
        //System.out.println(opr);
        //System.out.println(values);
        while(!opr.isEmpty()){
            char ch = opr.pop();
            int val2 = values.pop();
            int val1 = values.pop();
            if(ch=='+'){
                values.push(val1+val2);
            }else{
                values.push(val1-val2);
            }
        }
        return values.pop();
    }
}
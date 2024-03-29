class Solution {
    public String multiply(String num1, String num2) {
        //return multiplyUsingMathsImplementation(num1, num2);
        return multiplyUsingProductFromDigitPairs(num1, num2);
    }
    
    private String multiplyUsingProductFromDigitPairs(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        
        StringBuilder first = new StringBuilder(num1);
        StringBuilder second = new StringBuilder(num2);
        first = first.reverse();
        second = second.reverse();
        
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<first.length() + second.length();i++){
            ans.append('0');
        }
        
        for(int i=0;i<second.length();i++){
            int d2 = second.charAt(i)-'0';
            for(int j=0;j<first.length();j++){
                int curPos = i+j;
                int d1 = first.charAt(j)-'0';
                int carry = ans.charAt(curPos)-'0';
                int mul = d1*d2 + carry;
                ans.setCharAt(curPos, (char)(mul%10+'0'));
                int next = (ans.charAt(curPos+1) - '0') + mul/10;
                ans.setCharAt(curPos+1, (char)(next+'0'));
            }
        }
        
        if(ans.charAt(ans.length()-1)=='0'){
            ans.deleteCharAt(ans.length()-1);
        }
        
        return ans.reverse().toString();
    }
    
    private String multiplyUsingMathsImplementation(String num1, String num2) {
        String ans = "";
        int len1 = num1.length();
        int len2 = num2.length();
        if(checkZero(num1, len1) || checkZero(num2, len2)){
            return "0";
        }
        for(int i=0;i<len1;i++){
            StringBuilder mulSoFar = new StringBuilder();
            int carry = 0;
            for(int j=0;j<i;j++){
                mulSoFar.append('0');
            }
            for(int j=len2-1;j>=0;j--){
                int val1 = num1.charAt(len1-1-i)-'0';
                int val2 = num2.charAt(j)-'0';
                int val = val1 * val2 + carry;
                //System.out.println(val+" "+val1+" "+val2+" "+carry);
                mulSoFar.append(val%10);
                carry = val/10;
            }
            if(carry!=0){
                mulSoFar.append(carry);
            }
            mulSoFar.reverse();
            //System.out.println(mulSoFar);
            ans = plus(ans, mulSoFar.toString());
        }
        return ans;
    }
    public String plus(String a, String b){
        int lenA = a.length();
        int lenB = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(lenA>0 && lenB>0){
            int val = (int)(a.charAt(lenA-1)-'0') + (int)(b.charAt(lenB-1)-'0') + carry;
            sb.append(val%10);
            carry = val/10;
            lenA--;
            lenB--;
        }
        while(lenA>0){
            int val = (int)(a.charAt(lenA-1)-'0') + carry;
            sb.append(val%10);
            carry = val/10;
            lenA--;
        }
        while(lenB>0){
            int val = (int)(b.charAt(lenB-1)-'0') + carry;
            sb.append(val%10);
            carry = val/10;
            lenB--;
        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    public boolean checkZero(String s, int len){
        for(int i=0;i<len;i++){
            if(s.charAt(i)!='0'){
                return false;
            }
        }
        return true;
    }
}
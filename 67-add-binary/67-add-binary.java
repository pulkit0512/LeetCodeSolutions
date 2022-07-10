class Solution {
    public String addBinary(String a, String b) {
        if (a == null && b == null) {
            return a;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int n = a.length();
        int m = b.length();
        int i = n-1, j = m-1;
        StringBuilder sb = new StringBuilder();
        char carry = '0';
        while(i>=0 && j>=0){
            if(a.charAt(i)=='1' && b.charAt(j)=='1'){
                if(carry=='0'){
                    sb.append('0');
                } else{
                    sb.append('1');
                }
                carry = '1';
            }else if(a.charAt(i)=='1' && b.charAt(j)=='0'){
                if(carry=='0'){
                    sb.append('1');
                } else{
                    sb.append('0');
                }
            }else if(a.charAt(i)=='0' && b.charAt(j)=='1'){
                if(carry=='0'){
                    sb.append('1');
                } else{
                    sb.append('0');
                }
            } else{
                if(carry=='0'){
                    sb.append('0');
                } else{
                    sb.append('1');
                }
                carry = '0';
            }
            i--;
            j--;
        }
        while(i>=0){
            if(a.charAt(i)=='1' && carry=='1'){
                sb.append('0');
            } else if(a.charAt(i)=='1' && carry=='0'){
                sb.append('1');
            } else if(a.charAt(i)=='0' && carry=='1'){
                sb.append('1');
                carry='0';
            } else{
                sb.append('0');
            }
            i--;
        }
        while(j>=0){
            if(b.charAt(j)=='1' && carry=='1'){
                sb.append('0');
            } else if(b.charAt(j)=='1' && carry=='0'){
                sb.append('1');
            } else if(b.charAt(j)=='0' && carry=='1'){
                sb.append('1');
                carry='0';
            } else{
                sb.append('0');
            }
            j--;
        }
        if(carry=='1'){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
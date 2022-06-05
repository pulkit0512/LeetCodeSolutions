class Solution {
    public int compress(char[] chars) {
        int prevCount = 1;
        char prevChar = chars[0];
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i=1;i<chars.length;i++){
            if(chars[i]==prevChar){
                prevCount++;
            }else{
                chars[idx++] = prevChar;
                //sb.append(prevChar);
                if(prevCount>1){
                    int st = idx;
                    while(prevCount>0){
                        chars[idx++] = (char)((prevCount%10)+'0');
                        prevCount /= 10;
                    }
                    int ed = idx-1;
                    reverse(chars, st, ed);
                }
                prevChar = chars[i];
                prevCount = 1;
            }
        }
        chars[idx++] = prevChar;
        if(prevCount>1){
            int st = idx;
            while(prevCount>0){
                chars[idx++] = (char)((prevCount%10)+'0');
                prevCount /= 10;
            }
            int ed = idx-1;
            reverse(chars, st, ed);
        }
        return idx;
    }
    
    private void reverse(char[] chars, int st, int ed) {
        while(st<ed){
            char temp = chars[st];
            chars[st] = chars[ed];
            chars[ed] = temp;
            st++;
            ed--;
        }
    }
}
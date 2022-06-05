class Solution {
    public int compress(char[] chars) {
        int prevCount = 1;
        char prevChar = chars[0];
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<chars.length;i++){
            if(chars[i]==prevChar){
                prevCount++;
            }else{
                sb.append(prevChar);
                if(prevCount>1){
                    sb.append(prevCount);
                }
                prevChar = chars[i];
                prevCount = 1;
            }
        }
        sb.append(prevChar);
        if(prevCount>1){
            sb.append(prevCount);
        }
        for(int i=0;i<sb.length();i++){
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}
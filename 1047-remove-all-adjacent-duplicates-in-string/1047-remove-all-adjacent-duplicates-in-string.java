class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i=0;i<len;i++){
            if(sb.length()==0 || sb.charAt(sb.length()-1)!=s.charAt(i)){
                sb.append(s.charAt(i));
            }else{
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
}
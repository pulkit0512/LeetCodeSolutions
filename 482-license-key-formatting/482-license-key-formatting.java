class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int cnt = k;
        for(int i=len-1;i>=0;i--){
            if(cnt==0){
                sb.append('-');
                cnt = k;
            }
            if(s.charAt(i)!='-'){
                sb.append(Character.toUpperCase(s.charAt(i)));
                cnt--;
            }
        }
        if(sb.length()!=0 && sb.charAt(sb.length()-1)=='-'){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();
    }
}
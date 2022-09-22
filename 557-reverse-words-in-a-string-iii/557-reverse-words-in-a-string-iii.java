class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        int len = s.length();
        StringBuilder res = new StringBuilder(len+1);
        for(String x:arr) {
            int curLen = x.length();
            for(int i=curLen-1;i>=0;i--){
                res.append(x.charAt(i));
            }
            res.append(' ');
        }
        
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}
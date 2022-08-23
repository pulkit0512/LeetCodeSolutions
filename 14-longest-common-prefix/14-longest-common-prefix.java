class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int min = Integer.MAX_VALUE;
        for(String str:strs) {
            min = Math.min(min, str.length());
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<min;i++){
            char ch = strs[0].charAt(i);
            boolean isCommon = true;
            for(int j=1;j<n;j++){
                if(ch!=strs[j].charAt(i)){
                    isCommon = false;
                    break;
                }
            }
            if(isCommon){
                ans.append(ch);
            }else{
                break;
            }
        }
        return ans.toString();
    }
}
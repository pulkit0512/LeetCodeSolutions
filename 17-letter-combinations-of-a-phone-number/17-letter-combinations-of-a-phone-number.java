class Solution {
    String[] map;
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int n = digits.length();
        if(n==0){
            return ans;
        }
        if(map==null) {
            map = new String[10];
            map[2] = "abc";
            map[3] = "def";
            map[4] = "ghi";
            map[5] = "jkl";
            map[6] = "mno";
            map[7] = "pqrs";
            map[8] = "tuv";
            map[9] = "wxyz";
        }
        helper(ans, digits, 0, new StringBuilder(), n);
        return ans;
    }
    public void helper(List<String> ans, String digits, int idx, StringBuilder s, int n) {
        if(idx==n){
            ans.add(s.toString());
            return;
        }
        int len = map[digits.charAt(idx)-'0'].length();
        for(int i=0;i<len;i++){
            s.append(map[digits.charAt(idx)-'0'].charAt(i));
            helper(ans, digits, idx+1, s, n);
            s.deleteCharAt(s.length()-1);
        }
    }
}
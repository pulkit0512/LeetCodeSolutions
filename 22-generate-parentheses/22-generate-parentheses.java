class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generateParenthesisUtil(n, "", 0);
        return ans;
    }
    private void generateParenthesisUtil(int n, String s, int balance) {
        if(s.length()==2*n){
            if(balance==0){
                ans.add(s);
            }
            return;
        }
        if(balance<0){
            return;
        }
        generateParenthesisUtil(n, s+"(", balance+1);
        generateParenthesisUtil(n, s+")", balance-1);
    }
}
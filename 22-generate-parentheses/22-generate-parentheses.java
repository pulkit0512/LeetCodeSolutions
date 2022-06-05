class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generateParenthesisUtil(n, new StringBuilder(), 0);
        return ans;
    }
    private void generateParenthesisUtil(int n, StringBuilder sb, int balance) {
        if(sb.length()==2*n){
            if(balance==0){
                ans.add(sb.toString());
            }
            return;
        }
        if(balance<0){
            return;
        }
        generateParenthesisUtil(n, sb.append('('), balance+1);
        sb.deleteCharAt(sb.length()-1);
        generateParenthesisUtil(n, sb.append(')'), balance-1);
        sb.deleteCharAt(sb.length()-1);
    }
}
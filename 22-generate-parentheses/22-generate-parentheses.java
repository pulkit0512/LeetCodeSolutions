class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generateParenthesisUtil(new StringBuilder(), n, 0);
        return ans;
    }
    
    private void generateParenthesisUtil(StringBuilder sb, int n, int balance) {
        if(sb.length()==2*n){
            if(balance==0){
                ans.add(sb.toString());
            }
            return;
        }
        if(balance<0 || balance>n){
            return;
        }
        generateParenthesisUtil(sb.append('('), n, balance+1);
        sb.deleteCharAt(sb.length()-1);
        
        generateParenthesisUtil(sb.append(')'), n, balance-1);
        sb.deleteCharAt(sb.length()-1);
    }
}
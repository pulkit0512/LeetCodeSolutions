class Solution {
    List<Integer> list;
    public int[] numsSameConsecDiff(int n, int k) {
        list = new ArrayList<>();
        for(int i=1;i<=9;i++){
            numsSameConsecDiffUtil(n-1, k, i);
        }
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    
    private void numsSameConsecDiffUtil(int n, int k, int cur) {
        if(n==0){
            list.add(cur);
            return;
        }
        int last = cur%10;
        if(last+k<=9){
            numsSameConsecDiffUtil(n-1, k, cur*10 + (last+k));
        }
        if(last-k>=0 && k!=0){
            numsSameConsecDiffUtil(n-1, k, cur*10 + (last-k));
        }
    }
}
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(k, n, list, 9);
        return result;
    }
    private void backtrack(int k, int n, List<Integer> list, int prev) {
        if(k==0){
            if(n==0){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if(n<0){
            return;
        }
        for(int i=prev;i>=1;i--){
            list.add(i);
            backtrack(k-1, n-i, list, i-1);
            list.remove(list.size()-1);
        }
    }
}
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> cur, int start) {
        if(target==0){
            result.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i=start;i<candidates.length;i++){
            if(target-candidates[i]>=0){
                cur.add(candidates[i]);
                backtrack(candidates, target-candidates[i], result, cur, i+1);
                cur.remove(cur.size()-1);
            }
            
            // To avoid duplicate combination ignore same elements.
            while(i<candidates.length-1 && candidates[i+1]==candidates[i]){
                i++;
            }
        }
    }
}
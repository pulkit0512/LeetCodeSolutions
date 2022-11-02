class Solution {
    int steps;
    public int minMutation(String start, String end, String[] bank) {
        steps = Integer.MAX_VALUE;
        boolean[] vis = new boolean[bank.length];
        minMutationUtil(start, end, bank, vis, 0);
        return steps==Integer.MAX_VALUE ? -1 : steps;
    }
    
    private void minMutationUtil(String start, String end, String[] bank, boolean[] vis, int curSteps) {
        if(start.equals(end)) {
            steps = Math.min(steps, curSteps);
            return;
        }
        
        for(int i=0;i<bank.length;i++) {
            if(vis[i]){
                continue;
            }
            
            int edit = 0;
            for(int j=0;j<8;j++){
                if(bank[i].charAt(j)!=start.charAt(j)){
                    edit++;
                }
            }
            
            if(edit == 1) {
                vis[i] = true;
                minMutationUtil(bank[i], end, bank, vis, curSteps+1);
                vis[i] = false;
            }
        }
    }
}
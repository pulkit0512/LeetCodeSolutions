class Solution {
    public int[] movesToStamp(String stamp, String target) {
        //return movesToStamp1(stamp, target);
        return movesToStamp2(stamp, target);
    }
    
    private int[] movesToStamp2(String stamp, String target) {
        char[] t = target.toCharArray();
        int n = t.length;
        int m = stamp.length();
        Stack<Integer> res = new Stack<>();
        boolean change = true;
        while(change) {
            change = false;
            for(int i=0;i<=n-m;i++){
                change = change|check(t, stamp, i, res, m);
            }
        }
        
        for(char ch:t){
            if(ch!='?'){
                return new int[0];
            }
        }
        int size = res.size();
        int ans[] = new int[size];
        for(int i=0;i<size;i++){
            ans[i] = res.pop();
        }
        return ans;
    }
    
    private boolean check(char[] t, String s, int idx, Stack<Integer> res, int m) {
        boolean change = false;
        for(int j=0;j<m;j++){
            if(t[idx+j]=='?'){
                continue;
            }else if(t[idx+j]!=s.charAt(j)){
                return false;
            }else{
                change = true;
            }
        }
        if(change){
            res.add(idx);
            for(int j=0;j<m;j++){
                t[idx+j] = '?';
            }
        }
        return change;
    }
    
    // TC: O(N*(N-M)) SC: O(N*(N-M)), N = target length and M = stamp length
    private int[] movesToStamp1(String stamp, String target) {
        int n = target.length();
        int m = stamp.length();
        boolean[] done = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> opr = new Stack<>();
        // Pair contains two hashsets, one for matching chars in the window and other for non matching chars.
        List<Pair<Set<Integer>, Set<Integer>>> window = new ArrayList<>();
        
        for(int i=0;i<=n-m;i++){
            window.add(new Pair(new HashSet<>(), new HashSet<>()));
            for(int j=0;j<m;j++){
                if(target.charAt(i+j)==stamp.charAt(j)){
                    window.get(window.size()-1).getKey().add(i+j);
                }else{
                    window.get(window.size()-1).getValue().add(i+j);
                }
            }
            if(window.get(window.size()-1).getValue().isEmpty()) {
                opr.add(i);
                enque(window.get(window.size()-1), done, que);
            }
        }
        
        while(!que.isEmpty()) {
            int i = que.poll();
            for(int j=Math.max(0, i-m+1);j<=Math.min(n-m, i);j++){
                if(window.get(j).getValue().contains(i)){
                    window.get(j).getValue().remove(i);
                    if(window.get(j).getValue().isEmpty()) {
                        opr.add(j);
                        enque(window.get(j), done, que);
                    }
                }
            }
        }
        
        for(boolean b:done){
            if(!b){
                return new int[0];
            }
        }
        
        int size = opr.size();
        int ans[] = new int[size];
        
        for(int i=0;i<size;i++){
            ans[i] = opr.pop();
        }
        
        return ans;
    }
    
    private void enque(Pair<Set<Integer>, Set<Integer>> d, boolean[] done, Queue<Integer> que) {
        for(int matched:d.getKey()) {
            if(!done[matched]){
                done[matched] = true;
                que.add(matched);
            }
        }
    }
}
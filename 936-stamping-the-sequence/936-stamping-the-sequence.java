class Solution {
    class Data {
        Set<Integer> match, todo;
        public Data() {
            match = new HashSet<>();
            todo = new HashSet<>();
        }
    }
    
    public int[] movesToStamp(String stamp, String target) {
        int n = target.length();
        int m = stamp.length();
        boolean[] done = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> opr = new Stack<>();
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
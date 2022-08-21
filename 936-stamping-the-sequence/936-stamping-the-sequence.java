class Solution {
    class Data {
        Set<Integer> match, todo;
        public Data() {
            match = new HashSet<>();
            todo = new HashSet<>();
        }
    }
    boolean[] done;
    Queue<Integer> que;
    Stack<Integer> opr;
    List<Data> window;
    public int[] movesToStamp(String stamp, String target) {
        int n = target.length();
        int m = stamp.length();
        done = new boolean[n];
        que = new LinkedList<>();
        opr = new Stack<>();
        window = new ArrayList<>();
        
        for(int i=0;i<=n-m;i++){
            window.add(new Data());
            for(int j=0;j<m;j++){
                if(target.charAt(i+j)==stamp.charAt(j)){
                    window.get(window.size()-1).match.add(i+j);
                }else{
                    window.get(window.size()-1).todo.add(i+j);
                }
            }
            if(window.get(window.size()-1).todo.isEmpty()) {
                opr.add(i);
                enque(window.get(window.size()-1));
            }
        }
        
        while(!que.isEmpty()) {
            int i = que.poll();
            for(int j=Math.max(0, i-m+1);j<=Math.min(n-m, i);j++){
                if(window.get(j).todo.contains(i)){
                    window.get(j).todo.remove(i);
                    if(window.get(j).todo.isEmpty()) {
                        opr.add(j);
                        enque(window.get(j));
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
    
    private void enque(Data d) {
        for(int matched:d.match) {
            if(!done[matched]){
                done[matched] = true;
                que.add(matched);
            }
        }
    }
}
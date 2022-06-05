class Solution {
    int dir[][] = new int[][]{{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    Map<String, Integer> map;
    class MoveData{
        int x, y, moves;
        public MoveData(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }
    public int minKnightMoves(int x, int y) {
        //return minKnightMovesBFS(x, y);
        return minKnightMovesDFS(x, y);
    }
    
    private int minKnightMovesDFS(int x, int y){
        map = new HashMap<>();
        return dfs(Math.abs(x), Math.abs(y));
    }
    
    private int dfs(int x, int y) {
        String key = x+","+y;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(x+y==0){
            return 0;
        }
        if(x+y==2){
            return 2;
        }
        int steps = Math.min(dfs(Math.abs(x-2), Math.abs(y-1)), dfs(Math.abs(x-1), Math.abs(y-2))) + 1;
        map.put(key, steps);
        return steps;
    }
    
    private int minKnightMovesBFS(int x, int y) {
        Queue<MoveData> que = new LinkedList<>();
        boolean[][] visited = new boolean[601][601];
        que.add(new MoveData(0,0,0));
        visited[300][300] = true;
        while(!que.isEmpty()){
            MoveData prev = que.poll();
            if(prev.x==x && prev.y==y){
                return prev.moves;
            }
            for(int i=0;i<8;i++){
                int newRow = dir[i][0] + prev.x;
                int newCol = dir[i][1] + prev.y;
                if(Math.abs(newRow)<=300 && Math.abs(newCol)<=300) {
                    if(!visited[newRow+300][newCol+300]) {
                        visited[newRow+300][newCol+300] = true;
                        que.add(new MoveData(newRow, newCol, prev.moves+1));
                    }
                }
            }
        }
        return -1;
    }
}
class Solution {
    int dir[][] = new int[][]{{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    class MoveData{
        int x, y, moves;
        public MoveData(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }
    public int minKnightMoves(int x, int y) {
        Queue<MoveData> que = new LinkedList<>();
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        que.add(new MoveData(0,0,0));
        visited.put(0, new HashSet<>());
        visited.get(0).add(0);
        while(!que.isEmpty()){
            MoveData prev = que.poll();
            if(prev.x==x && prev.y==y){
                return prev.moves;
            }
            for(int i=0;i<8;i++){
                int newRow = dir[i][0] + prev.x;
                int newCol = dir[i][1] + prev.y;
                if(Math.abs(newRow)<=300 && Math.abs(newCol)<=300) {
                    if((visited.containsKey(newRow) && !visited.get(newRow).contains(newCol)) 
                       || !visited.containsKey(newRow)){
                        que.add(new MoveData(newRow, newCol, prev.moves+1));
                        if(!visited.containsKey(newRow)){
                            visited.put(newRow, new HashSet<>());
                        }
                        visited.get(newRow).add(newCol);
                    }
                }
            }
        }
        return -1;
    }
}
class Solution {
    class StepState {
        public int steps, row, col, k;

        public StepState(int row, int col, int k, int steps) {
            this.steps = steps;
            this.row = row;
            this.col = col;
            this.k = k;
        }

        @Override
        public int hashCode() {
            // needed when we put objects into any container class
            return (this.row + 1) * (this.col + 1) * this.k;
        }

        @Override
        public boolean equals(Object other) {
            /**
            * only (row, col, k) matters as the state info
            */
            if (!(other instanceof StepState)) {
                return false;
            }
            StepState newState = (StepState) other;
            return (this.row == newState.row) && (this.col == newState.col) && (this.k == newState.k);
        }

        @Override
        public String toString() {
            return String.format("%d %d %d", this.row, this.col, this.k);
        }
    }
    int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        Queue<StepState> pq = new LinkedList<>();
        Set<StepState> set = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        if(k>=m+n-2){
            return m+n-2;
        }
        StepState start = new StepState(0,0,0,0);
        pq.add(start);
        set.add(start);
        int minSteps = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            StepState state= pq.poll();
            if(state.row==m-1 && state.col==n-1){
                minSteps = state.steps;
                break;
            }
            for(int i=0;i<4;i++){
                int newRow = dir[i][0] + state.row;
                int newCol = dir[i][1] + state.col;
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n){
                    StepState s0 = new StepState(newRow, newCol, state.k, state.steps+1);
                    StepState s1 = new StepState(newRow, newCol, state.k+1, state.steps+1);
                    if(grid[newRow][newCol]==0 && !set.contains(s0)){
                        pq.add(s0);
                        set.add(s0);
                    }else if(grid[newRow][newCol]==1 && state.k+1<=k && !set.contains(s1)){
                        pq.add(s1);
                        set.add(s1);
                    }
                }
            }
        }
        return minSteps==Integer.MAX_VALUE?-1:minSteps;
    }
}
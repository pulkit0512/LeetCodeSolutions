class Solution {
    int ans, n;
    public int totalNQueens(int n) {
        this.ans = 0;
        this.n = n;
        getBoard(new HashSet<>(), new HashSet<>(), new HashSet<>(), 0);
        return ans;
    }
    
    private void getBoard(Set<Integer> col, Set<Integer> dia, Set<Integer> antiDia, int row) {
        if(row==this.n){
            ans++;
            return;
        }
        for(int i=0;i<this.n;i++){
            int curDia = row-i;
            int curAntiDia = row+i;
            if(col.contains(i) || dia.contains(curDia) || antiDia.contains(curAntiDia)){
                continue;
            }
            col.add(i);
            dia.add(curDia);
            antiDia.add(curAntiDia);
            getBoard(col, dia, antiDia, row+1);
            col.remove(i);
            dia.remove(curDia);
            antiDia.remove(curAntiDia);
        }
    }
}
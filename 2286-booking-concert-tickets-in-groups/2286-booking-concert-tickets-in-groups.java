class BookMyShow {
    class SegmentTree{
        long[] maxSegTree, sumSegTree;
        int n, m;
        
        public SegmentTree(int n, int m){
            this.n = n;
            this.m = m;
            maxSegTree = new long[4*n + 1];
            sumSegTree = new long[4*n + 1];
            build(0, 0, n-1, m);
        }
        
        private void build(int idx, int l, int r, int val){
            if(l==r){
                sumSegTree[idx] = val;
                maxSegTree[idx] = val;
                return;
            }
            int mid = (l+r)/2;
            build(2*idx+1, l, mid, val);
            build(2*idx+2, mid+1, r, val);
            sumSegTree[idx] = sumSegTree[2*idx+1] + sumSegTree[2*idx+2];
            maxSegTree[idx] = Math.max(maxSegTree[2*idx+1], maxSegTree[2*idx+2]);
        }
        
        private void update(int idx, int l, int r, int pos, int val) {
            if(l==r){
                maxSegTree[idx] = val;
                sumSegTree[idx] = val;
                return;
            }
            int mid = (l+r)/2;
            if(pos<=mid){
                update(2*idx+1, l, mid, pos, val);
            }else{
                update(2*idx+2, mid+1, r, pos, val);
            }
            sumSegTree[idx] = sumSegTree[2*idx+1] + sumSegTree[2*idx+2];
            maxSegTree[idx] = Math.max(maxSegTree[2*idx+1], maxSegTree[2*idx+2]);
        }
        
        public void update(int pos, int val){
            update(0, 0, n-1, pos, val);
        }
        
        private long scatterQuery(int idx, int l, int r, int ql, int qr){
            if(l>qr || r<ql){
                return 0;
            }
            if(ql<=l && qr>=r){
                return sumSegTree[idx];
            }
            int mid = (l+r)/2;
            return scatterQuery(2*idx+1, l, mid, ql, qr) + scatterQuery(2*idx+2, mid+1, r, ql, qr);
        }
        
        public long scatterQuery(int firstRow, int maxRow){
            return scatterQuery(0, 0, n-1, firstRow, maxRow);
        }
        
        private int gatherQuery(int idx, int l, int r, int k, int maxRow) {
            if(maxSegTree[idx]<k || l>maxRow){
                return -1;
            }
            if(l==r){
                return l;
            }
            int mid = (l+r)/2;
            int row = gatherQuery(2*idx+1, l, mid, k, maxRow);
            if(row==-1){
                row = gatherQuery(2*idx+2, mid+1, r, k, maxRow);
            }
            return row;
        }
        
        public int gatherQuery(int k, int maxRow){
            return gatherQuery(0, 0, n-1, k, maxRow);
        }
        
    }

    Map<Integer, Set<Integer>> cache;
    SegmentTree segTree;
    int[] seats;
    public BookMyShow(int n, int m) {
        cache = new HashMap<>();
        segTree = new SegmentTree(n, m);
        seats = new int[n];
        Arrays.fill(seats, m);
    }
    
    public int[] gather(int k, int maxRow) {
        if(cache.containsKey(k) && cache.get(k).contains(maxRow)){
            return new int[0];
        }
        int row = segTree.gatherQuery(k, maxRow);
        if(row==-1){
            if(!cache.containsKey(k)){
                cache.put(k, new HashSet<>());
            }
            cache.get(k).add(maxRow);
            return new int[0];
        }
        int ans[] = new int[2];
        ans[0] = row;
        ans[1] = segTree.m-seats[row];
        seats[row] -= k;
        segTree.update(row, seats[row]);
        return ans;
    }
    
    public boolean scatter(int k, int maxRow) {
        if(cache.containsKey(k) && cache.get(k).contains(maxRow)){
            return false;
        }
        long sum = segTree.scatterQuery(0, maxRow);
        if(sum<k){
            if(!cache.containsKey(k)){
                cache.put(k, new HashSet<>());
            }
            cache.get(k).add(maxRow);
            return false;
        }
        for(int i=0;i<=maxRow && k>0;i++){
            if(seats[i]>0){
                int available = Math.min(seats[i], k);
                k -= available;
                seats[i] -= available;
                segTree.update(i, seats[i]);
            }
        }
        return true;
    }
    
    // Brute Force approach, with caching and prefix sum of available seats upto row i it passes all testcases.
    /*int seats[];
    int n, m;
    long pre[];
    Map<String, Boolean> cache;
    public BookMyShow(int n, int m) {
        seats = new int[n];
        pre = new long[n];
        cache = new HashMap<>();
        this.n = n;
        this.m = m;
        pre[0] = m;
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + m;
        }
    }
    
    public int[] gather(int k, int maxRow) {
        if(cache.containsKey(k+" "+maxRow)){
            return new int[0];
        }
        int row = 0;
        for(;row<=maxRow;row++){
            if(m-seats[row]>=k){
                break;
            }
        }
        if(row>maxRow){
            cache.put(k+" "+maxRow, false);
            return new int[0];
        }
        int ans[] = new int[2];
        ans[0] = row;
        ans[1] = seats[row];
        seats[row] += k;
        for(int i=row;i<n;i++){
            pre[i] -= k;
        }
        
        return ans;
    }
    
    public boolean scatter(int k, int maxRow) {
        if(pre[maxRow]<k){
            cache.put(k+" "+maxRow, false);
            return false;
        }
        
        for(int row=0;row<=maxRow && k>0;row++){
            int available = m-seats[row];
            seats[row] = Math.min(m, seats[row]+k);
            k = k-available;
        }
        pre[0] = m-seats[0];
        for(int row=1;row<n;row++){
            pre[row] = pre[row-1] + (m-seats[row]);
        }
        return true;
    }*/
}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */
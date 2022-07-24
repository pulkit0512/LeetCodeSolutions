class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int map[] = new int[n];
        for(int i=0;i<n;i++){
            map[row[i]] = i;
        }
        int ans = 0;
        for(int i=0;i<n;i+=2){
            int a = row[i];
            int b = a^1;
            if(row[i+1]!=b){
                int pos = map[b];
                swap(map, row, i+1, pos);
                ans++;
            }
        }
        return ans;
    }
    
    private void swap(int[] map, int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        map[a[i]] = i;
        map[a[j]] = j;
    }
}
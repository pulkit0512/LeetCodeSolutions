class Solution {
    class Sort implements Comparator<int[]>{
        public int compare(int a[], int b[]){
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people, new Sort());
        int[][] queue = new int[n][2];
        for(int i=0;i<n;i++){
            int idx = people[i][1];
            for(int j=i;j>idx;j--){
                queue[j] = queue[j-1];
            }
            queue[idx] = people[i];
        }
        return queue;
    }
}
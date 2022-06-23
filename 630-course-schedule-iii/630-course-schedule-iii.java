class Solution {
    class Sort implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[1]==b[1]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        }
    }
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Sort());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        int cnt = 0, ans = 0;
        for(int i=0;i<courses.length;i++){
            if(courses[i][0]>courses[i][1]){
                continue;
            }
            if(sum+courses[i][0]<=courses[i][1]){
                sum += courses[i][0];
                pq.add(courses[i][0]);
                cnt++;
            }else{
                ans = Math.max(ans, cnt);
                sum += courses[i][0];
                pq.add(courses[i][0]);
                cnt++;
                while(!pq.isEmpty() && sum>courses[i][1]){
                    sum -= pq.poll();
                    cnt--;
                }
            }
        }
        ans = Math.max(ans, cnt);
        return ans;
    }
}
class Solution {
    public int scheduleCourse(int[][] courses) {
        return scheduleCourseNLogN(courses);
        //return scheduleCourseNCount(courses);
    }
    private int scheduleCourseNLogN(int[][] courses){
        Arrays.sort(courses, (a,b)->(a[1]-b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for(int i=0;i<courses.length;i++){
            if(courses[i][0]>courses[i][1]){
                continue;
            }
            if(sum+courses[i][0]<=courses[i][1]){
                sum += courses[i][0];
                pq.add(courses[i][0]);
            }else{
                if(!pq.isEmpty() && pq.peek()>courses[i][0]){
                    sum += courses[i][0] - pq.poll();
                    pq.add(courses[i][0]);
                }
            }
        }
        return pq.size();
    }
    
    private int scheduleCourseNCount(int[][] courses) {
        Arrays.sort(courses, (a,b)->(a[1]-b[1]));
        int sum = 0, cnt = 0;
        for(int i=0;i<courses.length;i++){
            if(courses[i][0]>courses[i][1]){
                continue;
            }
            if(sum+courses[i][0]<=courses[i][1]){
                sum += courses[i][0];
                courses[cnt] = courses[i];
                cnt++;
            }else{
                int max_i = i;
                for(int j=cnt-1;j>=0;j--){
                    if(courses[j][0]>courses[max_i][0]){
                        max_i = j;
                    }
                }
                if(max_i!=i){
                    sum += courses[i][0] - courses[max_i][0];
                    courses[max_i] = courses[i];
                }
            }
        }
        return cnt;
    }
}
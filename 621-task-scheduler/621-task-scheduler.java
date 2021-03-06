class Solution {
    public int leastInterval(char[] tasks, int n) {
        //return leastIntervalPriorityQueue(tasks, n);
        return leastIntervalSort(tasks, n);
    }
    
    private int leastIntervalSort(char[] tasks, int n) {
        int freq[] = new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        Arrays.sort(freq);
        int fMax = freq[25];
        // Max idle time can be (fMax-1)*n i.e. time needed to complete the maximum frequence task alone with cooling period
        // of n.
        int idle_time = (fMax-1)*n;
        for(int i=24;i>=0;i--){
            //See how many idle slots to can be filled with current task.
            idle_time = idle_time - Math.min(fMax-1, freq[i]);
        }
        return tasks.length + Math.max(0, idle_time);
    }
    
    private int leastIntervalPriorityQueue(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                pq.add(freq[i]);
            }
        }
        int time = 0;
        Queue<Integer> que = new LinkedList<>();
        while(!pq.isEmpty()){
            int wait = n;
            while(wait>=0){
                if(!pq.isEmpty()){
                    int val = pq.poll();
                    wait--;
                    time++;
                    if(val>1){
                        que.add(val-1);
                    }
                }else{
                    if(!que.isEmpty()){
                        time += wait + 1;
                    }
                    wait = -1;
                }
            }
            while(!que.isEmpty()){
                pq.add(que.poll());
            }
        }
        return time;
    }
}
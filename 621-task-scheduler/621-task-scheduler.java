class Solution {
    public int leastInterval(char[] tasks, int n) {
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
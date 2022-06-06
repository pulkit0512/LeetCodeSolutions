class Solution {
    class ProcessData {
        int pid;
        int curTime;
        int notProcessTime;
        
        public ProcessData(int pid, int curTime){
            this.pid = pid;
            this.curTime = curTime;
            this.notProcessTime = 0;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<ProcessData> process = new Stack<>();
        int[] processTime = new int[n];
        for(String log:logs) {
            String[] data = log.split(":");
            int pid = Integer.valueOf(data[0]);
            int curTime = Integer.valueOf(data[2]);
            if(data[1].equals("start")){
                process.push(new ProcessData(pid, curTime));
            }else{
                ProcessData start = process.pop();
                processTime[start.pid] += (curTime - start.curTime + 1) - start.notProcessTime;
                if(!process.isEmpty()){
                    process.peek().notProcessTime += (curTime - start.curTime + 1);
                }
            }
        }
        return processTime;
    }
}
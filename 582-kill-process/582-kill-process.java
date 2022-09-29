class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> processMap = new HashMap<>();
        for(int i=0;i<ppid.size();i++){
            if(!processMap.containsKey(ppid.get(i))){
                processMap.put(ppid.get(i), new ArrayList<>());
            }
            
            processMap.get(ppid.get(i)).add(pid.get(i));
        }
        
        List<Integer> res = new ArrayList<>();
        killProcessDfs(processMap, kill, res);
        return res;
    }
    
    private void killProcessDfs(Map<Integer, List<Integer>> processMap, int kill, List<Integer> res) {
        res.add(kill);
        List<Integer> childProcess = processMap.get(kill);
        if(childProcess==null){
            return;
        }
        
        for(int child:childProcess){
            killProcessDfs(processMap, child, res);
        }
    }
}
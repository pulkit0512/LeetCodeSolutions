class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String path:paths) {
            String[] arr = path.split(" ");
            
            for(int i=1;i<arr.length;i++){
                int open = arr[i].indexOf('(');
                String file = arr[i].substring(0, open);
                String content = arr[i].substring(open);
                
                if(!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                
                map.get(content).add(arr[0]+'/'+file);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(Map.Entry<String, List<String>> entry:map.entrySet()){
            if(entry.getValue().size()>=2){
                ans.add(entry.getValue());
            }
        }
        
        return ans;
    }
}
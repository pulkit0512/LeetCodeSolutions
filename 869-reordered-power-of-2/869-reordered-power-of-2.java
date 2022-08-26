class Solution {
    public boolean reorderedPowerOf2(int n) {
        Map<Integer, Integer> orgMap = new HashMap<>();
        while(n>0){
            orgMap.put(n%10, orgMap.getOrDefault(n%10, 0) + 1);
            n = n/10;
        }
        
        //Set<Map<Integer, Integer>> mapSet = new HashSet<>(30);
        for(int i=0;i<30;i++){
            int val = (1<<i);
            Map<Integer, Integer> map = new HashMap<>();
            while(val>0){
                map.put(val%10, map.getOrDefault(val%10, 0) + 1);
                val = val/10;
            }
            if(orgMap.equals(map)){
                return true;
            }
        }
        
        return false;
    }
}
class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        
        if(n%2==1){
            return new int[0];
        }
        
        Map<Integer, Integer> map = new TreeMap<>();
        for(int num:changed){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int[] ans = new int[n/2];
        int idx = 0;
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(value==0){
                continue;
            }
            
            if(key==0){
                for(int i=0;i<value/2;i++){
                    ans[idx++] = key;
                }
                continue;
            }
            
            int doubleKeyValue = map.getOrDefault(2*key, 0);
            
            int minValue = Math.min(value, doubleKeyValue);
            
            if(value-minValue!=0){
                return new int[0];
            }else{
                for(int i=0;i<value;i++){
                    ans[idx++] = key;
                }
            }
            
            map.put(key, value-minValue);
            map.put(2*key, doubleKeyValue-minValue);
        }
        
        return ans;
    }
}
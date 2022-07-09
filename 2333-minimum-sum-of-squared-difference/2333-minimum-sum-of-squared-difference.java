class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(0,0);
        int k = k1 + k2;
        int n = nums1.length;
        for(int i=0;i<n;i++){
            int val = Math.abs(nums1[i]-nums2[i]);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        //System.out.println(map+" "+k);
        while(k>0 && map.size()>1){
            Map.Entry<Integer, Integer> entry1 = map.pollFirstEntry();
            Map.Entry<Integer, Integer> entry2 = map.firstEntry();
            int val = entry1.getKey() - entry2.getKey();
            if(val*entry1.getValue()<=k){
                k = k-val*entry1.getValue();
                map.put(entry2.getKey(), entry2.getValue()+entry1.getValue());
            }else{
                int eqDist = k/entry1.getValue();
                int left = k-eqDist*entry1.getValue();
                int newKey = entry1.getKey()-eqDist;
                if(newKey==0){
                    break;
                }
                map.put(newKey, map.getOrDefault(newKey,0) + (entry1.getValue()-left));
                map.put(newKey-1, map.getOrDefault(newKey-1,0) + left);
                k = 0;
            }
            //System.out.println(map+" "+k);
        }
        long ans = 0L;
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            ans += (long)entry.getKey()*entry.getKey()*entry.getValue();
        }
        return ans;
    }
}
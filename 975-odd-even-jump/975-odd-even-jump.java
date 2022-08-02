class Solution {
    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = arr.length;
        boolean higher[] = new boolean[n], lower[] = new boolean[n];
        map.put(arr[n-1], n-1);
        higher[n-1] = lower[n-1] = true;
        int ans = 1;
        for(int i=n-2;i>=0;i--){
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> lo = map.floorEntry(arr[i]);
            if(hi!=null){
                higher[i] = lower[(int)hi.getValue()];
            }
            if(lo!=null){
                lower[i] = higher[(int)lo.getValue()];
            }
            if(higher[i]){
                ans++;
            }
            map.put(arr[i], i);
        }
        return ans;
    }
}
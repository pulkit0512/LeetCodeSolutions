class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b)->(a[0]-b[0]));
        Arrays.sort(slots2, (a,b)->(a[0]-b[0]));
        
        int i1 = 0, i2 = 0;
        List<Integer> interval = new ArrayList<>();
        while(i1<slots1.length && i2<slots2.length){
            int st = Math.max(slots1[i1][0], slots2[i2][0]);
            int ed = Math.min(slots1[i1][1], slots2[i2][1]);
            
            if(ed-st>=duration){
                interval.add(st);
                interval.add(st+duration);
                break;
            }
            
            if(slots1[i1][1]<slots2[i2][1]){
                i1++;
            }else if(slots2[i2][1]<slots1[i1][1]){
                i2++;
            }else{
                if(slots1[i1][0]<slots2[i2][0]){
                    i1++;
                }else{
                    i2++;
                }
            }
        }
        return interval;
    }
}
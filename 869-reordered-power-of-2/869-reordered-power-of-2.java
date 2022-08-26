class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] orgMap = new int[10];
        while(n>0){
            orgMap[n%10]++;
            n = n/10;
        }
        
        for(int i=0;i<30;i++){
            int val = (1<<i);
            int[] map = new int[10];
            while(val>0){
                map[val%10]++;
                val = val/10;
            }
            
            boolean equal = true;
            for(int j=0;j<10;j++){
                if(map[j]!=orgMap[j]){
                    equal = false;
                    break;
                }
            }
            
            if(equal){
                return true;
            }
        }
        
        return false;
    }
}
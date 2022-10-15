class Solution {
    public String similarRGB(String color) {
        //0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xAA, 0xBB, 0xCC, 0xDD, 0xEE, 0xFF
        
        int ab = Integer.valueOf(color.substring(1,3), 16);
        int cd = Integer.valueOf(color.substring(3,5), 16);
        int ef = Integer.valueOf(color.substring(5,7), 16);
        
        int minAB = Integer.MAX_VALUE;
        int minCD = minAB, minEF = minAB;
        
        int newAB = 0, newCD = 0, newEF = 0;
        
        for(int i=0;i<16;i++){
            int val = 17*i;
            int absAB = Math.abs(ab-val);
            int absCD = Math.abs(cd-val);
            int absEF = Math.abs(ef-val);
            
            if(absAB<minAB){
                minAB = absAB;
                newAB = val;
            }
            
            if(absCD<minCD){
                minCD = absCD;
                newCD = val;
            }
            
            if(absEF<minEF){
                minEF = absEF;
                newEF = val;
            }
        }
        StringBuilder res = new StringBuilder("#");
        res.append(String.format("%02x", (0xFF & newAB)));
        res.append(String.format("%02x", (0xFF & newCD)));
        res.append(String.format("%02x", (0xFF & newEF)));
        
        return res.toString();
    }
}
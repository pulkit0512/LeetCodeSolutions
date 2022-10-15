class Solution {
    public String similarRGB(String color) {
        //0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xAA, 0xBB, 0xCC, 0xDD, 0xEE, 0xFF
        
        int ab = 16*(add(color.charAt(1))) + add(color.charAt(2));
        int cd = 16*(add(color.charAt(3))) + add(color.charAt(4));
        int ef = 16*(add(color.charAt(5))) + add(color.charAt(6));
        
        
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
        StringBuilder res = new StringBuilder(7);
        res.append('#');
        res.append(String.format("%02x", (0xFF & newAB)));
        res.append(String.format("%02x", (0xFF & newCD)));
        res.append(String.format("%02x", (0xFF & newEF)));
        
        return res.toString();
    }
    
    private int add(char ch) {
        if(Character.isDigit(ch)){
            return ch-'0';
        }else{
            return 10 + (ch-'a');
        }
    }
}
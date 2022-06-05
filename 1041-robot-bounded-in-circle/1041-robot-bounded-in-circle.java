class Solution {
    public boolean isRobotBounded(String instructions) {
        int step = 0;
        int n = instructions.length();
        //0 = north, 1 = east, 2 = south, 3 = west
        int dir = 0;
        for(int i=0, cycle=1;i<n && cycle<=4;i++){
            if(dir==0){
                if(instructions.charAt(i)=='G'){
                    step++;
                }else if(instructions.charAt(i)=='L'){
                    dir = 3;
                }else{
                    dir = 1;
                }
            }else if(dir==1){
                if(instructions.charAt(i)=='G'){
                    step++;
                }else if(instructions.charAt(i)=='L'){
                    dir = 0;
                }else{
                    dir = 2;
                }
            }else if(dir==2){
                if(instructions.charAt(i)=='G'){
                    step--;
                }else if(instructions.charAt(i)=='L'){
                    dir = 1;
                }else{
                    dir = 3;
                }
            }else{
                if(instructions.charAt(i)=='G'){
                    step--;
                }else if(instructions.charAt(i)=='L'){
                    dir = 2;
                }else{
                    dir = 0;
                }
            }
            if(i+1==n){
                if(step==0){
                    return true;
                }
                i=-1;
                cycle++;
            }
        }
        return false;
    }
}
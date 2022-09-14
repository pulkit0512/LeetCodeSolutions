class Solution {
    public boolean validUtf8(int[] data) {
        int type = 0;
        for(int x:data) {
            int arr[] = new int[8];
            int idx = 7;
            while(x>0){
                arr[idx] = x%2;
                x = x/2;
                idx--;
            }
            
            if(type!=0){
                if(arr[0]!=1 || arr[1]!=0){
                    return false;
                }else{
                    type--;
                }
            }else{
                idx = 8;
                for(int i=0;i<8;i++){
                    if(arr[i]==0){
                        idx = i;
                        break;
                    }
                }
                if(idx==0){
                    type = 0;
                }else if(idx==1){
                    return false;
                }else{
                    type = idx-1;
                }
                
                if(type>=4){
                    return false;
                }
            }
        }
        
        return type==0;
    }
}
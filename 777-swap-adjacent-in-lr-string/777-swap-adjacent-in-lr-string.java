class Solution {
    public boolean canTransform(String start, String end) {
        int len = start.length();
        int sPtr = 0, ePtr = 0;
        while(true){
            while(sPtr<len && start.charAt(sPtr)=='X'){
                sPtr++;
            }
            while(ePtr<len && end.charAt(ePtr)=='X'){
                ePtr++;
            }
            if(sPtr==len && ePtr==len){
                break;
            }
            if(sPtr==len || ePtr==len){
                return false;
            }
            if(start.charAt(sPtr)!=end.charAt(ePtr)){
                return false;
            }
            if(start.charAt(sPtr)=='L' && sPtr<ePtr){
                return false;
            }
            if(start.charAt(sPtr)=='R' && sPtr>ePtr){
                return false;
            }
            sPtr++;
            ePtr++;
        }
        
        return true;
    }
}
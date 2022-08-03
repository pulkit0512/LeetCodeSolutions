class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sPtr = s.length() - 1;
        int tPtr = t.length() - 1;
        
        while(sPtr>=0 || tPtr>=0){
            int cnt = 0;
            while(sPtr>=0 && (cnt>0 || s.charAt(sPtr)=='#')){
                if(s.charAt(sPtr)=='#'){
                    cnt++;
                }else{
                    cnt--;
                }
                sPtr--;
            }
            
            cnt = 0;
            while(tPtr>=0 && (cnt>0 || t.charAt(tPtr)=='#')){
                if(t.charAt(tPtr)=='#'){
                    cnt++;
                }else{
                    cnt--;
                }
                tPtr--;
            }
            
            if(sPtr==-1 && tPtr==-1){
                return true;
            }
            if(sPtr==-1 || tPtr==-1){
                return false;
            }
            
            if(s.charAt(sPtr)==t.charAt(tPtr)){
                sPtr--;
                tPtr--;
            }else{
                return false;
            }
        }
        
        return true;
    }
    /*public boolean backspaceCompareNSpace(String s, String t) {
        StringBuilder sbS = new StringBuilder();
        StringBuilder sbT = new StringBuilder();
        int lenS = s.length();
        int lenT = t.length();
        for(int i=0;i<lenS;i++){
            if(s.charAt(i)=='#'){
                if(sbS.length()>0){
                    sbS.deleteCharAt(sbS.length()-1);
                }
            }else{
                sbS.append(s.charAt(i));
            }
        }
        for(int i=0;i<lenT;i++){
            if(t.charAt(i)=='#'){
                if(sbT.length()>0){
                    sbT.deleteCharAt(sbT.length()-1);
                }
            }else{
                sbT.append(t.charAt(i));
            }
        }
        //System.out.println(sbS + " "+ sbT);
        if(sbS.compareTo(sbT)==0){
            return true;
        }else{
            return false;
        }
    }*/
}
class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        int len = path.length();
        int dot = 0, chars = 0;
        for(int i=0;i<len;i++){
            char ch = path.charAt(i);
            if(ch=='.'){
                if(sb.length()==0){
                    continue;
                }else{
                    sb.append(ch);
                    if(chars==0){
                        dot++;
                    }
                }
            }else if(ch=='/'){
                if(sb.length()==0){
                    sb.append(ch);
                }else if(sb.charAt(sb.length()-1)=='/'){
                    continue;
                }else if(dot==1 || dot==2){
                    handleDots(sb, dot);
                    dot = 0;
                }else{
                    dot = 0;
                    chars = 0;
                    sb.append(ch);
                }
            }else{
                sb.append(ch);
                chars++;
                dot = 0;
            }
        }
        if(dot==1 || dot==2){
            handleDots(sb, dot);
            dot = 0;
        }
        if(sb.length()>1 && sb.charAt(sb.length()-1)=='/'){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
    
    private void handleDots(StringBuilder sb, int dot){
        if(dot==1){
            sb.deleteCharAt(sb.length()-1);
        }else if(dot==2){
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            if(sb.length()>1){
                sb.deleteCharAt(sb.length()-1);
                while(sb.charAt(sb.length()-1)!='/'){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }
}
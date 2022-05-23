class Solution {
    public String simplifyPath(String path) {
        return simplifyPathUsingStringBuilder(path);
        
        //return simplifyPathUsingStack(path);
    }
    private String simplifyPathUsingStack(String path) {
        Stack<String> st = new Stack<>();
        String[] dir = path.split("/");
        for(String d:dir){
            //System.out.println(d);
            if(d.equals(".") || d.isEmpty()){
                continue;
            }else if(d.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(d);
            }
        }
        //System.out.println(st);
        StringBuilder ans = new StringBuilder();
        for(String d:st){
            ans.append('/').append(d);
        }
        return ans.length()==0?"/":ans.toString();
    }
    
    private String simplifyPathUsingStringBuilder(String path) {
        StringBuilder sb = new StringBuilder();
        int len = path.length();
        int dot = 0, chars = 0;
        for(int i=0;i<len;i++){
            char ch = path.charAt(i);
            if(ch=='.'){
                sb.append(ch);
                if(chars==0){
                    dot++;
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
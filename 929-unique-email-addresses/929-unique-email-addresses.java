class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> validEmails = new HashSet<>();
        for(int i=0;i<emails.length;i++){
            String email = emails[i];
            int len = email.length();
            StringBuilder sb = new StringBuilder();
            boolean plusFound = false, atFound = false;
            for(int j=0;j<len;j++){
                if(!plusFound && !atFound){
                    if(email.charAt(j)=='.'){
                        continue;
                    } else if(email.charAt(j)=='+'){
                        plusFound = true;
                    } else if(email.charAt(j)=='@'){
                        atFound = true;
                        sb.append('@');
                    } else{
                        sb.append(email.charAt(j));
                    }
                } else if(plusFound && !atFound){
                    if(email.charAt(j)=='@'){
                        atFound = true;
                        sb.append('@');
                    }
                } else{
                    sb.append(email.charAt(j));
                }
            }
            validEmails.add(sb.toString());
        }
        //System.out.println(validEmails);
        return validEmails.size();
    }
}
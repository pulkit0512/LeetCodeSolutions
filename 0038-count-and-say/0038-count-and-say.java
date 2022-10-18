class Solution {
    public String countAndSay(int n) {
        StringBuilder ans = new StringBuilder("1");
        for(int i=2;i<=n;i++){
            int len = ans.length();
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            for(int j=1;j<len;j++){
                if(ans.charAt(j)==ans.charAt(j-1)) {
                    cnt++;
                } else {
                    sb.append(cnt).append(ans.charAt(j-1));
                    cnt = 1;
                }
            }
            sb.append(cnt).append(ans.charAt(len-1));
            ans = sb;
            //System.out.println(ans);
        }
        return ans.toString();
    }
}
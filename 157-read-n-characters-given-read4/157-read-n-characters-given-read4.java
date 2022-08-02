/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int ans = 0;
        char[] buf4 = new char[4];
        int idx = 0;
        while(true) {
            int cnt = read4(buf4);
            if(cnt==0){
                break;
            }else{
                for(int i=0;i<cnt && idx<n;i++){
                    buf[idx++] = buf4[i];
                }
                ans += cnt;
                if(ans>=n){
                    ans = n;
                    break;
                }
            }
        }
        return ans;
    }
}
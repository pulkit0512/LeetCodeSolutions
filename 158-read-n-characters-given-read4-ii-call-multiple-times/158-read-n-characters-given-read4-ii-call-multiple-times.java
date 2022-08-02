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
    char[] buf4 = new char[4];
    int bytesRead = 0, bufPtr = 0;
    public int read(char[] buf, int n) {
        int idx = 0;
        while(idx<n){
            while(bufPtr<bytesRead && idx<n){
                buf[idx++] = buf4[bufPtr++];
            }
            if(idx==n){
                break;
            }
            bytesRead = read4(buf4);
            bufPtr = 0;
            
            if(bytesRead==0){
                break;
            }
            while(bufPtr<bytesRead && idx<n){
                buf[idx++] = buf4[bufPtr++];
            }
        }
        return idx;
    }
}
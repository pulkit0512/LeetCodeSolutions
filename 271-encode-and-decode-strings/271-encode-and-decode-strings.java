public class Codec {

    //Approach1: Using Non Ascii Value
    /*// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String ch258 = String.valueOf((char)258);
        if(strs.isEmpty()){
            return ch258;
        }
        String ch257 = String.valueOf((char)257);
        StringBuilder encode = new StringBuilder();
        for(String str:strs){
            encode.append(str);
            encode.append(ch257);
        }
        encode.deleteCharAt(encode.length()-1);
        return encode.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String ch258 = String.valueOf((char)258);
        if(s.equals(ch258)){
            return new ArrayList<>();
        }
        String ch257 = String.valueOf((char)257);
        return Arrays.asList(s.split(ch257, -1));
    }*/
    
    //Approach2: Using Chunk Transfer encoding
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for(String str:strs) {
            encode.append(intToString(str));
            encode.append(str);
        }
        return encode.toString();
    }
    
    private String intToString(String str) {
        int len = str.length();
        char bytes[] = new char[4];
        for(int i=3;i>=0;i--){
            bytes[i] = (char)((len>>((3-i)*8)) & 0xff);
        }
        return String.valueOf(bytes);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decode = new ArrayList<>();
        int n = s.length();
        int i = 0;
        while(i<n){
            int len = stringToInt(s.substring(i, i+4));
            i += 4;
            decode.add(s.substring(i, i+len));
            i += len;
        }
        return decode;
    }
    
    private int stringToInt(String s) {
        int res = 0;
        for(int i=0;i<4;i++){
            res = (res<<8) + (int)s.charAt(i);
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
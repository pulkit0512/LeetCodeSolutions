public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for(String str:strs) {
            int len = str.length();
            for(int i=0;i<len;i++){
                encode.append((int)str.charAt(i)).append('_');
            }
            if(len>0){
                encode.deleteCharAt(encode.length()-1);
            }else{
                encode.append('0');
            }
            encode.append(' ');
        }
        //System.out.println(encode);
        return encode.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] strs = s.split(" ");
        List<String> decode = new ArrayList<>();
        for(String str:strs) {
            String[] chars = str.split("_");
            char[] val = new char[chars.length];
            if(chars[0].equals("0")){
                decode.add("");
                continue;
            }
            for(int i=0;i<chars.length;i++){
                val[i] = (char)(int)Integer.valueOf(chars[i]);
            }
            decode.add(String.valueOf(val));
        }
        return decode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
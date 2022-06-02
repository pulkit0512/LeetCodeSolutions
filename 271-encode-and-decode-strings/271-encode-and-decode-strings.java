public class Codec {

    //Approach1: Using Non Ascii Value
    // Encodes a list of strings to a single string.
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
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
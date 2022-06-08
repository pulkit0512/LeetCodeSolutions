class Solution {
    public String addBoldTag(String s, String[] words) {
        int n = words.length;
        if(n==0){
            return s;
        }
        int size = s.length();
        List<int[]> pairs = new ArrayList<>();
        for(int i=0;i<n;i++){
            int len = words[i].length();
            int prev = 0;
            while(true){
                int val = s.indexOf(words[i], prev);
                if(val<0){
                    break;
                }
                pairs.add(new int[]{val, val+len});
                prev = val+1;
            }
        }
        Collections.sort(pairs, (a,b) -> a[0]-b[0]);
        Stack<int[]> st = new Stack<>();
        for(int i=0;i<pairs.size();i++){
            if(st.isEmpty() || st.peek()[1]<pairs.get(i)[0]){
                st.push(pairs.get(i));
            }else{
                if(st.peek()[1]<pairs.get(i)[1]){
                    st.peek()[1] = pairs.get(i)[1];
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        int prev = 0;
        for(int[] pair : st) {
            ans.append(s.substring(prev, pair[0]));
            ans.append("<b>");
            ans.append(s.substring(pair[0], pair[1]));
            ans.append("</b>");
            prev = pair[1];
        }
        ans.append(s.substring(prev, size));
        return ans.toString();
    }
}
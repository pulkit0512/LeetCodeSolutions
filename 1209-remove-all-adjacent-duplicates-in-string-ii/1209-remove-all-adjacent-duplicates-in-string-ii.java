class Solution {
    class Pair{
        char ch;
        int cnt;
        public Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> freqStack = new Stack<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(freqStack.isEmpty() || freqStack.peek().ch!=ch){
                freqStack.push(new Pair(ch, 1));
            }else{
                if(freqStack.peek().cnt==k-1){
                    freqStack.pop();
                }else{
                    freqStack.peek().cnt++;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!freqStack.isEmpty()) {
            Pair p = freqStack.pop();
            for(int i=0;i<p.cnt;i++){
                ans.append(p.ch);
            }
        }
        return ans.reverse().toString();
    }
}
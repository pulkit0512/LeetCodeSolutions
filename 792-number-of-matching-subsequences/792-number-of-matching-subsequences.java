class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] charMap= new ArrayList[26];
        for(int i=0;i<26;i++){
            charMap[i] = new ArrayList<>();
        }
        int len = s.length();
        for(int i=0;i<len;i++){
            charMap[s.charAt(i)-'a'].add(i);
        }
        /*for(int i=0;i<5;i++){
            System.out.println(charMap[i]);
        }*/
        int ans = 0;
        for(String word:words){
            int wLen = word.length();
            int idx = -1;
            for(int i=0;i<wLen;i++){
                char ch = word.charAt(i);
                idx = binarySearch(charMap[ch-'a'], idx+1);
                if(idx==-1){
                    break;
                }
            }
            if(idx!=-1){
                ans++;
            }
        }
        return ans;
    }
    
    private int binarySearch(List<Integer> indexList, int idx) {
        int st = 0, ed = indexList.size()-1;
        int val = -1;
        while(st<=ed){
            int mid = (st+ed)/2;
            if(indexList.get(mid)<idx){
                st = mid+1;
            }else if(indexList.get(mid)>idx){
                val = indexList.get(mid);
                ed = mid-1;
            }else{
                val = indexList.get(mid);
                break;
            }
        }
        return val;
    }
}
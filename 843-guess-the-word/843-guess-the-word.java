/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> words = Arrays.asList(wordlist);
        Random rand = new Random();
        for(int i=0, match=0;i<10 && match!=6;i++){
            String word = words.get(rand.nextInt(words.size()));
            match = master.guess(word);
            if(match==6){
                break;
            }
            List<String> tempWords = new ArrayList<>();
            for(String s:words){
                if(match==getMatch(s, word)){
                    tempWords.add(s);
                }
            }
            words = tempWords;
        }
    }
    
    private int getMatch(String s, String word){
        int match = 0;
        for(int i=0;i<6;i++){
            if(s.charAt(i)==word.charAt(i)){
                match++;
            }
        }
        return match;
    }
}
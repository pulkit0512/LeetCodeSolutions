class Solution {
    // If there was no restriction on getting the minimum length which will guarantee to unlock the safe
    // then answer would be concatenation of all k^n permuations of string.
    // But we need to return the minimum length which guarantee to crack the safe. So we still need all K^N
    // permutations to be concatenated but in a greedy way.
    // What we can do to generate the next permuation we can use the last n-1 characters and
    // append a new character. This will create a permutation and to make sure that this permutation already
    // doesn't exist in the answer string. We keep a set of already existing permutations.
    // We stop the DFS once visited set size becomes equal to the k^n. At this point we have 
    // smallest string that has all k^n permutations in it.
    // We start with all 0 string of length n.
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // starting permuation of all 0's.
        for(int i=0;i<n;i++){
            sb.append('0');
        }
        // total permutations.
        int total = (int)Math.pow(k,n);
        // Visited set to contains existing permutations.
        HashSet<String> visitedSet = new HashSet<>();
        visitedSet.add(sb.toString());
        if(crackSafeHelper(sb, visitedSet, n, k, total)){
            return sb.toString();
        }
        return "-1";
    }
    private boolean crackSafeHelper(StringBuilder sb, Set<String> visitedSet, int n, int k, int total){
        // We have all permuations return now.
        if(total == visitedSet.size()){
            return true;
        }
        
        // Get the last n-1 characters from string to get next permuation.
        String temp = sb.substring(sb.length()-(n-1)).toString();
        for(int i=0;i<k;i++){
            char ch = (char)(i+'0');
            // Create new permuation by appending one character to last n-1 existing characters.
            String newStr = temp + ch;
            // If permutation already doesn't exist.
            if(!visitedSet.contains(newStr)){
                visitedSet.add(newStr);
                sb.append(ch);
                if(crackSafeHelper(sb, visitedSet, n, k, total)){
                    return true;
                }
                
                // backtrack
                visitedSet.remove(newStr);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return false;
    }
}
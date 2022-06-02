class Solution {
    public long wonderfulSubstrings(String word) {
        //store count of all faced bitmask combinations from 0b0000000000 to 0b1111111111
        // since we have 10 chars in our input 'a'-'j'
        int count[] = new int[1024];
        int mask = 0;
        long res = 0;
        // count[0] = 1 represent empty string indicating mask 0 happened once.
        count[mask] = 1;
        int len = word.length();
        
        // iterate over each char one pass, and 
        // a) find mask value at current position
        // b) count substrings with all even occurences
        // c) count substrings with just 1 odd occurence
		// d) update count array to increment the number of occurence we saw the mask by 1
        for(int i=0;i<len;i++){
            //Check for even substring
            
            //if we faced  the same bitmask once, that means substring between prev. bitmask and curr. bitmask
            //contains only even number of changes for all characters 'a' through 'j'
            
            //if we faced the same bitmask two or more times, then let's add all substrings started in
            //prev. occurrences and finished at curr. occurrence
            
            mask = mask^(1<<(word.charAt(i)-'a'));
            res += count[mask];
            
            //in the same manner, check all faced occurrences of bitmasks with just one odd bit difference
            //and count corresponding substrings started there and finished with current bitmask
            
            for(int j=0;j<10;j++){
                // check for unseend substrings with atmost one char as odd count from a-j
                res += count[mask^(1<<j)];
            }
            // increment the mask count to mark this string as processed
            count[mask]++;
        }
        return res;
    }
}
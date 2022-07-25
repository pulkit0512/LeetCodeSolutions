## Approach: Sliding window
* Created frequency map of string t.
* Then used sliding window on S to get the minimum substring of S that contains all characters of T. If found a substring having all the characters of T. From start pointer remove the characters which are not needed in this substring to get a minimum window.
​
### Time Complexity: O(M+N)
### Space Complexity: O(1), Since at max 52 characters can be there in map.
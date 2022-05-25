**Approach: HashMap**
In this, I have used a map to keep count of each domain. First for each cpdomain split on space to get count and domain. After that until that domain is not empty update freq of domain in map. Update domain with substring after index of '.' if no more parent domain is present in string set domain to empty string.
Iterate over the map and ans concatenated strings of key value pair.
​
**Complexity Analysis**
​
**Time Complexity: O(N*L)**, where N is the length of cpdomains, and L is the length of cpdomains[i].
​
**Space Complexity: O(N)**, the space used in our count.
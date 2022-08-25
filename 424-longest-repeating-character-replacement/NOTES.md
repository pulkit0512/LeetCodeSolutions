## Approach:
* Find all the chars present in the input string.
* For each char present in the input, try to find the maximum substring with k replacements with current char.
* Once consume all the k replacements check if this is the maximum substring till now or not.
* Also start moving the st pointer untill we remove one of the consumed replacement.
​
### Time Complexity: O(Number of unique Chars x Len) = O(Len) since unique chars will be atmost 26.
### Space Complexity: O(1)
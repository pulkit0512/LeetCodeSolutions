## Approach:
* Group pure suffix by the first character.
* Now we try to swap two characters trying all combinations of prefix groups. And creating a set for particular combination having unique suffixes which indicates these combinations will result in duplicate.
* Number of distinct names will be twice of (set size- groups[i] size) * (set size - groups[j] size).
​
### Time Complexity: O(N), N is number of words
### Space Compexity: O(N)
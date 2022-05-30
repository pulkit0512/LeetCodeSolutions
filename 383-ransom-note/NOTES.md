## Approach: Using array
In this approach, I have an integer array of size 26 since it was given only lower case characters are allowed, to keep frequency of each character in magazine string. Then iterated over ransomNote String and checked if frequency of current char is greater then 0 or not. If not return false else decrement the frequency of current char and move ahead.
​
### Complexity Analysis
​
* We'll say m is the length of the magazine, and n is the length of the ransom note.
​
* Also, let k be the number of unique characters across both the ransom note and magazine. While this is never more than 26, we'll treat it as a variable for a more accurate complexity analysis.
​
* **Time Complexity : O(m).**
​
* When m < n, we immediately return false. Therefore, the worst case occurs when m ≥ n.
* Creating a int arr of counts for the magazine is O(m), as each count update is O(1), and is done for each of the m characters.
* We then iterate over the ransom note, performing an O(1) operation for each character in it. This has a cost of O(n).
* Becuase we know that m ≥ n, again this simplifies to O(m).
​
* **Space Complexity : O(1).**
## Approach:
* In this question I have calcualted frequency of each number in input array and stored in frequency array. Now using 3 pointer approach if map[i], map[j] and map[k] != 0 Then check is i+j+k is target if yes then
* if all three are equal ans += map[i] C 3
* if any two are equal ans += map[i] C 2 * map[j] C 1 or map[i] C 2 * map[k] C 1 or map[j] C 2 * map[i] C 1.
* If all three are different ans+ = (map[i] C 1) * (map[j] C 1) * (map[k] C 1)
* Implement mod at each mathematical operation. Also if i, j or k points to 0 freq in map then update these pointers.
​
### Complexity Analysis
* **Time Complexity: O(N^2),** where N is the length of A.
* **Space Complexity: O(N).**
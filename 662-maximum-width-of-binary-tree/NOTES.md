## Approach: BFS
* Treat each node as an index in array.
* We need each level information so will use BFS to iterate over each level at time.
* For each node at index i it's children will be at index 2 * i, 2 * i + 1.
* For each level get the first index that is peek of each element and index of last tree node in the same level.
* Number of nodes possible in that level will be equal to lastIndex-firstIndex+1.
* Return maximum nodes in any level.
​
### Time Complexity: O(N)
### Space Complexity: O(N)
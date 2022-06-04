## Approach:
Used sorting to sort intervals in ascending order on the basis of start time if not equal and if equal sorted them on end time in descending order. For each interval pushed into stack if not empty or covered. Return stack size as answer.
​
### Complexity Analysis
* **Time complexity : O(NlogN) since the sorting dominates the complexity of the algorithm.**
* **Space complexity : O(N), size of stack**
* **In Java, the Arrays.sort() is implemented as a variant of quicksort algorithm whose space complexity is O(logN).**
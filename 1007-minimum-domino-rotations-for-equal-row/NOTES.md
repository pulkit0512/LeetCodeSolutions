## Approach1:
Used 3 arrays of size 7. First two is used to store the freq of each number in top and bottom array. Other third array is used to store freq of elements present at same position in both array since for these no swap is needed.
Once frequency is calculated if topFreq[i]+bottomFreq[i]-commonFreq[i]==length then minimum swaps will be updated if more then min(topFreq[i], bottomFreq[i]) - commonFreq[i].
​
## Approach2:
Only one domino element was checked here, and still it's enough because the rotation is the only allowed operation here.
**Algorithm**
1. Pick up the first element. It has two sides: A[0] and B[0].
2. Check if one could make all elements in A row or B row to be equal to A[0]. If yes, return the minimum number of rotations needed.
3. Check if one could make all elements in A row or B row to be equal to B[0]. If yes, return the minimum number of rotations needed.
4. Otherwise return -1.
​
### Time Complexity: O(N)
### Space Complexity: O(1)
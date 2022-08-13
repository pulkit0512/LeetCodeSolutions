## Approach: Union Find
* Using union find, for each edge create a union between the two if not connected yet and reduce the connected component numbers by 1. And if already connected then there is a cycle return false becuase tree can't have a cycle.
* If in the end we have one connected component then it is a valid tree.
​
### Time Complexity: O(N x @(N)), @(N) is inverse Ackerman function which takes almost constant time.
### Space Complexity: O(N)
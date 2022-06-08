## Approach:
Used 3 arrays of size 7. First two is used to store the freq of each number in top and bottom array. Other third array is used to store freq of elements present at same position in both array since for these no swap is needed.
Once frequency is calculated if topFreq[i]+bottomFreq[i]-commonFreq[i]==length then minimum swaps will be updated if more then min(topFreq[i], bottomFreq[i]) - commonFreq[i].
​
### Time Complexity: O(N)
### Space Complexity: O(1)
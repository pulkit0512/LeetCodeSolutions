## Approach: Treeset
* Maintain a treeset. Find successor and predecessor of current element
* If successor not null and less then right boundary i.e. nums[i]+t return true.
* If predecessor not null and greater then left boundary i.e. nums[i]-t reurn true.
* Else add current element to set. If set size greater then k remove nums[i-k] from it.
​
### Time Complexity: O(NLog(min(N,K))
### Space Complexity: O(min(N,K))
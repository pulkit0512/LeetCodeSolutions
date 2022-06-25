## Approach:
* In this question, I have a intution if we have a decreasing trend then for both points making this edge are candidates for modification. If we can modify atmost one of them and get a non-decreasing trend then it's possible to go ahead and check. Else return false from here.
```
I am considering a Integer.MIN_VALUE at index -1 and Integer.MAX_VALUE at index n.
if(nums[i]<nums[i+1]) // indicating a downward trend
then if(nums[i+1]>=nums[i-1] || nums[i]>=nums[i-2])
then we can modify atleast one of the point to get the increasing trend upto current index.
Else we need to modify both points so return false.
```
​
### Time Complexity: O(N)
### Space Complexity: O(1)
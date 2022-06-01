## Approach1: Using LIS
* Calculate LIS
* Reverse Array
* Calculate LIS, this will be LDS
* Calculate min removals and answer will be max of LIS[i]+LDS[i]-1 only is LIS[i]>1 and LDS[i]>1.
* return ans.
* To caculate LIS we can use N^2 or NLogN approach.
​
### Time Complexity: O(NLogN or N^2) based on LIS Approach
### Space Complexity: O(N).
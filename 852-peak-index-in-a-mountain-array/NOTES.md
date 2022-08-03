## Approach:
* Binary search on given array.
* If we have downward slope for mid-1, mid, mid+1 then peak is in left.
* Else if we have upward slope from mid-1, mid, mid+1 then peak is in right.
* Else we found the peak.
​
### Time Complexity: O(LogN)
### Space Complexity: O(1)
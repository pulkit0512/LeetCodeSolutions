## Approach: Sweep Line Algorithm, Boundary Value Count
* In this, for each employee iterated over the intervals and incremented the value from start boundary of interval in treemap and decremented the value from end boundary of interval in treemap.
* Once we are done with the boundary value counts for all employees intervals.
* Iterate over the map entrySet and do prefix sum on the values. If sum is 0 this indicates all employees are free starting from this point, so this key becomes start of interval.
* As soon as sum becomes non-zero and we had found the start then, current key becomes end of the interval, since one or more employee becomes busy at this time.
* Add this interval to the final result. Reset the start.
* Traverse the complete entrySet in similar way.
​
### Time Complexity: O(NLogN), N = Number of total intervals and LogN for each insertion in TreeMap.
### Space Complexity: O(N)
## Approach: Merged Interval using TreeMap
*  In this, I have used a tree map to merge intervals.
*  When a new interval is being added to the tree map, first check the floorKey and floorVal can be merged to current interval.
*  while we can merge intervals update the boundaries of current interval, remove floor interval from map and update count of integer by removing number of integers from floor interval.
*  Once we reach a point where we can't merge any more intervals break out and add update current interval to map and update count by adding number of intergers in current interval.
*  For count call, return count.
​
###
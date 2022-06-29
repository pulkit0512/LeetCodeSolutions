## Approach
* We first try to place tallest people with ascending K values at K indexes. Then move to the second largest height and start placing people at K indexes by shifting all the other people from that current person K value to till end to one place ahead. Now current K value position is empty place current person at this index.
* Sort people:
* In the descending order by height.
* Among the guys of the same height, in the ascending order by k-values.
* Take guys one by one, and place them in the output array at the indexes equal to their k-values.
* Return output array.
​
### Time Complexity: O(N^2), sort takes NLogN
### Space Complexity: O(N) for output
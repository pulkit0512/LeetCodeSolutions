## Approach: Cyclic Sort
* For all positive integer num try to place them at index num-1. We can do this using cyclic sort swaping untill current num reaches to index num-1.
* Once done iterater over the modified array and return (index+1) for first index whose value is not equal to index+1.
* If all numbers are present at correct index return n+1.
​
### Time Complexity: O(N)
### Space Complexity: O(1)
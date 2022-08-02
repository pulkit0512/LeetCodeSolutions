## Approach:
* Maximum subarray length of two distinct integers.
* Two pointers approach, Keep a frequency map or two element counters.
* Use a start pointer and iterator pointer, untill we are getting atmost 2 distinct character keep increasing there frequencies. Once we get a third integer, update ans with max (ans, i-st)  then start decreasing the frequency of element pointed by the start pointer untill it's frequency of anyone of the element becomes zero. Then remove that element and start using current element as new counter.
* Return the maximum length of two distinct integers.
​
### Time Complexity: O(N)
### Space Complexity: O(1), since at a time at max two enteries will be present in map.
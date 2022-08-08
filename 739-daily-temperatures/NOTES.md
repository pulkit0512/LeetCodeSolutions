## Approach1: Monotonic Stack
* Monotonic Stack to find next greater element in right.
​
### Time Complexity: O(N)
### Space Complexity: O(N)
​
## Approach2: Constant Space
* In this approach, we move backwards, and to calculate current day answer we will answer array formed till now.
* We use a variable day, initialized with 1 to check in right which day will be warmer.
* For current day, first check the next day if it is warmer then current day then we found the answer else the answer for next day will tell which day in future is warmer then next day.
* Since next day temperature's warmer day we can skip all the middle days since they are cooler then next day they will be cooler for current day as well.
* So day will be jump to answer[curDay + day]. day += answer[curDay + day].
* If curDay temperature is hottest temperature till now we no answer for this will be zero, so we update the hottest temperature and continue.
​
### Time Complexity: O(N)
### Space Complexity: O(1)
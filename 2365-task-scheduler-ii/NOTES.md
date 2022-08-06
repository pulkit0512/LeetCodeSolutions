## Approach:
* Create a map of Task vs last execution day.
* Also keep track of current day.
* If current task is already been executed once. And it has not passed the break time then increment number of days to the last day upto which current task can't be executed.
* Update current task last execution day with current day
* Return total number of days it took.
​
### Time Complexity: O(N)
### Space Complexity: O(N)
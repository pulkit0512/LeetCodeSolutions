## Approach1: PriorityQueue
* Sort the courses on the last time
* Use priority queue as max heap to store the courses which we have considered so far.
* If cur course duaration + duration of courses we have selected till now less then equal to last time of current course add it's duration to total duration and also store it's duration in pq.
* If cur course duration + duration of courses till now is greater then last time of cur course then if we have a course duration in pq i.e. is peek of pq which is greater then cur course duration then we remove that course from selection and add cur course to que. Update total duration accordingly.
* Return pq size as final ans.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(N)
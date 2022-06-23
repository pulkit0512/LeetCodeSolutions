## Approach1: PriorityQueue
* Sort the courses on the last time
* Use priority queue as max heap to store the courses which we have considered so far.
* If cur course duaration + duration of courses we have selected till now less then equal to last time of current course add it's duration to total duration and also store it's duration in pq.
* If cur course duration + duration of courses till now is greater then last time of cur course then if we have a course duration in pq i.e. is peek of pq which is greater then cur course duration then we remove that course from selection and add cur course to que. Update total duration accordingly.
* Return pq size as final ans.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(N)
​
## Approach2:
* Sort the courses on end time.
* I am using two variables sum and cnt to keep track of total duration of selected courses till now and number of courses selected till now.
* if we can select current course, i.e. current course duration + total duration <= current course end time. Update the total duration and set course[cnt] = course[i] and update cnt.
* If we can't select the current course due to end time duration constraint we will find a course in selected courses whose duration is maximum of all courses duration and greater then current course duration.
* If exist remove that course and add current course and removed course index.
* return cnt as answer.
​
### Time Complexity: O(N*Count)
### Space Complexity: O(1)
## Approach: DP
* In this, if number of jobs is less then number of days to complete all jobs then return -1. Since we need to do atleast one job everyday.
* Else our base case if for the last day we need to complete all the remaining jobs and difficulty for that day will be maximum of all remaining jobs from particular job index.
* Once we have our base case, move from day-1 to 0 and for each day range of job will be [day-1, len-(totalDays-day)) and we try to find the hardest job in this range with another nested loop.
* Then dp[i][day] is min of (dp[i][day], hardestJob upto index j + dp[j+1][day+1]).
* Answer will be at dp[0][1] which means starting from 0 index at day 1 minimum difficulty we can have.
* **DP[i][j] means starting from job i at day j minimum difficulty we can have.**
​
### Time Complexity: O(Len x Len x days), where Len is number of jobs.
### Space Complexity: O(Len x days)
## Approach1: DP
* Create a jobData array having details of start time, end time and profit for each job. Sort this jobData array on the basis of start time.
* Iterate over the jobs from right to left and find the profit we can have from current job.
* For this we find the first job in right of current index whose start time >= end time of current job. So that we can add current job to that list.
* Current profit will be profit by current job and profit sum for the right job from dp array.
* Store result in dp array, if by schedulling current job profit is more then without schedulling this job.
* dp[i] = max(curProfit, dp[i+1])
* return dp[0].
​
## Approach2: Priority Queue
* Create a jobData array having details of start time, end time and profit for each job. Sort this jobData array on the basis of start time.
* Create a priority queue having end time and profit for all conflicting job lists.
* Sort the priority queue on the end time.
* Iterate over the jobs from left to right. For current job remove all the jobs from priority queue which are not conflicting with this job. That is start time of current job >= end time of jobs in priortiy queue.
* This is done because current job will be appended to one of these non conflicting job lists.
* Also for job each popped job keep track of maxProfit.
* Once done with this, combine the current job to maxProfit job list. That is add a new entry in priority queue with end time as current job end time and profit as current job profit + maxProfit from all popped jobs.
* After the iterating over all the jobs, priority queue will have all conflicting merged jobs. Find the maximum profit from these conflicting merged jobs.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(N)
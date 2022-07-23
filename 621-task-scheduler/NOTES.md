## Approach1: Priority Queue
* Create a frequency array of each task. And store the final frequency of each task in max heap priority queue.
* Calculate the time taken to complete all tasks considering cooldown period.
* Untill priority queue is not emepty try to fetch n+1 elements from priority queue if present and increment time accordingly if size of priority queue size is less then n+1 then add remaining idle_slots+1 to time.
* Store polled elements back to priority queue.
* Return total time.
​
## Approach2: Sorting
* Create a frequency array of each task. Sort the frequency array.
* Get the max frequency, so maximum idle_time can be (fMax-1) x N, this is max time needed to complete maximum frequency task with N as cooldown.
* iterate over the frequency array and decrease the idle time with number of idle slots that can be filled with current task.
* total time will number of tasks + Math.max(0, idle_time)
​
### Time Complexity: O(N), number of tasks
### Space Complexity: O(26) = O(1), atmost 26 upper characters.
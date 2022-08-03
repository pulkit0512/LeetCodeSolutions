## Approach1: Sorting + Min Heap
* Sort Arrays on start time.
* Create a min heap on end time.
* If current interval start time >= pq.peek() i.e. start time of next meeting greater then end time of previous meeting.
* we can use previous room for current meeting as well. So poll that meeting end time out.
* Push current meeting's end time to priority queue.
* Size of pq in the end will be the number of seperate rooms needed for all meetings.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(N)
​
## Approach2: Using Chronological Ordering
* From the intervals, create two arrays, one for startTime and other for endTime.
* Sort both the arrays, now we have startTime sorted array and endTime sorted array.
* Use two pointers to iterate over start time and end time arrays.
* if(startTime[sPtr] >= endTime[ePtr]), then we can free one room and ePtr moves ahead.
* use one room for current start time meeting and move sPtr ahead.
* Once sPtr reaches end, number of rooms used will be the answer.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(N)
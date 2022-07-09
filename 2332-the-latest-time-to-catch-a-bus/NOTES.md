## Approach: Greedy
* Use greedy approach to assign passengers to buses, by sorting the passengers and buses.
* Assign add the time of passengers that can take any bus in the list and also keep track of capacity of a bus. If bus is full remaining passengers will onboard next bus if any.
* And also keep track of bus arrival time and passenger arrival time since passenger can onboard future buses only.
* Once we get list of all onboarded passengers then we need to find largest missing positive integer. This will be our potential answer.
* In worst case our potential answer is 1, according to constraints input arrival times start from 2.
* Also we need to check if we can assign any bus arrival time as answer if no person arrived at that time and bus arrival time is greater then our existing potential answer. Since we need to return the largest possible answer. **This can only be done for those buses whose onboarded passengers count are less then the capacity. Since we are giving upper bound value of the interval, if capacity already full answer can't be the upper bound.**
​
​
### Time Complexity: O(NLogN), due to sorting
### Space Complexity: O(N)
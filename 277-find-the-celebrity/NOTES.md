## Approach1: Brute Force
* For each individual, goes to all other individuals and check if current individiual is celeb or not.
* To check if current individual is celeb or not check if current individual knows other one or other one doesn't know current individual then current individual is not celeb.
​
### Complexity Analysis
​
* We don't know what time and space the knows(...) API uses. Because it's not our concern, we'll assume it's O(1) for the purpose of analysing our algorithm.
​
* **Time Complexity : O(n^2).**
​
* For each of the n people, we need to check whether or not they are a celebrity.
* Checking whether or not somebody is a celebrity requires making 2 API calls for each of the n - 1 other people, for a total of 2⋅(n−1)=2⋅n−2 calls. In big-oh notation, we drop the constants, leaving O(n).
* So each of the n celebrity checks will cost O(n), giving a total of O(n^2).
​
* **Space Complexity : O(1).**
* Our code only uses constant extra space. The results of the API calls are not saved.
​
## Approach 2: Logical Deduction
* In this approach, I have used a deduction. If A knows B then A is definitely not a celeb else B is not a celeb.
* We start with assuming 0 as a celeb and then for all individual 1 to n-1 will check if celeb know i, if yes then update celeb as i. After the end of this iteration celeb is the only potential answer.
* Then with one more iteration we can check if celeb is real answer or not. By doing similar thing what I did in above approach for all individuals.
* So in this approach instead of making N^2 calls, we first find potential celeb in N-1 calls and then with 2*(N-1) calls we verify weather this is correct or not.
​
### Complexity Analysis
​
* **Time Complexity : O(n).**
* Our code is split into 2 parts.
* The first part finds a celebrity candidate. This requires doing n−1 calls to knows(...) API, and so is O(n).
* The second part is the same as before—checking whether or not a given person is a celebrity. We determined that this is O(n).
* Therefore, we have a total time complexity of O(n + n) = O(n).
​
* **Space Complexity : O(1).**
* Same as above. We are only using constant extra space.
​
#### We are assuming this knows function call to be O(1) but in case it is DB call we can create a cache at application layer and store the results of knows call in that. And is knows call is repeated we can return the data cache, instead of making real call.
**In this cache implementation space complexity will become O(N) for caching and time complexity remains O(N)**
**For caching we can overide the knows method which now have a cache as well if entry present in cache return the value from cache else make super.knows call to get the data and cache it.**
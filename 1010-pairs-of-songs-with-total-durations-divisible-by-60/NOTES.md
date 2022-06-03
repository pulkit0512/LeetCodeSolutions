## Approach: Using Array to store frequency
* In this approach, I have used an array to store the frequency time%60. At each index calculate the time%60 if it's 0 add the frequency of 0 to the answer since this index can pair with each of the member we have visited before with same frequency. And if it's not 0 then add the frequency of (60-val) for the same reason to the answer. Update the frequency of time%60.
​
### Algorithm
* We would initiate an array remainders with size 60 to record the frequencies of each remainder - as the range of remainders is [0,59] Then we can loop through the array once and for each element a we would:
* if a % 60=0, add remainders[0] to the result; else, add remainders[60 - a % 60] to the result;
* update remainders[a % 60].
​
### Complexity Analysis
* **Time complexity: O(n),** when n is the length of the input array, because we would visit each element in time once.
* **Space complexity: O(1), because the size of the array remainders is fixed with 60.**
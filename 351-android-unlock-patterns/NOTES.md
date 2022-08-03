## Approach:
* Create a matrix of 10, 10. Where we will store the middle element of index i, j.
* middle[1][3] = middle[3][1] = 2
* So once this middle matrix is created, and we have visited array to keep track of visited numbers in pattern find the accepted patterns.
* For this we will find accepted patterns starting from num 1. which will be same for 3, 7, 9 as well. So directly multiply by 4.
* Also patterns starting from num 2, will be same for 4, 6, 8 do directly multiply by 4.
* Apart from this, find patterns for num 5.
* In backtracking if length of pattern >= m increment the accepted patterns. And if len>n return accepted patterns.
* Mark current num visited, Iterate over 1 to 9 for next num. If next num not visited and midlle of num and i is 0 or already visited then make next recursive call.
* Once done backtrack and unmark the visited node.
​
​
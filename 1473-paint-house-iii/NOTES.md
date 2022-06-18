## Approach: Memoization DP
* In this approach, I have used memoization where base case is if we reach last house and if number of neighbours becomes equal target return 0 else return INT_MAX.
* If already result calculated and present in DP return the value.
* If house already painted and then we don't add any cost.
* If painted house color is same as previous painted then we don't increment the number of neighbourhoods else increment the neighbourhoods and make recursive call.
* Else house not painted already we try to paint it with all the given paints to get the minimum cost to paint upto this house. If color is same as previous color don't increment neighbourhood else increment and make recursive call.
* Store the result in DP and return
​
### Time Complexity: O(MxTxNxN)
### Space Complexity: O(MxTxN)
* M: Number of houses
* T: Number of target neighbourhoods
* N: Number of colors
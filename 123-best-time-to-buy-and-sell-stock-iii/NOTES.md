## Approach1: Using N Space
* In this, I am using bi-directional DP. From left to right I am checking minLeft and maxLeft so far. When price[i] greater then maxLeft then update maxLeft but when price[i] is less minLeft update both minLeft & maxLeft since this will become the new buying point. Calculate profit for left dp which will be max of left[i-1] or maxLeft-minLeft.
* Similarly for right DP check minRight and maxRight, if price[i] less then minRight update minRight, if price[i] greater then maxRight update both minRight and maxRight since this will be the new selling point. Calculate profit for right DP which will be max of right[i+1] or maxRight-minRight.
* Now return max of left[i]+right[i].
​
### Time Complexity & Space Complexity: O(N)
​
## Approach2: Using Constant Space
* In this approach, we consider this as a simulation game where we have t1_cost, t1_profit, t2_cost, t2_profit.
* Over the iteration, we calculate 4 variables which correspond to the costs or the profits of each action respectively, as follows:
* **t1_cost**: the minimal cost of buying the stock in transaction #1. The minimal cost to acquire a stock would be the minimal price value that we have seen so far at each step.
* **t1_profit**: the maximal profit of selling the stock in transaction #1. Actually, at the end of the iteration, this value would be the answer for the first problem in the series, i.e. Best Time to Buy and Sell Stock.
* **t2_cost**: the minimal cost of buying the stock in transaction #2, while taking into account the profit gained from the previous transaction #1. One can consider this as the cost of reinvestment. Similar with t1_cost, we try to find the lowest price so far, which in addition would be partially compensated by the profits gained from the first transaction.
* **t2_profit**: the maximal profit of selling the stock in transaction #2. With the help of t2_cost as we prepared so far, we would find out the maximal profits with at most two transactions at each step.
​
### Time Complexity: O(N)
### Space Complexity: O(1)
* **In both approaches I have first calculated number of zeros and ones in each string of given array.**
​
* **Approach1 DP using Memoization**
* In this approach I am using 3D array mem[i][j][k] which indiactes largest subset of strings starting from index i with atmost 'j' zeros and 'k' ones.
* If we reach end of array return 0. If for a recursive call of i, j, k already calculated the answer and we have a non zero-value stored in mem array then return that value.
* Now we will make recursive calls if possible taking current string in subset and without taking current string in subset. If we are able to chose current string in subset we make a recursive call for next string by decreasing zeros and ones with curent string zeros and ones.
* Once we have max length if we choose current string and if we don't choose then store max of both value in mem array for i, j, k.
​
* **Complexity Analysis**
* **Time complexity : O(l∗m∗n).** memomemo array of size l∗m∗n is filled, where l is the length of strs  and n are the number of zeroes and ones respectively.
​
* **Space complexity : O(l∗m∗n).** 3D array memomemo is used.
​
* **Approach2: Tabular DP.**
* In this approach I have used a 2D DP to store the size of subset of strings with atmost i zeros and j ones. I am iterating over binary array having number of zeros and ones at index i. Then going from m to binary[i][0] and then from n to binary[i][1].
* then dp[j][k] = Math.max(dp[j][k], dp[j-binary[i][0]][k-binary[i][1]] +1). Meaning either we are considering current string or rejecting it. If we are accepting current string then it will be 1 more then the dp[j-binary[i][0]][k-binary[i][1]].
* ans is in dp[m][n].
​
* **Complexity Analysis**
* **Time complexity : O(l∗m∗n).** memomemo array of size l∗m∗n is filled, where l is the length of strs  and n are the number of zeroes and ones respectively.
​
* **Space complexity : O(m∗n).** 2D DP array is used.
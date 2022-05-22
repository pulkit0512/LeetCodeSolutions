* **Approach:** In this question, I have used a map which will store the column the list of integers at that column. While making a left call from parent I am reducing the column val by 1 and while making a call to right I am increasing the column val by 1. Also Keeping the check on the min and max column so that we can get the range of columns stored in the map. Using BFS traveral in queue I am pushing TreeNode and column of that node.
* Once done with the BFS traversal. Iterate over the range and add the list from map to the ans list.
​
* **Complexity Analysis**
* **Time Complexity: O(N)** where N is the number of nodes in the tree.
​
* **Space Complexity: O(N)** where N is the number of nodes in the tree.
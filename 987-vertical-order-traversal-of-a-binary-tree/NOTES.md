## Approach: BFS
* Use a map to store the values in a particular vertical Level.
* For each vertical level, there will be a list of Pair<horLevel, node.val>. Which will be used to check whether 2 values belong to same row or not.
* Then we will apply BFS on the tree, with a queue which will have three values <TreeNode, verLevel, horLevel>.
* Whenever we have a new level/row then increment the horLevel.
* For a particular verLevel add horLevel and it's node val in map against verLevel as pair.
* left child will have verLevel as parentVerLevel-1 and right child will have parentVerLevel+1.
* Once BFS is completed, we iterate over the min to max vertical levels and for each level, sort the pair list based on given conditions of sorted values in case of same horizontal level.
* add values to verLevelList and then add the verLevelList to the answer list.
​
### Time Complexity: O(N Log(N/K)), Consider we have K groups of equal size. Then each group will have N/K elements. Sorting one group will have TC: O (N/K Log(N/K). So for K groups it is, O(N Log(N/K))
​
### Space Complexity: O(N), queue to have atmost N nodes.
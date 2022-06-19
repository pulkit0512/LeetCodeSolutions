## Approach:
1. In this first a created map of smallest abbrevations containing first and last char only vs index of strings having that abbrevation.
2. Once the grouping is done create a prefix tree for each group and then we start removing duplicacies from that particular group.
3. For a particular word in a group we move ahead in prefix tree untill the count of strings with that prefix becomes.
4. Once we find the node which has only 1 string with current prefix we abbrevate that string using current prefix.
5. Similarly resolve duplicacies from other groups as well by following step 3 & 4.
​
### Time Complexity: O(C) where C is the number of characters across all words in the given array.
### Space Complexity: O(C).
## Approach: Using List and Map
In this question, I have used a list to store all our elements. And Map to store the element with all it's indexes in the original list in a set so that we can update also in O(1).
​
### insert:
Append the element to the list and add the index to HashMap[element].
### remove:
0. If val not present return false.
1. From map get the index to be removed.
2. From list get the last element
3. Swap this index value with the last index of list value.
4. From map remove this index from val.
5. Udate the map for last element by adding the index got in step 1 and remove the last index of list.
6. Remove last element from list which is currently the val we want to remove since we have swapped it in step 3.
7. If map[val] is empty, remove val from map.
8. return true.
### getRandom:
Sample a random element from the list.
​
​
## Complexity Analysis
* **Time complexity : O(N)**, with N being the number of operations. All of our operations are O(1), giving N * O(1) = O(N).
* **Space complexity : O(N)**, with N being the number of operations. The worst case scenario is if we get N add operations, in which case our ArrayList and our HashMap grow to size N.
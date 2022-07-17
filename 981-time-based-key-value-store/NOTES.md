## Approach:
* Created a timeMap of key vs List<Pair<timestamp, value>>, since set is called with increasing timestamps only. If this was not given we would have used treeMap.
* For set, add the pair of timestamp, value in the list of given key.
* For get, fetch the list of timestamp, value and do binaysearch on this list for timestamp to return lower bound pair.
* String which above pair contains is the answer. In case nothing found return "".
​
### Time Complexity: for set O(1), for get O(LogN)
### Space Complexity: O(N), timeMap
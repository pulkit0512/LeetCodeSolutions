## Approach:
* DFS Solution with backtracking.
* Check if current string can become any other string from the bank with one change and that string is not yet visited.
* Then visit that gene from current string, make DFS call with this string as start string and increase the number of steps needed by 1.
* Once back from the DFS call reset the visited string.
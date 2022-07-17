## Approach: Graphs DFS
* Create an adjacency list: For each account add an undirected edge between the first email (accountFirstEmail) and each of the other emails in the account.
* Traverse over the accounts; for each account, check if the first email in the account (accountFirstEmail) was already visited. If so, then do not start a new DFS. Otherwise, perform DFS with this email as the source node.
* During each DFS, store the traversed emails in an array mergedAccount, also mark all these emails as visited.
* After the DFS traversal is over, sort the emails and add the account name (accountName) at the start of the vector mergedAccount.
* Store the vector mergedAccount in the answer list mergedAccounts.
​
### Time Complexity: O(NK LogNK), N = number of accounts and K = maximum length of an account
### Space Complexity: O(NK), Adjacency list, visited set and recursion stack use O(NK) space.
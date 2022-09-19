## Approach: HashMap
* Split each input string on spaces so that we can have directory string and files string with there content.
* First string in splitted array will be the directory.
* For each file content substring, fetch the file name and content using the index of '('.
* Once done stote dir/fileName at respective content key in map.
* Return all the keys list which are of atleast size 2.
​
### Time Complexity: O(N * X), N strings of length X.
### Space Complexity: O(N * X), map and ans size grows upto N * X.
​
## FOLLOW UPS
### BFS vs DFS
BFS explores neighbors first. This means that files which are located close to each other are also accessed one after another. This is great for space locality and that's why BFS is expected to be faster. Also, BFS is easier to parallelize (more fine-grained locking). DFS will require a lock on the root node.
​
### Very large files and false positives
For very large files we should do the following comparisons in this order:
* compare sizes, if not equal, then files are different and stop here!
* hash them with a fast algorithm e.g. MD5 or use SHA256 (no collisions found yet), if not equal then stop here!
* compare byte by byte to avoid false positives due to collisions.
​
### Complexity
* Runtime - Worst case (which is very unlikely to happen): O(N^2 * L) where L is the size of the maximum bytes that need to be compared
* Space - Worst case: all files are hashed and inserted in the hashmap, so O(H^2*L), H is the hash code size and L is the filename size
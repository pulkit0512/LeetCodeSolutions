## Approach: Trie, HashMap
* Used a trie based approach, since each dir will have multiple sub-directories. Also each directory will have a map containing fileName vs Content.
​
Here M = Length of path, N = depth of Dir
​
### FileSystem() , O(1)
* Create a root dir, with "" subDir.
​
### ls(String path), O(M+N, KLogK)
* Split the path.
* From the given path, using Trie from root dir goto the 2nd last subDir.
* Now check the last dirPath. If it is a file then return it's name as list. If it's directory go to that directory and return all the fileNames and subDir names in sorted order.
* In case of "/", check the contents of root dir.
​
### mkdir(String path), O(M + N)
* Split the path, and start creating directories if not already existed.
* Using trie move to the subDir and create furthe subDirs.
​
### addContentToFile(String path), O(M+N)
* Split the path, make call to mkdir for path excluding fileName.
* We will get the last directory where we want to update/add the file with input content.
* Update fileMap of current dir for given file with provided content.
​
### readContentFromFile(String path), O(M+N)
* Split the path, goto the subDir where the input file exist.
* From that dir fileMap return the content of input File.
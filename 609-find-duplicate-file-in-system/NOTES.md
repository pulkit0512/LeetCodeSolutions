## Approach: HashMap
* Split each input string on spaces so that we can have directory string and files string with there content.
* First string in splitted array will be the directory.
* For each file content substring, fetch the file name and content using the index of '('.
* Once done stote dir/fileName at respective content key in map.
* Return all the keys list which are of atleast size 2.
​
### Time Complexity: O(N * X), N strings of length X.
### Space Complexity: O(N * X), map and ans size grows upto N * X.
## Approach:
String implementation from right to left, convert all lowercase to uppercase. Once a group of K is formed append '-'. Also in end check if we have '-' as last character in case all groups are uniform then delete it. Return the reverse string. Use StringBuilder for this.
​
### Time Complexity: O(N)
### Space Complexity: O(N)
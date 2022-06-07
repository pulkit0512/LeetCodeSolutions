## Approach:
In this approach, used frequency array of size equal to max element. Then stored the frequency of each element in the frequency array. Calculate the GCD of freq array for all the indexes whose values is not 0. If GCD>=2 return true we can split the array into equal size same element groups. Else return false.
​
### Complexity Analysis
#### Time Complexity: O(N x Log^2 N), where N is the number of votes. If there are C_i cards with number i, then each gcd operation is naively O(log^2 C_i).
#### Space Complexity: O(N).
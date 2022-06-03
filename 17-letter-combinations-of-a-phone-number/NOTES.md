## Approach: Simple recursion
In this approach, I have used recusrion at each digit add one of the character map to the digit and then made call to next digit to get the all the possible combinations.
​
### Complexity Analysis
​
#### Time complexity: O(4^N x N), where N is the length of digits. Note that 4 in this expression is referring to the maximum value length in the hash map, and not to the length of the input.
​
The worst-case is where the input consists of only 7s and 9s. In that case, we have to explore 4 additional paths for every extra digit. Then, for each combination, it costs up to N to build the combination. This problem can be generalized to a scenario where numbers correspond with up to M characters, in which case the time complexity would be O(M^N x N). For the problem constraints, we're given, M=4, because of digits 7 and 9 having 4 letters each.
​
#### Space complexity: O(N), where N is the length of digits.
Not counting space used for the output, the extra space we use relative to input size is the space occupied by the recursion call stack. It will only go as deep as the number of digits in the input since whenever we reach that depth, we backtrack.
**As the hash map does not grow as the inputs grows, it occupies O(1) space.**
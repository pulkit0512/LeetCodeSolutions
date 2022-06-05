## Approach:
Count number of unbalanced open and closed brackets. And return ceil of (open+close)/4.
This done becuase in one swap we can fix at most for unbalanced brackets.
}}}}{{ == swap index 2 and 5 == }}{}{} == swap index 0 and 1 == {}{{}}2 swaps for 6 unbalanced brackets == ceil of 6/4.
​
### Time Complexity: O(N)
### Space Complexity: O(1)
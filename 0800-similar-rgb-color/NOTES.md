## Approach:
* Split the input color #ABCDEF into three sections AB, CD, and EF.
* For each section AB, we get the rounded value X of AB to 17, then the best fit for this section is XX.
* Once we find out the best fits for all three sections (Let's call them XX, YY, and ZZ), combine them into one RGB color code #XXYYZZ and this is the target color we want.
​
### Time Complexity: O(1)
### Space Complexity: O(1)
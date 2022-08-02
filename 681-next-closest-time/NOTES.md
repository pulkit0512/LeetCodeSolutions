## Approach:
* Store the digits from time string in an array of size 4 and sort it.
* One of the potential answer will smallest digit from all 4 as all digits in time. I.E. "ss:ss".
* Now for each index in time string we try to find if there is digit just greater then current index val. There will be certain checks as well.
* If checking for index 3 it's value can't be greater than or equal to 6.
* If checking for index 1 if index 0 value is 2 then index 1 can't have value greater or equal to 4.
* If checking for index 0 value can't be greater then 2.
* After passing all these condition for a given index if we found just greater digit. Current index will have that digit. All other digits to the left will have original value and all digits to right will have the smallest value.
​
### Time Complexity: O(1)
### Space Complexity: O(1)
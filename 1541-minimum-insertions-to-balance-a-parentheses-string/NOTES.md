## Approach:
* According to the description, we can have:
* for any (, there must have a corresponding )) in the remaining string
* for any ), there must have a corresponding ( in the previous string and a successive )
* We can summarize that there are totally 4 cases for a given string:
* ( and )), which is a vaild case
* ( and ), which means we must add a )
* only ), which meast we must add a ) and a (
* only )), which means we must add a (
* only (, which means we must add a ))
​
* So I have used open counter to keep track of number of unbalanced open and brackets. If at any index we get open bracket increment it's count. Else if we get single close bracket increment the answer. Else increment idx. After getting both close brackets if open==0 then we need to add one open bracket in the result else decrement open count since one open will be balanced out.
* In the end if still open unbalanced brackets add twice of open to the final answer.
​
### Time Complexity: O(N)
### Space Complexity: O(1)
## Approach:
* In the final end string all L's will be either at there current position or left of current position.
* all R's will be either at there current position or right of current position.
* So iterate over both strings untill we reach end of both.
* Increment the sPtr while we encounter X in start. Similarly increment the ePtr while we encounter X in end.
* If we reach end of both break out.
* If we reach end of any one return false.
* If both chars at current pointer not equal return false.
* If both points to L and sPtr < ePtr return false. This means in end we have a L shifted right which is not possible.
* If both points to R and sPtr > ePtr return false. This means in end we have a R shifted left which is again not possible.
​
### Time Complexity: O(N)
### Space Complexity: O(1)
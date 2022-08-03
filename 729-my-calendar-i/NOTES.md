## Approach:
* Used a treemap to keep track of all the bookings (start vs end).
* For a new booking, fetch the previous and next booking from tree map.
* If prevBooking doesn't exist or it's end is before new booking start and next booking doesn't exist or it's start is after new booking end.
* Then we can have this booking, insert in tree map.
* else return false.
​
### Time Complexity:
#### Book: O(LogN)
#### constructor: O(1)
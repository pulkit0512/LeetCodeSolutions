## Approach: Using 2 HashMaps
* In this question, I have used 2 hashmaps one to store customer details and other to store station details.
* Map<Integer, Pair<String, Integer>> custMap;
* Map<String, Pair<Integer, Integer>> timeMap;
* custMap will store customer id vs it's check In station and time.
* timeMap will store startStation_endStation vs total time till now and number of trips till now
​
* checkIn: Update the custMap with id and new check In details.
* checkOut: get the check in details from custMap for the same id. Calculate time and startStation_endStation key. If timeMap contains this key get the pair add the new time and increment the count of trips by 1. If not present store this in map with time and count as 1.
* getAverageTime: given start station and end station get the pair from map and return the times divided by count of trips as average.
​
### Complexity Analysis
​
* **Time complexity : O(1) for all.**
* checkIn(...): Inserting a key/value pair into a HashMap is an O(1) operation.
* checkOut(...): Additionally, getting the corresponding value for a key from a HashMap is also an O(1) operation. and storing the travel time details in other hash map is O(1) operation.
* getAverageTime(...): Dividing two numbers is also an O(1) operation.
​
* **Space complexity : O(P + S^2) where S is the number of stations on the network, and P is the number of passengers making a journey concurrently during peak time.**
* The program uses two HashMaps. We need to determine the maximum sizes these could become.
* Firstly, we'll consider checkInData. This HashMap holds one entry for each passenger who has checkIn(...)ed, but not checkOut(...)ed. Therefore, the maximum size this HashMap could be is the maximum possible number of passengers making a journey at the same time, which we defined to be P. Therefore, the size of this HashMap is O(P).
* Secondly, we need to consider journeyData. This HashMap has one entry for each pair of stations that has had at least one passenger start and end a journey at those stations. Over time, we could reasonably expect every possible pair of the S stations on the network to have an entry in this HashMap, which would be O(S^2).
* Seeing as we don't know whether S^2 or P is larger, we need to add these together, giving a total space complexity of O(P + S^2).
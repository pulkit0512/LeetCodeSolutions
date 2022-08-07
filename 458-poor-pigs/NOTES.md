## Approach: Quantum Bit
* If there is no time to test, i.e. minutesToTest / minutesToDie = 0, the pig has only one state - alive.
* For one test pig can have two states dead or alive after test completion.
* For two tests pig can have three states dead after first test or dead after second test or alive.
* So pig states for n tests is n+1.
* If one pig has 2 state it can check two buckets. If drank from bucket 1 and alive after time to die then poison in bucket 2. If dead poison in bucket 1.
* If two pigs has 2 states, pig1 drank from bucket1 and bucket2. pig2 drank from bucket2 and bucket3.
* If after the test, pig1 died poison in bucket1. pig2 died poison in bucket3. If both died poison in bucket2. If none died poison in bucket4.
* So number of buckets x pigs can test with s states will be (s^x).
* We need x pigs such that (s^x) >= buckets.
* x >= log(buckets)/log(s)
​
### Time Complexity: O(1)
### Space Complexity: O(1)
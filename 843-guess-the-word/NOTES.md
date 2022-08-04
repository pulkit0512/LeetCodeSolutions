## Approach:
* From the starting list of words, we guess a word randomly and we will get number of characters matching with the secret word.
* Then we reduce the search space by keeping only those words in the list which exactly matches current selected word with number of match returned from the API. Becuase our potential answer will lie in this reduced list.
* We keep on reducing the list size untill we get match size as 6.
​
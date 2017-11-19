# Poker Face

A program that names a poker hand. The program reads input from a file and converts the specified hands (there may be many) into the name of the corresponding poker hand. The name of the hand will be one of:

* High card
* One pair
* Two pair
* Three of a kind
* Straight
* Flush
* Full house
* Four of a kind
* Straight flush
* Royal Flush

The full list of available poker hands is available here: http://en.wikipedia.org/wiki/List_of_poker_hands

## Getting Started

### Installing
On the command line run ``mvc clean install``

### Running
On the command line run ``java -jar ./target/poker-1.0-SNAPSHOT.jar {path to file}``

### Input file

Each line of the input file will contain 5 valid card descriptions. Each description is in the
form CS, where C is the name of the card (2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A) and S is the
suit (H, D, S, C for Hearts, Diamonds, Spades and Clubs respectively).

#### Example input:
```
3H JS 3C 7C 5D
JH 2C JD 2H 4C
9H 9D 3S 9S 9C
9C 3H 9S 9H 3S
```
#### Example output:
```
3H JS 3C 7C 5D => One pair
JH 2C JD 2H 4C => Two pair
9H 9D 3S 9S 9C => Four of a kind
9C 3H 9S 9H 3S => Full house
```
_Note: Aces can be the highest or lowest card of a straight flush i.e. 1, 2, 3, 4, 5 or T, J, Q, K, A_
# Frog
This is the solution I came up for one coding test taken from [Codility](http://codility.com).
The solution is not guaranteed to be entirely corrected, at least it works for the provided example :)

* A = [ 1, 3, 1, 4, 2, 5 ]
* X = 7
* D = 3
* expected result = 3

The test says you have a Frog that wants to jump from a bank of the river to the other one.
The two banks are distant X metres. The frog can jump for as long as D metres ( or even less than D). If D >= X there are no problems. If not, there are some falling leaves on which the frog can jump in order to get to the other bank.
You are provided with an array A with this meaning:
each value A[K] contains the position ( distance in metres from the frog ) in which a leaf will fall at time K.
you need to find the smaller K which allows the frog to jump from one bank to the other.



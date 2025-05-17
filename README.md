# question-no-75
Solution to the question no 75 on leet code 

75. Sort Colors
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

How it works:
Three pointers are used:

low – points to the position for the next 0

mid – current element being checked

high – points to the position for the next 2

Depending on the value at mid:

If it's 0, swap with low, move both low and mid forward.

If it's 1, just move mid forward.

If it's 2, swap with high, and move high backward.

This sorts the array in-place efficiently.

The main() method tests the function with various test cases.

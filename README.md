# poker

## How the solution works

I read the file with the poker hands and split each line by spaces. After that I take the first 5 elements of the array and create a List of Card Objects, and the same for the last 5 elements of the array.
With these Lists of Cards I create two Hand objects. After creating the Hand objects I find out the rank of each Hand. This process leverages the sorting of the List of Cards, and the creation of a HashMap with the number of times a card appears in a hand.
After that a comparison is made two find out wich player won.

## Which object-oriented programming ideas did you apply to solve the problem

In this project, I used two objects to represent respectively a Card and a Hand.

## What you like and do not like about your solution

I like the fact that my solution is easy to understand.
I don´t like the fact that I have to traverse an ArrrayList and a HashMap for each hand to find the rank of the hand. I believe this could have been done more effeciently   at the cost of simplicity.

## Which of the technologies or approaches used were new to you

Nothing

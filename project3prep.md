# Project 3 Prep

**For tessellating hexagons, one of the hardest parts is figuring out where to place each hexagon/how to easily place hexagons on screen in an algorithmic way.
After looking at your own implementation, consider the implementation provided near the end of the lab.
How did your implementation differ from the given one? What lessons can be learned from it?**

Answer: I didn't attend live, but our solution had some drawbacks: we did use the natural symmetry of
the hexagon, that is, using the diagonals, but we simply used 5 for loops to get the diagonals. We could
have used perhaps a helper function to accomplish this.

-----

**Can you think of an analogy between the process of tessellating hexagons and randomly generating a world using rooms and hallways?
What is the hexagon and what is the tesselation on the Project 3 side?**

Answer: The rooms could be the hexagons, and the tesselation could be the way in which the rooms fit together
or how the hallways connect them.


-----
**If you were to start working on world generation, what kind of method would you think of writing first? 
Think back to the lab and the process used to eventually get to tessellating hexagons.**

Answer: write a method that makes rooms, then write a method to connect the rooms.

-----
**What distinguishes a hallway from a room? How are they similar?**

Answer: The hallways will have an orientation and a length, whereas the rooms will have a x and y dimension.
Therefore, both have two numbers determining dimensions, but the rooms have x and y. Hallways are not rectangular
necessarily, as they can have corners.

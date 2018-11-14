# Proj 0 - Universe Simulator

Run:  

	javac NBody.java
	java NBody 157788000.0 25000.0 data/planets.txt


1. Planet class
- define variables
- two constructors: initialize a planet object; copy a planet
- calculate distance funtion
- calculate force function
- calculate netforce function(all the plants effect)
- update velocity/location function

2. NBody class
- read radius from file
- read planets array from file
- main funcition
	- draw background
	- draw planets
	- simulation (in each time step, calculate netforce, update velocity/position, draw)
	- print final state of the universe
	- add sound 

# Notes
1. remember ';'
2. if, for, while ()
3. Math.pow(a,2) = a*a (pow is slower)
4. declare variable type at first
5. loop still need to declare index i first(int i;)

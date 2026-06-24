# Block Match GUI Game

## Project Overview

This project is a simple graphical user interface (GUI) game where the user is presented with a row of three randomly generated blocks. The user must determine whether the blocks form a **valid match** based on specific rules involving their properties.

The game is designed using GUI principles and must use proper layout managers (no absolute positioning).

## Game Rules

Each block has three properties:

* Shape Type
* Shape Colour
* Block Colour

A **match** occurs when, for all three blocks:

* Each property is either **all the same** OR **all different**

### Example of a Match

* Shape Type: all identical
* Shape Colour: all different
* Block Colour: all different

This is considered a valid match because each property satisfies one of the required conditions (either all same or all different).

### Example of a Non-Match

If any property is neither all the same nor all different (e.g., two values match and one is different), then the blocks do **not** form a valid match.

## How the Game Works

1. The program randomly generates three blocks.
2. Each block is assigned:

   * A shape type
   * A shape colour
   * A block background colour
3. The user is asked to guess whether the blocks form a valid match.
4. After the user makes a selection:

   * The program checks the correct answer
   * It displays whether the user was correct or incorrect
   * It explains the reason based on the three properties

## Features

* Random generation of block properties
* Interactive GUI interface
* User input for match prediction
* Immediate feedback after each guess
* Explanation of results based on rule evaluation

## Technical Requirements

* Must be implemented using a GUI framework 
* Must use layout managers 
* Must be written manually 
* Code must be clean, structured, and well-commented

## Learning Outcomes

This project demonstrates understanding of:

* GUI design principles
* Event-driven programming
* Random value generation
* Conditional logic
* Problem decomposition
* User interaction handling



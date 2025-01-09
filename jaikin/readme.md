# Jaikin
The goal of this project is to implement Chaikin's algorithm and create a step-by-step animation of the process using a canvas.

## Features and binds
* Esc - Exit the application
* R - Restart the drawing
* Mouse1 (left click) - Add a point or drag a selected point
* Mouse2 (right click) - Delete a selected point
* Enter - Apply the Chaikin's algorithm and run animation 

## Requirements
### [Audit Questions](https://github.com/01-edu/public/tree/master/subjects/java/raids/Jaikin/audit)

1. Create a canvas where the user can draw one or more points. Each point should be represented by a small circle.

2. Receive input from the mouse, allowing the user to place control points for Chaikin's algorithm using the left button.

3. Display the selected points on the canvas as small circles surrounding each point.

4. If the canvas has control points drawn on it, pressing the Enter key should initiate the animation. The animation should cycle through the steps of Chaikin's algorithm, proceeding until it reaches the 7th step. After completing the 7th step, the animation should restart.

5. If the user presses Enter before any points have been drawn, nothing should happen. However, the user should still be able to draw points, and an optional message may be displayed to remind the user to draw points.

6. If the canvas has only one control point, the program must display that point without cycling through the steps.

7. If the canvas has only two control points, the program must draw a straight line between those two points.

8. Pressing the Escape key should close the window.

## Bonus
Optionally, you may implement the following bonus features:

1. Allow the user to clear the screen, enabling them to select new control points.

2. Implement real-time dragging of the control points, so the user can adjust their position interactively.


## Authors 
### [Juss](https://01.kood.tech/git/juss/jaikin) & [Iryna](https://01.kood.tech/git/ivelychk)
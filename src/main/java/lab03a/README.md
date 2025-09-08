Lab 03A

Static fields and methods

Lab: Game! – Static fields and methods
Objective
In this lab, you will:
• further your understanding of object-oriented programming.
• create a graphical application instead of a Console app.

Part 1
You'll be creating a graphical application, which is an exciting new challenge. While this will involve copying and pasting several lines of code, you don't need to fully understand how the graphics code functions.
However, it’s worth noting that the code isn’t overly complex, so if you're curious, you can take the time to explore and investigate it on your own.

1. Back in the labs project, create a new class called Game in a package named oo2.
2. Create an instance of Game in the main() method. This will run the Game’s constructor code which you will create later.
3. To begin, you’ll need a canvas to draw on and display your animation. In this example, you’ll create several ball objects bouncing around within a rectangle (referred to as ‘the world’).
   Feel free to get creative with this project later, but for now, it’s important to follow the provided steps. The primary goal is to explore and understand object-oriented programming, not to focus on animation or graphic design.
   Start by deleting any existing code in the Game class. Then, copy and paste the code below. You'll notice that there are a few comments included in the code, which act as placeholders for sections you’ll write later.

```java
import java.awt._;
import java.awt.event._;
import java.util._;
import java.util.Timer;
import javax.swing._;

public class Game extends Canvas {
// create an array of 3 balls
// call this array balls

    Game() {

JFrame frame = new JFrame();
this.setSize(400, 400);
frame.add(this);
frame.pack();
frame.setVisible(true);
Timer t = new Timer();
TimerTask tt = new TimerTask() {
@Override
public void run() {
draw();
}
};

t.schedule(tt, 0, 50);

frame.addWindowListener(new WindowAdapter() {
@Override
public void windowClosing(WindowEvent e) {
t.cancel();
tt.cancel();
}
});
}

public void draw() {
// call the move() method of each balls
// Tip: use an enhanced for loop to pick
// each ball in the balls array.
this.repaint();
}

public void paint(Graphics g) {
g.drawRect(0, 0, 300, 300);
// move and draw each ball in balls array
// Tip: use an enhanced for loop to pick
// each ball in the balls array.

}
} 4. Run the application to see if your code works as expected.

5. Create a class called Ball with the following fields.
   public int x, y, w, h;
   private int dirX, dirY;
```

A ball's dimension is represented as a rectangle. X and y are the top coordinate and w and h are the width and height of the ball's rectangle.
dirX and dirY are the amount by which each ball moves in the x and y direction.
The coordinate system is perhaps unlike what you're familiar with as it is upside-down! X increases to the right and Y increases towards the bottom. 6. Create a constructor to set every field (x,y,w,h,dirX,dirY). 7. To practice using constructor chaining, create another constructor to set just x,y,w,h but not the dirX and dirY.
Use constructor chaining to call the first constructor with dirX=1 and dirY=1. 8. Create a method called move() in the Ball class.
In this method, increase x by dirX and y by dirY and then follow a series of tests to make sure each ball stay within the world which is set in the paint event as 300px wide, 300px high, and starts at x=0,y=0.
If (x < 0) then set x=0 and change the sign of dirX.  
Tip: dirX = -dirX
Do the same for the y coordinate (when it goes below zero) but this time changing dirY.
If (x > 300-width of the ball) then set x=300-width of the ball and reverse the sign of dirY.
Do the same for the y coordinate (taking the height of the ball into account).

9. Back in the Game class, view the comments and perform those tasks (create three balls, call move()… and draw each ball).
   Tip: The paint method can draw a circle using this code:

   ```java
   g.drawOval( b.x, b.y, b.w, b.h );
    // where b is a ball reference
   ```

10. If everything works, you should see three objects bouncing on your screen. If you have a need for speed then increase the dirX and dirY values!

Part 2 – Using the static keyword

In this section, you will explore the use of the static keyword. Defining the world dimensions as fixed values, such as 300 pixels for both height and width, is not an ideal approach. Since all the balls share the same world coordinates, this scenario presents an excellent opportunity to utilise the static keyword. By doing so, you ensure that the world dimensions are shared across all instances, reflecting their universal nature within the program.

1. Create a static int field in Ball called worldW and another called worldH to represent the width and height of the world. You should see three balls bouncing!
2. Create static method as
   public static void setWorld(int w, int h)
   to set the static worldW and worldH values.
3. In the Game() constructor, just before the line Timer t = new Timer(); invoke the setWorld() method of the Ball class to set the world's width and height for every Ball.
4. Change the move() method in the Ball class to use the Ball.worldH and Ball.worldW values instead of 300px. You'll also need to change the paint() method to use the new static values (to draw the world's rectangle).
5. Run and test your code.

** End **

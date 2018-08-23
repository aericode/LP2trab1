import java.awt.Color;
import java.awt.Dimension;

/**
 * Class BallDemo - provides a demonstration of the
 * BouncingBall and Canvas classes. 
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2010.11.30
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 500;

    /**
     * Create a BallDemo object.
     * Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", WIDTH, HEIGHT);
        myCanvas.setVisible(true);
    }
 
    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        Dimension canvasSize = new Dimension (myCanvas.getSize());

        int ground = (canvasSize.height*7)/ 8;   // position of the ground line
        int xStart = canvasSize.width     / 8;    // x-start of the ground line
        int xLimit = (canvasSize.width*7) / 8;   // x-limit of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.blue);
        myCanvas.drawLine(xStart, ground, xLimit, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(xStart, 50, 16, Color.blue, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(xStart + 20, 80, 20, Color.red, ground, myCanvas);
        ball2.draw();

        // Make them bounce until both have gone beyond the xLimit.
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= xLimit && ball2.getXPosition() >= xLimit) {
                finished = true;
            }
        }
        ball.erase();
        ball2.erase();
    }
    
}
/*
    public void drawFrame(){
        int xPos = 20;
        int yPos = 20;
        Dimension canvasSize = new Dimension (myCanvas.getSize());
        Rectangle rect = new Rectangle(xPos, yPos, canvasSize.width-(2*xPos), canvasSize.height-(2*yPos));
        myCanvas.draw(rect);
    }
*/

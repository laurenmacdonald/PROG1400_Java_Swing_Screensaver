package classes;

import java.awt.*;

public class Fan extends Shape{
    private int startAngle;
    private int arcAngle;
    public Fan(ShapeColor color, int height, int width, int xPosition, int yPosition, int startAngle, int arcAngle) {
        this.setShapeColor(color);
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
        this.setStartAngle(startAngle);
        this.setArcAngle(arcAngle);
    }
    //Overriding the inherited method from Shape class
    @Override
    public void drawShape(Graphics g){
        Color rectangleColor = this.getShapeColor();

        //Draw the 'fan' using Arc. Added startAngle and arcAngle to this class.
        g.setColor(rectangleColor);
        g.fillArc(this.getxPosition(), this.getyPosition(), this.getWidth(), this.getHeight(), this.getStartAngle(), this.getArcAngle());
    }

    @Override
    public void moveShape(){
        //Move the shape by adding speed to the current x/y positions
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }

    public int getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    public int getArcAngle() {
        return arcAngle;
    }

    public void setArcAngle(int arcAngle) {
        this.arcAngle = arcAngle;
    }
}

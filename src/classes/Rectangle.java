package classes;

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle(ShapeColor color, int height, int width, int xPosition, int yPosition) {
        this.setShapeColor(color);
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
    }
    //Overriding the inherited method from Shape class
    @Override
    public void drawShape(Graphics g){
        Color rectangleColor = this.getShapeColor();

        //Draw the rectangle
        g.setColor(rectangleColor);
        g.fillRect(this.getxPosition(), this.getyPosition(), this.getWidth(), this.getHeight());
    }

    @Override
    public void moveShape(){
        //Move the shape by adding speed to the current x/y positions
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }
}

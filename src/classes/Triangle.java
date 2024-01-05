package classes;

import java.awt.*;

public class Triangle extends Shape {
    public Triangle(ShapeColor shapeColor, int height, int width, int xPosition, int yPosition) {
        this.setShapeColor(shapeColor);
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
    }

    @Override
    public void drawShape(Graphics g) {
        Color triangleColor = this.getShapeColor();
        g.setColor(triangleColor);
        //Draw the triangle using polygon of 3 points
        //(The math required to make a triangle took me the majority of the time spent on this assignment, someone give me back
        //my elementary school geometry memories!!)
        g.fillPolygon(new int[] {this.getxPosition(), this.getxPosition() + (this.getWidth() / 2), this.getxPosition() + this.getWidth()},
                new int[] {this.getyPosition(), this.getyPosition() - this.getHeight(), this.getyPosition()}, 3);
    }

    @Override
    public void moveShape() {
        //Move the shape by adding speed to the current x/y positions
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }
}

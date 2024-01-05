package classes;

import java.awt.*;

public class Cross extends Shape {
    public Cross(ShapeColor shapeColor, int height, int width, int xPosition, int yPosition) {
        this.setShapeColor(shapeColor);
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
    }

    @Override
    public void drawShape(Graphics g) {
        //Casting Graphics2D class to Graphics g.
        Graphics2D g2d = (Graphics2D)g;
        Color crossColor = this.getShapeColor();
        g2d.setColor(crossColor);
        //Making the size of the lines thicker.
        g2d.setStroke(new BasicStroke(6.0F));
        //Draw the cross
        g2d.drawLine(this.getxPosition(), this.getyPosition(), this.getxPosition() + this.getWidth(), this.getyPosition() + this.getHeight());
        g2d.drawLine(this.getxPosition(), this.getyPosition() + this.getHeight(), this.getxPosition() + this.getWidth(), this.getyPosition());
    }

    @Override
    public void moveShape() {
        //Move the shape by adding speed to the current x/y positions
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }



}

package classes;
import java.awt.*;

public abstract class Shape {

    private ShapeColor shapeColor;
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private int xSpeed =10;
    private int ySpeed =10;

    public abstract void drawShape(Graphics g);

    public abstract void moveShape();

    public ShapeColor getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(ShapeColor shapeColor) {
        this.shapeColor = shapeColor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
}

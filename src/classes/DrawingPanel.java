package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class DrawingPanel extends JPanel {

    //Timer class to implement custom ActionListener
    private Timer timer = new Timer(100, new TimerAction());
    //Shape ArrayList to hold shapes
    private ArrayList<Shape> shapes;
    //array list to hold numbers to iterate through to get random generation
    private ArrayList<Integer> shapeRandomizerNum;


    //Constructor for the DrawingPanel
    public DrawingPanel(){
        //ArrayList to hold numbers which will be used to randomize shape creation (5=the number of Shape subclasses)
        shapeRandomizerNum = new ArrayList<>();
        shapeRandomizerNum.add(1);
        shapeRandomizerNum.add(2);
        shapeRandomizerNum.add(3);
        shapeRandomizerNum.add(4);
        shapeRandomizerNum.add(5);

        //shapes ArrayList to hold created shapes
        shapes = new ArrayList<>();


        //MouseListener to capture user input (click of mouse)
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Random RBG number values
                Random randomColor = new Random();
                int upperboundColor = 255;
                int r = randomColor.nextInt(upperboundColor);
                int b = randomColor.nextInt(upperboundColor);
                int g = randomColor.nextInt(upperboundColor);

                //Random shapeHeight, shapeWidth integers for shape creation
                Random randomSize = new Random();
                int upperboundSize = 100;
                int shapeHeight = randomSize.nextInt(upperboundSize);
                int shapeWidth = randomSize.nextInt(upperboundSize);

                //Randomly generate shape using a random number within the limits of the shapeRandomizerNum array
                Random randomNumber = new Random();
                int upperbound = shapeRandomizerNum.size() + 1;    //size of number array + 1 so nextInt() method includes the amount
                int origin = 1;     //assigning 1 as the lowest potential value that could be assigned via the nextInt() method
                int randomShape = randomNumber.nextInt(origin, upperbound);

                //Switch statement to create new shapes based off of the randomShape int defined above.
                switch(randomShape){
                    case 1:
                        //making shapeHeight and shapeWidth the same to make even circle.
                        shapes.add(new Circle(new ShapeColor(r, b, g), shapeWidth, shapeWidth, e.getX(), e.getY()));
                        break;
                    case 2:
                        shapes.add(new Rectangle(new ShapeColor(r, b, g), shapeHeight, shapeWidth, e.getX(), e.getY()));
                        break;
                    case 3:
                        shapes.add(new Triangle(new ShapeColor(r,b,g), shapeHeight, shapeWidth, e.getX(), e.getY()));
                        break;
                    case 4:
                        shapes.add(new Cross(new ShapeColor(r,b,g), shapeHeight, shapeWidth, e.getX(), e.getY()));
                        break;
                    case 5:
                        //Setting specific startAngle and arcAngle numbers so the fans are a consistent shape
                        shapes.add(new Fan(new ShapeColor(r,b,g),shapeHeight, shapeWidth, e.getX(), e.getY(), 225,90));
                        break;
                }
                startMoving();
            }
        });

    }
    @Override
    public void paintComponent(Graphics g) {
        //Overriding the paintComponent method, iterating through the shapes array to draw each shape
        //by calling its drawShape method through the superclass.
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.drawShape(g);
        }
    }
    private void startMoving(){
        //Call the timer start method
        timer.start();
    }

    public void moveThings(){
        //Call the move method for the Shape and check for wall hit and collision between shapes, repaint the panel to illustrate shape movement.
        for(Shape shape : shapes){
            shape.moveShape();
            checkForWallHit(shape);
            checkForCollision(shape);
            this.repaint();
        }
    }
    public void checkForWallHit(Shape currentShape){ //property set so that the program checks each individual shape rather than all at one time
        //Compare current position to the position of the window border
        if((currentShape.getxPosition() + currentShape.getWidth() >= this.getWidth())){ //compare position of shape with wall (this.getWidth())
            currentShape.setxSpeed(currentShape.getxSpeed() * -1);  //change direction if the right side of the wall hit
        }else if (currentShape.getxPosition() <= 0){
            currentShape.setxSpeed(currentShape.getxSpeed() * -1);  //change direction if the left side of the wall hit
        }else if((currentShape.getyPosition() + currentShape.getWidth() >= this.getHeight())){
            currentShape.setySpeed(currentShape.getySpeed() * -1);  //change direction if the bottom side of the wall hit
        }else if (currentShape.getyPosition() <= 0){                //change direction if the top side of the wall hit
            currentShape.setySpeed(currentShape.getySpeed() * -1);
        }
    }

    public void checkForCollision(Shape currentShape) { //Checking each individual shape
        //Random rbg values to change the color of the shape
        Random randomColor = new Random();
        int upperboundColor = 255;
        int r = randomColor.nextInt(upperboundColor);
        int b = randomColor.nextInt(upperboundColor);
        int g = randomColor.nextInt(upperboundColor);

        //NOTE: Still a little confused on what exactly is being checked against with the below if statements,
        //but after lots of trial and error I believe the comments are correct

        //For each loop to compare each shape in the array against 'current shape'
        for (Shape shape : shapes) {
            if (currentShape != shape &&    //Ensure that the shape is not comparing against itself
                    currentShape.getxPosition() + currentShape.getWidth() + currentShape.getxSpeed() > shape.getxPosition() &&  //checking for hit on currentShape's right side
                    currentShape.getxPosition() + currentShape.getxSpeed() < shape.getxPosition() + shape.getWidth() &&     //checking for hit on currentShape's left side
                    currentShape.getyPosition() + currentShape.getHeight() > shape.getyPosition() &&    //check for hit on currentShape's bottom
                    currentShape.getyPosition() < shape.getyPosition() + shape.getHeight()) {        //check for hit on currentShape's top

                currentShape.setxSpeed(currentShape.getxSpeed() * -1);  //If hit change direction and change color
                currentShape.setShapeColor(new ShapeColor(r, b, g));
            }

            if (currentShape != shape &&
                    currentShape.getxPosition() + currentShape.getWidth() > shape.getxPosition() && //check for hit on shape's right side
                    currentShape.getxPosition() < shape.getxPosition() + shape.getWidth() &&        //check for hit on shape's left
                    currentShape.getyPosition() + currentShape.getHeight() + currentShape.getySpeed() > shape.getyPosition() &&     //check for hit on shape's bottom
                    currentShape.getyPosition() + currentShape.getySpeed() < shape.getyPosition() + shape.getHeight()) {        //check for hit on shape's top

                currentShape.setySpeed(currentShape.getySpeed() * -1);
                currentShape.setShapeColor(new ShapeColor(r, b, g));
            }

        }
    }


    //Creating custom TimerAction class which implements ActionListener class (aka is an ActionListener class)
    //actionPerformed method calls the moveThings method to move the object upon event.
    private class TimerAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            moveThings();
        }
    }

}

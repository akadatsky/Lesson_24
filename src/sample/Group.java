package sample;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by oleg on 24.11.2014.
 */
public class Group extends Shape {
    List<Shape>list=new ArrayList<Shape>();

    public Group(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        for(Shape s:list){
            s.changeColor();
        }
    }

    @Override
    public void changeColor() {

    }
    public void moveUp(){
        for (Shape s:list){
            s.moveUp();
        }
    }
    public void moveDown(){
        for (Shape s:list){
            s.moveDown();
        }
    }
    public void moveRight(){
        for (Shape s:list){
            s.moveRight();
        }
    }
    public void moveLeft(){
        for (Shape s:list){
            s.moveLeft();
        }
    }
    public void addToGroup(Shape shape){
        list.add(shape);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        return false;
    }
}

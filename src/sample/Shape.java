package sample;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

/**
 * Created by oleg on 19.11.2014.
 */
public abstract class Shape {
    Random random = new Random();
    protected GraphicsContext gc;
    protected int x;
    protected int y;
    protected int step = 5;

    protected Shape(GraphicsContext gc) {
        this.gc = gc;
        x = random.nextInt((int) gc.getCanvas().getWidth());
        y = random.nextInt((int) gc.getCanvas().getHeight());
    }

    public void moveUp() {
        y -= step;
    }

    public void moveDown() {
        y += step;
    }

    public void moveRight() {
        x += step;
    }

    public void moveLeft() {
        x -= step;
    }

    public abstract void draw();

    public abstract void changeColor();

    public void clean() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    public abstract boolean isTouched(double clickX, double clickY);
}

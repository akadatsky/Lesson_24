package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sun.security.provider.SHA;

/**
 * Created by oleg on 18.11.2014.
 */
public class Oval extends Shape {
    private int size = 40;

    public Oval(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void changeColor() {
        gc.setFill(Color.GREEN);
        gc.fillOval(x, y, size, size);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= x + size) && (clickX >= x) && (clickY <= y + size) && (clickY >= y)) {
            return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void draw() {
        gc.setFill(Color.AQUA);
        gc.fillOval(x, y, size, size);
    }
}

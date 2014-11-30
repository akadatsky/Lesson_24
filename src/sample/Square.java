package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by oleg on 19.11.2014.
 */
public class Square extends Shape {
    private int size = 50;

    public Square(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void changeColor() {
        gc.setFill(Color.GREEN);
        gc.fillRoundRect(x, y, size, size, 0, 0);
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
        gc.setFill(Color.RED);
        gc.fillRoundRect(x, y, size, size, 0, 0);
    }
}

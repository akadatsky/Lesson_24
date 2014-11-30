package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by oleg on 19.11.2014.
 */
public class Triangle extends Shape {
    public Triangle(GraphicsContext gc) {
        super(gc);
    }

    private int size = 50;

    @Override
    public void draw() {
        gc.setFill(Color.BLUE);
        gc.fillPolygon(new double[]{x, x + size, x + size / 2},
                new double[]{y, y, y - size}, 3);
    }

    public int getSize() {
        return size;
    }

    @Override

    public void changeColor() {
        gc.setFill(Color.GREEN);
        gc.fillPolygon(new double[]{x, x + size, x + size / 2},
                new double[]{y, y, y - size}, 3);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= x + size) && (clickX >= x) && (clickY <= y)) {
            return true;
        }
        return false;
    }
}

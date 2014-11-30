package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    private int CANVAS_X = 1000;
    private int CANVAS_Y = 600;
    GraphicsContext gc;
    Scene scene;
    ArrayList<Shape> list = new ArrayList<Shape>();
    private int circle = 0;
    Random rand = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello world");
        BorderPane group = new BorderPane();
        Canvas canvas = new Canvas(CANVAS_X, CANVAS_Y);
        scene = new Scene(group);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setScene(scene);
        group.setCenter(canvas);
        primaryStage.show();
        list.add(new Oval(gc));
        list.get(circle).draw();
        setOnKeyPressed();
        setOnMousePressed();
        setOnKeyPressed();


    }

    private void setOnMousePressed() {
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Group group1 = new Group(gc);
                double clickX = event.getSceneX();
                double clickY = event.getSceneY();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).isTouched(clickX, clickY)) {

                        Shape current = list.get(circle);
                        Shape selected = list.get(i);
                        if (current == selected) {
                            return;
                        }
                        group1.addToGroup(current);
                        group1.addToGroup(selected);
                        group1.draw();
                        list.remove(current);
                        list.remove(selected);
                    }
                }
                list.add(group1);
                circle = list.size() - 1;
            }
        });
    }

    public void setOnKeyPressed() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //Add oval
                if (event.getCode() == KeyCode.DIGIT1) {
                    list.add(new Oval(gc));
                    list.get(list.size() - 1).clean();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    circle++;

                }
                //Add square
                if (event.getCode() == KeyCode.DIGIT2) {
                    list.add(new Square(gc));
                    list.get(list.size() - 1).clean();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    circle++;

                }
                //Add triangle
                if (event.getCode() == KeyCode.DIGIT3) {
                    list.add(new Triangle(gc));
                    list.get(list.size() - 1).clean();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    circle++;

                }
                //Switch forward between shapes and shapes group
                if (event.getCode() == KeyCode.A) {
                    circle--;
                    if (circle < 0) {
                        circle = 0;
                    }

                }
                //Switch backward between shapes and shapes group
                if (event.getCode() == KeyCode.D) {
                    circle++;
                    if (circle > list.size() - 1) {
                        circle = list.size() - 1;
                    }
                }


                //Move shapes(any shapes group)
                {
                    switch (event.getCode()) {
                        case UP:
                            list.get(circle).moveUp();
                            break;
                        case DOWN:
                            list.get(circle).moveDown();
                            break;
                        case RIGHT:
                            list.get(circle).moveRight();
                            break;
                        case LEFT:
                            list.get(circle).moveLeft();
                            break;
                    }
                    list.get(list.size() - 1).clean();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }


                }
            }

        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

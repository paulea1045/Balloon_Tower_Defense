package com.example.tower_defense;

import com.example.tower_defense.Input.InputManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.*;
import javafx.scene.text.*;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Screen extends Application{
    private static final int width = 1280;
    private static final int height = 720;
    private static final int towerHeight = 400;
    private static final int towerWidth = 200;
    private static final double dart = 15;

    public ArrayList<Balloon> balloons = new ArrayList<>();

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Balloons Tower Defense");

        Group root = new Group();
        Scene scene = new Scene(root,Color.LIGHTSKYBLUE);
        primaryStage.setScene(scene);

        Image icon = new Image(new FileInputStream("src/main/java/icon.png"));
        primaryStage.getIcons().add(icon);

        primaryStage.setHeight(height);
        primaryStage.setWidth(width);
        primaryStage.setResizable(false);

        Rectangle grass= new Rectangle(0 , 720-80,1280,80);
        grass.setFill(Color.GREEN);
        root.getChildren().add(grass);

        Image monkey= new Image(new FileInputStream("src/main/java/monkeyman.png"));
        ImageView monkeyFrame= new ImageView();
        monkeyFrame.setImage(monkey);
        monkeyFrame.setFitHeight(800);
        monkeyFrame.setFitWidth(600);
        monkeyFrame.setX(800);
        monkeyFrame.setY(60);
        root.getChildren().add(monkeyFrame);

        Circle sun= new Circle(1280,0,100);
        sun.setFill(Color.YELLOW);
        root.getChildren().add(sun);

        Canvas canvas= new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline mainLoop = new Timeline();
        mainLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(Duration.seconds(1d / 60), event -> run(gc));
        InputManager.configure(canvas);

        mainLoop.getKeyFrames().add(kf);
        mainLoop.play();


        root.getChildren().add(canvas);
        primaryStage.show();

    }



    public void run(GraphicsContext gc){
        gc.clearRect(0, 0, 10000, 10000);
        for (Balloon b : balloons){
            b.x += 3;
            b.update(gc);
        }

    }

    public static void main(String[] args) { /*This is how go*/
        launch(args);
    }

}


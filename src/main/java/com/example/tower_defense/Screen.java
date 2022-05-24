package com.example.tower_defense;

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

public class Screen extends Application{
    private static final int width= 1280;
    private static final int height= 720;
    private static final int tower_height= 400;
    private static final int tower_width= 200;
    private static final double dart= 15;

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tower Defense baby");

        Group root= new Group();
        Scene scene= new Scene(root,Color.LIGHTSKYBLUE);
        primaryStage.setScene(scene);

        Image icon= new Image("C:\\Users\\Euhun\\IdeaProjects\\Tower Defense\\src\\main\\java\\icon.png");
        primaryStage.getIcons().add(icon);

        primaryStage.setHeight(height);
        primaryStage.setWidth(width);
        primaryStage.setResizable(false);

        Rectangle grass= new Rectangle(0 , 720-80,1280,80);
        grass.setFill(Color.GREEN);
        root.getChildren().add(grass);

        Circle sun= new Circle(1280,0,100);
        sun.setFill(Color.YELLOW);
        root.getChildren().add(sun);

        Canvas canvas= new Canvas(width, height);
        GraphicsContext gc= canvas.getGraphicsContext2D();
        Timeline t1= new Timeline(new KeyFrame(Duration.millis(10),event ->run(gc)));
        t1.setCycleCount(Timeline.INDEFINITE);
       // primaryStage.setScene(new Scene(new StackPane(canvas))); idk what's wrong with this
        primaryStage.show();


    }


    public void run(GraphicsContext gc){


    }

    public static void main(String[] args) { /*This is how go*/
        launch(args);
    }

}


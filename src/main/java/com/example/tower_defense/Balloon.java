package com.example.tower_defense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Balloon{
    public double x;
    public double y;
    public static Image image;

    static {
        try {
            image = new Image(new FileInputStream("src/main/java/balloon.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(GraphicsContext gc){
        gc.drawImage(image, x, y);
    }
}

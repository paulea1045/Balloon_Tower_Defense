package com.example.tower_defense;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Balloon{
    public double x = -100;
    public double y = Math.random() * 350 + 200;
    public static Image image;

    static {
        try {
            image = new Image(new FileInputStream("src/main/java/balloon.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(GraphicsContext gc){
    gc.drawImage(image, x, y, 100, 100);
    }
}

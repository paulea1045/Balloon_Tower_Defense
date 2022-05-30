package com.example.tower_defense.Input;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseButton;

public class InputManager {
  public final static Keyboard keyboard = new Keyboard();
  public final static Mouse mouse = new Mouse();

  public static void configure(Canvas canvas){
    canvas.setOnMouseMoved(e -> {

      mouse.x = e.getX();
      mouse.y = e.getY();
    });

    canvas.setOnMouseDragged(e -> {
      mouse.x = e.getX();
      mouse.y = e.getY();
    });

    canvas.setOnMousePressed(e -> {
      if(e.getButton() == MouseButton.PRIMARY) mouse.updateLeft(true);
      if(e.getButton() == MouseButton.SECONDARY) mouse.updateRight(true);
      if(e.getButton() == MouseButton.MIDDLE) mouse.updateScroll(true);
    });

    canvas.setOnMouseReleased(e -> {
      if(e.getButton() == MouseButton.PRIMARY) mouse.updateLeft(false);
      if(e.getButton() == MouseButton.SECONDARY) mouse.updateRight(false);
      if(e.getButton() == MouseButton.MIDDLE) mouse.updateScroll(false);
    });

    canvas.setOnScroll(e -> {
      mouse.scrollDX = e.getDeltaX();
      mouse.scrollDY = e.getDeltaY();
      mouse.scroll();
    });

    canvas.setOnScrollFinished(e -> mouse.releaseScroll());

    canvas.setFocusTraversable(true);

    canvas.setOnKeyPressed((e) -> keyboard.updateKey(e.getCode(), true));
    canvas.setOnKeyReleased((e) -> keyboard.updateKey(e.getCode(), false));

  }
}

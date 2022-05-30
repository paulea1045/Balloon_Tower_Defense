package com.example.tower_defense.Input;

import java.util.ArrayList;
import java.util.List;

class Button{
  public List<Runnable> pressEvents = new ArrayList<>();
  public List<Runnable> releaseEvents = new ArrayList<>();
  public boolean isPressed = false;
  boolean buffer = false;

  void update(boolean pressed){
    isPressed = pressed;
    if(pressed){
      if(!buffer) {
        pressEvents.forEach(Runnable::run);
        buffer = true;
      }
    }
    else{
      releaseEvents.forEach(Runnable::run);
      buffer = false;
    }

  }
}

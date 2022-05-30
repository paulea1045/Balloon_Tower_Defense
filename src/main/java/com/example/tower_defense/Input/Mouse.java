package com.example.tower_defense.Input;

import java.util.ArrayList;
import java.util.List;

public class Mouse {
    public double x = 0, y = 0;
    public double scrollDX = 0, scrollDY = 0;
    Button left = new Button();
    Button right = new Button();
    Button scroll = new Button();

    private List<Runnable> scrollEvents = new ArrayList<>();

    public boolean rightPressed(){
        return right.isPressed;
    }
    public boolean leftPressed(){
        return left.isPressed;
    }
    public boolean scrollPressed(){
        return scroll.isPressed;
    }

    public void addOnRightPressed(Runnable event){
        right.pressEvents.add(event);
    }
    public void addOnRightReleased(Runnable event){
        right.releaseEvents.add(event);
    }
    public void addOnLeftPressed(Runnable event){
        left.pressEvents.add(event);
    }
    public void addOnLeftReleased(Runnable event){
        left.releaseEvents.add(event);
    }
    public void addOnScrollPressed(Runnable event) {
        scroll.pressEvents.add(event);
    }
    public void addOnScrollReleased(Runnable event){
        scroll.releaseEvents.add(event);
    }

    public void addOnScroll(Runnable event){
        scrollEvents.add(event);
    }

    void scroll(){
        scrollEvents.forEach(Runnable::run);
    }

    void updateRight(boolean pressed){
        right.isPressed = pressed;
        if(pressed) {
            if (!right.buffer) {
                right.buffer = true;
                right.pressEvents.forEach(Runnable::run);
            }
        }else{
            right.buffer = false;
            right.releaseEvents.forEach(Runnable::run);
        }
    }

    void releaseScroll(){
        scrollDX = 0;
        scrollDY = 0;
    }

    void updateLeft(boolean pressed){
        left.isPressed = pressed;
        if(pressed) {
            if (!left.buffer) {
                left.buffer = true;
                left.pressEvents.forEach(Runnable::run);
            }
        }else{
            left.buffer = false;
            left.releaseEvents.forEach(Runnable::run);
        }
    }

    void updateScroll(boolean pressed){
        scroll.update(pressed);
    }

}
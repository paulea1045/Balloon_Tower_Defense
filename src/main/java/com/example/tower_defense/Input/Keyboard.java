package com.example.tower_defense.Input;

import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

public class Keyboard {
    Map<KeyCode, Button> keys = new HashMap<>();
    Map<Combination, Button> combinations = new HashMap<>();

    void updateKey(KeyCode key, boolean pressed){
        keys.putIfAbsent(key, new Button());
        keys.get(key).update(pressed);

        for(Map.Entry<Combination, Button> e : combinations.entrySet()){
            final Combination c = e.getKey();
            final Button b = e.getValue();
            if(c.contains(key)){
                boolean allPressed = true;
                for(KeyCode k : c.keys){
                    if(!getKey(k)){
                        allPressed = false;
                        break;
                    }
                }

                b.update(allPressed);
            }
        }
    }

    public void addPressEvent(KeyCode key, Runnable event){
        keys.putIfAbsent(key, new Button());
        keys.get(key).pressEvents.add(event);
    }

    public void addPressEvent(Combination key, Runnable event){
        combinations.putIfAbsent(key, new Button());
        combinations.get(key).pressEvents.add(event);
    }

    public void addPressEvent(Runnable event, KeyCode... keys){
        addPressEvent(new Combination(keys), event);
    }

    public void addReleaseEvent(KeyCode key, Runnable event){
        keys.putIfAbsent(key, new Button());
        keys.get(key).releaseEvents.add(event);
    }

    public void addReleaseEvent(Combination key, Runnable event){
        combinations.putIfAbsent(key, new Button());
        combinations.get(key).releaseEvents.add(event);

    }

    public void addReleaseEvent(Runnable event, KeyCode... keys){
        addReleaseEvent(new Combination(keys), event);
    }

    public boolean getKey(KeyCode key){
        keys.putIfAbsent(key, new Button());
        return keys.get(key).isPressed;
    }

    public String keyString(){
        String out = "";
        for(Map.Entry<KeyCode, Button> entry : keys.entrySet()){
            out += entry.getKey().name() + ": " + entry.getValue().isPressed + "\n";
        }

        return out;
    }
}

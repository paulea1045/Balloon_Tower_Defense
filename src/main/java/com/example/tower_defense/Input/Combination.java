package com.example.tower_defense.Input;

import javafx.scene.input.KeyCode;

public class Combination{
  KeyCode[] keys;

  public Combination(KeyCode... keys){
    this.keys = keys;
  }

  @Override
  public boolean equals(Object other) {
    if(other instanceof Combination){
      Combination otherCombination = (Combination) other;
      if(keys.length == otherCombination.keys.length){
        for(int i = 0; i < keys.length; i++){
          if(!keys[i].equals(otherCombination.keys[i])) return false;
        }

        return true;
      }
    }

    return false;
  }

  public boolean contains(KeyCode code){
    for (KeyCode k : keys) if(k == code) return true;
    return false;
  }
}

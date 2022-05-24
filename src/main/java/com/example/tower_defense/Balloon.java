//package com.example.tower_defense;
//import javafx.scene.shape.*;
//import javafx.animation.Transition;
//
//public class Balloon {
//    Rectangle rect = new Rectangle (100, 40, 100, 100);
//     rect.setArcHeight(50);
//     rect.setArcWidth(50);
//     rect.setFill(Color.VIOLET);
//
//
//    Path path = new Path();
//     path.getElements().add (new MoveTo (0f, 50f));
//     path.getElements().add (new CubicCurveTo (40f, 10f, 390f, 240f, 1904, 50f));
//
//     pathTransition.setDuration(Duration.millis(10000));
//     pathTransition.setNode(rect);
//     pathTransition.setPath(path);
//     pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
//     pathTransition.setCycleCount(4f);
//     pathTransition.setAutoReverse(true);
//
//     pathTransition.play();
//}

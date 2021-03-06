package com.example.firstApp.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition tt;

    public Shake(Node node){
        tt = new TranslateTransition(Duration.millis(100), node);
        tt.setFromX(-15f);
        tt.setByX(15f);
        tt.setFromY(-15f);
        tt.setByY(15f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);
    }
    public void playAnim() {
        tt.playFromStart();
    }
}

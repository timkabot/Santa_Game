package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

/**
 * Created by Timkabo on 27.04.2016.
 */
public class gift {
    ImageView child;
    Random random = new Random();
    TranslateTransition move;
    public gift()
    {
        child = new ImageView( new Image("/gift.png"));
        move = new TranslateTransition(Duration.millis(2000),child);
        child.setTranslateY(800);
        move.setByY(-1100);
        child.setFitHeight(100);
        child.setFitWidth(100);
    }
}

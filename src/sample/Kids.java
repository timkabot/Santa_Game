package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.util.Duration;
import java.awt.*;
import java.util.Random;

public class Kids {
    ImageView child;
    int j;
    Random random = new Random();
    TranslateTransition move;
    public Kids()
    {
        Random random = new Random();
         j = random.nextInt(4);
        child = new ImageView( new Image("/KID" + (j) +  ".png"));
        move = new TranslateTransition(Duration.millis(8000),child);
        child.setTranslateX(-300);
        child.setTranslateY(random.nextInt(600));
        move.setByX(+2100);
        child.setFitHeight(100);
        child.setFitWidth(100);
        if(j==2) {child.setFitWidth(80);child.setFitHeight(80);}
        if(j==1) {child.setFitWidth(90);child.setFitHeight(90);}
    }
}

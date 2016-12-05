package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Character {
    ImageView ded_moroz;


    int width,height;
    public Character ()
    {
        width = 200;
        height = 200;
        ded_moroz = new ImageView( new Image("/Santa.png"));
        ded_moroz.setTranslateY(800);
        ded_moroz.setTranslateX(1010);
        ded_moroz.setFitHeight(height);
        ded_moroz.setFitWidth(width);
    }
    public void moveleftX()
    {
        ded_moroz.setTranslateX(ded_moroz.getTranslateX()-20);
    }
    public void moverightX()
    {
        ded_moroz.setTranslateX(ded_moroz.getTranslateX()+20);
    }

}
